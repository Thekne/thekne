package com.javaqxp.test4;

import java.util.Scanner;

public class Tms {
	//老师数组，用来保存所有老师的信息的
	private Teacher[] stus = new Teacher[3];
	private int index = 0; //学生的个数
	//添加老师
	public void add(Teacher stu){
		//如果数组中的元素的个数大于等于数组长度的时候，说明数组长度不够
		if(index>=stus.length){
			//数组扩展
			Teacher[] demo = new Teacher[stus.length+3];
			//数组的拷贝
			System.arraycopy(stus,0,demo,0,stus.length);
			stus = demo;
		}
		stus[index++] = stu;// stus[index] = stu; index++;
	}
	/**
	stus = {
		{1001,terry},
		{1002,larry},	
		{1003,tom},
		null,
		null
	
	}
	// 1002  stuIndex = 1; index = 3
	for(int i=1;i<2;i++){
		//stus[0] = stus[1]
		//stus[1] = stus[2]
		stus[2] = stus[3]
	}
	index = 3

	{1,2,4,5,6,7,8,9,0}
	*/
	//通过id删除老师 1002  1T  "HELLO WORLD"
	public void deleteById(long id){
		//调用方法获取id为指定参数，所在数组中的位置
		int stuIndex = queryIndexById(id); // 1
		if(stuIndex!=-1){
			for(int i=stuIndex;i<index-1;i++){
				stus[i] = stus[i+1];
			}
			stus[--index] = null;
		}
	}
	
	//通过id查找该老师所在的位置 1002
	private int queryIndexById(long id){
		int stuIndex= -1;
		for(int i=0;i<index;i++){
			if(stus[i].getId() == id){
				stuIndex = i;
				break;
			}
		}
		return stuIndex;
	}
	//通过id查询老师 ddl  dml
	public Teacher queryById(long id){
		//调用方法获取id为指定参数，所在数组中的位置
		int stuIndex = queryIndexById(id);
		return stuIndex==-1?null:stus[stuIndex];
	}

	//查看所有老师信息
	public Teacher[] queryAll(){
		Teacher[] demo = new Teacher[index];
		System.arraycopy(stus,0,demo,0,index);
		return demo;
	}
	/**
	{
	{1001,terry,},
	{1002,larry,},
	null
	}
	1002
	{1002,larry,}
	请输入。。。。[name,]
	tom#14

	{1002,tom,}
	*/  
	public void update(Teacher stu){
		for(int i=0;i<index;i++){
			if(stu.getId() == stus[i].getId()){
				stus[i].setName(stu.getName());
				stus[i].setPro(stu.getPro());
			}
		}
	}
	//菜单
	public void menu(){
		System.out.println("********老师管理系统*******");
		System.out.println("*1，查看所有老师信息*");
		System.out.println("*2，添加老师信息*");
		System.out.println("*3，删除老师信息*");
		System.out.println("*4，查询老师信息*");
		System.out.println("*5，修改老师信息*");
		System.out.println("*exit，退出*");
		System.out.println("*help，帮助*");
		System.out.println("***************************");
	}

	public static void main(String[] args){
		//创建Tms对象
		Tms tms = new Tms();
	    tms.menu();	//显示主页面
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.print("请输入功能编号：");
			//等待用户输入功能编号，等用户输入回车的时候获取回车前输入的内容
			String option = scanner.nextLine();
			switch(option){
				case "1"://查询所有
					System.out.println("以下是所有老师的信息：");
					Teacher[] stus = tms.queryAll();
					for(Teacher stu : stus){
						System.out.println(stu);
					}
					System.out.println("总计："+stus.length+" 人");
					break;
				case "2"://添加
					while(true){
						System.out.println("请输入老师信息【id#name#pro】或者输入break回到上一级目录");
						String stuStr = scanner.nextLine();
						if(stuStr.equals("break")){
							break;
						}
						String[] stuArr = stuStr.split("#");
						long id = Long.parseLong(stuArr[0]);
						String name = stuArr[1];
						String pro = stuArr[2];
						//封装对象
						Teacher stu = new Teacher(id,name,pro);
						//判断该用户id是否已经被人占用
						Teacher dbStu = tms.queryById(id);
						if(dbStu!=null){
							System.out.println("该id已经被人占用，请重新录入！");
							continue;
						}

						tms.add(stu);
						System.out.println("添加成功！");
					}
					
					break;
				case "3"://删除
					while(true){
						System.out.print("请输入您要删除老师的id或break返回上一级目录:");
						String id = scanner.nextLine();
						if(id.equals("break")){
							break;
						}
						tms.deleteById(Long.parseLong(id));
						System.out.println("删除成功！老师个数为："+tms.index);
					}
					break;
				case "4"://查询
					while(true){
						System.out.print("请输入您要查询老师的id或break返回上一级目录:");
						String id = scanner.nextLine();
						if(id.equals("break")){
							break;
						}
						Teacher stu = tms.queryById(Long.parseLong(id));
						System.out.println("以下是您要查找的老师的信息：");
						System.out.println(stu!=null?stu:"not found!");
					}
					break;
				case "5"://修改
					while(true){
						System.out.print("请输入您要修改老师的id或break返回上一级目录:");
						String id = scanner.nextLine();
						if(id.equals("break")){
							break;
						}
						Teacher stu = tms.queryById(Long.parseLong(id));
						if(stu == null){
							System.out.println("该老师不存在！");
							continue;
						}
						System.out.println("原信息为："+stu);
						System.out.println("请输入您要修改的信息【name#pro】");
						String stuStr = scanner.nextLine();
						String[] stuArr = stuStr.split("#");

						String name = stuArr[0];
						String pro = stuArr[1];

						Teacher newStu = new Teacher(Long.parseLong(id),name,pro);

						tms.update(newStu);
						System.out.println("修改成功！");
					}
					break;
				case "help":
					tms.menu();
					break;
				case "exit":
					System.out.println("bye bye");
					System.exit(0);
				default:
					System.out.println("输入出错，请重新输入！");
			}
		}
			
	}
}