package no.hvl.dat250.jpa.assignment2;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public int number;
    public int limit;
    public int balance;

    @ManyToOne
    public Bank owningBank;

    public Pincode pincode;
}
