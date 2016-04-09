package com.lockiely.easy.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObjectUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(ObjectUtils.class);

	public static Object getInstance(String name) {
		Class<?> clazz = getClass(name);
		Object o = null;
		try {
			o = clazz.newInstance();
		} catch (InstantiationException e) {
			logger.error("", e);
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			logger.error("", e);
			e.printStackTrace();
		}
		return o;
	}
	
	/**
	 * 根据类的class名称和参数构建对象，其中构造函数不能为基本数据类型。
	 * @param name 
	 * @param params 
	 * @return
	 */
	public static Object getInstace(String name, Object params[]) {
		Class<?> clazz = getClass(name);
		Class<?> classParas[] = new Class[params.length];
		for (int i = 0; i < params.length; i++) {
//			params.getClass().getClass().getDeclaringClass()
			classParas[i] = params[i].getClass();
		}
		Object o = null;
		try {
			Constructor<?> con = clazz.getConstructor(classParas);
			o = con.newInstance(params);
		} catch (NoSuchMethodException e) {
			logger.error("", e);
			e.printStackTrace();
		} catch (SecurityException e) {
			logger.error("", e);
			e.printStackTrace();
		} catch (InstantiationException e) {
			logger.error("", e);
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			logger.error("", e);
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			logger.error("", e);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			logger.error("", e);
			e.printStackTrace();
		}
		
		return o;
	}

	public static Class<?> getClass(String name) {
		Class<?> clazz = null;
		try {
			clazz = Class.forName(name);
		} catch (ClassNotFoundException e) {
			logger.error("", e);
			e.printStackTrace();
		}
		return clazz;
	}
	
	/**
	 * 通过反射执行方法
	 * @param obj 对象
	 * @param methodName 方法名
	 * @param params 参数值
	 * @return 返回方法的值
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static Object invokeMethod(Object obj, String methodName, Object params[]) 
			throws NoSuchMethodException, SecurityException, IllegalAccessException, 
			IllegalArgumentException, InvocationTargetException{
		Class<?> clazz = obj.getClass();
		Class<?> classParas[] = new Class[params.length];
		for (int i = 0; i < params.length; i++) {
			classParas[i] = params[i].getClass();
		}
		Method method = clazz.getDeclaredMethod(methodName, classParas);
		method.setAccessible(true);
		return method.invoke(obj, params);
	}
	
	public static void setFieldValue(Object obj, String fieldName, Class<?> clazz, Object value) throws Exception{
		Field fields[] = clazz.getDeclaredFields();
		for (Field field : fields) {
			if(field.getName().equals(fieldName)){
				field = clazz.getDeclaredField(fieldName);
				field.setAccessible(true);
				field.set(obj, value);
			}
		}
	}
	
	public static Object getFieldValue(Object obj, String fieldName, Class<?> clazz) throws Exception{
		Field field = clazz.getDeclaredField(fieldName);
		field.setAccessible(true);
		return field.get(obj);
	}
	
	public static List<String> getFieldNames(Object obj){
		List<String> fieldNames = new ArrayList<String>();
		Field fileds[] = obj.getClass().getDeclaredFields();
		for (Field field : fileds) {
			fieldNames.add(field.getName());
		}
		return fieldNames;
	}
	
	public static boolean isContainsField(Object obj, String filedName){
		if(getFieldNames(obj).contains(filedName))
			return true;
		return false;
	}
	
	
}
