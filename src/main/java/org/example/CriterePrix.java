package org.example;

public class CriterePrix implements Critere{
    private float prix;

    public CriterePrix(float prix) {
        this.prix = prix;
    }

    @Override
    public boolean estSatisfaitPar(Voiture v) {
        return this.prix > v.getPrixLocation();
    }
}
