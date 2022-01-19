package com.company;

import java.util.ArrayList;
import java.util.List;

public class Gym {
List<Trainer> trainer;
List<Person> person;

    public Gym() {
        this.trainer = new ArrayList<>();
        this.person = new ArrayList<>();
    }

    public List<Trainer> getTrainer() {
        return trainer;
    }

    public void setTrainer(List<Trainer> trainer) {
        this.trainer = trainer;
    }

    public List<Person> getPerson() {
        return person;
    }

    public void setPerson(List<Person> person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Gym{" +
                "trainer=" + trainer +
                ", person=" + person +
                '}';
    }
}
