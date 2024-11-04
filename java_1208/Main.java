import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
  public static void main(String[] args) throws IOException {
  	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  	for (int test_case = 1; test_case<=10; ++test_case){
  	  int count = Integer.parseInt(br.readLine());
  	  int[] list = new int[100];
  	  StringTokenizer input = new StringTokenizer(br.readLine());
  	  for (int i = 0; i < 100; ++i){
  	    list[i] = Integer.parseInt(input.nextToken());
  	  }

  	  Arrays.sort(list);
  	  int answer = 0;
  	  int min_value = list[0], max_value = list[99];
  	  for (int i = 0; i< count; ++i){
  	    int min_index = 0, max_index = 99;
    	  for(int j = 0; j < 100; ++j){
    	    if (min_value >= list[j]){
    	      min_index = j;
    	      min_value = list[j];
    	    }else{
    	      break;
    	    }
    	  }

    	  for(int j = 99; j >= 0; --j){
    	    if(max_value <= list[j]){
    	      max_index = j;
    	      max_value = list[j];
    	    }else{
    	      break;
    	    }
    	  }

    	  // bw.write(String.format("min: %d: %d, max: %d: %d\n", min_index,list[min_index],max_index, list[max_index]));
    	  list[min_index] += 1;
    	  list[max_index] -= 1;
    	  min_value += 1;
    	  max_value -= 1;
  	  }

	    int min_index = 0, max_index = 99;
  	  for(int j = 1; j < 100; ++j){
  	    if (list[min_index] > list[j]){
  	      min_index = j;
  	    }else{
  	      break;
  	    }
  	  }

  	  for(int j = 99; j >= 0; --j){
  	    if(list[max_index] < list[j]){
  	      max_index = j;
  	    }else{
  	      break;
  	    }
  	  }

  	  answer = list[max_index] - list[min_index];
  	  bw.write(String.format("#%d %d\n", test_case, answer));
  	}

  	br.close();
  	bw.flush();
  	bw.close();
  }
}
