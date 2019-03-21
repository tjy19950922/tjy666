package com.java.generic;
import java.util.ArrayList;
import java.util.List;
/**
 * 泛型的上下界问题:
 * List<Object> list1=new ArrayList<String>();//错误
 * List<String> list2=new ArrayList<Object>();//错误
 */
public class TestGeneric06 {
	public static void main(String[] args) {
		//doMethod01();
		ArrayList<String> lst1=new ArrayList<String>();
		lst1.add("A");lst1.add("B");
		doMethod02(lst1);
		
		ArrayList<StringBuffer> lst2=new ArrayList<>();
		StringBuffer sb1=new StringBuffer();
		sb1.append("C").append("D");
		lst2.add(sb1);
		doMethod02(lst2);
		
	}
	//定义此方法用于输出一个List集合内容,
	//其内容只能是与字符串相关的类型.
	
	static void doMethod02(List<? extends CharSequence> list){
		System.out.println(list);
	}
	
	//泛型上下界测试
	private static void doMethod01() {
		//指定对象上届
		List<? extends Object> list1=
		new ArrayList<String>();
		list1.add(null);
		//list1.add("123");//错误
		//指定对象下届
		List<? super String> list2=
		new ArrayList<Object>();
		list2.add("1000");
		//list2.add(2000);//错误,编译时看等号左边
	}
}



