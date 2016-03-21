package com.springs;

public class HelloIndia {
	public HelloIndia(Message m,int age,String name) {
		message4=m;
		System.out.println("In Hello India Constructor");
		System.out.println("From Constructor- "+m.getMsg());
		System.out.println("Age =" + age);
		System.out.println("Name =" + name);
		// TODO Auto-generated constructor stub
	}
	Message message4;
	String message1;
	Message message2;
	String message3;
	public Message getMessage4() {
		return message4;
	}
	public void setMessage4(Message message4) {
		this.message4 = message4;
	}
	public String getMessage1() {
		return message1;
	}
	public void setMessage1(String message1) {
		this.message1 = message1;
	}
	public Message getMessage2() {
		return message2;
	}
	public void setMessage2(Message message2) {
		this.message2 = message2;
	}
	public String getMessage3() {
		return message3;
	}
	public void setMessage3(String message3) {
		this.message3 = message3;
	}
}
