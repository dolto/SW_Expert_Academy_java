import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
  public static void main(String[] args) throws IOException {
  	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  	for(int test_case = 1; test_case <= 10; ++test_case){
  	  br.readLine();
  	  String find = br.readLine();
  	  String data = br.readLine();
  	  if (find == " "){
  	    data += "1";
  	  }else{
  	    data += " ";
  	  }

  	  int answer = data.split(find).length - 1;
  	  bw.write(String.format("#%d %d\n", test_case, answer));
  	}

  	br.close();
  	bw.flush();
  	bw.close();
  }
}
