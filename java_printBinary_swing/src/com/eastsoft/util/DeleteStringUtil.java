package com.eastsoft.util;
/**
 * 编码修改为UTF-8
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class DeleteStringUtil {
	
	/**
	 * 
	 * @param path filepath
	 * @return the arraylist contains every line's conent;
	 */
	public static ArrayList<String> readFile(String path){
		BufferedReader br = null;
		ArrayList<String> lines = new ArrayList<>();
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			String line = br.readLine();
			while(line != null){
				lines.add(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lines;
		
	}
	
	
	/**
	 * 
	 * @param path filepath;
	 * @param lines the arraylist contains every line's conent;
	 */
	public static void writeFile(String path,ArrayList<String> lines){
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			for (int i = 0; i < lines.size(); i++) {
				bw.write(lines.get(i)+'\n');
				bw.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	/**
	 * 
	 * @param path filepath
	 * @param str the string you want to delete;
	 */
	public static void deleteString(String path,String str){
		ArrayList<String> lines = readFile(path);
		
		for (int i = 0; i < lines.size(); i++) {
			if(lines.get(i).equals(str)){
				lines.remove(i);
			}
		}
		
		/*for(String line :lines){
			System.out.println(line);
		}*/
		File newfile = new File("temp.txt");
		/*System.out.println(newfile.getPath());
		System.out.println(newfile.toString());
		System.out.println(newfile.getAbsolutePath());
		try {
			System.out.println(newfile.getCanonicalPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		writeFile(newfile.getPath(), lines);
		
		File oldfile = new File(path);
		oldfile.delete();
		
		newfile.renameTo(new File(path));
		
	}
	
	
	
	

}
