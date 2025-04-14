import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<String> todos = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "0":
                    System.out.println("До свидания!");
                    return;
                case "1":
                    addTask();
                    break;
                case "2":
                    showTasks();
                    break;
                case "3":
                    deleteByNumber();
                    break;
                case "4":
                    deleteByText();
                    break;
                default:
                    System.out.println("Некорректный ввод, попробуйте снова.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nВыберите операцию:");
        System.out.println("0. Выход из программы");
        System.out.println("1. Добавить дело");
        System.out.println("2. Показать дела");
        System.out.println("3. Удалить дело по номеру");
        System.out.println("4. Удалить дело по названию");
        System.out.print("Ваш выбор: ");
    }

    private static void addTask() {
        System.out.print("\nВведите название задачи: ");
        String task = scanner.nextLine().trim();
        if (task.isEmpty()) {
            System.out.println("Название не может быть пустым.");
        } else if (todos.contains(task)) {
            System.out.println("Такое дело уже есть в списке.");
        } else {
            todos.add(task);
            System.out.println("Добавлено!");
        }
        showTasks();
    }

    private static void showTasks() {
        System.out.println("Ваш список дел:");
        if (todos.isEmpty()) {
            System.out.println("Нет дел.");
        } else {
            for (int i = 0; i < todos.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, todos.get(i));
            }
        }
    }

    private static void deleteByNumber() {
        System.out.print("\nВведите номер для удаления: ");
        try {
            int number = Integer.parseInt(scanner.nextLine());
            if (number < 1 || number > todos.size()) {
                System.out.println("Нет дела с таким номером.");
            } else {
                todos.remove(number - 1);
                System.out.println("Удалено!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Введите корректный номер.");
        }
        showTasks();
    }

    private static void deleteByText() {
        System.out.print("\nВведите задачу для удаления: ");
        String task = scanner.nextLine().trim();
        if (todos.remove(task)) {
            System.out.println("Удалено!");
        } else {
            System.out.println("Нет дела с таким названием.");
        }
        showTasks();
    }
}
