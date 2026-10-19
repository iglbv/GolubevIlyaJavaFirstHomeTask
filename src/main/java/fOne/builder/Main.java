package fOne.builder;

import fOne.builder.collection.BolideArrayList;
import fOne.builder.model.Bolide;

import java.util.Scanner;

import static fOne.builder.service.BolideService.*;
import static fOne.builder.sort.BolideFilterSortBolideArrayList.*;

public class Main {
    public static void main(String[] args) {

        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        BolideArrayList<Bolide> bolides = new BolideArrayList<>();

        boolean isRunning = true;

        while (isRunning) {
            printMenu();

            String input = scanner.nextLine();
            int choice;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод.");
                continue;
            }

            switch (choice) {
                case 1:
                    addBolide(scanner, bolides);
                    break;
                case 2:
                    loadBolides(scanner, bolides);
                    break;
                case 3:
                    showBolides(bolides);
                    break;
                case 4:
                    filterBolides(scanner, bolides);
                    break;
                case 5:
                    sortBolides(scanner, bolides);
                    break;
                case 6:
                    System.out.println("Завершение программы.");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Некорректное число");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("=========== МЕНЮ ===========");
        System.out.println("1. Добавить болид вручную");
        System.out.println("2. Загрузить болиды из файла");
        System.out.println("3. Показать все болиды");
        System.out.println("4. Фильтрация болидов");
        System.out.println("5. Сортировка болидов");
        System.out.println("6. Выход");
        System.out.print("Выберите пункт: ");
    }
}