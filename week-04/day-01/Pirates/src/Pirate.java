import java.util.Random;

public class Pirate {
    int rum;
    boolean alive;
    boolean passout;

    public Pirate(){
        alive = true;
        passout = false;
    }
    public void drinkSomeRum(){
        rum +=1;
    }

    public void howItsGoingMate(){
        if(!alive){
            System.out.println("He's dead");
        } else if(rum <= 4) {
            System.out.println("Pour me anudder!");
        } else {
            System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
            passout = true;
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
            pirate.passout = true;
            this.passout = true;
        }
    }
}
