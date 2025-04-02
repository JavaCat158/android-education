package taxes;

public class USNIncome extends TaxSystem {
    @Override
    public int calcTaxFor(int debit, int credit) {
        return (int) Math.round(debit * 0.06);
    }
}