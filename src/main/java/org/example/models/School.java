package org.example.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "School")
public class School {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "number_school")
    private Integer number_school;

    @OneToOne
    @JoinColumn(name = "director_id", referencedColumnName = "id")
    private Director director;

    public School() {
    }

    public School(Integer number_school) {
        this.number_school = number_school;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber_school() {
        return number_school;
    }

    public void setNumber_school(Integer number_school) {
        this.number_school = number_school;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "School{" +
                "number_school=" + number_school +
                '}';
    }
}
