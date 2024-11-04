import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
// import java.util.HashSet;
// import java.util.LinkedList;
// import java.util.Queue;
// import java.util.Set;
import java.util.StringTokenizer;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int test_case = Integer.parseInt(br.readLine());
    for(int i = 1; i<=test_case; ++i){
      StringTokenizer input = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(input.nextToken());
      int t = Integer.parseInt(input.nextToken());
      int a = Integer.parseInt(input.nextToken());
      int b = Integer.parseInt(input.nextToken());

      if (b == 1){
        int temp = t - s;
        if (temp % a == 0){
          bw.write(String.format("#%d %d\n",i, (temp / a)));
        }else{
          bw.write(String.format("#%d -1\n",i));
        }
      }else{
        int day = 0;
        while (t != s) {
          if(t % b == 0){
            if(t / b < s){
              ++day;
              t -= a;
            }else {
              ++day;
              t /= b;
            }
          }else {
            ++day;
            t -= a;
          }

          if(t < s){
            day = -1;
            break;
          }
        }
        bw.write("#"+i+" "+day+"\n");
      }

    }
    br.close();
    bw.flush();
    bw.close();
  }

  // static int solved(int start,int t, int a, int b){
  //   Queue<int[]> queue = new LinkedList<>();
  //   Set<Integer> visited = new HashSet<>();
  //   queue.add(new int[]{start, 0});
  //   visited.add(start);

  //   while (!queue.isEmpty()){
  //     int[] current = queue.poll();
  //     int currentValue = current[0];
  //     int days = current[1];

  //     if (currentValue == t){
  //       return days;
  //     }

  //     int nextAdd = currentValue + a;
  //     int nextMul = currentValue * b;
  //     if (nextAdd <= t && !visited.contains(nextAdd)){
  //       queue.add(new int[]{nextAdd, days+1});
  //       visited.add(nextAdd);
  //     }

  //     if (nextMul <= t && !visited.contains(nextMul)){
  //       queue.add(new int[]{nextMul, days +1});
  //       visited.add(nextMul);
  //     }
  //   }
  //   return -1;
  // }
}
