package baekjun.nsalgo.week7;

import java.io.*;
import java.util.*;

public class P5212 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int r;
    private static int c;
    private static String[][] now;
    private static String[][] after;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        now = new String[r][c];
        after = new String[r][c];

        for(int i = 0; i < r; i++){
            now[i] = br.readLine().split("");
        }

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                checkdir(i,j);
            }
        }

        int minx = c;
        int maxx = 0;
        int miny = r;
        int maxy = 0;

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(after[i][j].equals("X")){
                    if(i < miny) miny = i;
                    if(i > maxy) maxy = i;
                    if(j < minx) minx = j;
                    if(j > maxx) maxx = j;
                }
            }
        }

        for(int i = miny; i <= maxy; i++){
            for(int j = minx; j <= maxx; j++){
                System.out.print(after[i][j]);
            }
            System.out.println();
        }
    }

    private static void checkdir(int i, int j) {
        int count = 0;

        if (i - 1 < 0 || now[i - 1][j].equals(".")) count++;
        if (i + 1 >= r || now[i + 1][j].equals(".")) count++;
        if (j - 1 < 0 || now[i][j - 1].equals(".")) count++;
        if (j + 1 >= c || now[i][j + 1].equals(".")) count++;

        if (now[i][j].equals("X") && count >= 3) {
            after[i][j] = ".";
        } else {
            after[i][j] = now[i][j];
        }
    }
}
