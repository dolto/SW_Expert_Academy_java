import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int[][] table = new int[100][100];

    for (int tcase = 1; tcase <= 10; ++tcase) {
      int answer = 0;
      int size = Integer.parseInt(br.readLine());
      for (int i = 0; i < size; ++i) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0; j < size; ++j) {
          table[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      for (int i = 0; i < size; ++i) {
        for (int j = 0; j < size; ++j) {
          boolean stuck = false;
          if (table[i][j] == 2) {
            for (int y = i - 1; y >= 0; --y) {
              if (table[y][j] == 1) {
                stuck = true;
                table[y + 1][j] = 4;
                table[i][j] = 0;
                table[y][j] = 3;
                break;
              } else if (table[y][j] == 4){
                table[y + 1][j] = 4;
                table[i][j] = 0;
                break;
              }
            }
            if (stuck) {
              ++answer;
            }
          } else if (table[i][j] == 1) {
            for (int y = i + 1; y < size; ++y) {
              if (table[y][j] == 2) {
                stuck = true;
                table[y - 1][j] = 3;
                table[i][j] = 0;
                table[y][j] = 4;
                break;
              } else if (table[y][j] == 3){
                table[y - 1][j] = 3;
                table[i][j] = 0;
                break;
              }
            }
            if (stuck) {
              ++answer;
            }
          }
        }
      }

      bw.write(String.format("#%d %d\n", tcase, answer));
    }

    br.close();
    bw.flush();
    bw.close();
  }
}
