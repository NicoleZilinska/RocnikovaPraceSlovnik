package com.example.rocnikovapracezkouska;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Preklad preklad = new Preklad();
        Hra hra =new Hra();
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> francouzskaSlova = new ArrayList<>();
        ArrayList<String> ceskaSlova = new ArrayList<>();
        try {
            BufferedReader cteniFrancouzska = new BufferedReader(new FileReader("francouzskaSlova.txt"));
            BufferedReader cteniCeska = new BufferedReader(new FileReader("ceskaSlova.txt"));
            String line1;
            String line2;
            while((line1= cteniFrancouzska.readLine()) != null && (line2= cteniCeska.readLine()) != null){
                francouzskaSlova.add(line1);
                ceskaSlova.add(line2);
            }
            cteniFrancouzska.close();
            cteniCeska.close();
        }

        catch (IOException e){ //
            System.out.println("Stala se chyba");
        }
        boolean opakovani=true;
        while (opakovani){
        try {
            System.out.println("⎪Vyberte si kategorii⎮");
            System.out.println("1.) 🇨🇿→🇫🇷 Česká slova na francouzská:");
            System.out.println("2.) 🇫🇷→🇨🇿 Francouzská slova na česká:");
            System.out.println("3.) slovni hra");
            System.out.println("4.) Konec hry.");
            int vyberUzivatele = scanner.nextInt();
            switch (vyberUzivatele) {
                case 1 -> preklad.ceskaNaFrancouzska(francouzskaSlova, ceskaSlova);
                case 2 -> preklad.francouzskaNaCeska(francouzskaSlova, ceskaSlova);
                case 3 -> hra.SlovniHra(francouzskaSlova, ceskaSlova);
                case 4 -> opakovani=false;
            }
        }catch (InputMismatchException e){
            System.out.println("Zadejte prosím číslo:");
            }
        }
    }
}
