package com.techlabs.rectangle.test;

import com.techlabs.rectangle.*;

public class RectangleTest {

	private static void printDetails(Rectangle obj) {
		System.out.println("\nHeight:" + obj.getHeight() + " Width:"
				+ obj.getWidth() + " Area:"+obj.calcArea()+" Border: " + obj.getBorder());

	}

	public static void main(String[] args) {

		Rectangle r1 = new Rectangle(10, 20, BorderStyleOption.DOTTED);
		printDetails(r1);

		Rectangle r2 = new Rectangle(20, 40);
		printDetails(r2);
		
		Rectangle r3 = r1.whoIsBigger(r2);
		printDetails(r3);
	}

}
