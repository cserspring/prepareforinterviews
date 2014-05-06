package arr;

/*
 How to check whether you win in a Tic-Tac Toe game
 * */
public class TicTacToe {
	private int SIZE;
	private int MSIZE;
	private int[] row;
	private int[] col;
	private int diagnal;
	private int antidiag;

	public TicTacToe() {
		SIZE = 3;
		MSIZE = -3;
		row = new int[SIZE];
		col = new int[SIZE];
		diagnal = 0;
		antidiag = 0;
	}

	public int check(int x, int y, int player) {
		if (player == 1) {
			row[x]++;
			col[y]++;
			if (x == y)
				diagnal++;
			if (x == SIZE - y)
				antidiag++;
		} else if (player == 2) {
			row[x]--;
			col[y]--;
			if (x == y)
				diagnal--;
			if (x == SIZE - y)
				antidiag--;
		}

		if (row[x] == SIZE || row[x] == MSIZE || col[y] == SIZE
				|| col[y] == MSIZE || diagnal == SIZE || diagnal == MSIZE
				|| antidiag == SIZE || antidiag == MSIZE)
			return player;
		return 0;
	}
}
