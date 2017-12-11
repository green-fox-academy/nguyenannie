public class Fibonacci {
    public int findnFibonacci(int index) {
        if(index == 0) {
            return 0;
        } else if(index == 1) {
            return 1;
        } else {
            return findnFibonacci(index - 1) + findnFibonacci(index - 2);
        }
    }
}
