import java.util.Random;

public class Pirate {
    public static final int RUM_LIMIT = 4;
    protected int rum;
    private boolean alive;
    boolean passout;

    public Pirate(){
        alive = true;
        passout = false;
        rum = 0;
    }
    public void drinkSomeRum(){
        rum += (int) (Math.random()* 10) ;
        if(!alive){
            System.out.println("He's dead");
        }
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
        } else if(rum <= RUM_LIMIT) {
            System.out.println("Pour me anudder!");
        } else {
            System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
        }
    }
    public void die(){
        if(!alive){
            System.out.println("He's dead");
        } else alive = false;
    }

    public void brawl(Pirate pirate) {
        if(!this.alive | !pirate.alive){
            System.out.println("He's dead");
            return;
        }

        int r = new Random().nextInt(3);
        if(r == 0) {
            this.die();
        } else if (r == 1) {
            pirate.die();
        } else if(r == 2) {
            pirate.passout = true;
            this.passout = true;
        }
    }
}
