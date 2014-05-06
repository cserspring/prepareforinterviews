package sudoku;

import java.util.Arrays;

/*
 Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

 The Sudoku board could be partially filled, where empty cells are 
 filled with the character '.'.
 * */
public class ValidSudoku {
	private int N = 9;
	private int M = 3;

	public boolean isValidSudoku(char[][] board) {
		int[] flag = new int[N];

		for (int i = 0; i < N; ++i) {
			Arrays.fill(flag, 0);
			for (int j = 0; j < N; ++j) {
				if (board[i][j] != '.')
					flag[board[i][j] - '0' - 1]++;
			}
			for (int j = 0; j < N; ++j) {
				if (flag[j] > 1)
					return false;
			}
		}

		for (int j = 0; j < N; ++j) {
			Arrays.fill(flag, 0);
			for (int i = 0; i < N; ++i) {
				if (board[i][j] != '.')
					flag[board[i][j] - '0' - 1]++;
			}
			for (int i = 0; i < N; ++i) {
				if (flag[i] > 1)
					return false;
			}
		}

		for (int i = 0; i < N; i += M) {
			for (int j = 0; j < N; j += M) {
				Arrays.fill(flag, 0);
				for (int m = i; m < i + M; ++m) {
					for (int n = j; n < j + M; ++n) {
						if (board[m][n] != '.')
							flag[board[m][n] - '0' - 1]++;
					}
				}
				for (int k = 0; k < N; ++k) {
					if (flag[k] > 1)
						return false;
				}
			}
		}
		return true;
	}

	public static void main(String args[]) {
		char[][] board = { { '5', '3', '4', '6', '7', '8', '9', '1', '2' },
				{ '6', '7', '2', '1', '9', '5', '3', '4', '8' },
				{ '1', '9', '8', '3', '4', '2', '5', '6', '7' },
				{ '8', '5', '9', '7', '6', '1', '4', '2', '3' },
				{ '4', '2', '6', '8', '5', '3', '7', '9', '1' },
				{ '7', '1', '3', '9', '2', '4', '8', '5', '6' },
				{ '9', '6', '1', '5', '3', '7', '2', '8', '4' },
				{ '2', '8', '7', '4', '1', '9', '6', '3', '5' },
				{ '3', '4', '5', '2', '8', '6', '1', '7', '9' } };
		ValidSudoku v = new ValidSudoku();
		System.out.println(v.isValidSudoku(board));
	}
}
