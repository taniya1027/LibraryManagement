package com.spring.Dao;

public interface Dao
{
	public boolean ifAdminExist(int aid, String password);
	
	public void addMember(String mname, String mpassword);
	
	public void addBook(int bookid, String bname);
	
	public void deleteBook(int bookid, String bname);

}
