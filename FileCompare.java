import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class FileCompare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть шлях до першого файлу: ");
        Path path1 = Paths.get(scanner.nextLine());

        System.out.print("Введіть шлях до другого файлу: ");
        Path path2 = Paths.get(scanner.nextLine());

        try {
            List<String> lines1 = Files.readAllLines(path1);
            List<String> lines2 = Files.readAllLines(path2);

            int maxLines = Math.max(lines1.size(), lines2.size());
            boolean isIdentical = true;

            System.out.println("\n=== РЕЗУЛЬТАТ ПОРІВНЯННЯ ===");
            for (int i = 0; i < maxLines; i++) {
                String line1 = (i < lines1.size()) ? lines1.get(i) : "[Рядок відсутній]";
                String line2 = (i < lines2.size()) ? lines2.get(i) : "[Рядок відсутній]";

                if (!line1.equals(line2)) {
                    isIdentical = false;
                    System.out.println("Незбіг у рядку №" + (i + 1) + ":");
                    System.out.println("  Файл 1: " + line1);
                    System.out.println("  Файл 2: " + line2);
                }
            }

            if (isIdentical) {
                System.out.println("Файли повністю збігаються!");
            }

        } catch (IOException e) {
            System.err.println("Помилка читання файлу: " + e.getMessage());
        }
    }
}