import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
  public static void main(String[] args) throws IOException{
  	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  	for (int i = 1;i <= 10; ++i){
  	  int length = Integer.parseInt(br.readLine());
  	  int[] apartements = new int[length];
  	  int answer = 0;

  	  StringTokenizer input = new StringTokenizer(br.readLine());
  	  for (int j = 0; j< length; ++j){
  	    apartements[j] = Integer.parseInt(input.nextToken());
  	  }

  	  for (int j = 2; j < length - 2; ++j){
  	    int max = 0;
  	    for (int k = j - 2; k <= j + 2; ++k){
  	      if (k < 2 || k >= length - 2 || k == j){
  	        continue;
  	      }

  	      max = Integer.max(max, apartements[k]);  	      
  	    }

  	    answer += Integer.max(0, apartements[j] - max);
    	  // bw.write(String.format("%d\t%d\n", apartements[j] ,max));
  	  }

  	  bw.write(String.format("#%d %d\n", i, answer));
  	}

  	br.close();
  	bw.flush();
  	bw.close();
  }
}
