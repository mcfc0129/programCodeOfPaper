package com.example;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import lombok.Data;

@Data
public class Person {
    private int num;
    private String name;
    private int entrytime;
    private double publicValue;
    private LinkedList<Preference> truePreference;
    private LinkedList<Preference> preference;

    Random random = new Random();

    public Person(int num, String name, int time) {
        this.num = num;
        this.name = name;
        entrytime = random.nextInt(time);
        publicValue = random.nextGaussian();
    }

    public Person(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public Person(int num) {
        this.num = num;
    }

    public Person(String name) {
        this.name = name;
    }

    public void makeTruePreference(LinkedList<Person> mateList, double parameter) {
        this.truePreference = new LinkedList<Preference>();
        Map<Double, String> valueTable = new HashMap<>();
        for (int i = 0; i < mateList.size(); i++) {
            double value = parameter * mateList.get(i).getPublicValue() + (1 - parameter) * (random.nextGaussian());
            valueTable.put(value, mateList.search(new Person(i), (new Person(i)).NUM_ORDER).getName());
        }
        LinkedHashMap<Double, String> result = sortMap(valueTable);
        List<String> tempList = new ArrayList<>();
        result.forEach((key, value) -> {
            tempList.add(value);
        });
        // int selfrank = random.nextInt(mateList.size());
        for (int i = 0; i < 5; i++) {
            Person temp = mateList.search(new Person(tempList.get(i)), (new Person(tempList.get(i))).NAME_ORDER);
            Preference pre = new Preference(i, temp);
            truePreference.addLast(pre);
        }
    }

    public static LinkedHashMap<Double, String> sortMap(Map<Double, String> map) {
        List<Map.Entry<Double, String>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));

        LinkedHashMap<Double, String> result = new LinkedHashMap<>();
        for (Map.Entry<Double, String> entry : entries) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    public void makePreference(int time, int width) {
        this.preference = new LinkedList<>();

        ArrayList<ArrayList<Integer>> table = new ArrayList<>();
        int division = time / width;
        int j = 0;
        for (int i = 1; i <= division; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (; j < width * i && j < time; j++) {
                temp.add(j);
            }
            table.add(temp);
        }
        ArrayList<Integer> myterm = new ArrayList<>();
        for (int i = 0; i < table.size(); i++) {
            if (table.get(i).contains(entrytime)) {
                myterm = table.get(i);
                break;
            }
        }

        for (int i = 0; i < truePreference.size(); i++) {
            Preference temp = truePreference.get(i);
            if (myterm.contains(temp.getPerson().getEntrytime())) {
                preference.addLast(temp);
            }
        }
    }

    public void dumpTruePreference() {
        System.out.println("------" + this.name + ":" + this.entrytime + ": TruePreference------");
        truePreference.dump();
    }

    public void dumpPreference() {
        System.out.println("------" + this.name + ":" + this.entrytime + ": Preference------");
        preference.dump();
    }

    public final Comparator<Person> NUM_ORDER = new NoOrderComparator();

    public static class NoOrderComparator implements Comparator<Person> {
        public int compare(Person p1, Person p2) {
            return (p1.num > p2.num) ? 1 : (p1.num < p2.num) ? -1 : 0;
        }
    }

    public final Comparator<Person> NAME_ORDER = new NameOrderComparator();

    public static class NameOrderComparator implements Comparator<Person> {
        public int compare(Person p1, Person p2) {
            return p1.name.compareTo(p2.name);
        }
    }

    public String toString() {
        return num + ":" + name;
    }
}
