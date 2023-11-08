package org.example;

import java.util.ArrayList;

public class ListVoitures implements InterfaceListVoiture {
    private ArrayList<Voiture> listVoitures = new ArrayList<>();

    public ArrayList<Voiture> getListVoitures() {
        return listVoitures;
    }

    public void setListVoitures(ArrayList<Voiture> listVoitures) {
        this.listVoitures = listVoitures;
    }

    @Override
    public void ajouterVoiture(Voiture v) throws
            VoitureException {
        if (this.listVoitures.contains(v)) {
            throw new VoitureException("Voiture+"+v+" deja existe .");
        } else {
            this.listVoitures.add(v);
        }
    }

    @Override
    public void supprimerVoiture(Voiture v) throws VoitureException {
        if (this.listVoitures.contains(v)) {
            this.listVoitures.remove(v);
        } else {
            throw new VoitureException("La voiture spécifiée n'existe pas dans la liste.");
        }
    }

    @Override
    public void afficherVoiture() {
        for (Voiture v : listVoitures)
            System.out.println(v);
    }
}
