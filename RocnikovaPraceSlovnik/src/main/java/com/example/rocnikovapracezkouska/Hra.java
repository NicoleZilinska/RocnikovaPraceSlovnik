package com.example.rocnikovapracezkouska;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hra {
    public void SlovniHra(ArrayList<String> francouzskaSlova, ArrayList<String> ceskaSlova){
        Scanner scanner= new Scanner(System.in);
        Random random = new Random();
        ArrayList<Integer> pocetBodu = new ArrayList<>();
        System.out.println("Zadejte počet hráčů:");
        int pocetHracu = scanner.nextInt();
        for (int i=0;i<pocetHracu; i++){
            int body=0;
            for (int n=0; n<4; n++){
                System.out.println("Hraje hráč "+(i+1));
                int nahodneCislo = random.nextInt(2);
                switch (nahodneCislo) {
                    case 0 -> {
                        if (ceskaNaFrancouzska(francouzskaSlova, ceskaSlova)) {
                            body++;
                        }
                    }
                    case 1 -> {
                        if (francouzskaNaCeska(francouzskaSlova, ceskaSlova)) {
                            body++;
                        }
                    }
                }
            }
            pocetBodu.add(body);
        }
        System.out.println(urceniViteze(pocetBodu));
    }

    public String urceniViteze(ArrayList<Integer> pocetBodu){
        int nejvetsiCislo=0;
        int hrac=0;
        for (int i=0;i< pocetBodu.size(); i++){
            if (pocetBodu.get(i)>nejvetsiCislo){
                nejvetsiCislo= pocetBodu.get(i);
                hrac=i+1;
            }
        }
        return "Vítěz je hrac "+hrac+ " s "+nejvetsiCislo+ " body";
    }
    public boolean ceskaNaFrancouzska(ArrayList<String> francouzskaSlova, ArrayList<String> ceskaSlova){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean spravne=false;
        int nahodneCislo= random.nextInt(francouzskaSlova.size());
        System.out.println("Přeložte: "+ceskaSlova.get(nahodneCislo));
        String slovoUzivatele = scanner.nextLine();
        if (slovoUzivatele.equals(francouzskaSlova.get(nahodneCislo))){
            System.out.println("Správně");
            ceskaSlova.remove(nahodneCislo);
            francouzskaSlova.remove(nahodneCislo);
            spravne=true;
        }
        else {
            System.out.println("Špatně, správná odpověď je: "+francouzskaSlova.get(nahodneCislo));
        }
        return spravne;
    }
    public boolean francouzskaNaCeska(ArrayList<String> francouzskaSlova, ArrayList<String> ceskaSlova){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean spravne=false;
        int nahodneCislo= random.nextInt(ceskaSlova.size());
        System.out.println("Přeložte: "+francouzskaSlova.get(nahodneCislo));
        String slovoUzivatele = scanner.nextLine();
        if (slovoUzivatele.equals(ceskaSlova.get(nahodneCislo))){
            System.out.println("Správně");
            ceskaSlova.remove(nahodneCislo);
            francouzskaSlova.remove(nahodneCislo);
            spravne=true;
        }
        else {
            System.out.println("Špatně, správná odpověď: "+ceskaSlova.get(nahodneCislo));
        }
        return spravne;
    }
}
