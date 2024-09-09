package nl.han.bewd.lambdas;

import nl.han.bewd.lambdas.reis.*;

import java.util.Random;

public class Main {
    /*
    Een Reis wordt gemaakt met een enkel vervoermiddel. De reistijd kan door middel van een simulatie van de
    reis worden berekend. Hierbij kan onderscheid gemaakt worden of de reis tijdens de spits of buiten de spits is.
     */
    public static void main(String[] args) {
        System.out.println("Buiten spits met fiets");
        Reis mijnReis = new Reis(false);
        VervoerStrategy vervoer = new FietsVervoerStrategy();
        mijnReis.simuleerReis(vervoer);

        System.out.println("Tijdens de spits");
        mijnReis.setSpits(true);
        mijnReis.simuleerReis(vervoer);                   // Met fiets
        mijnReis.simuleerReis(new AutoVervoerStrategy()); // Met auto
        mijnReis.simuleerReis(new OVVervoerStrategy());   // Met OV

        System.out.println("Met <nieuw> vervoer (Stap 2)  ");
        System.out.println("TODO:");
        mijnReis.setSpits(false);
        VervoerStrategy fatbikeVervoer = new OpgevoerdeFatbikeVervoerStrategy();
        mijnReis.simuleerReis(fatbikeVervoer); // Met opgevoerde fatbike
        mijnReis.setSpits(true);
        mijnReis.simuleerReis(fatbikeVervoer); // Met opgevoerde fatbike in spits

        System.out.println("Met <nieuw> vervoer, lambda edition! (Stap 5)");
        System.out.println("TODO:");
        VervoerStrategy lambdaAuto = (s) -> {
            if (s) {
                return 60;
            } else {
                return 30;
            }
        };
        mijnReis.simuleerReis(lambdaAuto);
        mijnReis.setSpits(false);
        mijnReis.simuleerReis(lambdaAuto);

        VervoerStrategy lambdaUFO = s -> 1;
        mijnReis.simuleerReis(lambdaUFO);
    }
}