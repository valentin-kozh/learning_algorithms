package SetCoveredProblem;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Integer[][] all = {
                {1, 2}, {3, 4,5}, {8, 9},
                {10, 7}, {5, 8}, {11, 6},
                {4, 5}, {6, 7}, {10, 11},
        };
        Integer[] solution = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

        List<Set<Integer>> sets = new ArrayList<>();
        for(Integer[] i : all){
            sets.add(new LinkedHashSet<>(Arrays.asList(i)));
        }
        Set<Integer> sol = new LinkedHashSet<>(Arrays.asList(solution));

        SetCover.Filter<Set<Set<Integer>>> filter = new SetCover.Filter<Set<Set<Integer>>>() {
            @Override
            public boolean matches(Set<Set<Integer>> sets) {
                Set<Integer> union = new LinkedHashSet<>();
                for (Set<Integer> set : sets){
                    union.addAll(set);
                }
                return union.equals(sol);
            }
        };

        Set<Set<Integer>> result = SetCover.search(filter, sets);
        System.out.println(result);
    }
}
