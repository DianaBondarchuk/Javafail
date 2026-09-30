import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class LongestLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть шлях до файлу: ");
        Path path = Paths.get(scanner.nextLine());

        try {
            List<String> lines = Files.readAllLines(path);

            if (lines.isEmpty()) {
                System.out.println("Файл порожній.");
                return;
            }

            String longest = "";
            for (String line : lines) {
                if (line.length() > longest.length()) {
                    longest = line;
                }
            }

            System.out.println("\n=== РЕЗУЛЬТАТ ===");
            System.out.println("Довжина найдовшого рядка: " + longest.length());
            System.out.println("Сам рядок: " + longest);

        } catch (IOException e) {
            System.err.println("Помилка читання файлу: " + e.getMessage());
        }
    }
}