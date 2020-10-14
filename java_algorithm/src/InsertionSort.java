public class InsertionSort {
    public static void main(String[] args) {
        int[] a = new int[]{1, 8, 9, 7, 5, 6, 2, 3, 4};
        int tmp = 0;
        for(int i = 0; i < a.length; i++){
            for(int j = i; j > 0; j--){
                if(a[j] < a[j-1]){
                    tmp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = tmp;
                }
            }
        }

        for(int k: a){
            System.out.print(k + " ");
        }
    }
}
