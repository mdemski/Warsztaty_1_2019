package warsztaty_1_zadanie_2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main2 {
    static public void main(String args[]) {
        Integer[] randomNumbers = getRandoms();
        int[] numbersFromUser = getNumbersFromUser();

        System.out.println("Użytkownik: " + Arrays.toString(numbersFromUser));
        System.out.println("Wylosowane: " + Arrays.toString(randomNumbers));

        checkWin(numbersFromUser, randomNumbers);

    }

    static void checkWin(int[] numbersFromUser, Integer[] randomNumbers) {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (numbersFromUser[i] == randomNumbers[j]) {
                    count++;
                }
            }
            if (count > 3) {
                System.out.println("Trafiłeś: " + count + "liczb.");
            }
        }
    }

    static Integer[] getRandoms() {
        Integer[] arr = new Integer[49];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        Collections.shuffle(Arrays.asList(arr));
        return Arrays.copyOf(arr, 6);
    }

    static int[] getNumbersFromUser() {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[6];
        int userNumber = 0;
        int index = 0;
        while (index < 6) {
            System.out.print("Podaj typowaną liczbę: ");
            while (scanner.hasNextInt()) {
//                System.out.print("Podaj typowaną liczbę: ");

                userNumber = scanner.nextInt();
                boolean sameNumber = false;
                for (int i = 0; i <= index; i++) {
                    if (numbers[i] == userNumber) {
                        sameNumber = true;
                        break;
                    }
                    if (sameNumber == false && userNumber >= 1 && userNumber <= 49) {
                        numbers[index] = userNumber;
                        index++;
                        break;
                    }
                }
                break;
            }
        }
        return numbers;
    }
}
