package Knapsack;

public class Knapsack {
    public int getKnapsackResolve(int[] weighs, int[] values, int n, int maxWeigh){
        if (n <= 0 || maxWeigh <= 0) return 0;
        int[][] m = new int[n+1][maxWeigh+1];
        for (int j = 0; j <= maxWeigh; j++) {
            m[0][j] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxWeigh; j++) {
                if (weighs[i-1] > j) {
                    m[i][j] = m[i-1][j];
                }
                else {
                    m[i][j] = Math.max(m[i-1][j],
                            values[i-1] + m[i-1][j-weighs[i-1]]);
                }
            }
        }
        return m[n][maxWeigh];
    }
    public int getKnapsackResolveRec(int[] weighs, int[] values, int n, int maxWeigh){
        if (n <= 0) return 0;
        else if (weighs[n-1] > maxWeigh) return getKnapsackResolveRec(weighs,values,n-1,maxWeigh);
        else return Math.max(
                getKnapsackResolveRec(weighs,values,n-1,maxWeigh),
                values[n-1] + getKnapsackResolveRec(weighs,values,n-1, maxWeigh - weighs[n-1])
            );
    }
}
