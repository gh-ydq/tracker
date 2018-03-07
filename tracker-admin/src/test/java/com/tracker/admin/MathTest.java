package com.tracker.admin;

public class MathTest {
	public static void main(String[] args) {
		int size = 1024;
		int i =0;
		while(Math.pow(2, i)<size){
			System.out.println("----------------i "+i);
			System.out.println("------pow :"+Math.pow(2, i));
			++i;
		}

	}
}
