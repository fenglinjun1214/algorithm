public class QuickSortDemo {

    public  static  void main(String[] args) {
        int[] arr = {1,7,8,9,6,5,4,3,3,2,10};
        quickSort(arr, 0, arr.length -1);
        System.out.println(arr);
        Singleton singleton = Singleton.getInstance();
    }

    public static void quickSort(int[] arr, int low, int high) {
        //随机选一个数，小的数放在左边，大的数放在右边
        if(low >= high) {
            return;
        }
        int i = low;
        int j = high;
        int temp = arr[low];


        while(i < j) {
            //从右边开始，依次递减，如果小于就停止
            while(i<j && arr[j] >= temp) {
                j--;
            }
            while(i<j && arr[i] <= temp) {
                i++;
            }
            //如果没到最后一点，就交换，把小的放在左边，大的放在右边
            if(i<j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        //交换完毕后，把首选字放在中间，最后一个数是i++，一定比首字小
        int later = arr[i];
        arr[i] = arr[low];
        arr[low] = later;


        //一个交换完毕后，进行递归处理
        quickSort(arr, low, i);
        quickSort(arr, i+1, high);
    }

}