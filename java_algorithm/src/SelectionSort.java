public class SelectionSort {
    public static void main(String[] args){
        int[] a = new int[]{1, 8, 9, 7, 5, 6, 2, 3, 4};

        for(int i = 0; i < a.length-1; i++){
            int tmp = Integer.MAX_VALUE;
            int idx = i;
            for(int j = i; j < a.length; j++){
                if(tmp > a[j]){
                    tmp = a[j];
                    idx = j;
                }
            }
            int temp = a[i];
            a[i] = tmp;
            a[idx] = temp;
        }
        for(int t: a){
            System.out.print(t + " ");
        }

    }

}
