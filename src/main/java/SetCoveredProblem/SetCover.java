package SetCoveredProblem;

import java.util.*;

public class SetCover {
    interface Filter<T> {
        boolean matches(T t);
    }
    public static <T> Set<T> search (Filter<Set<T>> filter, List<T> sets){
        int size = sets.size();
        int comb = 1 << size;

        List<Set<T>> possible = new ArrayList<>();

        for (int i = 0; i < comb; i++) {
            Set<T> combination = new LinkedHashSet<>();
            for (int j = 0; j < size; j++) {
                if (((i >> j) & 1) != 0){
                    combination.add(sets.get(j));
                }
            }
            possible.add(combination);
        }
        Collections.sort(possible, new Comparator<Set<T>>() {
            @Override
            public int compare(Set<T> o1, Set<T> o2) {
                return o1.size() - o2.size();
            }
        });
        for (Set<T> possibleSolution : possible){
            if (filter.matches(possibleSolution)) return possibleSolution;
        }
        return null;
    }
}
