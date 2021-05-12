package com.spring.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import com.spring.Entities.Admin;

public class AdminMapper implements RowMapper {

	public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		
		Admin a = new Admin();
		a.setAid(rs.getInt(1));
		a.setAname(rs.getString(2));
		a.setPassword(rs.getString(3));
		
		return a;
	}

}
