package obama;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.PatternSyntaxException;
	 
	public class WordCount {
	 
	       public static void main(String[] args) {
	 
	              ArrayList<String> arr = new ArrayList<String>();
	              try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\lenehand\\downloads\\obama.txt")))
	              {
	 
	                     String sCurrentLine;
	 
	                     while ((sCurrentLine = br.readLine()) != null) {
	 
	                           String newStr = sCurrentLine.replaceAll("[^a-zA-Z ]", "");
	                           try {
	                                  String[] splitArray = newStr.split("\\s+");
	                                  for(int i=0;i<splitArray.length; i++)
	                                         arr.add(splitArray[i]);
	                           } catch (PatternSyntaxException ex) {
	                                  ex.printStackTrace();
	                           }
	 
	                     }
	 
	              } catch (IOException e) {
	                     e.printStackTrace();
	              }
	 
	              System.out.println(arr);
	              Map<String, Integer> mp = new HashMap<String, Integer>();
	 
	              for (String string : arr) {
	                     if(mp.keySet().contains(string))
	                     {
	                           mp.put(string, mp.get(string)+1);
	                     }else
	                     {
	                           mp.put(string, 1);
	                     }
	              }
	 
	              System.out.println("Unsorted Map: "+mp);
	             
	              Map<String,Integer> tempMap=new HashMap<String,Integer>(mp);
	              LinkedHashMap<String,Integer> sortedOutputMap=new LinkedHashMap<String,Integer>();
	 
	              for(int i=0;i<mp.size();i++){
	                  Map.Entry<String,Integer> maxEntry=null;
	                  Integer maxValue=-1;
	                  for(Map.Entry<String,Integer> entry:tempMap.entrySet()){
	                      if(entry.getValue()>maxValue){
	                          maxValue=entry.getValue();
	                          maxEntry=entry;
	                      }
	                  }
	                  tempMap.remove(maxEntry.getKey());
	                  sortedOutputMap.put(maxEntry.getKey(),maxEntry.getValue());
	              }     
	              System.out.println("Sorted Map: "+sortedOutputMap);
	       }
	 
	}

	