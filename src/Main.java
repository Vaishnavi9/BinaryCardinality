import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1024,512,256,128,64,32,16,8,4,2,1};
        Solution solution = new Solution();
        int[] temp = solution.sortByBits(arr);
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i]+" ");
        }
    }
}

class Solution {
    public int[] sortByBits(int[] arr) {
        //TreeMap with keys - number of 1 bits
        //and values - list of numbers which have equal bit count
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int n : arr) {
            int bit = Integer.bitCount(n);
            if (map.containsKey(bit)) {
                map.get(bit).add(n);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(n);
                map.put(bit, list);
            }
        }
        //TreeMap is used to store sorted keys
        //So I get the list (from the smallest key to largest)
        //and sort the list, and put into array again
        //so that I don't use extra memory
        int i = 0;
        for (int key : map.keySet()) {
            List<Integer> list = map.get(key);
            Collections.sort(list);
            for (int n : list) {
                arr[i++] = n;
            }
        }
        return arr;
    }
}

class SolutionOne {
    public int[] sortByBits(int[] arr) {
        for(int i=0;i<arr.length;i++){
            arr[i]+=Integer.bitCount(arr[i])*10001;
        }
        Arrays.sort(arr);

        for(int i=0;i<arr.length;i++){
            arr[i]=arr[i]%10001;
        }
        return arr;
    }
}

