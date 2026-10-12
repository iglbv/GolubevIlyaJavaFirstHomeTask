package fOne.builder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BolideFilterSortStreamApi {
    public static void filterBolides(Scanner scanner, ArrayList<Bolide> bolides) {
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

        List<String> result = bolides.stream()
                .filter(b -> b.getTeam().equalsIgnoreCase(teamFilter))
                .map(b -> b.getDriver() + " — " + b.getModel() + " (" + b.getTeam() + ")")
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("Болидов команды " + teamFilter + " не найдено.");
            return;
        }

        System.out.println("=========== РЕЗУЛЬТАТ ФИЛЬТРАЦИИ ===========");
        for (String line : result) {
            System.out.println(line);
        }
    }

    public static void sortBolides(Scanner scanner, ArrayList<Bolide> bolides) {
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

        List<Bolide> sorted = bolides.stream()
                .sorted(comparator)
                .collect(Collectors.toList());

        System.out.println("=========== РЕЗУЛЬТАТ СОРТИРОВКИ ===========");
        for (Bolide b : sorted) {
            System.out.println(b);
        }
    }
}