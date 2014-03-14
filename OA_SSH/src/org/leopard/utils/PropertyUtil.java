package org.leopard.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {
	// 在文件中读取
	public static String getPath(String str) {
		Properties p = new Properties();
	//	FileInputStream in;
		String path = "";
		InputStream in = PropertyUtil.class.getResourceAsStream("/conf/config.properties");
		try {
		//	in = new FileInputStream(path);
			p.load(in);
			path = p.getProperty(str);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(null != in){
				try {
					in.close();
					in = null;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return path;
	}

}
