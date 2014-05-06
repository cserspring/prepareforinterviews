package sudoku;

/*
 Write a program to solve a Sudoku puzzle by filling the empty cells.
 Empty cells are indicated by the character '.'.
 You may assume that there will be only one unique solution.
 * */
public class SudokuSolver {
	private int N = 9;
	private int M = 3;

	public void solveSudoku(char[][] board) {
		existSolver(board);
	}

	public boolean existSolver(char[][] board) {
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (board[i][j] == '.') {
					for (int k = '1'; k <= '9'; ++k) {
						if (isValidCell(board, (char) k, i, j)) {
							board[i][j] = (char) k;
							if (existSolver(board))
								return true;
						}
						board[i][j] = '.';
					}
					return false;
				}
			}
		}
		return true;
	}

	private boolean isValidCell(char[][] board, char c, int row, int col) {
		for (int i = 0; i < N; ++i) {
			if (board[row][i] == c)
				return false;
		}
		for (int i = 0; i < N; ++i) {
			if (board[i][col] == c)
				return false;
		}
		for (int i = M * (row / M); i < M * (row / M + 1); ++i) {
			for (int j = M * (col / M); j < M * (col / M + 1); ++j) {
				if (board[i][j] == c)
					return false;
			}
		}
		return true;
	}

	public static void main(String args[]) {
		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' },
				{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' },
				{ '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' },
				{ '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				{ '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		SudokuSolver s = new SudokuSolver();
		s.solveSudoku(board);
		for (int i = 0; i < s.N; ++i) {
			for (int j = 0; j < s.N; ++j) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}
