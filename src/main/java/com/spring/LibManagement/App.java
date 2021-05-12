package com.spring.LibManagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.Dao.Dao;
import com.spring.Dao.DaoImpl;
import com.spring.Dao.MemberDao;
import com.spring.Dao.MemberDaoImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Welcome, Member Login OR Admin Login? 1 or 2");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/spring/LibManagement/Config.xml");
        try {
			int c = Integer.parseInt(br.readLine());
			
			if(c == 1)
			{
				System.out.println("Enter your member name:");
				
				
				String name = br.readLine();
				
				System.out.println("Enter your password : ");
				
				String pass = br.readLine();
				
				MemberDao md = ctx.getBean("md",MemberDaoImpl.class);
				
				boolean b = md.ifMemExist(name,pass);
				
				if(b == true)
				{
					System.out.println("Member Login Successful");
					
					System.out.println("What would you like to do? 1.Search book 2.Borrow Book 3.Return Book");
					int choice = Integer.parseInt(br.readLine());
					
					if(choice == 1)
					{
						System.out.println("Enter book name");
						String bname = br.readLine();
						md.searchBook(bname);
					}
					else if(choice == 2)
					{
						System.out.println("Enter the book id ");
						int bookid = Integer.parseInt(br.readLine());
						System.out.println("Enter the book name");
						String bname = br.readLine();
						System.out.println("Enter the member id");
						int mid = Integer.parseInt(br.readLine());
						
						md.borrowBook(bookid,bname,mid);
					}
					else if(choice == 3)
					{
						System.out.println("enter the member id");
						int mid = Integer.parseInt(br.readLine());
						md.returnBook(mid);
					}
					else
					{
						System.out.println("INVALID CHOICE");
					}
				}
				else
				{
					System.out.println("member doesn't exists, enter valid values");
				}
			}
			else if(c == 2)
			{
				System.out.println("Enter your Admin id");
				int aid = Integer.parseInt(br.readLine());
				System.out.println("Enter your admin password");
				String password = br.readLine();
				Dao admin = ctx.getBean("DaoImpl", DaoImpl.class);
				boolean b = admin.ifAdminExist(aid,password);
				
				if(b == true)
				{
					System.out.println("Admin login successful");
					
					System.out.println("What would you like to do? 1.Add member 2.Add Book 3.Delete Book");
					
					int ch = Integer.parseInt(br.readLine());
					
					if(ch == 1)
					{
						System.out.println("Enter member name");
						String mname = br.readLine();
						
						System.out.println("Enter member password");
						String mpassword = br.readLine();
						
						admin.addMember(mname,mpassword);
					}
					else if(ch == 2)
					{
						System.out.println("enter book id");
						int bookid = Integer.parseInt(br.readLine());
						
						System.out.println("enter book name");
						String bname = br.readLine();
						
						admin.addBook(bookid, bname);
					}
					else if(ch == 3)
					{
						System.out.println("Enter the book id");
						int bid = Integer.parseInt(br.readLine());
						System.out.println("Enter the book name");
						String bname= br.readLine();
						admin.deleteBook(bid,bname);
					}
					else
					{
						System.out.println("INVALID CHOICE");
					}
					
				}
				
				else
				{
					System.out.println("something went wrong, try again");
				}
			}
			else
			{
				System.out.println("Invalid Choice");
			}
		} 
        catch (IOException e)
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
       

        
        
    }

		// TODO Auto-generated method stub
     
		
		
    
    
	
}
