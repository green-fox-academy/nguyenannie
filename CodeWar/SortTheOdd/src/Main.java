public class Main {
    public static void main(String[] args) {
        /*
        You have an array of numbers.
        Your task is to sort ascending odd numbers but even numbers must be on their places.

        Zero isn't an odd number and you don't need to move it. If you have an empty array, you need to return it.

        Example

        sortArray([5, 3, 2, 8, 1, 4]) == [1, 3, 2, 8, 5, 4]
         */

        int[] array = {5, 3, 2, 8, 1, 4};
        for(int i = 0; i < array.length; i++) {
            System.out.print(SortTheOdd.sortArray(array)[i] + " ");
        }
    }
}
