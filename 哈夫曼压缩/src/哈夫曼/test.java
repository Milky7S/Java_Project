package ������;

import java.io.File;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HuffmanCompress sample = new HuffmanCompress();
	//	File inputFile = new File("C:\\Users\\long452a\\Desktop\\opencv�����ĵ�.txt");
	//   File outputFile = new File("C:\\Users\\long452a\\Desktop\\opencv�����ĵ�.rar");
	//    sample.compress(inputFile, outputFile);
	    File inputFile = new File("C:\\Users\\long452a\\Desktop\\opencv�����ĵ�.rar");
	        File outputFile = new File("C:\\Users\\long452a\\Desktop\\opencv�����ĵ�1.txt");
	       sample.extract(inputFile, outputFile);
	}

}
