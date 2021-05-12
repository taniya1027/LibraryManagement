package com.spring.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.Entities.Book;
import com.spring.Entities.Member;

public class RowMapperImpl implements RowMapper{

	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Member m = new Member();
		
		int i = rs.getInt(1);
		
		m.setMid(i);
		m.setMname(rs.getString(2));
		m.setMpassword(rs.getString(3));
		
		return m;
	}
	
	

}
