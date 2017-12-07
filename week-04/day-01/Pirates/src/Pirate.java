import java.util.Random;

public class Pirate {
    int intoxication;
    boolean alive = true;

    public Pirate(){

    }
    public void drinkSomeRum(){
        intoxication +=1;
        if(!alive){
            System.out.println("He's dead");
        }
    }
    public void howItsGoingMate(){
        if(!alive){
            System.out.println("He's dead");
        } else if(intoxication >= 4) {
            System.out.println("Pour me anudder!");
        } else {
            System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
        }
    }
    public void dies(){
        alive = false;
    }

    public void brawl(Pirate pirate) {
        int r = new Random().nextInt(3) + 1;
        if(r == 1) {
            this.dies();
        } else if (r == 2) {
            pirate.dies();
        } else if(r == 3) {
            pirate.dies();
            this.dies();
        }
    }
}
