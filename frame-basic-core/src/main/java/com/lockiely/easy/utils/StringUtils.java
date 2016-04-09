package com.lockiely.easy.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	/**
	 * 将下划线个第一个字符装换成大写字符。
	 * @param underLineStr
	 * @return
	 */
	public static String convertUnderLineStrToJavaBean(String underLineStr){
		StringBuilder sb = new StringBuilder(underLineStr);
		Matcher mc = Pattern.compile("_").matcher(underLineStr);
		int i = 0;
		while(mc.find()){
			int position = mc.end() - (i++);
			sb .replace(position-1, position+1, 
					sb.substring(position, position + 1).toUpperCase());
		}
		return sb.toString();
	}
	
	public static String changeFirstCharUpOrLow(String oldString, int changeType){
		if(changeType == 0){
			return oldString.replaceFirst(oldString.substring(0, 1), 
					oldString.substring(0, 1).toUpperCase());
		}else if(changeType == 1){
			return oldString.replaceFirst(oldString.substring(0, 1), 
					oldString.substring(0, 1).toLowerCase());
		}
		return oldString;
	}
}
