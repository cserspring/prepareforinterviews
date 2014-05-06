package string;

import java.util.ArrayList;

public class BoggleGame {
	private int N;

	public ArrayList<ArrayList<Integer>> getWordLocation(char[][] matrix,
			String word) {
		N = matrix.length;
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		boolean[][] visited = new boolean[N][N];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j)
				visited[i][j] = false;
		}
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				ArrayList<Integer> oneResult = new ArrayList<Integer>();
				find(res, oneResult, matrix, visited, i, j, word, 0);
			}
		}
		return res;
	}

	private void find(ArrayList<ArrayList<Integer>> res,
			ArrayList<Integer> oneResult, char[][] matrix, boolean[][] visited,
			int i, int j, String word, int pos) {
		if (visited[i][j] || matrix[i][j] != word.charAt(pos))
			return;
		if (!visited[i][j] && pos == word.length() - 1) {
			oneResult.add(i * N + j);
			res.add(new ArrayList<Integer>(oneResult));
			oneResult.remove(oneResult.size() - 1);
			return;
		}
		for (int m = -1; m <= 1; ++m) {
			for (int n = -1; n <= 1; ++n) {
				visited[i][j] = true;
				oneResult.add(i * N + j);
				if (i + m >= 0 && i + m < N && j + n >= 0 && j + n < N
						&& (m != 0 || n != 0)) {
					find(res, oneResult, matrix, visited, i + m, j + n, word,
							pos + 1);
				}
				oneResult.remove(oneResult.size() - 1);
				visited[i][j] = false;
			}
		}
	}

	public static void main(String[] args) {
		char[][] matrix = { { 'e', 'g', 'o', 'd' }, 
				            { 't', 'c', 'a', 't' },
				            { 'e', 'a', 't', 'e' }, 
				            { 'k', 't', 'q', 'z' } };
		BoggleGame bg = new BoggleGame();
		System.out.println(bg.getWordLocation(matrix, "cat"));
	}
}
