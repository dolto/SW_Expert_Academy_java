import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int test_case = Integer.parseInt(br.readLine());
    for (int _i = 0; _i< test_case; ++_i){
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int n = Integer.parseInt(st.nextToken());
      int p = Integer.parseInt(st.nextToken());

      int temp = 0;
      int pop_candidate = 1;

      for (int i = 1; i <= n; ++i){
        temp += i;
        if(temp == p) {
          temp -= pop_candidate;
          ++pop_candidate;
        }
      }

      bw.write(Integer.toString(temp)+"\n");
    }
    br.close();
    bw.flush();
    bw.close();
  }
}
