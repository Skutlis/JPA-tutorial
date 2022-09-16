package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String street;
    public int number;

    @ManyToMany
    public Set<Person> owners;
}
