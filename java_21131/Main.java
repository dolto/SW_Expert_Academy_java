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
  	for (int _i = 0; _i<test_case; ++_i){
  	  int capercity = Integer.parseInt(br.readLine());
  	  boolean[] first = new boolean[capercity];
  	  StringTokenizer elements = new StringTokenizer(br.readLine());
  	  for (int expect = 1; expect <= capercity; ++expect){
  	    first[expect - 1] = expect == Integer.parseInt(elements.nextToken());
  	  }

  	  int answer = 0;
  	  for (int i = capercity - 1; i >= 1; --i){
  	    if (!first[i]){
  	      answer += 1;
  	      for (int j = 0; j <= i; ++j){
  	        first[j] = !first[j];
  	      }
  	    }
  	  }

  	  bw.write(answer + "\n");
  	  for (int i = 1; i < capercity; ++i){
  	    br.readLine();
  	  }
  	}

  	br.close();
  	bw.flush();
  	bw.close();
  }
}
