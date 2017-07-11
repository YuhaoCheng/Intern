import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
public class MapTheCharacter {
	static private String readpath;
	static private String target;
	static int numberOfLabels;
	String writepath = "maptable.txt";
	//Map<String,Integer> result = new HashMap<String,Integer>();
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	Map<String,Integer> dict = new HashMap<String,Integer>();
    public MapTheCharacter(String readpath, String target,int number){
    	this.target = target;
    	this.readpath = readpath;
    	this.numberOfLabels = number;
    	try {
			this.createResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    public void setWritePath(String path){
    	this.writepath = path;
    }
    public void writeToFile() throws Exception{
    	File out = new File(writepath);
    	 out.delete();  
         out.createNewFile(); 
    	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(out),"utf-8"));
    	for(ArrayList<Integer> line:result){
    		for(Integer index:line){
    			writer.write(String.valueOf(index));
    			writer.write(",");
    			System.out.print(index);
    		}
    		System.out.print("\n");
    		writer.write("\n");
    	}
    	writer.close();
    	
    	// check the writing process 
    	File f = new File(writepath);
    	BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f),"utf-8"));
    	String line = null;
    	while((line=reader.readLine())!=null){
    		System.out.println(line + "check");
    	}
    }
    
    private  ArrayList<ArrayList<Integer>> createResult() throws Exception{
    	File f = new File(target);
    	BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f),"utf-8"));
    	//ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    	String line = null;
    	dict = this.loadDict();
    	int i =0;  //identify the No. of lines 
		while((line=reader.readLine())!=null){
			int index = 0;// identify the location in each line
			String item[] = line.split("/");
			//int[] temp = new int[item.length];
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(String word:item){
				if(dict.containsKey(word)){
					index = dict.get(word);
					temp.add(index);
				}
				
			}
			System.out.println(temp);
			result.add(temp);
		}
    	System.out.println(result);
    	
		return result;
    }
    
    private Map<String,Integer> loadDict() throws Exception{
    	File f = new File(readpath);
    	BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f),"utf-8"));
    	Map<String,Integer> temp = new HashMap<String, Integer>();
    	String item = null;
    	Integer index = 0;
    	index = numberOfLabels;
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	while((item=reader.readLine())!=null){
            if(item.equals(" ")){
            	break;
            }
    		index++;
    		temp.put(item, index);
    		System.out.println((int)index + item);
    		
    	}
    	System.out.println("Successfully load the dict" + df.format(new Date()));
    	return temp;
    }
    
}
