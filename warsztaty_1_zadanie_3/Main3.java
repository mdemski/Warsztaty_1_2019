package warsztaty_1_zadanie_3;

import java.util.Scanner;

public class Main3 {
    public static void main(String args[]) {
        int a = getNumber();
        Scanner scanner = new Scanner(System.in);
        int max = 1000;
        int min = 1;
        int guess = (max - min) / 2 + min;
        int count = 0;
        while ((guess != a)) {
            count++;
            System.out.println("Zgaduję: " + guess);
            System.out.print("Zgadłem?");
            String ans1 = scanner.nextLine();
            if (ans1.equals("tak")) {
                break;
            }
            if (ans1.equals("nie")) {
                System.out.print("Za dużo?");
                String ans2 = scanner.nextLine();
                if (ans2.equals("tak")) {
                    max = guess;
                } else if (ans2.equals("nie")) {
                    System.out.print("Za mało?");
                    String ans3 = scanner.nextLine();
                    if (ans3.equals("tak")) {
                        min = guess;
                    } else {
                        System.out.println("Nie oszukuj!");
                        break;
                    }
                } else {
                    System.out.println("Nie oszukuj!");
                    break;
                }
                guess = ((max - min) / 2) + min;
            }
        }
        if (count < 10) {
            System.out.println("Pomyślałeś liczbę: " + a);
            System.out.print("Wygrałem! Udało się w " + count + " krokach.");
        }
    }

    static int getNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Pomyśl i podaj liczbę od 1 do 1000: ");
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
        }
        int a = scanner.nextInt();
        return a;
    }
}
