package com.java.util;

/**
 * ×Ö·û´®¹¤¾ßÀà
 * @author Artest
 *
 */
public class StringUtil {

	/**
	 * ÅÐ¶ÏÊÇ·ñÊÇ¿Õ×Ö·û´®
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(str == null || "".equals(str.trim())){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * ÅÐ¶Ï×Ö·û´®²»Îª¿Õ
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str){
		if(str != null && !"".equals(str.trim())){
			return true;
		}
		else{
			return false;
		}
	}
}
