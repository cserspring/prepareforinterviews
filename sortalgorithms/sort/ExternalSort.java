package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExternalSort {

	public static void main(String[] args) throws IOException {
		init();
		sort();
	}

	public static void init() throws IOException {
		File file = new File("E:/����/source.txt");
		int numCount = 1205468;
		Random r = new Random();
		if (file.exists())
			file.delete();
		FileWriter fw = new FileWriter(file);
		for (int i = 0; i < numCount; i++) {
			fw.write(r.nextInt() + "\n");
		}
		fw.close();
	}

	public static void sort() throws IOException {
		File file = new File("E:/����/source.txt");
		BufferedReader fr = new BufferedReader(new FileReader(file));// Դ�����ļ���ȡ��
		final int SIZE = 10000;// �����Ƕ������ǽ�Դ�ļ�����10000����¼��Ϊ��λ���зָ
		int[] nums = new int[SIZE];// ��ʱ��ŷָ�ʱ�ļ�¼
		List<String> fileNames = new ArrayList<String>();// �������зָ��ļ�������
		int index = 0;
		while (true) {
			String num = fr.readLine();// ��ԭ�ļ��ж�ȡһ����¼
			if (num == null) {// �����ȡ��Ϻ󣬽���һ�����򲢱���
				if (index > 0)
					fileNames.add(sortAndSave(nums, index - 1));
				break;
			}
			nums[index] = Integer.valueOf(num);
			if (index == SIZE - 1) {// ��nums����������ֵ��ﳤ�ȱ߽�ʱ�����򣬴洢
				fileNames.add(sortAndSave(nums, index));// sortAndSave�ǽ�nums��ǰindex����¼�ȿ�������Ȼ������ļ�����ý��ļ������ء�
				index = -1;// ����index
			}
			index++;
		}
		fr.close();
		mergeSort(fileNames);// ������fileNames���ļ����кϲ�
	}

	// sortAndSave�ǽ�nums��ǰindex����¼�ȿ�������Ȼ������ļ�����ý��ļ�������
	public static String sortAndSave(int[] nums, int endIndex)
			throws IOException {
		if (endIndex >= nums.length)
			endIndex = nums.length - 1;
		_QuickSort_.sort(nums, 0, endIndex);
		String fileName = "E:/����/sort" + System.nanoTime() + ".txt";
		File rf = new File(fileName);
		BufferedWriter bw = new BufferedWriter(new FileWriter(rf));
		for (int i = 0; i <= endIndex; i++)
			bw.write(nums[i] + "\n");

		bw.close();
		return fileName;
	}

	public static void mergeSort(List<String> fileNames) throws IOException {
		List<String> tempFileNames = new ArrayList<String>();
		for (int i = 0; i < fileNames.size(); i++) {
			String resultFileName = "E:/����/sort" + System.nanoTime() + ".txt";
			File resultFile = new File(resultFileName);
			tempFileNames.add(resultFileName);
			BufferedWriter bw = new BufferedWriter(new FileWriter(resultFile));
			File file1 = new File(fileNames.get(i++));
			BufferedReader br1 = new BufferedReader(new FileReader(file1));
			if (i < fileNames.size()) {
				File file2 = new File(fileNames.get(i));
				BufferedReader br2 = new BufferedReader(new FileReader(file2));
				String numVal1 = null, numVal2 = null;
				int num1 = 0, num2 = 0;
				boolean isFirst = true;
				boolean firstNext = true;
				for (;;) {
					if (isFirst) {
						numVal1 = br1.readLine();
						numVal2 = br2.readLine();
						isFirst = false;
					} else if (firstNext) {
						numVal1 = br1.readLine();
					} else {
						numVal2 = br2.readLine();
					}
					if (numVal1 != null && numVal2 != null) {
						num1 = Integer.valueOf(numVal1);
						num2 = Integer.valueOf(numVal2);
						if (num1 < num2) {
							bw.write(num1 + "\n");
							firstNext = true;
						} else {
							bw.write(num2 + "\n");
							firstNext = false;
						}
					} else {
						if (numVal1 != null)
							bw.write(numVal1 + "\n");
						if (numVal2 != null)
							bw.write(numVal2 + "\n");
						break;
					}
				}
				while (true) {
					numVal2 = br2.readLine();
					if (numVal2 != null)
						bw.write(numVal2 + "\n");
					else
						break;
				}
				br2.close();
				file2.delete();
			}
			while (true) {
				String numVal1 = br1.readLine();
				if (numVal1 != null)
					bw.write(numVal1 + "\n");
				else
					break;
			}
			br1.close();
			file1.delete();
			bw.close();
		}
		int size = tempFileNames.size();
		if (size > 1) {
			mergeSort(tempFileNames);
		} else if (size == 1) {
			File file = new File(tempFileNames.get(0));
			file.renameTo(new File("E:/����/result.txt"));
		}
	}

}

// ��������
class _QuickSort_ {
	public static void sort(int data[], int low, int hight) {
		_QuickSort_ qs = new _QuickSort_();
		qs.data = data;
		qs.sort(low, hight);
	}

	public int data[];

	private int partition(int sortArray[], int low, int hight) {
		int key = sortArray[low];
		while (low < hight) {
			while (low < hight && sortArray[hight] >= key)
				hight--;
			sortArray[low] = sortArray[hight];
			while (low < hight && sortArray[low] <= key)
				low++;
			sortArray[hight] = sortArray[low];
		}
		sortArray[low] = key;
		return low;
	}

	public void sort(int low, int hight) {
		if (low < hight) {
			int result = partition(data, low, hight);
			sort(low, result - 1);
			sort(result + 1, hight);
		}
	}

	public void display() {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]);
			System.out.print(" ");
		}
	}
}