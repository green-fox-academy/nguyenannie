import java.util.*;

public class JosephusProblem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of players: ");
        int playerNum = input.nextInt();

        System.out.println("The winning position is: " + findJosephusWinner(playerNum));
    }

    public static int findJosephusWinner(int totalPlayer){

        boolean [] josephusNum = new boolean[totalPlayer];
        int deadPlayer = 0;
        int skip = 0;
        int i = 0;

        for (int a = 0; a < totalPlayer; a ++) {
            josephusNum[a] = true;
        }

        while(deadPlayer < totalPlayer - 1) {
            if(josephusNum[i]){
                skip = skip + 1;
            }

            if(skip == 2) {
                josephusNum[i] = false;
                skip = 0;
                deadPlayer = deadPlayer + 1;
            }

            i = i + 1;
            if(i == totalPlayer){
                i = 0;
            }
        }

        int winnerPos = 0;

        for (int j = 0; j < totalPlayer; j ++) {
            if(josephusNum[j]) {
                winnerPos = j + 1;
                break;
            }
        }

        return winnerPos;

    }
}
