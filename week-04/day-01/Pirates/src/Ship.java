import java.util.ArrayList;
import java.util.List;

public class Ship {
    List<Pirate> ship;
    Pirate captain = new Pirate();
    int alivePirates;

    public Ship(){
        ship = new ArrayList<>();
    }
    public void fillShip(){
        ship.add(captain);
        for(int i = 0; i < Math.random()* 100; i ++) {
            ship.add(new Pirate());
        }
    }
    public int numberofAlivePirate(){
        for(int i = 0; i < ship.size(); i ++) {
            if(ship.get(i).alive){
                alivePirates +=1;
            }
        }
        return alivePirates;
    }

}
