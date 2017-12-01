public class Bunny2 {
    public static void main(String[] args) {
        System.out.println(bunnyWierdEar(5));
    }
    public static int bunnyWierdEar(int x) {
        if( x == 0) {
            return 0;
        } else if(x %2 != 0){
            return bunnyWierdEar(x - 1) + 2;
        } else {
            return bunnyWierdEar(x - 1) + 3;
        }
    }
}
