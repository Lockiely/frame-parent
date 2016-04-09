package com.lockiely.easy.utils;

import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class PropertiesUtils {

	private PropertiesUtils() {}
	
	public static Properties getProperties(){
		return (Properties) ApplicationPersonalSupport.getBean("configProperties");
	}
	
	public static String getPropertieValue(String key) {
		Properties pro =getProperties();
		return pro.getProperty(key);
	}
	
	public static String getPropertieStringValue(String key){
		return getPropertieStringValue(key);
	}
	
	public static boolean getPropertieBooleanValue(String key){
		return Boolean.valueOf(getPropertieValue(key));
	}
	
	public static int getPropertieIntegerValue(String key){
		return Integer.valueOf(getPropertieValue(key));
	}
	
	public static String getPropertieStringValue(String key, String defaultValue){
		return StringUtils.isNotEmpty(getPropertieValue(key)) ? getPropertieValue(key) : defaultValue;
	}
	
	public static boolean getPropertieBooleanValue(String key, boolean defaultValue){
		return StringUtils.isNotEmpty(getPropertieValue(key)) ? Boolean.valueOf(getPropertieValue(key)) : defaultValue;
	}
	
	public static int getPropertieIntegerValue(String key, int defaultValue){
		return StringUtils.isNotEmpty(getPropertieValue(key)) ? Integer.valueOf(getPropertieValue(key)) : defaultValue;
	}
}
