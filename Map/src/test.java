import java.util.HashMap;
import java.util.Map;
import java.math.*;
public class test {
	public static void main(String[] args) throws Exception{
		//MapTheCharacter mtc = new MapTheCharacter("custom_dict.txt","test.txt",8);
		//mtc.loadDict();
		//mtc.setWritePath("D:\\PyCharm_workspace\\cut_txt\\maptable.txt");
		//mtc.writeToFile();
		
		//Map<String,HashMap<String,Float>> map = new HashMap<String,HashMap<String,Float>>();
		GiveLabel gl =new GiveLabel("record.csv");
		gl.createLevel2Table();
		//gl.createLevel1Table();
		//double i = Math.random()*10 - 1 ;
		//System.out.println(i);
		
	}
}
