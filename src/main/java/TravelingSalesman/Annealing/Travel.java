package TravelingSalesman.Annealing;

import java.util.ArrayList;
import java.util.Collections;

public class Travel {
    private static ArrayList<City> travel = new ArrayList<>();
    private static ArrayList<City> previousTravel = new ArrayList<>();
    public Travel(int numberOfCities){
        for (int i = 0; i < numberOfCities; i++) {
            travel.add(new City());
        }
    }
    public void getInitTravel(){
        if (travel.isEmpty()){
            new Travel(10);
        }
        Collections.shuffle(travel);
    }
    public City getCity(int index){
        return travel.get(index);
    }
    public void swapCities(){
        int a = getRandomIndex();
        int b = getRandomIndex();
        City x = getCity(a);
        City y = getCity(b);
        previousTravel = travel;
        travel.set(a,y);
        travel.set(b,x);
    }
    public void revertSwap(){
        travel = previousTravel;
    }
    private int getRandomIndex(){
        return (int) (Math.random()*travel.size());
    }
    public double getDistance(){
        double distance = 0;
        for (int i = 0; i < travel.size(); i++) {
            City starting = getCity(i);
            City destination;
                if ((i+1) < travel.size()){
                    destination = getCity(i+1);
                }
                else destination = getCity(0);
            distance += starting.getDistanceBetweenCities(destination);
        }
        return distance;
    }
}
