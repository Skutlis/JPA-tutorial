package no.hvl.dat250.jpa.assignment2;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Pincode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String pincode;

    public int count;


}
