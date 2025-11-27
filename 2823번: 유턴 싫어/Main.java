/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2823                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: dmb07301 <boj.kr/u/dmb07301>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2823                           #+#        #+#      #+#    */
/*   Solved: 2025/11/25 17:53:02 by dmb07301      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

/*
유턴을 하지 않고 마을의 모든 구역을 돌아다닐 수 있는지 (막다른 길이 있는지)
R x C
빌딩 : X 표시
길 : . 표시
유턴 : 방금 이동한 방향의 반대 방향으로 이동
임의의 한 길에서 시작해서, 갈 수 있는 어떤 방향으로 움직이더라도, 유턴을 하지 않고 그 위치로 돌아올 수 있어야 함

배열을 돌면서 .인 부분의 4방향 중 3방향이 건물이면 불가능
사이클이 있어야 함

*/

import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] arr = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {

                if (arr[i][j] == '.') {

                    int degree = 0;

                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                            if (arr[nx][ny] == '.') {
                                degree++;
                            }
                        }
                    }

                    if (degree <= 1) {
                        System.out.println(1);
                        return;
                    }
                }
            }
        }

        System.out.println(0);
    }
}