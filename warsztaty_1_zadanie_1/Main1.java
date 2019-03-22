package warsztaty_1_zadanie_1;

import java.util.Random;
import java.util.Scanner;

public class Main1 {
    public static void main (String args[]){
        try {
            int value =-1;
            int a = getRandom();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Zgadnij liczbę: ");
            while (value != a){
                while (!scanner.hasNextInt()) {
                    System.out.print("Podaj liczbę: ");
                    scanner.nextLine();
                }
                value = scanner.nextInt();
                if (value > a){
                    System.out.println("Podana wartość jest za duża.");
                    System.out.print("Podaj kolejną liczbę: ");

                } else if (value < a){
                    System.out.println("Podana wartość jest za mała.");
                    System.out.print("Podaj kolejną liczbę: ");
                }

            }
        } catch (NumberFormatException e){
            System.out.println("Podana wartość nie jest liczbą.");
        }


    }
    static int getRandom(){
        Random r = new Random();
        return (r.nextInt(100))+1;
    }
}
