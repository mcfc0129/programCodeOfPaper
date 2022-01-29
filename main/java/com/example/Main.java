package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        int simulation_size = 1;
        int mList_size = 5;
        int wList_size = 5;
        int time = 2;
        int width1 = 1;
        int width2 = 2;
        int width3 = 3;
        int width4 = 4;
        int width6 = 6;
        int width12 = 12;

        ArrayList<Integer> result_width1_DA_stable = new ArrayList<>();
        ArrayList<Integer> result_width2_DA_stable = new ArrayList<>();
        ArrayList<Integer> result_width3_DA_stable = new ArrayList<>();
        ArrayList<Integer> result_width4_DA_stable = new ArrayList<>();
        ArrayList<Integer> result_width6_DA_stable = new ArrayList<>();
        ArrayList<Integer> result_width12_DA_stable = new ArrayList<>();

        ArrayList<Integer> result_width1_TTC_stable = new ArrayList<>();
        ArrayList<Integer> result_width2_TTC_stable = new ArrayList<>();
        ArrayList<Integer> result_width3_TTC_stable = new ArrayList<>();
        ArrayList<Integer> result_width4_TTC_stable = new ArrayList<>();
        ArrayList<Integer> result_width6_TTC_stable = new ArrayList<>();
        ArrayList<Integer> result_width12_TTC_stable = new ArrayList<>();

        ArrayList<Integer> result_width1_DA_efficiency = new ArrayList<>();
        ArrayList<Integer> result_width2_DA_efficiency = new ArrayList<>();
        ArrayList<Integer> result_width3_DA_efficiency = new ArrayList<>();
        ArrayList<Integer> result_width4_DA_efficiency = new ArrayList<>();
        ArrayList<Integer> result_width6_DA_efficiency = new ArrayList<>();
        ArrayList<Integer> result_width12_DA_efficiency = new ArrayList<>();

        ArrayList<Integer> result_width1_TTC_efficiency = new ArrayList<>();
        ArrayList<Integer> result_width2_TTC_efficiency = new ArrayList<>();
        ArrayList<Integer> result_width3_TTC_efficiency = new ArrayList<>();
        ArrayList<Integer> result_width4_TTC_efficiency = new ArrayList<>();
        ArrayList<Integer> result_width6_TTC_efficiency = new ArrayList<>();
        ArrayList<Integer> result_width12_TTC_efficiency = new ArrayList<>();

        for (int a = 0; a < simulation_size; a++) {
            long start7 = System.currentTimeMillis();
            LinkedList<Person> mList = new LinkedList<>();
            LinkedList<Person> wList = new LinkedList<>();

            for (int i = 0; i < mList_size; i++) {
                mList.addLast(new Person(i, "M" + i, time));
            }
            for (int i = 0; i < wList_size; i++) {
                wList.addLast(new Person(i, "W" + i, time));
            }

            for (int i = 0; i < wList_size; i++) {
                wList.get(i).makeTruePreference(mList, 0.5);
                wList.get(i).dumpTruePreference();
            }
            for (int i = 0; i < mList_size; i++) {
                mList.get(i).makeTruePreference(wList, 0.5);
                mList.get(i).dumpTruePreference();
            }

            for (int i = 0; i < mList_size; i++) {
                mList.get(i).makePreference(time, width1);
            }
            for (int i = 0; i < wList_size; i++) {
                wList.get(i).makePreference(time, width1);
            }
            LinkedList<LinkedList<Person>> mList_width1_DA = makeList(mList, time, width1);
            LinkedList<LinkedList<Person>> wList_width1_DA = makeList(wList, time, width1);
            LinkedList<LinkedList<Pair>> pair_width1_DA = DA_width(mList_width1_DA, wList_width1_DA, time, width1);
            result_width1_DA_stable.add(stableCheck(pair_width1_DA));
            result_width1_DA_efficiency.add(efficiencyCheck(pair_width1_DA, mList_size));

            for (int i = 0; i < mList_size; i++) {
                mList.get(i).makePreference(time, width2);
            }
            for (int i = 0; i < wList_size; i++) {
                wList.get(i).makePreference(time, width2);
            }
            LinkedList<LinkedList<Person>> mList_width2_DA = makeList(mList, time, width2);
            LinkedList<LinkedList<Person>> wList_width2_DA = makeList(wList, time, width2);
            LinkedList<LinkedList<Pair>> pair_width2_DA = DA_width(mList_width2_DA, wList_width2_DA, time, width2);
            result_width2_DA_stable.add(stableCheck(pair_width2_DA));
            result_width2_DA_efficiency.add(efficiencyCheck(pair_width2_DA, mList_size));

            for (int i = 0; i < mList_size; i++) {
                mList.get(i).makePreference(time, width3);
            }
            for (int i = 0; i < wList_size; i++) {
                wList.get(i).makePreference(time, width3);
            }
            LinkedList<LinkedList<Person>> mList_width3_DA = makeList(mList, time, width3);
            LinkedList<LinkedList<Person>> wList_width3_DA = makeList(wList, time, width3);
            LinkedList<LinkedList<Pair>> pair_width3_DA = DA_width(mList_width3_DA, wList_width3_DA, time, width3);
            result_width3_DA_stable.add(stableCheck(pair_width3_DA));
            result_width3_DA_efficiency.add(efficiencyCheck(pair_width3_DA, mList_size));

            for (int i = 0; i < mList_size; i++) {
                mList.get(i).makePreference(time, width4);
            }
            for (int i = 0; i < wList_size; i++) {
                wList.get(i).makePreference(time, width4);
            }
            LinkedList<LinkedList<Person>> mList_width4_DA = makeList(mList, time, width4);
            LinkedList<LinkedList<Person>> wList_width4_DA = makeList(wList, time, width4);
            LinkedList<LinkedList<Pair>> pair_width4_DA = DA_width(mList_width4_DA, wList_width4_DA, time, width4);
            result_width4_DA_stable.add(stableCheck(pair_width4_DA));
            result_width4_DA_efficiency.add(efficiencyCheck(pair_width4_DA, mList_size));

            for (int i = 0; i < mList_size; i++) {
                mList.get(i).makePreference(time, width6);
            }
            for (int i = 0; i < wList_size; i++) {
                wList.get(i).makePreference(time, width6);
            }
            LinkedList<LinkedList<Person>> mList_width6_DA = makeList(mList, time, width6);
            LinkedList<LinkedList<Person>> wList_width6_DA = makeList(wList, time, width6);
            LinkedList<LinkedList<Pair>> pair_width6_DA = DA_width(mList_width6_DA, wList_width6_DA, time, width6);
            result_width6_DA_stable.add(stableCheck(pair_width6_DA));
            result_width6_DA_efficiency.add(efficiencyCheck(pair_width6_DA, mList_size));

            for (int i = 0; i < mList_size; i++) {
                mList.get(i).makePreference(time, width12);
            }
            for (int i = 0; i < wList_size; i++) {
                wList.get(i).makePreference(time, width12);
            }
            LinkedList<LinkedList<Person>> mList_width12_DA = makeList(mList, time, width12);
            LinkedList<LinkedList<Person>> wList_width12_DA = makeList(wList, time, width12);
            LinkedList<LinkedList<Pair>> pair_width12_DA = DA_width(mList_width12_DA, wList_width12_DA, time, width12);
            result_width12_DA_stable.add(stableCheck(pair_width12_DA));
            result_width12_DA_efficiency.add(efficiencyCheck(pair_width12_DA, mList_size));

            for (int i = 0; i < mList_size; i++) {
                mList.get(i).makePreference(time, width1);
            }
            for (int i = 0; i < wList_size; i++) {
                wList.get(i).makePreference(time, width1);
            }
            LinkedList<LinkedList<Person>> mList_width1_TTC = makeList(mList, time, width1);
            LinkedList<LinkedList<Person>> wList_width1_TTC = makeList(wList, time, width1);
            LinkedList<LinkedList<Pair>> pair_width1_TTC = TTC_width(mList_width1_TTC, wList_width1_TTC, time, width1);
            result_width1_TTC_stable.add(stableCheck(pair_width1_TTC));
            result_width1_TTC_efficiency.add(efficiencyCheck(pair_width1_TTC, mList_size));

            for (int i = 0; i < mList_size; i++) {
                mList.get(i).makePreference(time, width2);
            }
            for (int i = 0; i < wList_size; i++) {
                wList.get(i).makePreference(time, width2);
            }
            LinkedList<LinkedList<Person>> mList_width2_TTC = makeList(mList, time, width2);
            LinkedList<LinkedList<Person>> wList_width2_TTC = makeList(wList, time, width2);
            LinkedList<LinkedList<Pair>> pair_width2_TTC = TTC_width(mList_width2_TTC, wList_width2_TTC, time, width2);
            result_width2_TTC_stable.add(stableCheck(pair_width2_TTC));
            result_width2_TTC_efficiency.add(efficiencyCheck(pair_width2_TTC, mList_size));

            for (int i = 0; i < mList_size; i++) {
                mList.get(i).makePreference(time, width3);
            }
            for (int i = 0; i < wList_size; i++) {
                wList.get(i).makePreference(time, width3);
            }
            LinkedList<LinkedList<Person>> mList_width3_TTC = makeList(mList, time, width3);
            LinkedList<LinkedList<Person>> wList_width3_TTC = makeList(wList, time, width3);
            LinkedList<LinkedList<Pair>> pair_width3_TTC = TTC_width(mList_width3_TTC, wList_width3_TTC, time, width3);
            result_width3_TTC_stable.add(stableCheck(pair_width3_TTC));
            result_width3_TTC_efficiency.add(efficiencyCheck(pair_width3_TTC, mList_size));

            for (int i = 0; i < mList_size; i++) {
                mList.get(i).makePreference(time, width4);
            }
            for (int i = 0; i < wList_size; i++) {
                wList.get(i).makePreference(time, width4);
            }
            LinkedList<LinkedList<Person>> mList_width4_TTC = makeList(mList, time, width4);
            LinkedList<LinkedList<Person>> wList_width4_TTC = makeList(wList, time, width4);
            LinkedList<LinkedList<Pair>> pair_width4_TTC = TTC_width(mList_width4_TTC, wList_width4_TTC, time, width4);
            result_width4_TTC_stable.add(stableCheck(pair_width4_TTC));
            result_width4_TTC_efficiency.add(efficiencyCheck(pair_width4_TTC, mList_size));

            for (int i = 0; i < mList_size; i++) {
                mList.get(i).makePreference(time, width6);
            }
            for (int i = 0; i < wList_size; i++) {
                wList.get(i).makePreference(time, width6);
            }
            LinkedList<LinkedList<Person>> mList_width6_TTC = makeList(mList, time, width6);
            LinkedList<LinkedList<Person>> wList_width6_TTC = makeList(wList, time, width6);
            LinkedList<LinkedList<Pair>> pair_width6_TTC = TTC_width(mList_width6_TTC, wList_width6_TTC, time, width6);
            result_width6_TTC_stable.add(stableCheck(pair_width6_TTC));
            result_width6_TTC_efficiency.add(efficiencyCheck(pair_width6_TTC, mList_size));

            for (int i = 0; i < mList_size; i++) {
                mList.get(i).makePreference(time, width12);
            }
            for (int i = 0; i < wList_size; i++) {
                wList.get(i).makePreference(time, width12);
            }
            LinkedList<LinkedList<Person>> mList_width12_TTC = makeList(mList, time, width12);
            LinkedList<LinkedList<Person>> wList_width12_TTC = makeList(wList, time, width12);
            LinkedList<LinkedList<Pair>> pair_width12_TTC = TTC_width(mList_width12_TTC, wList_width12_TTC, time, width12);
            result_width12_TTC_stable.add(stableCheck(pair_width12_TTC));
            result_width12_TTC_efficiency.add(efficiencyCheck(pair_width12_TTC, mList_size));

            long end7 = System.currentTimeMillis();
            System.out.println(end7 - start7 + "ms");
            System.out.println(a + "回目");
        }
        writeFile(result_width1_DA_stable, "width1_DA_stable.csv");
        writeFile(result_width2_DA_stable, "width2_DA_stable.csv");
        writeFile(result_width3_DA_stable, "width3_DA_stable.csv");
        writeFile(result_width4_DA_stable, "widht4_DA_stable.csv");
        writeFile(result_width6_DA_stable, "width6_DA_stable.csv");
        writeFile(result_width12_DA_stable, "width12_DA_stable.csv");
        writeFile(result_width1_TTC_stable, "width1_TTC_stable.csv");
        writeFile(result_width2_TTC_stable, "width2_TTC_stable.csv");
        writeFile(result_width3_TTC_stable, "width3_TTC_stable.csv");
        writeFile(result_width4_TTC_stable, "widht4_TTC_stable.csv");
        writeFile(result_width6_TTC_stable, "width6_TTC_stable.csv");
        writeFile(result_width12_TTC_stable, "width12_TTC_stable.csv");

        writeFile(result_width1_DA_efficiency, "width1_DA_efficiency.csv");
        writeFile(result_width2_DA_efficiency, "width2_DA_efficiency.csv");
        writeFile(result_width3_DA_efficiency, "width3_DA_efficiency.csv");
        writeFile(result_width4_DA_efficiency, "widht4_DA_efficiency.csv");
        writeFile(result_width6_DA_efficiency, "width6_DA_efficiency.csv");
        writeFile(result_width12_DA_efficiency, "width12_DA_efficiency.csv");
        writeFile(result_width1_TTC_efficiency, "width1_TTC_efficiency.csv");
        writeFile(result_width2_TTC_efficiency, "width2_TTC_efficiency.csv");
        writeFile(result_width3_TTC_efficiency, "width3_TTC_efficiency.csv");
        writeFile(result_width4_TTC_efficiency, "widht4_TTC_efficiency.csv");
        writeFile(result_width6_TTC_efficiency, "width6_TTC_efficiency.csv");
        writeFile(result_width12_TTC_efficiency, "width12_TTC_efficiency.csv");
    }

    public static LinkedList<Pair> DA(LinkedList<Person> list1, LinkedList<Person> list2) {
        LinkedList<Person> mList = clone(list1);
        LinkedList<Person> wList = clone(list2);

        LinkedList<Person> poolList = new LinkedList<>();
        LinkedList<Propose> propose = new LinkedList<>();
        LinkedList<Pair> pair = new LinkedList<>();
        int pairNum = 0;
        for (int i = 0; i < mList.size(); i++) {
            Person man = mList.get(i);
            LinkedList<Preference> man_pre = man.getPreference();
            if (man_pre.size() != 0) {
                Propose pro = new Propose(i, man, man_pre.get(0).getPerson());
                propose.addLast(pro);
                man_pre.removeFirst();
            } else {
                poolList.addLast(man);
            }
        }
        while (true) {
            HashMap<String, LinkedList<Person>> proList = new HashMap<>();
            for (int i = 0; i < propose.size(); i++) {
                Propose pro = propose.get(i);
                Person mate = pro.getMate();
                LinkedList<Person> temp = new LinkedList<>();
                temp = proList.get(mate.getName());
                if (temp == null) {
                    LinkedList<Person> duplication = new LinkedList<>();
                    duplication.addLast(pro.getName());
                    proList.put(mate.getName(), duplication);
                } else {
                    proList.get(mate.getName()).addLast(pro.getName());
                }
            }
            ArrayList<String> keyList = new ArrayList<>(proList.keySet());
            for (int i = 0; i < keyList.size(); i++) {
                Person woman = wList.search(new Person(keyList.get(i)), (new Person(keyList.get(i))).NAME_ORDER);
                LinkedList<Preference> wo_pre = woman.getPreference();
                LinkedList<Person> list = proList.get(keyList.get(i));
                for (int j = 0; j < list.size();) {
                    Person man = list.get(j);
                    if (!contains(man.getName(), wo_pre)) {
                        poolList.addLast(man);
                        list.removeCurrentNode();
                    } else {j++;}
                }
                if (list.size() > 1) {
                    Person winner = list.get(0);
                    int winner_rank = wo_pre.search(new Preference(winner), (new Preference(winner)).NAME_ORDER).getRank();
                    int j = 1;
                    do {
                        Person charenger = list.get(j);
                        int charenger_rank = wo_pre.search(new Preference(charenger), (new Preference(charenger)).NAME_ORDER).getRank();
                        if (winner_rank > charenger_rank) {
                            poolList.addLast(winner);
                            list.removeFirst();
                            winner = charenger;
                            winner_rank = charenger_rank;
                        } else {
                            poolList.addLast(charenger);
                            list.removeCurrentNode();
                        }
                    } while (list.size() != 1);
                }
            }

            for (int i = 0; i < poolList.size();) {
                Person pool = poolList.get(i);
                if (pool.getPreference().size() == 0) {
                    Propose pro = propose.search(new Propose(pool), new Propose(pool).NAME_ORDER);
                    if (pro != null) {
                        propose.removeCurrentNode();
                    }
                    Person single = list1.search(new Person(pool.getName()), (new Person(pool.getName())).NAME_ORDER);
                    Pair single_pair = new Pair(pairNum, single, single);
                    pairNum++;
                    pair.addLast(single_pair);
                    poolList.removeCurrentNode();
                } else {i++;}
            }

            if (poolList.size() == 0 || endCondition(poolList)) {
                for (int i = 0; i < wList.size(); i++) {
                    Person woman_temp = wList.get(i);
                    Person woman = list2.search(new Person(woman_temp.getName()), (new Person(woman_temp.getName())).NAME_ORDER);
                    if (proList.get(woman.getName()) != null) {
                        if (proList.get(woman.getName()).size() != 0) {
                            Person mate = mList.search(new Person(proList.get(woman.getName()).get(0).getName()), (new Person(proList.get(woman.getName()).get(0).getName())).NAME_ORDER);
                            Pair temp = new Pair(pairNum, mate, woman);
                            pairNum++;
                            pair.addLast(temp);
                        } else {
                            Pair temp = new Pair(pairNum, woman, woman);
                            pairNum++;
                            pair.addLast(temp);
                        }
                    } else {
                        Pair temp = new Pair(pairNum, woman, woman);
                        pairNum++;
                        pair.addLast(temp);
                    }
                }
                break;
            }

            for (int i = 0; i < poolList.size();) {
                Person man = poolList.get(i);
                LinkedList<Preference> man_pre = man.getPreference();
                Propose pro = propose.search(new Propose(man), (new Propose(man)).NAME_ORDER);
                pro.setMate(man_pre.get(0).getPerson());
                man_pre.removeFirst();
                poolList.removeFirst();
            }
        }
        return pair;
    }

    public static boolean endCondition(LinkedList<Person> poolList) {
        int counter = 0;
        for (int i = 0; i < poolList.size(); i++) {
            if (poolList.get(i).getPreference() == null) {
                counter++;
            }
        }
        return counter != poolList.size() ? false : true;
    }

    public static boolean contains(String name, LinkedList<Preference> list) {
        for (int i = 0; i < list.size(); i++) {
            Preference data = list.get(i);
            if (data.getPerson().getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static LinkedList<Pair> TTC(LinkedList<Person> mList, LinkedList<Person> wList) {
        LinkedList<Person> list1 = clone(mList);
        LinkedList<Person> list2 = clone(wList);
        LinkedList<Person> poolList_woman = new LinkedList<>();
        LinkedList<Person> poolList_man = new LinkedList<>();

        LinkedList<Pair> pairs = new LinkedList<>();
        while ((list1.size() != 0) || (list2.size() != 0)) {
            // System.out.println(list1);
            // System.out.println(list2);
            HashMap<String, LinkedList<Person>> possession = new HashMap<>();
            for (int i = 0; i < list2.size(); i++) {
                Person woman = list2.get(i);
                LinkedList<Preference> pref = woman.getPreference();
                if (pref.size() != 0) {
                    String firstman = pref.get(0).getPerson().getName();
                    Person firstChoice = list1.search(new Person(firstman), (new Person(firstman)).NAME_ORDER);
                    while (firstChoice == null || firstChoice.getPreference().size() == 0) {
                        pref.removeFirst();
                        if (pref.size() == 0) {
                            poolList_woman.addFirst(woman);
                            break;
                        }
                        firstChoice = list1.search(new Person(pref.get(0).getPerson().getName()), (new Person(pref.get(0).getPerson().getName())).NAME_ORDER);
                    }
                    if (pref.size() > 0) {
                        LinkedList<Person> womanList = possession.get(firstChoice.getName());
                        if (womanList == null) {
                            LinkedList<Person> duplication = new LinkedList<>();
                            duplication.addFirst(woman);
                            possession.put(firstChoice.getName(), duplication);
                        } else {
                            possession.get(firstChoice.getName()).addFirst(woman);
                        }
                    }
                } else {
                    poolList_woman.addFirst(woman);
                }
            }

            // System.out.println(possession);
            HashMap<String, String> point = new HashMap<>();
            ArrayList<String> key = new ArrayList<>(possession.keySet());
            for (int i = 0; i < list1.size(); i++) {
                Person man = list1.get(i);
                // System.out.println(man);
                LinkedList<Preference> pref = man.getPreference();
                if (pref.size() != 0) {
                    String firstwoman = pref.get(0).getPerson().getName();
                    Person firstChoice = list2.search(new Person(firstwoman), (new Person(firstwoman)).NAME_ORDER);
                    while (firstChoice == null || firstChoice.getPreference().size() == 0) {
                        pref.removeFirst();
                        if (pref.size() == 0) {
                            poolList_man.addFirst(man);
                            break;
                        }
                        firstChoice = list2.search(new Person(pref.get(0).getPerson().getName()), (new Person(pref.get(0).getPerson().getName())).NAME_ORDER);
                    }
                    if (pref.size() > 0) {
                        for (int j = 0; j < key.size(); j++) {
                            if (possession.get(key.get(j)).contain(firstChoice, firstChoice.NAME_ORDER)) {
                                point.put(man.getName(), key.get(j));
                                break;
                            }
                        }
                    }
                } else {
                    poolList_man.addFirst(man);
                }
            }
            // System.out.println(point);
            for (int i = 0; i < poolList_man.size(); i++) {
                Pair single = new Pair(i, poolList_man.get(i), poolList_man.get(i));
                pairs.addFirst(single);
                list1.search(new Person(poolList_man.get(i).getName()), (new Person(poolList_man.get(i).getName())).NAME_ORDER);
                list1.removeCurrentNode();
            }
            for (int i = 0; i < poolList_woman.size(); i++) {
                Pair single = new Pair(i, poolList_woman.get(i), poolList_woman.get(i));
                pairs.addFirst(single);
                list2.search(new Person(poolList_woman.get(i).getName()), (new Person(poolList_woman.get(i).getName())).NAME_ORDER);
                list2.removeCurrentNode();
            }
            poolList_man.clear();poolList_woman.clear();

            LinkedList<LinkedList<Person>> topCycle = new LinkedList<>();
            for (int i = 0; i < list1.size(); i++) {
                LinkedList<Person> cycle = new LinkedList<>();
                Person man = list1.get(i);
                cycle.addFirst(man);
                Person choice = list1.search(new Person(point.get(man.getName())), (new Person(point.get(man.getName()))).NAME_ORDER);
                if (choice == null) {
                    continue;
                }
                while (!cycle.contain(choice, choice.NAME_ORDER) || !list1.contain(choice, choice.NAME_ORDER)) {
                    cycle.addFirst(choice);
                    choice = list1.search(new Person(point.get(choice.getName())), (new Person(point.get(choice.getName()))).NAME_ORDER);
                    if (choice == null) {
                        break;
                    }
                }
                if (man == choice) {
                    topCycle.addFirst(cycle);
                    for (int j = 0; j < cycle.size(); j++) {
                        list1.search(new Person(cycle.get(j).getName()), (new Person(cycle.get(j).getName())).NAME_ORDER);
                        list1.removeCurrentNode();
                    }
                    i--;
                }
            }
            // System.out.println(topCycle);
            for (int i = 0; i < topCycle.size(); i++) {
                for (int j = 0; j < topCycle.get(i).size(); j++) {
                    Pair pair = new Pair(j, topCycle.get(i).get(j), topCycle.get(i).get(j).getPreference().get(0).getPerson());
                    pairs.addLast(pair);
                }
            }
            // System.out.println(pairs);
            for (int i = 0; i < pairs.size(); i++) {
                Person man = pairs.get(i).getName();
                Person woman = pairs.get(i).getMate();
                if (!man.getName().equals(woman.getName())) {
                    Person listinmate = list2.search(new Person(woman.getName()), (new Person(woman.getName())).NAME_ORDER);
                    // System.out.println(listinmate);
                    if (listinmate != null) {
                        list2.removeCurrentNode();
                    }
                }
            }
        } //while ();
        // System.out.println(pairs);
        return pairs;
    }

    public static LinkedList<LinkedList<Pair>> DA_width(LinkedList<LinkedList<Person>> mList, LinkedList<LinkedList<Person>> wList, int time, int width) {
        LinkedList<LinkedList<Pair>> pairs = new LinkedList<>();
        for (int i = 0; i < (time / width) - 1; i++) {
            LinkedList<Pair> pair = DA(mList.get(i), wList.get(i));

            LinkedList<Person> single = searchSingle(pair);
            pairs.addLast(pair);

            LinkedList<Person> nextmList = mList.get(i + 1);
            LinkedList<Person> nextwList = wList.get(i + 1);
            for (int j = 0; j < single.size(); j++) {
                Person per = single.get(j);
                int nowEntrytime = per.getEntrytime();
                per.setEntrytime(nowEntrytime + width); //
                if (per.getName().contains("M")) {
                    nextmList.addLast(per);
                } else {
                    nextwList.addLast(per);
                }
            }

            for (int j = 0; j < nextmList.size(); j++) {
                nextmList.get(j).makePreference(time, width);
            }
            for (int j = 0; j < nextwList.size(); j++) {
                nextwList.get(j).makePreference(time, width);
            }
        }
        LinkedList<Pair> pair = DA(mList.get((time / width) - 1), wList.get((time / width) - 1));
        pairs.addLast(pair);
        return pairs;
    }

    public static LinkedList<LinkedList<Pair>> TTC_width(LinkedList<LinkedList<Person>> mList, LinkedList<LinkedList<Person>> wList, int time, int width) {
        LinkedList<LinkedList<Pair>> pairs = new LinkedList<>();
        for (int i = 0; i < (time / width) - 1; i++) {
            LinkedList<Pair> pair = TTC(mList.get(i), wList.get(i));

            LinkedList<Person> single = searchSingle(pair);
            pairs.addFirst(pair);

            LinkedList<Person> nextmList = mList.get(i + 1);
            LinkedList<Person> nextwList = wList.get(i + 1);
            for (int j = 0; j < single.size(); j++) {
                Person per = single.get(j);
                int nowEntrytime = per.getEntrytime();
                per.setEntrytime(nowEntrytime + width);
                if (per.getName().contains("M")) {
                    nextmList.addLast(per);
                } else {
                    nextwList.addLast(per);
                }
            }

            for (int j = 0; j < nextmList.size(); j++) {
                nextmList.get(j).makePreference(time, width);
            }
            for (int j = 0; j < nextwList.size(); j++) {
                nextwList.get(j).makePreference(time, width);
            }
        }
        LinkedList<Pair> pair = TTC(mList.get((time / width) - 1), wList.get((time / width) - 1));
        pairs.addFirst(pair);
        return pairs;
    }

    public static LinkedList<Person> searchSingle(LinkedList<Pair> list) {
        LinkedList<Person> singles = new LinkedList<>();
        for (int i = 0; i < list.size();) {
            Pair pair = list.get(i);
            if (pair.getName().getName().equals(pair.getMate().getName())) {
                singles.addLast(pair.getName());
                list.removeCurrentNode();
            } else {i++;}
        }
        return singles;
    }

    public static LinkedList<LinkedList<Person>> makeList(LinkedList<Person> list, int time, int width) {
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
        LinkedList<LinkedList<Person>> result = new LinkedList<>();
        for (int i = 0; i < table.size(); i++) {
            LinkedList<Person> temp = new LinkedList<>();
            for (int k = 0; k < list.size(); k++) {
                Person temp_per = list.get(k);
                if (table.get(i).contains(temp_per.getEntrytime())) {
                    temp.addLast(temp_per);
                }
            }
            result.addLast(temp);
        }

        return result;
    }

    public static LinkedList<Person> clone(LinkedList<Person> mList) {
        LinkedList<Person> temp_copyList = new LinkedList<>();
        for (int  i = 0; i < mList.size(); i++) {
            Person copySource = mList.get(i);
            Person copy = new Person(copySource.getNum(), copySource.getName());
            copy.setEntrytime(copySource.getEntrytime());
            copy.setPublicValue(copySource.getPublicValue());
            temp_copyList.addLast(copy);

            //todo
            LinkedList<Preference> tp = mList.get(i).getTruePreference();
            LinkedList<Preference> copy_truepre = new LinkedList<>();
            for (int j = 0; j < tp.size(); j++) {
                Preference pre = tp.get(j);
                Preference copy_pre = new Preference(pre.getRank(), pre.getPerson());
                copy_truepre.addLast(copy_pre);
            }
            copy.setTruePreference(copy_truepre);
            LinkedList<Preference> copy_pre = new LinkedList<>();
            LinkedList<Preference> p = mList.get(i).getPreference();
            if (p != null) {
                for (int j = 0; j < p.size(); j++) {
                    Preference pre = p.get(j);
                    Preference copy_temp = new Preference(pre.getRank(), pre.getPerson());
                    copy_pre.addLast(copy_temp);
                }
                copy.setPreference(copy_pre);
            }
        }

        return temp_copyList;
    }

    public static int stableCheck(LinkedList<LinkedList<Pair>> list) {
        int unstable = 0;
        LinkedList<Pair> pairs = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                pairs.addLast(list.get(i).get(j));
            }
        }
        System.out.println(pairs);

        for (int i = 0; i < pairs.size(); i++) {
            Pair pair = pairs.get(i);
            LinkedList<Preference> pre = pair.getName().getTruePreference();
            if (pair.getName().getName() != pair.getMate().getName()) {
                int pair_rank = pre.search(new Preference(pair.getMate()), (new Preference(pair.getMate())).NAME_ORDER).getRank();
                for (int j = 0; j < pair_rank; j++) {
                    Preference p = pre.get(j);
                    Person charenger = p.getPerson();
                    LinkedList<Preference> charenger_pre = charenger.getTruePreference();
                    Pair charenger_pair = pairs.search(new Pair(charenger), (new Pair(charenger)).MATE_ORDER);
                    if (charenger_pair.getName().getName() != charenger_pair.getMate().getName()) {
                        Preference mateinpre = charenger_pre.search(new Preference(charenger_pair.getName()), (new Preference(charenger_pair.getName())).NAME_ORDER);
                        if (mateinpre == null) {
                            unstable++;
                            continue;
                        }
                        int rank = mateinpre.getRank();
                        Preference temp = charenger_pre.search(new Preference(pair.getName()), (new Preference(pair.getName())).NAME_ORDER);
                        if (temp != null) {
                            int self_rank = temp.getRank();
                            if (rank > self_rank) {
                                unstable++;
                            }
                        }
                    } else {
                        Preference temp = charenger_pre.search(new Preference(pair.getName()), (new Preference(pair.getName())).NAME_ORDER);
                        if (temp != null) {
                            unstable++;
                        }
                    }
                }
            } else {
                if (pair.getName().getName().contains("M")) {
                    for (int j = 0; j < pre.size(); j++) {
                        Preference p = pre.get(j);
                        Person charenger = p.getPerson();
                        LinkedList<Preference> charenger_pre = charenger.getTruePreference();
                        Pair charenger_pair = pairs.search(new Pair(charenger), (new Pair(charenger)).MATE_ORDER);
                        // System.out.println(charenger_pair);
                        if (charenger_pair.getName().getName() != charenger_pair.getMate().getName()) {
                            Preference mateinpre = charenger_pre.search(new Preference(charenger_pair.getName()), (new Preference(charenger_pair.getName())).NAME_ORDER);
                            if (mateinpre == null) {
                                unstable++;
                                continue;
                            }
                            int rank = mateinpre.getRank();
                            Preference temp = charenger_pre.search(new Preference(pair.getName()), (new Preference(pair.getName())).NAME_ORDER);
                            if (temp != null) {
                                int self_rank = temp.getRank();
                                if (rank > self_rank) {
                                    unstable++;
                                }
                            }
                        } else {
                            Preference temp = charenger_pre.search(new Preference(pair.getName()), (new Preference(pair.getName())).NAME_ORDER);
                            if (temp != null) {
                                unstable++;
                            }
                        }
                    }
                } else {
                    for (int j = 0; j < pre.size(); j++) {
                        Preference p = pre.get(j);
                        Person charenger = p.getPerson();
                        LinkedList<Preference> charenger_pre = charenger.getTruePreference();
                        Pair charenger_pair = pairs.search(new Pair(charenger), (new Pair(charenger)).NAME_ORDER);
                        if (charenger_pair.getName().getName() == charenger_pair.getMate().getName()) {
                            Preference temp = charenger_pre.search(new Preference(pair.getMate()), (new Preference(pair.getMate())).NAME_ORDER);
                            if (temp != null) {
                                unstable++;
                            }
                        }
                    }
                }
            }
        }
        return unstable;
    }

    public static int efficiencyCheck(LinkedList<LinkedList<Pair>> list, int size) {
        int efficiency = 0;
        LinkedList<Pair> pairs = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                pairs.addLast(list.get(i).get(j));
            }
        }

        for (int i = 0; i < pairs.size(); i++) {
            Person man = pairs.get(i).getName();
            Person woman = pairs.get(i).getMate();
            LinkedList<Preference> pref = man.getTruePreference();
            if (!man.getName().equals(woman.getName())) {
                int rank = pref.search(new Preference(woman), (new Preference(woman)).NAME_ORDER).getRank();
                int temp_effi = size - rank;
                efficiency += temp_effi;
            }
        }

        return efficiency;
    }

    public static void writeFile(ArrayList<Integer> list, String filename) {
        try {
            FileWriter fr = new FileWriter(filename, false);
            PrintWriter pw = new PrintWriter(new BufferedWriter(fr));
            for (int i = 0; i < list.size(); i++) {
                int a = (int) list.get(i);
                String str = String.valueOf(a);
                pw.write(str + "\n");
            }
            pw.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
