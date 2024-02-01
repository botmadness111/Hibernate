package org.example.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movie_id;

    @Column(name = "name")
    private String name;

    @Column(name = "year_of_production")
    private Integer year_of_production;

    @ManyToOne
    @JoinColumn(name = "director_id", referencedColumnName = "director_id")
    private Director director;

    public Movie() {
    }

    public Movie(String name, Integer year_of_production) {
        this.name = name;
        this.year_of_production = year_of_production;
    }

    public Integer getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Integer movie_id) {
        this.movie_id = movie_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear_of_production() {
        return year_of_production;
    }

    public void setYear_of_production(Integer year_of_production) {
        this.year_of_production = year_of_production;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", year_of_production=" + year_of_production +
                '}';
    }
}
