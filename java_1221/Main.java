import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{
  public static void main(String[] args) throws IOException {
  	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  	int test_case = Integer.parseInt(br.readLine());
  	String[] base_number = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV","SIX","SVN","EGT","NIN"};
   	for(int tcase = 1; tcase <= test_case; ++tcase){
  	  StringTokenizer title = new StringTokenizer(br.readLine());
  	  int tc = Integer.parseInt(title.nextToken().split("#")[1]);
  	  int size = Integer.parseInt(title.nextToken());

  	  StringTokenizer data = new StringTokenizer(br.readLine());

  	  HashMap<String, Integer> map = new HashMap<String, Integer>(size);
  	  for(int i = 0; i < size; ++i){
  	    String temp = data.nextToken();
  	    map.putIfAbsent(temp, 0);
  	    map.replace(temp, map.get(temp) + 1);
  	  }

  	  int count = 0;
      bw.write(String.format("#%d\n", tc));
  	  for(int i = 0; i< 10; ++i){
  	    for(int j = 0; j<map.getOrDefault(base_number[i], 0); ++j){
  	      ++count;
  	      if(count == size){
    	      bw.write(String.format("%s\n", base_number[i]));
  	      }else{  	        
    	      bw.write(String.format("%s ", base_number[i]));
  	      }
  	    }
  	  }
  	}
  	br.close();
  	bw.flush();
  	bw.close();
  }
}
