package ee.taltech.iti0202.bankmanagement.card;
import ee.taltech.iti0202.bankmanagement.exceptions.TransactionException;

import java.math.BigDecimal;

public final class CreditCard extends BankCard {

    CreditCard() {

    }

    @Override
    public BigDecimal withdraw(BigDecimal value) throws TransactionException {
        this.balance = this.balance.subtract(value);
        return null;
    }

    @Override
    public BigDecimal getBalance() {
        if (balance.compareTo(BigDecimal.ZERO) < 0) {
            return BigDecimal.ZERO;
        } else {
        return balance;
        }
    }

    @Override
    public BigDecimal getDebt() {
        if (balance.compareTo(BigDecimal.ZERO) > 0) {
            return BigDecimal.ZERO;
        } else {
            return balance.abs();
        }
    }
}
