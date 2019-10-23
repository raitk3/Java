package ee.taltech.iti0202.bankmanagement.card;
import ee.taltech.iti0202.bankmanagement.exceptions.TransactionException;

import java.math.BigDecimal;

public final class DebitCard extends BankCard {

    DebitCard() {

    }

    @Override
    public BigDecimal withdraw(BigDecimal value) throws TransactionException {
        if (value.compareTo(this.balance) < 0) {
            this.balance = this.balance.subtract(value);
        } else {
            throw new TransactionException();
        }
        return null;
    }

}
