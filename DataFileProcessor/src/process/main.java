/**
 * 
 */
package process;

/**
 * @author Eric
 *
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class main {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String fileName="5318";
		String format=".csv";
		String newLine="\r\n";
		String directory="C:\\Users\\Eric\\Desktop\\databaseR\\";
		String outputPath=directory+fileName+"All"+format;
		File file1=new File(outputPath);
		FileOutputStream fos=new FileOutputStream(file1);
		for(int i=1;i<=9;i++)
		{
		String path=directory+fileName+"-"+i+format;
		Set<String> set=new HashSet<String>();
		File file=new File(path);
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		String line;
		String []sArray;
		List<Tuple> tupleList=new ArrayList<Tuple>();
		while((line=br.readLine())!=null)
		{
			sArray=line.split(",");
			for(int j=1;j<sArray.length;j=j+2)
			{
				set.add(sArray[j]);
				Tuple tuple=new Tuple(sArray[j],Integer.parseInt(sArray[j+1]));
				tupleList.add(tuple);		
			}	
		}
		fr.close();
		br.close();
		
		Iterator<String> it=set.iterator();
		String tmp;

		while(it.hasNext())
		{
			tmp=it.next();
			int sum=0;
			int count=0;
			for(int j=0;j<tupleList.size();j++)
			{
				if(tupleList.get(j).getBssid().equals(tmp))
				{
					sum+=tupleList.get(j).getValue();
					count++;
				}
			}
			//BSSID_LEVEL.put(tmp, sum/count);
			if(count>3){
			StringBuilder sb=new StringBuilder();
			sb.append(tmp).append(",").append(sum/count).append(",");
			fos.write(sb.toString().getBytes());}
		}
		fos.write(newLine.getBytes());
		}
		fos.close();
		System.out.println("Process Finished!");
	}

}
