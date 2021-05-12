package com.spring.Dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.Entities.Book;
import com.spring.Entities.Member;


public class MemberDaoImpl implements MemberDao {
	
	JdbcTemplate template;
	

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public boolean ifMemExist(String name, String pass) {
		// TODO Auto-generated method stub
		
		String query = "select * from member where mname = ? and mpassword = ?";
		RowMapper<Member> rowMapper = new RowMapperImpl();
	
		Member a = template.queryForObject(query,rowMapper,name,pass);
		
		if(a != null)
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
	}

	public void searchBook(String bname) {
		// TODO Auto-generated method stub
		
		String query = "select * from book where bname = ?";
		
		RowMapper r = new BookMapperImpl();
		
		Book b = template.queryForObject(query,r,bname);
		
		if(b != null)
		{
			System.out.println("book found");
			System.out.println("book id : "+b.getBookid());
			
		}
		else
		{
			System.out.println("book doesn't exist");
		}
		
		
	}

	public void borrowBook(int bookid,String bname, int mid) {
		// TODO Auto-generated method stub
		
		String query = "insert into borrowedbook(bookid,bookname,mid) values(?,?,?)";
		int ans = template.update(query,bookid,bname,mid);
		
		if(ans == 1)
		{
			System.out.println("book borrowed, please return timely");
		}
		else
		{
			System.out.println("some error occured");
		}
		
	}

	public void returnBook(int mid) {
		// TODO Auto-generated method stub
		String query = "delete from borrowedbook where mid = ?";
		int a = template.update(query,mid);
		
		if(a == 1)
		{
			System.out.println(" book returned, Thank you");
		}
		else
		{
			System.out.println("some error occured, sorry");
		}
	}

}
