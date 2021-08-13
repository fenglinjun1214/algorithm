public class QuickSort {


    public static void main(String[] args) {

        int[] arr =  { 1, 12, 2, 13, 3, 14, 4, 15, 5, 16, 17, 17, 177, 18, 8, 8, 19 };
        quickSort(arr, 0, arr.length-1);

        System.out.println(arr);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low > high) {
            return;
        }
        int i = low;
        int j = high;
        int temp = arr[low];
        while(i<j) {
            while(i<j && temp<= arr[j]) {
                j--;
            }
            while(i<j && temp >= arr[i]) {
                i++;
            }
            if(i<j) {
                int a = arr[j];
                arr[j] = arr[i];
                arr[i] = a;
            }
        }
        int aa = arr[low];
        arr[low] = arr[i];
        arr[i] = aa;

        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
    }
}