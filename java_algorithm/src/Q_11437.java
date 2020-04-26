import java.util.Scanner;

public class Q_11437 {
    static Scanner sc = new Scanner(System.in);
    static int N, M;
    static int[] parent;
    static int[] depth;
    static int a,b;
    public static void main(String args[]){
        N = sc.nextInt();
        parent = new int[N+1];
        depth = new int[N+1];
        parent[1] = 1;
        depth[1] = 1;

        for(int i = 2; i<parent.length; i++){
            a = sc.nextInt();
            b = sc.nextInt();
            if(depth[a] != 0 && parent[a] != 0){
                parent[b] = a;
                depth[b] = depth[a] + 1;
            }
            else{
                parent[a] = b;
                depth[a] = depth[b] + 1;
            }
        }
        for(int t: parent)
            System.out.println(t);

        for(int x: depth)
            System.out.println(x);
    }

}
