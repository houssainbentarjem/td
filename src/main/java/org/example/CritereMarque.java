package org.example;

public class CritereMarque implements Critere{
    private String Marque ;

    public CritereMarque(String marque) {
        Marque = marque;
    }


    @Override
    public boolean estSatisfaitPar(Voiture v) {
        return v.getMarque().equals(this.Marque);
    }
}
