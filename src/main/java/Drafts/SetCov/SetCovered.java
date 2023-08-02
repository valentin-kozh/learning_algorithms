package Drafts.SetCov;

import java.util.*;

public class SetCovered {
    interface Filter<T>{
        boolean match (T t);
    }
    public static <T> Set<T> getResolveSetCoveredProblem(Filter<Set<T>> filter, List<T> sol){
        int size = sol.size();
        int comb = 1 << size;

        List<Set<T>> possible = new ArrayList<>();
        for (int i = 0; i < comb; i++) {
            Set<T> combinations = new LinkedHashSet<>();
            for (int j = 0; j < size; j++) {
                if (((i >> j) & 1) != 0){
                    combinations.add(sol.get(j));
                }
            }
            possible.add(combinations);
        }
        Collections.sort(possible, new Comparator<Set<T>>() {
            @Override
            public int compare(Set<T> o1, Set<T> o2) {
                return o1.size() - o2.size();
            }
        });
        for (Set<T> possibleSol : possible){
            if (filter.match(possibleSol)) return possibleSol;
        }
        return null;
    }

}
