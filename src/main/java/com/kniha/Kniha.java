package com.kniha;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Kniha {
    private List<String> riadky = null;


    public Kniha() {
        this.riadky = Arrays.asList(
                "Toto je prvy riadok",
                "Toto je druhy riadok"
        );
    }

    public String getRiadok() {
        Random random = new Random();
        int i = random.nextInt(riadky.size());
        return riadky.get(i);
    }

    public static void main(String[] args) {
        Kniha kniha = new Kniha();
        System.out.println(kniha.getRiadok());
    }
}
