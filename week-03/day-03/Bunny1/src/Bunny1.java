public class Bunny1 {
    public static void main(String[] args) {
        System.out.println(bunnyEar(1));

    }
    public static int bunnyEar(int b){
        if(b == 0) {
            return 0;
        } else {
            return bunnyEar(b -1)  + 2;
        }
    }
}
