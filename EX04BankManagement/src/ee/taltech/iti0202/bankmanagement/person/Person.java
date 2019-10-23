package ee.taltech.iti0202.bankmanagement.person;
import ee.taltech.iti0202.bankmanagement.card.BankCard;
import ee.taltech.iti0202.bankmanagement.exceptions.PersonException;

import java.math.BigDecimal;
import java.util.Optional;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
    private double monthlyIncome;
    private BankCard bankCard;

    public String cardType = null;

    public enum Gender { MALE, FEMALE }

    public Person(String firstName, String lastName, int age, Gender gender, double monthlyIncome) {
        if (age < 1 || monthlyIncome < 0) throw new PersonException();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.monthlyIncome = monthlyIncome;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    public Gender getGender() {
        return this.gender;
    }

    public double getMonthlyIncome() {
        return this.monthlyIncome;
    }

    /**
     * Return Optional.empty() if person has no bankcard.
     * @return Optional of BankCard
     */
    public Optional<BankCard> getBankCard() {
        return Optional.ofNullable(this.bankCard);
    }

    public void setBankCard(BankCard bankCard) {
        this.bankCard = bankCard;
    }

    @Override
    public String toString() {
        BigDecimal balance = this.bankCard.getBalance().subtract(this.bankCard.getDebt());
        return String.format("%s %s", this.firstName, balance);
    }
}
