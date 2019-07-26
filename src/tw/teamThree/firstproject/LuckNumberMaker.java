package tw.teamThree.firstproject;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

class processSQLserver {


}

class count {
	public int NumberCount(int[] data, int number) {
		int count = 0;
		for (int i = 0; i < data.length; i++) {
			if (number == data[i]) {
				count++;
			}
		}
		return count;
	}
}

public class LuckNumberMaker {

	public int[][] makeArray() {
		int[] data = new int[100000];
		int[] number = new int[42];
		int[][] NumberCount = new int[2][42];
		count answer = new count();
		for (int i = 0; i < data.length; i++) {
			Random ran = new Random();
			data[i] = ran.nextInt(42) + 1;
		}

		for (int i = 1; i < number.length + 1; i++) {
			number[i - 1] = i;
		}

		for (int i = 0; i < number.length; i++) {
			int count = answer.NumberCount(data, i + 1);

			NumberCount[0][i] = i + 1;
			NumberCount[1][i] = count;

		}

		return NumberCount;

	}

	public int NumberCount(int[] data, int number) {
		int count = 0;
		for (int i = 0; i < data.length; i++) {
			if (number == data[i]) {
				count++;
			}
		}
		return count;
	}

	public int[] NumberFormat(int[] Numbers) {
		while (true) {

			int count = 0;

			for (int i = 0; i < Numbers.length - 1; i++) {
				int temp = 0;
				int tempNumber = 0;
				if (Numbers[i] > Numbers[i + 1]) {
					temp = Numbers[i];
					Numbers[i] = Numbers[i + 1];
					Numbers[i + 1] = temp;

					count++;
				}
			}

			if (count == 0) {
				break;
			}

		}
		return Numbers;
	}

	public int[][] NumberFormat(int[][] Numbers) {
		while (true) {

			int count = 0;

			for (int i = 0; i < Numbers[1].length - 1; i++) {
				int temp = 0;
				int tempNumber = 0;
				if (Numbers[1][i] < Numbers[1][i + 1]) {
					temp = Numbers[1][i];
					Numbers[1][i] = Numbers[1][i + 1];
					Numbers[1][i + 1] = temp;

					tempNumber = Numbers[0][i];
					Numbers[0][i] = Numbers[0][i + 1];
					Numbers[0][i + 1] = tempNumber;

					count++;
				}
			}

			if (count == 0) {
				break;
			}

		}
		return Numbers;
	}

//	public void printData(int[][] data) {
//
//		for (int i = 0; i < data[0].length; i++) {
//			if ((i + 1) % 6 == 0) {
//				System.out.printf("%2d====%d\n", data[0][i], data[1][i]);
//
//			} else {
//				System.out.printf("%2d====%d\t", data[0][i], data[1][i]);
//
//			}
//		}
//	}
}
