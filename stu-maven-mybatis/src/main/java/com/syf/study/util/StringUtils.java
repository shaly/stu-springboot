package com.syf.study.util;

import java.util.List;

public class StringUtils {

	public static boolean isEmpty(String var) {
		return null==var || "".equals(var);
	}

	public static boolean isNotEmpty(String var) {
		return !isEmpty(var);
	}
	public static boolean isEmp(Object var) {
		return null==var ;
	}
	public static boolean isNotEmp(Object var) {
		return null!=var ;
	}
	public static boolean isNullList(List list) {
		return null==list || list.size()==0;
	}
	public static boolean isNotNullList(List list) {
		return !isNullList(list) ;
	}
}
