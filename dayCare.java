package unit6project;

import java.util.Scanner;
import java.io.*;

public class dayCare {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String[] rows = null;
		int numOfLines = 0;

		try {
			BufferedReader br = new BufferedReader(new FileReader("J:\\JavaEssentials\\MyFiles\\textFile1.txt"));
			String line = br.readLine();
			while (line != null) {
				numOfLines++;
				line = br.readLine();
			}
			br.close();
			rows = new String[numOfLines];
			BufferedReader br2 = new BufferedReader(new FileReader("J:\\JavaEssentials\\MyFiles\\textFile1.txt"));
			line = br2.readLine();
			int i = 0; // index

			while (line != null) {
				rows[i] = line;
				line = br2.readLine();
				i++;
			}
			br2.close();
		} catch (IOException e) {
			System.out.println("An error has occurred");
		}
		String[] names = new String[numOfLines];
		int[] ages = new int[numOfLines];
		String[] gender = new String[numOfLines];
		String[] hometown = new String[numOfLines];
		int[] days = new int[numOfLines];
		String[] number = new String[numOfLines];
		for (int i = 0; i < rows.length; i++) {
			names[i] = rows[i].substring(0, rows[i].indexOf(","));
			rows[i] = rows[i].substring(rows[i].indexOf(",") + 1);
			ages[i] = Integer.parseInt(rows[i].substring(0, rows[i].indexOf(",")));
			rows[i] = rows[i].substring(rows[i].indexOf(",") + 1);
			gender[i] = rows[i].substring(0, rows[i].indexOf(","));
			rows[i] = rows[i].substring(rows[i].indexOf(",") + 1);
			hometown[i] = rows[i].substring(0, rows[i].indexOf(","));
			rows[i] = rows[i].substring(rows[i].indexOf(",") + 1);
			days[i] = Integer.parseInt(rows[i].substring(0, rows[i].indexOf(",")));
			number[i] = rows[i].substring(0, rows[i].indexOf(","));
		}
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);

		}
		System.out.println("--------------------------------------------");
		int males = 0;
		double maleAverage = 0.0;
		int females = 0;
		double femaleAverage = 0.0;

		for (int i = 0; i < numOfLines; i++) {
			if (gender[i].equals("M")) {
				males++;
				maleAverage += ages[i];
			} else {
				females++;
				femaleAverage += ages[i];

			}
		}
		System.out.println("the average age of males is: " + maleAverage / males);
		System.out.println("the average age of females is: " + femaleAverage / females);

		System.out.println("--------------------------------------------");
		System.out.println("Histogram of towns:");
		int count[] = new int[4];
		String towns[] = { "Springfeild", "Greenville", "Franklin", "Washington" };
		for (int i = 0; i < numOfLines; i++) {
			if (hometown[i].equals("Springfield")) {
				count[0]++;
			}
			if (hometown[i].equals("Greenville")) {
				count[1]++;
			}
			if (hometown[i].equals("Franklin")) {
				count[2]++;
			}
			if (hometown[i].equals("Washington")) {
				count[3]++;
			}
		}

		for (int i = 0; i < 4; i++) {
			System.out.print(towns[i] + ":		");
			for (int g = 0; g < count[i]; g++) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println("--------------------------------------------");

		// calculate the income

		int income = 0;
		for (int i = 0; i < numOfLines; i++) {
			if (ages[i] == 1) {
				income += 35 * days[i];
			} else if (ages[i] == 2) {
				income += 30 * days[i];
			} else if (ages[i] == 3) {
				income += 25 * days[i];
			} else if (ages[i] == 4) {
				income += 20 * days[i];
			} else if (ages[i] == 5) {
				income += 15 * days[i];
			}
		}
		System.out.println("The total weekly income for the daycare is: " + income);

		System.out.println("--------------------------------------------");

		System.out.println("From the list below, choose who you would like more information on: ");

		// print out all names

		for (int i = 0; i < numOfLines; i++) {
			System.out.println((i + 1) + ") " + names[i]);
		}

		// select name

		System.out.println();
		int input = scanner.nextInt();
		input -= 1;

		// print the data requested

		System.out.println("Name: " + names[input]);
		System.out.println("Age: " + ages[input]);
		System.out.println("Gender: " + gender[input]);
		System.out.println("Hometown: " + hometown[input]);
		System.out.println("Days Attending Daycare: " + days[input]);
		System.out.println("Phone Number: " + number[input]);

		System.out.println("--------------------------------------------");

		// name order

		String[] namesOrder = new String[numOfLines];
		for (int i = 0; i < numOfLines; i++) {
			namesOrder[i] = names[i].substring(names[i].indexOf(" ") + 1, names[i].length());
		}

		for (int i = 0; i < numOfLines; i++) {
			int place3;
			String place;
			String place2;
			for (int k = 1; k < numOfLines; k++) {
				int val = 0;
				val = namesOrder[i].compareTo(namesOrder[k]);

				// swap places of names

				if (val < 0) {
					place = namesOrder[i];
					place2 = namesOrder[k];
					namesOrder[i] = place2;
					namesOrder[k] = place;

					place = names[i];
					names[i] = names[k];
					names[k] = place;

					place3 = ages[i];
					ages[i] = ages[k];
					ages[k] = place3;

					place = gender[i];
					gender[i] = gender[k];
					gender[k] = place;

					place = hometown[i];
					hometown[i] = hometown[k];
					hometown[k] = place;

					place3 = days[i];
					days[i] = days[k];
					days[k] = place3;

					place = number[i];
					number[i] = number[k];
					number[k] = place;

				}
			}
		}

		// print out the data

		for (int i = 1; i < numOfLines; i++) {
			System.out.println(
					names[i] + "," + ages[i] + "," + gender[i] + "," + hometown[i] + "," + days[i] + "," + number[i]);
		}
		System.out.println(
				names[0] + "," + ages[0] + "," + gender[0] + "," + hometown[0] + "," + days[0] + "," + number[0]);

	}
}
