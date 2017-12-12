import java.util.Scanner;

public class CAB {
    int randomNum;
    int counter;
    int cow = 0;
    int bull = 0;
    boolean playing;
    boolean finished;
    String toGuess;


    public CAB(){
        randomNum = (int)(Math.random() * 9 + 1) * 1000 + (int)(Math.random() * 9 + 1) * 100
                    + (int)(Math.random() * 9 + 1) * 10 + (int)(Math.random() * 9 + 1);
        toGuess = Integer.toString(randomNum);
        playing = true;
        finished = false;
        counter = 0;
    }

    public void guess() {
        Scanner playerInput = new Scanner(System.in);
        System.out.println("Enter your guess please");
        String playerGuess = playerInput.nextLine();
        for(int i = 0; i < 4; i++){
            if(playerGuess.charAt(i) == toGuess.charAt(i)){
                cow += 1;
            } else {
                if (toGuess.contains(playerGuess.substring(i, i + 1))) {
                    bull += 1;
                }
            }
        }
        System.out.println("you have "+ cow + " cow and " + bull + " bull.");
    }

    public void play(){
        while(playing){
            guess();
            if(cow == 4){
                playing = false;
                finished = true;
            }
            cow = 0;
            bull = 0;
            counter +=1;
        }
        if(finished){
            System.out.println("You win the game with " + counter + " guess(es)!");
        }
    }
    public static void main(String[] args) {
        CAB cab = new CAB();
        System.out.println(cab.toGuess);
        cab.play();
    }

}
