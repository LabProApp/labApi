package com.springs;

public class Message {

	String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	 public void init(){
	      System.out.println("Bean is going through init.");
	   }
	   public void destroy(){
	      System.out.println("Bean will destroy now.");
	   }
	
}
