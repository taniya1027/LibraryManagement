package com.spring.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.Entities.Book;

public class BookMapperImpl implements RowMapper{

	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Book b = new Book();
		int bid = rs.getInt(1);
		
		b.setBookid(bid);
		b.setBookname(rs.getString(2));
		
		return b;
		
	}

}
