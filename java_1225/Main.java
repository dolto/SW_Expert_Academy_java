import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
  public static void main(String[] args) throws IOException{
  	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  	for(int i = 0; i < 10; ++i){
  	  int tcase = Integer.parseInt(br.readLine());
  	  // 1 2 3 4 5 1 2 3
  	  // 4 5 1 2 3 4 5 1
  	  // 2 3 4 5 1 2 3 4
  	  // 5 1 2 3 4 5 1 2
  	  // 3 4 5 1 2 3 4 5

  	  // 15 15 15 15 15 15 15 15

  	  int min = Integer.MAX_VALUE;
  	  LinkedList<Integer> data = new LinkedList<Integer>();

  	  StringTokenizer st = new StringTokenizer(br.readLine());

  	  for(int j = 0; j < 8; ++j){
  	    data.addLast(Integer.parseInt(st.nextToken()));
  	    if (min > data.get(j)) {
  	      min = data.get(j);
  	    }
  	  }

  	  int div = Integer.max((min / 15 - 1) * 15, 0); // 버림차순
  	  for(int j = 0; j < 8; ++j){
  	    int temp = data.removeFirst() - div;
  	    data.addLast(temp);
  	  }

  	  int count = 1;
  	  while(true){
  	    int temp = Integer.max(data.removeFirst() - count, 0);
  	    data.addLast(temp);
  	    if(temp == 0){
  	      break;
  	    }
  	    count = count + 1 > 5 ? 1 : count + 1;
  	  }

  	  bw.write(String.format("#%d ", tcase));
  	  for(int j = 0; j < 7; ++j){
  	    bw.write(String.format("%d ", data.removeFirst()));
  	  }
  	  bw.write(String.format("%d\n", data.removeFirst()));
  	}

  	br.close();
  	bw.flush();
  	bw.close();
  }
}
