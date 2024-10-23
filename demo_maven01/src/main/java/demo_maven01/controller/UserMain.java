package demo_maven01.controller;

import java.util.Scanner;
import demo_maven01.dao.UserDao;
import demo_maven01.dto.User;

public class UserMain 
{
	static Scanner sc=new Scanner(System.in);
	static UserDao dao=new UserDao();
	public static void main(String[] args) throws Exception
	{
		dao.createTable();
		System.out.println("---------------welcome--------------");
		boolean check=true;
		while(check)
		{
			System.out.println("Enter the choice:\n 1. Register\n 2. Login\n 3. Exit");
			int key=sc.nextInt();
			switch (key) {
			case 1:
				userRegister();
				break;
			case 2:
				userLogin();
				break;
			case 3:
				check=false;
				break;
			default:System.out.println("entered invalid option");
				break;
			}
		}
		System.out.println("----------ara ara sayonara-----------");
	}
	public static void userLogin()
	{
		System.out.println("enter email: ");
		String email=sc.next();
		System.out.println("enter password: ");
		String pwd=sc.next();
		try {
			boolean result= dao.userLogin(email, pwd);
			if(result)
			{
				System.out.println("login successful");
			}
			else {
				
				System.err.println("invalid credentials");
				System.out.println();
				userLogin();
			}
		} 
		catch (Exception e) 
		{
			System.err.println("email not found");
			System.out.println();
			userLogin();
		}
	}
	public static void userRegister() 
	{
		System.out.println("enter id:");
		int id=sc.nextInt();
		System.out.println("enter name:");
		String name=sc.next();
		System.out.println("enter email:");
		String email=sc.next();
		System.out.println("enter password:");
		String pwd=sc.next();
		User user=new User(id, name, email, pwd);
		try {
			int result= dao.saveUser(user);
			if(result>0)
			{
				System.out.println(user.getName()+" registration successfull");
			}
		} catch (Exception e) 
		{
			System.err.println("already data exist pls try with new data");
			System.out.println();
			userRegister();
		}
	}
}
