package ee.taltech.iti0202.bankmanagement.card;
import ee.taltech.iti0202.bankmanagement.bank.Bank;
import ee.taltech.iti0202.bankmanagement.exceptions.TransactionException;
import ee.taltech.iti0202.bankmanagement.person.Person;

import java.math.BigDecimal;

public abstract class BankCard {

    protected Bank bank;
    protected Person person;
    protected BigDecimal balance;
    public enum CardType { CREDIT, DEBIT }

    /**
     * Constructor factory. Return a CreditCard or DebitCard object according to parameter cardType.
     *
     * @param cardType Specifies objected type to be returned.
     * @param bank     Specifies the bank of the created card.
     * @param person   Specifies the card owner.
     * @return
     */
    public static BankCard createCard(CardType cardType, Bank bank, Person person) {
        if (cardType.equals(CardType.DEBIT)) {
            BankCard bankCard = new DebitCard();
            person.cardType = "DEBIT";
            return getBankCard(bank, person, bankCard);
        } else {
            BankCard bankCard = new CreditCard();
            person.cardType = "CREDIT";
            return getBankCard(bank, person, bankCard);
        }
    }

    private static BankCard getBankCard(Bank bank, Person person, BankCard bankCard) {
        bankCard.bank = bank;
        bankCard.person = person;
        bankCard.balance = BigDecimal.ZERO;
        person.setBankCard(bankCard);
        bank.addCustomer(person);
        return bankCard;
    }

    /**
     * Deposit given amount to the card.
     *
     * @param value Value to be deposited.
     * @throws TransactionException Thrown if given value is zero or less.
     */
    public void deposit(BigDecimal value) throws TransactionException {
        if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new TransactionException();
        } else {
            this.balance = this.balance.add(value);
        }
    }

    /**
     * Withdraw the given amount from the card. Abstract function - implemented in subclasses CreditCard and DebitCard.
     *
     * @param value Value to be withdrawn.
     * @return Amount withdrawn.
     * @throws TransactionException Thrown if given value cannot be withdrawn for
     *                              various reasons - specified in subclasses.
     */
    public abstract BigDecimal withdraw(BigDecimal value) throws TransactionException;

    public BigDecimal getDebt() {
        return BigDecimal.ZERO;
    }

    public Bank getBank() {
        return bank;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Person getPerson() {
        return person;
    }
}
