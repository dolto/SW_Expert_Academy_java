import java.util.Scanner;

public class Main{
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
  	for (int tcase = 1; tcase <= 10; ++tcase){
  	  int test_case = Integer.parseInt(sc.next());
  	  int base_number = sc.nextInt();
  	  int pow = sc.nextInt();
  	  int answer = solved(base_number, pow);

  	  System.out.println(String.format("#%d %d", test_case, answer));
  	}

  	sc.close();
  }

  static int solved(int base_number, int pow){
    int answer = 1;
    for (int i = 0; i<pow; ++i){
      answer *= base_number;
    }

    return answer;
  }
}
