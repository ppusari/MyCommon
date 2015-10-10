package com.ppusari.database.connectionPool;

import com.ppusari.database.dto.MemberDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDao {
	
//	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
//	private String uid = "ppusari";
//	private String upw = "oraclepw";

	private DataSource dataSource;
	
	public MemberDao() {
		
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<MemberDto> memberSelect(){
		
		ArrayList<MemberDto> dtos = new ArrayList<MemberDto>();
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		 
		try {
//			con = DriverManager.getConnection(url, uid, upw);
			con = dataSource.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM member");
			
			while (rs.next()) {
				String name = rs.getString("name");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String phone = rs.getString("phone");
				
				MemberDto dto = new MemberDto(id, pw, name, phone);
				dtos.add(dto);				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				rs.close();
				stmt.close();
				con.close();				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return dtos;
	}	 
	
	public int memberInsert(MemberDto dto){
		int ri = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO member VALUES(?,?,?,?)";
		
		try {
//			con = DriverManager.getConnection(url, uid, upw);
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getPhone());
			ri = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				 
				pstmt.close();
				con.close();				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return ri;
	}
}
