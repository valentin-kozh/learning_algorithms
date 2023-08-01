package TravelingSalesman.Annealing;

public class City {
     private int x;
     private int y;
     public City(){
         this.x = (int) (Math.random()*500);
         this.y = (int) (Math.random()*500);
     }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public double getDistanceBetweenCities(City destination){
         int x = Math.abs(getX() - destination.getX());
         int y = Math.abs(getY() - destination.getY());
         return Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
    }
}
