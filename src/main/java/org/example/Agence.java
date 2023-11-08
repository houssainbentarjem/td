package org.example;

import java.util.*;

public class Agence implements InterfaceAgence {
    private String nom;
    private ListVoitures listVoitureAgence;
    private Map<Client, ListVoitures> clientVoitureLoue;


    public Agence(String nom, ListVoitures listAgence, Map<Client, ListVoitures> clientVoitureLoue) {
        this.nom = nom;
        this.listVoitureAgence = listAgence;
        this.clientVoitureLoue = clientVoitureLoue;
    }

    @Override
    public void ajoutVoiture(Voiture v) throws VoitureException {
        this.listVoitureAgence.ajouterVoiture(v);
    }

    @Override
    public void suppVoiture(Voiture v) throws VoitureException {
        this.listVoitureAgence.supprimerVoiture(v);
    }

    @Override
    public void loueClientVoiture(Client cl, Voiture v) throws VoitureException {
        //  search if client exist in ClientVoitureLoue
        if (clientVoitureLoue.containsKey(cl)) {
            ListVoitures listClient = clientVoitureLoue.get(cl);
            listClient.ajouterVoiture(v);
            this.listVoitureAgence.supprimerVoiture(v);
            this.clientVoitureLoue.put(cl, listClient);
        } else {
            ListVoitures list = new ListVoitures();
            list.ajouterVoiture(v);
            this.listVoitureAgence.supprimerVoiture(v);
            this.clientVoitureLoue.put(cl, list);
        }
    }

    @Override
    public void retourClientVoiture(Client cl, Voiture v) throws VoitureException {
        if(clientVoitureLoue.containsKey(cl)){
            clientVoitureLoue.get(cl).supprimerVoiture(v);
            this.listVoitureAgence.ajouterVoiture(v);
        }else {
            System.out.println("Client n'existe pas");
        }
    }

    @Override
    public List<Voiture> selectVoitureSelonCritere(Critere c) {
        List<Voiture> listeCri = new ArrayList<>();

        if (c instanceof CritereMarque) {
            CritereMarque cm = (CritereMarque) c;
            for (Voiture v : this.listVoitureAgence.getListVoitures()) {
                if (cm.estSatisfaitPar(v))
                    listeCri.add(v);

            }
        } else if (c instanceof CriterePrix) {
            CriterePrix cp = (CriterePrix) c;
            for (Voiture v : this.listVoitureAgence.getListVoitures()) {
                if (cp.estSatisfaitPar(v))
                    listeCri.add(v);
            }
        }
        return listeCri;
    }


    @Override
    public Set<Client> ensembleClientsLoueurs() {
        return this.clientVoitureLoue.keySet();
    }

    @Override
    public Collection<ListVoitures> collectionVoituresLouees() {
        return this.clientVoitureLoue.values();
    }

    @Override
    public void afficheLesClientsEtLeursListesVoitures() {
        this.clientVoitureLoue.forEach(((client, listVoitures) -> {
            System.out.println("Client" + client);
            listVoitures.afficherVoiture();
        }));
    }

    @Override
    public Map<Client, ListVoitures> triCodeCroissant() {
        TreeMap<Client, ListVoitures> triMap = new TreeMap<>(new TriCodeCroissant());
        triMap.putAll(clientVoitureLoue);
        return triMap;
    }

    @Override
    public Map<Client, ListVoitures> triNomCroissant() {
        TreeMap<Client, ListVoitures> triMap = new TreeMap<>(new TriNomCroissant());
        triMap.putAll(clientVoitureLoue);
        return triMap;
    }
}
