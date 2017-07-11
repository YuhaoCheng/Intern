import java.util.*;
import java.math.*;
import javax.imageio.stream.FileImageInputStream;

import java.io.*;
public class GiveLabel {
	private String filepath;
	public GiveLabel(String path){
		this.filepath = path;
		
	}
	
	public Map<String,Integer> createLevel1Table() throws Exception{
		Map<String,Integer> level1Table = new HashMap<String,Integer>(); // The table of the label1
		File input = new File(filepath);
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(input),"utf-8"));
		String line = null;
		int y = 0;
		while((line=reader.readLine())!=null){
			String temp[] =line.split(",");
			for(String word:temp){
				System.out.println(word + "-");
				}
			
			String label1 = temp[temp.length-2];
			System.out.println("The label1 is:" + label1);
			
			if(!level1Table.containsKey(label1)){
				y++;
				level1Table.put(label1, y);
				System.out.println("---" + y);
			}
			else{
				System.out.println("---Exist");
			}
					
		}
		
		return level1Table;
		
	}
	
	public Map<String,HashMap<String,Double>> createLevel2Table() throws Exception{
		Map<String,Double> label2Table = new HashMap<String,Double>();
		Map<String,Integer> label1Table = new HashMap<String, Integer>();
		Map<String, HashMap<String,Double>> level2Table = new HashMap<String,HashMap<String,Double>>();
		label1Table = this.createLevel1Table();
		
		File input = new File(filepath);
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(input),"utf-8"));
		
		String line = null;
		while((line=reader.readLine())!=null){
			String[] temp = line.split(",");
			System.out.print("The content of the record is:");
			for(String word:temp){
			System.out.print(word);
			}
			System.out.println();
			String label1 = temp[temp.length-2];
			String label2 = temp[temp.length-1];
			System.out.println("The label1 is:" + label1);
			System.out.println("The label2 is:" + label2);
			System.out.println();
			
			//Create the table
			if(label1Table.containsKey(label1)){
				int temp_y = label1Table.get(label1);
				if(!level2Table.containsKey(label1)){
					HashMap<String, Double> tempMap = new HashMap<String,Double>();
					double x = Math.random()*10 - 1;
					double temp_x = Math.exp(-x);
					double tempDouble = temp_y + temp_x;
					tempMap.put(label2, tempDouble);
					level2Table.put(label1, tempMap);
				}
				if(level2Table.containsKey(label1)){
					HashMap<String,Double> tempMap = level2Table.get(label1);
					if(!tempMap.containsKey(label2)){
						double x = Math.random()*10 - 1;
						double temp_x = Math.exp(-x);
						double tempDouble = temp_y + temp_x;
						tempMap.put(label2, tempDouble);
					}
				}
			}
			else{
				System.out.println("Invaild Label");
			}
			
			
		}
		System.out.println(level2Table);
		return level2Table;
	}

	

}
