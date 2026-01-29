
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> result;
    static boolean[] col, diag1, diag2;

    static void solve(int row, int n, int[] board) {

        if (row == n) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(board[i] + 1); 
            }
            result.add(temp);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (issafe(row, c, n)) {

                board[row] = c;
                col[c] = true;
                diag1[row + c] = true;
                diag2[row - c + n] = true;

                solve(row + 1, n, board);
                col[c] = false;
                diag1[row + c] = false;
                diag2[row - c + n] = false;
            }
        }
    }

    static boolean issafe(int r, int c, int n) {
        return !col[c] && !diag1[r + c] && !diag2[r - c + n];
    }

    public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();

        result = new ArrayList<>();

        col = new boolean[n];
        diag1 = new boolean[2 * n];
        diag2 = new boolean[2 * n];

        int[] board = new int[n];
        solve(0, n, board);
        
        if (result.size() == 0) {
            System.out.println("No solution");
        } else {
            for (ArrayList<Integer> sol : result) {
                System.out.println(sol);
            }
        }

        sc.close();
    }
}
