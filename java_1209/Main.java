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

  	int[][] list = new int[100][100];

  	for(int i = 1; i<=10; ++i){
  	  br.readLine();
    	int answer = Integer.MIN_VALUE;

  	  for(int y = 0; y < 100; ++y){
    	  StringTokenizer input = new StringTokenizer(br.readLine());
  	    for(int x = 0; x < 100; ++x){
  	      list[y][x] = Integer.parseInt(input.nextToken());
  	    }
  	  }
  	  for(int y = 0; y < 100; ++y){
  	    int sumx = 0, sumy = 0;
  	    for(int x = 0; x < 100; ++x){
  	      sumx += list[y][x];
  	      sumy += list[x][y];
  	    }
  	    answer = Integer.max(answer, Integer.max(sumx, sumy));
  	  }

	    int sumxy = 0, sumyx = 0;
  	  for(int j = 0; j < 100; ++j){
  	    sumxy += list[j][j];
  	    sumyx += list[99 -j][99 -j];
  	  }
	    answer = Integer.max(answer, Integer.max(sumxy, sumyx));

	    bw.write(String.format("#%d %d\n", i,answer));
  	}

  	br.close();
  	bw.flush();
  	bw.close();
  }
}
