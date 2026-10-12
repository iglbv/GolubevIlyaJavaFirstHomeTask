package fOne.builder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BolideService {
    public static void addBolide(Scanner scanner, BolideArrayList<Bolide> bolides) {
        System.out.println("Введите команду: ");
        String team = scanner.nextLine();

        System.out.println("Введите имя пилота: ");
        String driver = scanner.nextLine();

        System.out.println("Введите модель болида: ");
        String model = scanner.nextLine();

        if (team.isEmpty() || driver.isEmpty() || model.isEmpty()) {
            System.out.println("Все поля должны быть заполнены.");
            return;
        }

        bolides.add(new Bolide(team, driver, model));
        System.out.println("Болид добавлен");
    }

    public static void loadBolides(Scanner scanner, BolideArrayList<Bolide> bolides) {
        System.out.print("Введите путь файла: ");
        String filePath = scanner.nextLine();

        int loaded = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";", -1);

                if (data.length != 3) {
                    System.out.println("Некорректная строка: " + line);
                    continue;
                }

                String team = data[0].trim();
                String driver = data[1].trim();
                String model = data[2].trim();

                if (team.isEmpty() || driver.isEmpty() || model.isEmpty()) {
                    System.out.println("Строка с пустыми полями: " + line);
                    continue;
                }

                bolides.add(new Bolide(team, driver, model));
                loaded++;
            }

            System.out.println("Загрузка завершена. Добавлено болидов: " + loaded);

        } catch (IOException e) {
            System.out.println("Не удалось прочитать файл: " + e.getMessage());
        }
    }

    public static void showBolides(BolideArrayList<Bolide> bolides) {
        if (bolides.isEmpty()) {
            System.out.println("Коллекция пуста.");
            return;
        }

        System.out.println("=========== СПИСОК БОЛИДОВ ===========");

        for (int i = 0; i < bolides.size(); i++) {
            System.out.println((i + 1) + ". " + bolides.get(i));
        }
    }
}