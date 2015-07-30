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
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LabelsUtil {
	
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
			return null;
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
	 * tianbaolei 获取配置map
	 * @param path
	 * @return
	 */
	public static Map<String,String> readFileForMap(String path){
		BufferedReader br = null;
		HashMap<String,String> lines = new HashMap<String,String>();
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			String line = br.readLine();
			while(line != null){
				String[] tem = line.split(" ");
				lines.put(tem[0], tem[1]);
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
	 * tianbaolei 读取文件最后一行
	 * @param path
	 * @return
	 */
	public static String readLastLine(String path){
		BufferedReader br = null;
		String lines = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			String line = br.readLine();
			while(line != null){
				lines = line;
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
			bw.write(lines.get(0));
			for (int i = 1; i < lines.size(); i++) {
				bw.write('\n'+lines.get(i));
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
	/**
	 * 
	 * @param path filepath
	 * @param str the string str you want to append
	 */
	public static void appendString(String path, String str) {

		FileWriter writer = null;
		try {
			writer = new FileWriter(path, true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			writer.write('\n' + str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
