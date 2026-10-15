package test;

import java.util.Scanner;

public class Checker{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	Scanner userInput = new Scanner(System.in);
System.out.println("Put in 4 phrases here:");
	String word1 = userInput.next();
	String word2 = userInput.next();
	String word3 = userInput.next();
	String word4 = userInput.next();
	
	boolean areTheyDifferent = true;
			if (word1.equals(word2)) {
				System.out.println("word1 is the same as word2");
				areTheyDifferent = true;}

			if (word1.equals(word3)){
				System.out.println("word1 is the same as word3");
				areTheyDifferent = true;}
			
			if (word1.equals(word4)) {
				System.out.println("word1 is the same as word4");
				areTheyDifferent = true;}
			
			if (word2.equals(word3)) {
				System.out.println("word2 is the same as word3");
				areTheyDifferent = true;}
			
			if (word2.equals(word4)) {
				System.out.println("word2 is the same as word4");
				areTheyDifferent = true;}
			
			if (word1.equals(word4)) {
				System.out.println("word3 is the same as word4");
				areTheyDifferent = true;}
			
			if(areTheyDifferent = false) {
				System.out.println("All the words are different");
			}

	}}