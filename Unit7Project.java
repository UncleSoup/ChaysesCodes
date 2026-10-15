package Unit7;

import java.util.*;

public class Unit7Project {

	public static void main(String[] args) {

		ArrayList<Integer> firstList = new ArrayList<>();
		ArrayList<Integer> secondList = new ArrayList<>();

		System.out.println("Enter 5 integers:");
		firstList = populateList(firstList, 5);
		sortList(firstList);

		System.out.println("Enter 5 more integers:");
		firstList = populateList(firstList, 5);
		calculateSum(firstList);

		System.out.println("Enter 10 integers (may include duplicates):");
		firstList = populateList(firstList, 10);
		removeRepeats(firstList);

		System.out.println("\nEnter 5 numbers for the first array:");
		firstList = populateList(firstList, 5);

		System.out.println("Enter 5 numbers for the second array:");
		secondList = populateList(secondList, 5);
		mergeLists(firstList, secondList);
	}

	// Populates a list with user input
	public static ArrayList<Integer> populateList(ArrayList<Integer> dataList, int size) {
		Scanner input = new Scanner(System.in);
		dataList.clear();

		for (int i = 0; i < size; i++) {
			int num = input.nextInt();
			dataList.add(num);
		}
		return dataList;
	}

	// Sorts and prints the list
	public static void sortList(ArrayList<Integer> nums) {
		int minValue, pos;

		while (nums.size() > 1) {
			minValue = Integer.MAX_VALUE;
			pos = 0;

			for (int i = 0; i < nums.size(); i++) {
				if (nums.get(i) < minValue) {
					minValue = nums.get(i);
					pos = i;
				}
			}
			System.out.print(nums.remove(pos) + " ");
		}
		System.out.println(nums.get(0));
	}

	// Calculates and prints the sum
	public static double calculateSum(ArrayList<Integer> values) {
		int sum = 0;
		for (Integer val : values) {
			sum += val;
		}
		System.out.println(sum);
		return sum;
	}

	// Removes duplicates and prints unique elements
	public static void removeRepeats(ArrayList<Integer> numbers) {
		for (int i = 0; i < numbers.size(); i++) {
			for (int j = i + 1; j < numbers.size(); j++) {
				if (numbers.get(i).equals(numbers.get(j))) {
					numbers.remove(j);
					j--;
					i--;
				}
			}
		}
		System.out.println("Unique numbers are: ");
		displayList(numbers);
	}