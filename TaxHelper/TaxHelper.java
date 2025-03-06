import java.util.Scanner;

public class TaxHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int earnings = 0; // Доходы
        int spendings = 0; // Расходы

        while (true) {
            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");
            System.out.println("Введите 'end' для выхода.");

            String input = scanner.nextLine();
            if ("end".equalsIgnoreCase(input)) {
                break;
            }

            int operation = parseInt(input);
            if (operation == -1) {
                System.out.println("Ошибка ввода! Введите число или 'end' для выхода.");
                continue;
            }

            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    int income = parseInt(scanner.nextLine());
                    if (income != -1) {
                        earnings += income;
                    } else {
                        System.out.println("Ошибка ввода! Введите корректную сумму дохода.");
                    }
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");
                    int expense = parseInt(scanner.nextLine());
                    if (expense != -1) {
                        spendings += expense;
                    } else {
                        System.out.println("Ошибка ввода! Введите корректную сумму расхода.");
                    }
                    break;
                case 3:
                    chooseBestTaxSystem(earnings, spendings);
                    break;
                default:
                    System.out.println("Такой операции нет. Введите 1, 2 или 3.");
            }
        }
        System.out.println("Программа завершена!");
    }

    // Метод для безопасного преобразования строки в число
    public static int parseInt(String input) {
        if (input.matches("\\d+")) {
            return Integer.parseInt(input);
        }
        return -1;
    }

    // Метод для расчета налога по УСН "Доходы"
    public static int taxEarnings(int earnings) {
        return earnings * 6 / 100;
    }

    // Метод для расчета налога по УСН "Доходы минус расходы"
    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        return Math.max(tax, 0); // Налог не может быть отрицательным
    }

    // Метод для выбора лучшей системы налогообложения
    public static void chooseBestTaxSystem(int earnings, int spendings) {
        int taxEarnings = taxEarnings(earnings);
        int taxEarningsMinusSpendings = taxEarningsMinusSpendings(earnings, spendings);

        System.out.println("\nНалоги по разным системам:");
        System.out.println("УСН 'Доходы': " + taxEarnings + " рублей");
        System.out.println("УСН 'Доходы минус расходы': " + taxEarningsMinusSpendings + " рублей");

        if (taxEarnings < taxEarningsMinusSpendings) {
            System.out.println("Мы советуем вам УСН 'Доходы'. Вы сэкономите " +
                    (taxEarningsMinusSpendings - taxEarnings) + " рублей.");
        } else if (taxEarnings > taxEarningsMinusSpendings) {
            System.out.println("Мы советуем вам УСН 'Доходы минус расходы'. Вы сэкономите " +
                    (taxEarnings - taxEarningsMinusSpendings) + " рублей.");
        } else {
            System.out.println("Можете выбрать любую систему налогообложения, налоги одинаковые.");
        }
    }
}
