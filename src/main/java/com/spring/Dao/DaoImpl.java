package com.spring.Dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.Entities.Admin;

public class DaoImpl implements Dao
{

	JdbcTemplate template;
	
	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	

	public boolean ifAdminExist(int aid, String password) {
		
		String query = "select * from admin where aid = ? and password = ?";
		AdminMapper mapper = new AdminMapper();
		Admin a = template.queryForObject(query,mapper,aid,password);
		
		if(a != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void addMember(String mname, String mpassword) {
		// TODO Auto-generated method stub
		String query = "insert into member(mname,mpassword) values(?,?)";
		
		int i = template.update(query,mname,mpassword);
		
		if(i == 1)
		{
			System.out.println("Member Added Successfully");
		}
		else
		{
			System.out.println("something went wrong, Try Again");
		}
	}

	public void addBook(int bookid, String bname) {
		String query = "insert into book(bookid, bname) values(?,?)";
		
		int r = template.update(query,bookid,bname);
		
		if(r == 1)
		{
			System.out.println("Book added successfully");
		}
		else
		{
			System.out.println("Something went wrong, Try again");
		}
		// TODO Auto-generated method stub
		
	}

	public void deleteBook(int bookid, String bname) {
		// TODO Auto-generated method stub
		String query = "delete from book where bookid = ? and bname = ?";
		
		int r = template.update(query,bookid,bname);
		
		if(r == 1)
		{
			System.out.println("book deleted successfully");
		}
		else
		{
			System.out.println("something went wrong");
		}
				
		
	}
	
	
}
