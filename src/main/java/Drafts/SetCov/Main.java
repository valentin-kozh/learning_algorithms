package Drafts.SetCov;

import SetCoveredProblem.SetCover;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Integer[][] all = {
                {1, 2}, {3, 4,5}, {8, 9},
                {10, 7}, {5, 8}, {11, 6},
                {4, 5}, {6, 7}, {10, 11},
        };
        Integer[] solution = {1,2,3,4,5,6,7,8,9,10,11};

        ArrayList<Set<Integer>> sets = new ArrayList<>();
        Set<Integer> sol = new LinkedHashSet<>(Arrays.asList(solution));

        for (Integer[] init : all){
            sets.add(new LinkedHashSet<>(Arrays.asList(init)));
        }

        SetCovered.Filter<Set<Set<Integer>>> filter = new SetCovered.Filter<Set<Set<Integer>>>() {
            @Override
            public boolean match(Set<Set<Integer>> sets) {
                Set<Integer> union = new LinkedHashSet<>();
                for (Set<Integer> set : sets){
                    union.addAll(set);
                }
                return union.equals(sol);
            }
        };

        Set<Set<Integer>> result = SetCovered.getResolveSetCoveredProblem(filter, sets);
        System.out.println(result);
    }
}
