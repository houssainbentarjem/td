package org.example;

import java.util.Comparator;

public class TriCodeCroissant implements Comparator<Client> {

    @Override
    public int compare(Client o1, Client o2) {
        return o1.getCode()-o2.getCode();
    }
}
