package no.hvl.dat250.jpa.assignment2;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {
    private static final String PERSISTENCE_UNIT_NAME = "experiment2";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        // Adding the object to the database
        em.getTransaction().begin();
        Address address = new Address();
        address.setStreet("Inndalsveien");
        address.setNumber(28);

        Person max = new Person();
        max.setName("Max Mustermann");

        CreditCard card1 = new CreditCard();
        card1.setNumber(12345);
        card1.setBalance(-5000);
        card1.setLimit(-10000);

        CreditCard card2 = new CreditCard();
        card2.setNumber(123);
        card2.setBalance(1);
        card2.setLimit(2000);

        Pincode pincode = new Pincode();
        pincode.setPincode("123");
        pincode.setCount(1);

        Bank bank = new Bank();
        bank.setName("Pengebank");

        Set<Address> maxAddresses = new HashSet<>();
        maxAddresses.add(address);
        max.setAddresses(maxAddresses);

        Set<Person> inndalOwners = new HashSet<>();
        inndalOwners.add(max);
        address.setOwners(inndalOwners);

        Set<CreditCard> cards = new HashSet<>();
        cards.add(card1); cards.add(card2);
        max.setCreditCards(cards);

        card1.setPincode(pincode); card2.setPincode(pincode);
        card1.setOwningBank(bank); card2.setOwningBank(bank);

        bank.setOwnedCards(cards);

        em.persist(address);
        em.persist(max);
        em.persist(card1);
        em.persist(card2);
        em.persist(pincode);
        em.persist(bank);
        em.getTransaction().commit();

        em.close();
    }
}
