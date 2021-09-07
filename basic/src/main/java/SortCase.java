import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SortCase {


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int a = 10;

        Integer aaa = getIndex(arr, a);

        aaa = null;

        Integer op = Optional.ofNullable(aaa).map(v->v.intValue()).orElse(5);

    }


    public void getOption(Node node) {
        Integer aaa = null;
        List<Integer> bb=new ArrayList();

        Optional.ofNullable(aaa).ifPresent(bb::add);
    }

    private static Integer getIndex(int[] arr, Integer a) {

        int min = 0;
        int max = arr.length;
        int k = -1;

        while(min < max) {
            int mid = (min+max) /2;

            if(arr[mid] < a) {
                min = mid +1;
            } else if(arr[mid] > a) {
                max = mid;
            } else {
                k  = mid;
                break;
            }
        }
        return k;
    }



}