/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 5568                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: dmb07301 <boj.kr/u/dmb07301>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/5568                           #+#        #+#      #+#    */
/*   Solved: 2025/12/09 16:04:06 by dmb07301      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static List<String> list = new ArrayList<>();
    private static Set<Integer> result = new HashSet<>();
    private static String[] output;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        output = new String[k];
        visited = new boolean[n];

        for(int i = 0; i < n; i++){
            list.add(br.readLine());
        }

        permutation(0, k);
        System.out.println(result.size());
    }

    public static void permutation(int depth, int k){
        if(depth == k){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < k; i++){
                sb.append(output[i]);
            }
            result.add(Integer.parseInt(sb.toString()));
            return;
        }

        for(int i = 0; i < list.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                output[depth] = list.get(i);
                permutation(depth + 1, k);
                visited[i] = false; 
            }
        }
    }
}