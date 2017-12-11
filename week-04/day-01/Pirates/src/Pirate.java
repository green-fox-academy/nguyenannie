import java.util.Random;

public class Pirate {
    int rum;
    private boolean alive;
    boolean passout;

    public Pirate(){
        alive = true;
        passout = false;
        rum = 0;
    }
    public void drinkSomeRum(){
        rum += (int) (Math.random()* 10) ;
        if(rum > 4){
            passout = true;
        }
    }

    public boolean getAlive(){
        return alive;
    }

    public void howItsGoingMate(){
        if(!alive){
            System.out.println("He's dead");
        } else if(rum <= 4) {
            System.out.println("Pour me anudder!");
        } else {
            System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
        }
    }
    public void die(){
        alive = false;
    }

    public void brawl(Pirate pirate) {
        int r = new Random().nextInt(3) + 1;
        if(r == 1) {
            this.die();
        } else if (r == 2) {
            pirate.die();
        } else if(r == 3) {
            pirate.passout = true;
            this.passout = true;
        }
    }
}
