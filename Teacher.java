package com.javaqxp.test4;

/**
  ��ʦ��������������ʦ����ģ���ʦ�����������洢����ʦ����Ϣ��
  С��
	���
	6��
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