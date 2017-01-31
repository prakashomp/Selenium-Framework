package com.generic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadWriteData {
	

public static final String COMMA_DELIMITER = ",";
public static final String NEW_LINE_SEPARATOR = "\n";
static FileWriter fileWriter = null;
static ToolUtil toolutility;
static Properties props = ToolUtil.openPropertyFile(new File(System.getProperty("user.dir")+File.separator+"config.properties"));

public void writeCsvFile(String fileNames,String TestSteps,String TestDecription,String Status,String ImageName) {

	String fileName = System.getProperty("user.dir")+File.separator+props.getProperty("resultsTempPath")+File.separator+fileNames+".csv";
		try {
			fileWriter = new FileWriter(fileName,true);
			
		//	TestSteps,TestDecription,Time,Status,ImageName
			ImageName=ImageName.replace(".png", "");
			String data=TestSteps+COMMA_DELIMITER+TestDecription+COMMA_DELIMITER+ToolUtil.getCurrentTime()+COMMA_DELIMITER+Status+COMMA_DELIMITER+System.getProperty("user.url")+COMMA_DELIMITER+ImageName+NEW_LINE_SEPARATOR;
			fileWriter.append(data);
			
		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
			}
			
		}
	}

public static String readCsvFile(String fileName,String Key) { 
    String line = "";
    String cvsSplitBy = ",";
    String[] data=null;
    String keyValue=null;
	try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

        while ((line = br.readLine()) != null) {
        	data = line.split(cvsSplitBy);
        	if(data[0].equalsIgnoreCase(Key)){
        		 keyValue = String.valueOf(data[1]);
        		break;        		
        	}       	
        	
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
	return keyValue;


}
public static String readCsvFile(String fileName,String Key,int colnumber) { 
    String line = "";
    String cvsSplitBy = ",";
    String[] data=null;
    String keyValue=null;
	try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

        while ((line = br.readLine()) != null) {
        	data = line.split(cvsSplitBy);
        	if(data[0].equalsIgnoreCase(Key)){
        		 keyValue = data[colnumber];
        		break;        		
        	}       	
        	
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
	return keyValue;


}


public void writeintoJSON(String fileName,String key,String value) throws IOException, ParseException{
	  
	JSONParser parser = new JSONParser();
	  Object obj = parser.parse(new FileReader(fileName));  
	  
	   JSONObject jsonObject = (JSONObject) obj; 

	  FileWriter fileWriter = new FileWriter(fileName);  
	  jsonObject.put(key, value);
	  fileWriter.write(jsonObject.toJSONString());  
      fileWriter.flush();  
      fileWriter.close();  
}

public String readJSON(String fileName,String key) throws FileNotFoundException, IOException, ParseException{
	JSONParser parser = new JSONParser();
	  Object obj = parser.parse(new FileReader(fileName));  
		JSONObject jsonObject = (JSONObject) obj;

		String keyValue = (String) jsonObject.get(key);
		

	return keyValue;
}

}
