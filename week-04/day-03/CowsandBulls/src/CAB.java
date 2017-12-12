import java.util.Scanner;

public class CAB {
    private int randomNum;
    private int counter;
    public boolean playing;
    public String toGuess;


    public CAB(){
        randomNum = (int)(Math.random() * 9 + 1) * 1000 + (int)(Math.random() * 9 + 1) * 100
                    + (int)(Math.random() * 9 + 1) * 10 + (int)(Math.random() * 9 + 1);
        toGuess = Integer.toString(randomNum);
        playing = true;
        counter = 0;
    }

    public int[] guess(String playerGuess) {
        int cow = 0;
        int bull = 0;
        for(int i = 0; i < 4; i++){
            if(playerGuess.charAt(i) == toGuess.charAt(i)){
                cow += 1;
            } else {
                if (toGuess.contains(playerGuess.substring(i, i + 1))) {
                    bull += 1;
                }
            }
        }
        return new int[]{cow,bull};
    }

    public void play(){
        Scanner playerInput = new Scanner(System.in);
        System.out.println("Enter your guess please");

        while(playing){
            String playerGuess = playerInput.nextLine();

            int[] result = guess(playerGuess);
            int cow = result[0];
            int bull = result[1];

            if(cow == 4){
                playing = false;
            }
            counter +=1;
            System.out.println("you have "+ cow + " cow and " + bull + " bull.");
        }

        System.out.println("You win the game with " + counter + " guess(es)!");
    }

    public static void main(String[] args) {
        CAB cab = new CAB();
        System.out.println(cab.toGuess);
        cab.play();
    }

}
