package Knapsack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnapsackTest {

    @Test
    void getKnapsackResolveRec() {
        Knapsack knapsack = new Knapsack();
        int[] weighs = {3,1,2,2,1};
        int[] values = {10,3,9,5,6};
        int n = weighs.length;
        int maxWeigh = 6;
        assertEquals(25,knapsack.getKnapsackResolveRec(weighs,values,n,maxWeigh));
    }

    @Test
    void getKnapsackResolve() {
        Knapsack knapsack = new Knapsack();
        int[] weighs = {3,1,2,2,1};
        int[] values = {10,3,9,5,6};
        int n = weighs.length;
        int maxWeigh = 6;
        assertEquals(25,knapsack.getKnapsackResolve(weighs,values,n,maxWeigh));
    }

    @Test
    void checkZeroArgumentN(){
        Knapsack knapsack = new Knapsack();
        int[] weighs = {};
        int[] values = {};
        int n = weighs.length;
        int maxWeigh = 6;
        assertEquals(0,knapsack.getKnapsackResolve(weighs,values,n,maxWeigh));
        assertEquals(0,knapsack.getKnapsackResolveRec(weighs,values,n,maxWeigh));
    }
    @Test
    void checkZeroArgumentMaxWeigh(){
        Knapsack knapsack = new Knapsack();
        int[] weighs = {3,1,2,2,1};
        int[] values = {10,3,9,5,6};
        int n = weighs.length;
        int maxWeigh = 0;
        assertEquals(0,knapsack.getKnapsackResolve(weighs,values,n,maxWeigh));
        assertEquals(0,knapsack.getKnapsackResolveRec(weighs,values,n,maxWeigh));
    }

}