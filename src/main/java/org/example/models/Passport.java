package org.example.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "passport")
public class Passport {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "passport_number")
    private Integer passport_number;

    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Human human;

    public Passport() {
    }

    public Passport(Integer passport_number) {
        this.passport_number = passport_number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Human getHuman() {
        return human;
    }

    public void setHuman(Human person) {
        this.human = person;
    }

    public Integer getPassport_number() {
        return passport_number;
    }

    public void setPassport_number(Integer passport_number) {
        this.passport_number = passport_number;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "human=" + human +
                ", passport_number=" + passport_number +
                '}';
    }
}
