package com.techlabs.basic;
import java.io.*;

public class FileIOtest {

	public static void main(String[] args) {
		CreateFile f1 = new CreateFile();
		WriteToFile w1 = new WriteToFile();
		ReadToFile r1 = new ReadToFile();
		
		f1.create("sample.txt");
		w1.write("vipul 21 IT", "sample.txt");
		r1.read("Sample.txt");
		
		
		
		
	}

}
