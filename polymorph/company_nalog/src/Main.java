import taxes.USNIncome;
import taxes.USNIncomeMinusExpenses;

public class Main {
    public static void main(String[] args) {
        // Создаем компании с разными системами налогообложения
        Company company1 = new Company("Рога и копыта", new USNIncome());
        Company company2 = new Company("Партнер", new USNIncomeMinusExpenses());

        // Тестируем работу shiftMoney
        company1.shiftMoney(100000);
        company1.shiftMoney(-60000);
        company1.payTaxes(); // Должен быть 6% от 100000 = 6000

        company2.shiftMoney(100000);
        company2.shiftMoney(-60000);
        company2.payTaxes(); // Должен быть 15% от (100000-60000) = 6000

        // Тестируем смену системы налогообложения
        company1.setTaxSystem(new USNIncomeMinusExpenses());
        company1.shiftMoney(100000);
        company1.shiftMoney(-60000);
        company1.payTaxes(); // Теперь должно быть 15% от (100000-60000) = 6000

        company2.setTaxSystem(new USNIncome());
        company2.shiftMoney(100000);
        company2.shiftMoney(-60000);
        company2.payTaxes(); // Теперь должно быть 6% от 100000 = 6000

        // Тест с отрицательным налогом (расходы больше доходов)
        Company company3 = new Company("Убыточная", new USNIncomeMinusExpenses());
        company3.shiftMoney(50000);
        company3.shiftMoney(-100000);
        company3.payTaxes(); // Должен быть 0 (не отрицательный)
    }
}