package com.javaqxp.test4;

/**
  老师类是用来创建老师对象的，老师对象是用来存储该老师的信息的
  小米
	真空
	6袋
*/
public class Teacher{
	private long id;
	private String name;
	private String pro;

	public Teacher(){
	
	}
	public Teacher(long id,String name,String pro){
		this.id = id;
		this.name = name;
		this.pro = pro;
	}

	public void setId(long id){
		this.id = id;
	}
	public long getId(){
		return this.id;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setPro(String pro){
		this.pro = pro;
	}
	public String getPro(){
		return this.pro;
	}
	public String toString(){
		return "Student[id:"+this.id+",name:"+this.name+",pro:"+this.pro+"]";
	}
}