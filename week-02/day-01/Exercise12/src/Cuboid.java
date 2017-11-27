public class Cuboid {
    public static void main(String[] args){
        double a = 30;
        double b = 20;
        double c = 10;

        double area = 2 * (a * b + b * c + c * a);
        double volume = a  * b * c;

        System.out.println("Surface Area: " + area);
        System.out.println("Volume: " + volume);
    }
}
