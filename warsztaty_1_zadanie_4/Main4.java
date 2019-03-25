package warsztaty_1_zadanie_4;

import java.util.Random;
import java.util.Scanner;

public class Main4 {
    public static void main(String args[]){
        String[] parts = getThrow().split("D");
        int times = 1;
        int cube = 1;
        if (parts[0].length() > 0){
            times = Integer.parseInt(parts[0]);
        }
        String[] modificationPlus = parts[1].split("\\+");
        String[] modificationMinus = parts[1].split("-");
        int modification = 0;
        if (modificationPlus.length > 1 && modificationPlus[1].length()>0){
            modification = Integer.parseInt(modificationPlus[1]);
            cube = Integer.parseInt(modificationPlus[0]);
        } else if (modificationMinus.length > 1 && modificationMinus[1].length()>0){
            modification = (Integer.parseInt(modificationMinus[1]))*(-1);
            cube = Integer.parseInt(modificationMinus[0]);
        } else {
            cube = Integer.parseInt(parts[1]);
        }
        System.out.println("Rzucę " + times + " razy kostką " + cube + " ścienną i zmodyfikuję o " + modification);
        int result = 0;
        Random r = new Random();
        for (int i = 0; i<times; i++){
            int tmp = r.nextInt(cube) + 1;
            result += tmp;
        }
        result = result + modification;
        System.out.println("Wynik: " + result);

    }
    static String getThrow(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj kod rzutu: ");
        String str = scanner.nextLine();
        return str;
    }
}