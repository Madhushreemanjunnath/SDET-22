package com.crm.vtiger.genericUtilies;


import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileUtility {
/*Author @ madhushree(to get authority and whoever refer this file have doubt can come to us easily* *
 */
	public String getProperty(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstant.PropertyFilePath);
		
		Properties p=new Properties();
		p.load(fis);
		return p.getProperty(key);
	}
	
	public String getJSON(String key) throws IOException, ParseException
	{
		FileReader reader=new FileReader(IPathConstant.JSONPath);
		JSONParser jp=new JSONParser();
		Object objjp=jp.parse(reader);
		JSONObject ob=(JSONObject)objjp;
		return ob.get(key).toString();
	}
}
