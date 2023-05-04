package com.example.rocnikovapracezkouska;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Preklad{
    public void ceskaNaFrancouzska(ArrayList francouzskaSlova, ArrayList ceskaSlova){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int nahodneCislo= random.nextInt(francouzskaSlova.size());
        System.out.println("Přeložte: "+ceskaSlova.get(nahodneCislo));
        String slovoUzivatele = scanner.nextLine();
        if (slovoUzivatele.equals(francouzskaSlova.get(nahodneCislo))){
            System.out.println("Správně");
            ceskaSlova.remove(nahodneCislo);
            francouzskaSlova.remove(nahodneCislo);
        }
        else {
            System.out.println("Špatně, správná odpověď je: "+francouzskaSlova.get(nahodneCislo));
        }
    }
    public void francouzskaNaCeska(ArrayList francouzskaSlova, ArrayList ceskaSlova){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int nahodneCislo= random.nextInt(ceskaSlova.size());
        System.out.println("Přeložte: "+francouzskaSlova.get(nahodneCislo));
        String slovoUzivatele = scanner.nextLine();
        if (slovoUzivatele.equals(ceskaSlova.get(nahodneCislo))){
            System.out.println("Správně");
            ceskaSlova.remove(nahodneCislo);
            francouzskaSlova.remove(nahodneCislo);
        }
        else {
            System.out.println("Špatně, správná odpověď: "+ceskaSlova.get(nahodneCislo));
        }
    }
}
