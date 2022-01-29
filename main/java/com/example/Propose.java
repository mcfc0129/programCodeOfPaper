package com.example;

import java.util.Comparator;
import lombok.Data;

@Data
public class Propose {
    private int num;
    private Person name;
    private Person mate;

    public Propose(int num, Person name, Person mate) {
        this.num = num;
        this.name = name;
        this.mate = mate;
    }

    public Propose(Person name) {
        this.name = name;
    }

    public Propose() {}

    public String toString() {
        return name.getName() + "→" + mate.getName();
    }

    public final Comparator<Propose> NAME_ORDER = new NameOrderComparator();

    public static class NameOrderComparator implements Comparator<Propose> {
        public int compare(Propose a, Propose b) {
            return a.name.getName().compareTo(b.name.getName());
        }
    }
}
