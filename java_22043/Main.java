import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int test_case = Integer.parseInt(br.readLine());
    for (int i = 0; i<test_case; ++i){
      int count = Integer.parseInt(br.readLine());
      int answer = 0;

      String[] list = new String[count];
      for(int j = 0; j < count; ++j){
        list[j] = br.readLine();
      }

      for(int j = 0; j<count; ++j){
        for(int k = j + 1;k<count; ++k){
          int jbar = getPointNumber(list[j]);
          int kbar = getPointNumber(list[k]);
          if(jbar + kbar >= 0){
            answer += 1;
          }
        }
      }

      bw.write(answer + "\n");
    }
    br.close();
    bw.flush();
    bw.close();
  }

  static int getPointNumber(String value) {
    String[] temp = value.split("\\.");
    // System.out.println(temp[0]);
    int result = 0;
    if (temp.length == 2){
      result = temp[1].length() * -1;
    }else if(temp[0].equals("0")){
      result = 0;
    }else{
      char[] ctemp = temp[0].toCharArray();
      for (int i = ctemp.length - 1; i >= 0; --i){
        if(ctemp[i] == '0'){
          result += 1;
        }else{
          break;
        }
      }
    }
    return result;
  }
}
