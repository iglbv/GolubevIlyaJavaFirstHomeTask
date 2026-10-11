package fOne.builder;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            printMenu();

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Вариант 1");
                        break;
                    case 2:
                        System.out.println("Завершение программы");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Неизвестная ошибка. Введите число из списка меню");
                }
            } else {
                System.out.println("Ошибка");
                scanner.next();
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("=== МЕНЮ ===");
        System.out.println("1. Добавить болид 1");
        System.out.println("2. Выход");
        System.out.println("Выберите пункт: ");
    }
}
