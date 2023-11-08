package org.example;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface InterfaceAgence {
    void ajoutVoiture(Voiture v) throws VoitureException;

    void suppVoiture(Voiture v) throws VoitureException;

    void loueClientVoiture(Client cl, Voiture v) throws VoitureException;

    void retourClientVoiture(Client cl, Voiture v) throws VoitureException;

    List<Voiture> selectVoitureSelonCritere(Critere c);

    Set<Client> ensembleClientsLoueurs();

    Collection<ListVoitures> collectionVoituresLouees();

    void afficheLesClientsEtLeursListesVoitures();

    Map<Client, ListVoitures> triCodeCroissant();

    Map<Client, ListVoitures> triNomCroissant();


}