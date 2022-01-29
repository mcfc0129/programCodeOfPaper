package com.example;

import java.util.Comparator;
import lombok.Data;

@Data
public class Pair {
    private int num;
    private Person name;
    private Person mate;

    public Pair(int num, Person name, Person mate) {
        this.num = num;
        this.name = name;
        this.mate = mate;
    }

    public Pair(Person person) {
        if (person.getName().contains("M")) {
            this.name = person;
        } else {
            this.mate = person;
        }
    }

    public String toString() {
        return (num + " " + name.getName() + ":" + mate.getName());
    }

    public final Comparator<Pair> NAME_ORDER = new NameOrderComparator();

    public static class NameOrderComparator implements Comparator<Pair> {
        public int compare(Pair p1, Pair p2) {
            return p1.name.getName().compareTo(p2.name.getName());
        }
    }

    public final Comparator<Pair> MATE_ORDER = new MateOrderComparator();

    public static class MateOrderComparator implements Comparator<Pair> {
        public int compare(Pair p1, Pair p2) {
            return p1.mate.getName().compareTo(p2.mate.getName());
        }
    }
}
