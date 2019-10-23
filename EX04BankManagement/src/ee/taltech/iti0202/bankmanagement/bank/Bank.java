package ee.taltech.iti0202.bankmanagement.bank;
import ee.taltech.iti0202.bankmanagement.person.Person;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Bank {

    private String name;
    public Set<Person> customers = new HashSet<>();

    public Bank(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Set<Person> getCustomers() {
        return this.customers;
    }

    public boolean addCustomer(Person person) {
        if (person.getBankCard().isPresent()) {
            this.customers.add(person);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeCustomer(Person person) {
        if (customers.contains(person)) {
            person.setBankCard(null);
            person.cardType = null;
            this.customers.remove(person);
            return true;
        } else {
            return false;
        }
    }

    public double getAverageCustomerMonthlyIncome() {
        if (!customers.isEmpty()) {
            Set<Double> incomes = new HashSet<>();
            customers.forEach(person -> incomes.add(person.getMonthlyIncome()));
            return incomes.stream().mapToDouble(Double::intValue).average().getAsDouble();
        } else {
            return 0.0;
        }
    }

    public double getAverageCustomerMonthlyIncome(Set<Person> people) {
        if (!customers.isEmpty()) {
            Set<Double> incomes = new HashSet<>();
            people.forEach(person -> incomes.add(person.getMonthlyIncome()));
            return incomes.stream().mapToDouble(Double::intValue).average().getAsDouble();
        } else {
            return 0.0;
        }
    }

    public double getAverageCustomerMonthlyIncome(int maxAge) {
        if (customers.isEmpty()) {
            return 0.0;
        } else {
            Set<Person> peopleUnderMaxAge = customers.stream()
                    .filter(person -> person.getAge() <= maxAge)
                    .collect(Collectors.toSet());
            return getAverageCustomerMonthlyIncome(peopleUnderMaxAge);
        }
    }

    public double getAverageCustomerMonthlyIncome(int minAge, int maxAge) {
        if (customers.isEmpty()) {
            return 0.0;
        } else {
            Set<Person> peopleUnderMaxAge = customers.stream()
                    .filter(person -> person.getAge() <= maxAge)
                    .filter(person -> person.getAge() >= minAge)
                    .collect(Collectors.toSet());
            return getAverageCustomerMonthlyIncome(peopleUnderMaxAge);
        }
    }

    public double getAverageCustomerMonthlyIncome(Person.Gender gender) {
        if (customers.isEmpty()) {
            return 0.0;
        } else {
            Set<Person> peopleUnderMaxAge = customers.stream()
                    .filter(person -> person.getGender() == gender)
                    .collect(Collectors.toSet());
            return getAverageCustomerMonthlyIncome(peopleUnderMaxAge);
        }
    }

    public Set<Person> getAllCustomersWithCreditCards() {
        return customers.stream()
                .filter(person -> person.cardType.equals("CREDIT"))
                .collect(Collectors.toSet());
    }

    public Set<Person> getAllCustomersWithDebitCards() {
        return customers.stream()
                .filter(person -> person.cardType.equals("DEBIT"))
                .collect(Collectors.toSet());
    }

    public Optional<Person> getRichestCustomerByGender(Person.Gender gender) {
        if (customers.isEmpty()) {
            return null;
        } else {
            List<Person> customersByGender = customers.stream()
                    .filter(person -> person.getGender().equals(gender))
                    .collect(Collectors.toList());
            }
        }
    }

    @Override
    public String toString() {
        return getName();
    }
}
