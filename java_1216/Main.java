import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    for (int tcase = 1; tcase <= 10; ++tcase) {
      int[][] table = new int[100][100];
      int test_case = Integer.parseInt(br.readLine());
      int answer = 0;

      for (int i = 0; i < 100; ++i) {
        int[] temp = br.readLine().trim().chars().toArray();
        table[i] = temp;
      }

      end:for(int size = 100; size >= 1; --size){
        for(int i = 0; i < 100; ++i){
          for(int j = 0; j <= 100 - size; ++j){
            boolean right = true;
            for(int k = 0; k<size/2;++k){
              int reverse = size - k - 1;
              if(table[i][j+k] != table[i][j+reverse]){
                right = false;
                break;
              }
            }
            if(right){
              answer = size;
              break end;
            }

            right = true;
            for(int k = 0; k<size/2;++k){
              int reverse = size - k - 1;
              if(table[j+k][i] != table[j+reverse][i]){
                right = false;
                break;
              }
            }
            if(right){
              answer = size;
              break end;
            }

          }
        }
      }
      bw.write(String.format("#%d %d\n", test_case, answer));
    }

    br.close();
    bw.flush();
    bw.close();
  }
}
