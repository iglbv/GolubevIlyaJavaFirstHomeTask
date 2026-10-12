package fOne.builder;

import java.util.Comparator;
import java.util.Scanner;

public class BolideFilterSortBolideArrayList {

    public static void filterBolides(Scanner scanner, BolideArrayList<Bolide> bolides) {
        if (bolides.isEmpty()) {
            System.out.println("Коллекция пуста.");
            return;
        }

        System.out.print("Введите название команды: ");
        String teamFilter = scanner.nextLine().trim();

        if (teamFilter.isEmpty()) {
            System.out.println("Название команды не может быть пустым.");
            return;
        }

        BolideArrayList<Bolide> result = new BolideArrayList<>();
        for (int i = 0; i < bolides.size(); i++) {
            Bolide b = bolides.get(i);
            if (b.getTeam().equalsIgnoreCase(teamFilter)) {
                result.add(b);
            }
        }

        if (result.isEmpty()) {
            System.out.println("Болидов команды " + teamFilter + " не найдено.");
            return;
        }

        System.out.println("=========== РЕЗУЛЬТАТ ФИЛЬТРАЦИИ ===========");
        for (int i = 0; i < result.size(); i++) {
            Bolide b = result.get(i);
            System.out.println(b.getDriver() + " — " + b.getModel() + " (" + b.getTeam() + ")");
        }
    }

    public static void sortBolides(Scanner scanner, BolideArrayList<Bolide> bolides) {
        if (bolides.isEmpty()) {
            System.out.println("Коллекция пуста.");
            return;
        }

        System.out.println("Сортировать по:");
        System.out.println("1. Команда");
        System.out.println("2. Пилот");
        System.out.println("3. Модель");
        System.out.print("Выберите поле: ");

        String input = scanner.nextLine().trim();
        int field;

        try {
            field = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод.");
            return;
        }

        Comparator<Bolide> comparator;

        switch (field) {
            case 1:
                comparator = Comparator.comparing(Bolide::getTeam);
                break;
            case 2:
                comparator = Comparator.comparing(Bolide::getDriver);
                break;
            case 3:
                comparator = Comparator.comparing(Bolide::getModel);
                break;
            default:
                System.out.println("Некорректное число");
                return;
        }

        BolideArrayList<Bolide> sorted = new BolideArrayList<>();
        for (int i = 0; i < bolides.size(); i++) {
            sorted.add(bolides.get(i));
        }

        for (int i = 1; i < sorted.size(); i++) {
            Bolide key = sorted.get(i);
            int j = i - 1;
            while (j >= 0 && comparator.compare(sorted.get(j), key) > 0) {
                sorted.set(j + 1, sorted.get(j));
                j--;
            }
            sorted.set(j + 1, key);
        }

        System.out.println("=========== РЕЗУЛЬТАТ СОРТИРОВКИ ===========");
        for (int i = 0; i < sorted.size(); i++) {
            System.out.println(sorted.get(i));
        }
    }
}