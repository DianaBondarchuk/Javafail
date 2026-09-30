import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileArraysProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть шлях до файлу з даними масивів: ");
        Path path = Paths.get(scanner.nextLine());

        try {
            List<String> lines = Files.readAllLines(path);
            List<int[]> arraysList = new ArrayList<>();

            for (String line : lines) {
                line = line.trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split("\\s+");
                int[] arr = new int[parts.length];
                for (int i = 0; i < parts.length; i++) {
                    arr[i] = Integer.parseInt(parts[i]);
                }
                arraysList.add(arr);
            }

            int grandTotalSum = 0;

            System.out.println("\n=== ОБРОБКА МАСИВІВ ===");
            for (int index = 0; index < arraysList.size(); index++) {
                int[] arr = arraysList.get(index);

                int min = arr[0];
                int max = arr[0];
                int sum = 0;

                for (int num : arr) {
                    if (num < min) min = num;
                    if (num > max) max = num;
                    sum += num;
                }

                grandTotalSum += sum;

                System.out.println("Масив №" + (index + 1) + ": " + Arrays.toString(arr));
                System.out.println("  Мінімум: " + min);
                System.out.println("  Максимум: " + max);
                System.out.println("  Сума: " + sum);
                System.out.println("------------------------------------");
            }

            System.out.println("ЗАГАЛЬНА СУМА ВСІХ МАСИВІВ: " + grandTotalSum);

        } catch (IOException e) {
            System.err.println("Помилка роботи з файлом: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Помилка формату даних у файлі (виявлено нечислове значення).");
        }
    }
}
