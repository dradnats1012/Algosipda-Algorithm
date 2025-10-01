package baekjun;

public class Combination {

    public static void main(String[] args) {
        int n = 15;
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        boolean[] visited = new boolean[n];

        //for (int i = 1; i <= n; i++) {
            System.out.println("\n" + n + " 개 중에서 " + 5 + " 개 뽑기");
            combination(arr, visited, 0, n, 5);
        //}
    }

    static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            print(arr, visited, n);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    static void print(int[] arr, boolean[] visited, int n) {
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}
