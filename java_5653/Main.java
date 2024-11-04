import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  static class Gen {
    public int status; // -1: empty ,0: deactive, 1: active, 2:live, 3: dead
    public int hp;
    public int base_hp;
    public int begin_time;

    public Gen() {
      this.status = -1;
      this.hp = 0;
      this.base_hp = 0;
      this.begin_time = 0;
    }

    void init(int hp, int time) {
      if (hp == 0) {
        this.status = -1;
        return;
      }
      this.status = 0;
      this.hp = hp;
      this.base_hp = hp;
      this.begin_time = time;
    }

    static void print(Gen[][] table) {
      for (int i = 0; i < table.length; ++i) {
        for (int j = 0; j < table[0].length; ++j) {
          if (table[i][j].status == -1) {
            System.out.printf("# ");
          } else if (table[i][j].status == 3) {
            System.out.printf("- ");
          } else {
            System.out.printf("%d ", table[i][j].base_hp);
          }
        }
        System.out.println();
      }
      System.out.println();
    }

    void turn_end(Gen[][] table, int time, int x, int y) {
      if (this.begin_time == time || this.status == -1 || this.status == 3) {
        return;
      }
      --this.hp;
      if (this.status == 1) {
        this.status += 1;
        // this.hp = this.base_hp;
        Gen[] around = new Gen[4];
        around[0] = table[x][y - 1];
        around[1] = table[x - 1][y];
        around[2] = table[x][y + 1];
        around[3] = table[x + 1][y];
        for (int i = 0; i < 4; ++i) {
          if (around[i].status == -1) {
            around[i].init(this.base_hp, time);
          } else if (around[i].begin_time == time
              && around[i].base_hp < this.base_hp) {
            around[i].init(this.base_hp, time);
          }
        }
      }
      if (this.hp <= 0) {
        if (this.status == 0) {
          this.status += 1;
          this.hp = this.base_hp;
        } else {
          this.status += 1;
          this.hp = 0;
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int test_case = Integer.parseInt(br.readLine());
    for (int tcase = 1; tcase <= test_case; ++tcase) {
      StringTokenizer input = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(input.nextToken());
      int m = Integer.parseInt(input.nextToken());
      int k = Integer.parseInt(input.nextToken());

      int time = 0;

      Gen[][] table = new Gen[n + k][m + k];
      for (int i = 0; i < table.length; ++i) {
        for (int j = 0; j < table[0].length; ++j) {
          table[i][j] = new Gen();
        }
      }
      for (int i = k / 2; i < k / 2 + n; ++i) {
        StringTokenizer tinput = new StringTokenizer(br.readLine());
        for (int j = k / 2; j < k / 2 + m; ++j) {
          table[i][j].init(Integer.parseInt(tinput.nextToken()), time);
        }
      }
      // Gen.print(table);

      for (time = 1; time <= k; ++time) {
        for (int i = 0; i < table.length; ++i) {
          for (int j = 0; j < table[0].length; ++j) {
            table[i][j].turn_end(table, time, i, j);
          }
        }
        // Gen.print(table);
      }

      int answer = 0;
      for (int i = 0; i < n + k; ++i) {
        for (int j = 0; j < m + k; ++j) {
          if (table[i][j].status == 0 || table[i][j].status == 1 || table[i][j].status == 2) {
            ++answer;
          }
        }
      }

      bw.write(String.format("#%d %d\n", tcase, answer));
    }

    br.close();
    bw.flush();
    bw.close();
  }
}
