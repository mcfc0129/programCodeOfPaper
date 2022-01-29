package com.example;

import java.util.Comparator;
import lombok.Data;

@Data
public class Preference {
    private int rank;
    private Person person;

    public Preference(int rank, Person person) {
        this.rank = rank;
        this.person = person;
    }

    public Preference(Person person) {
        this.person = person;
    }

    public boolean isEmpty() {
        if (person == null) {
            return true;
        } else {
            return false;
        }
    }

    public final Comparator<Preference> NAME_ORDER = new NameOrderComparator();

    public static class NameOrderComparator implements Comparator<Preference> {
        public int compare(Preference a, Preference b) {
            return a.person.getName().compareTo(b.person.getName());
        }
    }

    public String toString() {
        return rank + ":" + person.getName() + ":" + person.getEntrytime();
    }
}
