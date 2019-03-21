package com.java.oop;
class Outer01{
	private int a;
	private static int b;
	/**
	 * 实例内部类
	 * 1)位置:类的内部,方法的外部
	 * 2)修饰:没有static修饰,访问修饰符任意(public,private,protected)
	 * 3)应用:依托于外部类对象,可以访问外部类所有成员
	 */
	 class Inner01{
		 public void display(){
			 System.out.println(this);
			 System.out.println(Outer01.this);
			 System.out.println("a="+a);
		     System.out.println("b="+b);
		 }
	 }
	 /**
	  * 实例方法(只要此方法被访问,肯定外部类对象已存在)
	  * 1)实例方法必须有类的实例调用
	  * 2)实例方法中使用this指向的是当前实例对象
	  */
	 public void create(){
		 this.new Inner01().display();
		 //如上this可以省略
		 new Inner01().display();
	 }
}
public class TestInnerClass01 {
     public static void main(String[] args) {
        //说明:
    	//1)对于实例内部类对象的构建,应先有外部类对象,再有内部类对象
		//2)对于实例内部类对象会有外部类对象的一个引用
    	//3)实例内部类中如何访问外部类引用?(外部类.this)
    	Outer01 out=new Outer01();
		Outer01.Inner01 inner=out.new Inner01();
		inner.display();
		out.create();
		//===================
		new Outer01().new Inner01().display();
		new Outer01().create();
	 }
}




