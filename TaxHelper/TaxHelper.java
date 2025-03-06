import java.util.Scanner;


public class TaxHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int earnings = 0; // Доходы
        int spendings = 0; // Расходы

        while (true) {
            System.out.println("\nВыберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");
            System.out.println("Введите 'end' для выхода.");

            String input = scanner.nextLine();
            if ("end".equalsIgnoreCase(input)) {
                break;
            }

            try {
                int operation = Integer.parseInt(input);
                switch (operation) {
                    case 1:
                        System.out.println("Введите сумму дохода:");
                        earnings += Integer.parseInt(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Введите сумму расхода:");
                        spendings += Integer.parseInt(scanner.nextLine());
                        break;
                    case 3:
                        chooseBestTaxSystem(earnings, spendings);
                        break;
                    default:
                        System.out.println("Такой операции нет. Введите 1, 2 или 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода! Введите число или 'end' для выхода.");
            }
        }
        System.out.println("Программа завершена!");
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
