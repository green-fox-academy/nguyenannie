public class SortThatList {
    public static void main(String[] args) {
        int[] array = {34, 12, 24, 9, 5};

        sort(array);

    }
    public static void sort(int[] arr) {
        for(int i = 0; i < arr.length; i ++) {
            for(int j = i + 1; j <arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for(int i =0; i <arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
