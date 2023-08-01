package TravelingSalesman.Annealing;

public class SimulatedAnnealing {
    private static Travel travel = new Travel(10);

    public static double simulateAnnealing(double startingTemperature, int numberOfIterations, double coolingRotation){
        double t = startingTemperature;
        travel.getInitTravel();
        double bestDistance = travel.getDistance();
        double b1 = bestDistance;
        System.out.println("Initial distance = "+bestDistance);
        for (int i = 0; i < numberOfIterations; i++) {
            if (t > 0.1){
                travel.swapCities();
                double currentDistance = travel.getDistance();
                if (currentDistance < bestDistance) {
                    bestDistance = currentDistance;
                } else if (Math.exp((bestDistance-currentDistance)/t) < Math.random()){
                    travel.revertSwap();
                }
                t *= coolingRotation;
            }
        }
        System.out.println("Best distance = "+bestDistance);
        System.out.println("Difference = "+((int)(b1-bestDistance)));
        return bestDistance;
    }
}
