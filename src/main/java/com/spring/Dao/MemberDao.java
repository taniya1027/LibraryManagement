package com.spring.Dao;

//import com.spring.Entities.Book;

//import com.spring.Entities.Member;

public interface MemberDao 
{
	public boolean ifMemExist(String name,String pass);
	
	public void searchBook(String bname);
	
	public void borrowBook(int bookid,String bname, int mid);
	
	public void returnBook(int mids);
	

}
