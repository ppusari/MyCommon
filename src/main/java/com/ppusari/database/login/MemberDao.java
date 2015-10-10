package com.ppusari.database.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;

public class MemberDao {
	
	public static final int MEMBER_NONEEXISTENT = 0;
	public static final int MEMBER_EXISTENT = 1;
	public static final int MEMBER_JOIN_FAIL = 0;
	public static final int MEMBER_JOIN_SUCCESS = 1;
	public static final int MEMBER_LOGIN_PW_NO_GOOD = 0;
	public static final int MEMBER_LOGIN_SUCCESS = 1;
	public static final int MEMBER_LOGIN_IS_NOT = -1;
	
	private static MemberDao instance = new MemberDao();
	 
	private MemberDao() {		
	}
	
	public static MemberDao getInstance(){
		return instance;
	}
	
	private Connection getConnection(){
		
		Context context = null;		
		DataSource dataSource = null;
		Connection connection = null;
		
		try {
			context = new InitialContext();			
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			connection = dataSource.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();			
		}
		
		return connection;
	}
	
	public int confirmId(String id){
		int ri = 0;
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "SELECT id FROM member WHERE id = ?";
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, id);
			set = pstmt.executeQuery();
			
			if (set.next()){
				ri = MemberDao.MEMBER_EXISTENT;						
			} else {
				ri = MemberDao.MEMBER_NONEEXISTENT;
			}					
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				set.close();
				pstmt.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return ri;
	}
	
	public int userCheck(String id, String pw)
	{
		int ri = 0;
		String dbPw;
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "SELECT pw FROM member WHERE id = ?";
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1,  id);
			set = pstmt.executeQuery();
			
			if (set.next()){
				dbPw = set.getString("pw");
				
				if (dbPw.equals(pw)){
					ri = MemberDao.MEMBER_LOGIN_SUCCESS;
				} else{
					ri = MemberDao.MEMBER_LOGIN_PW_NO_GOOD;
				}
			} else {
				ri = MemberDao.MEMBER_LOGIN_IS_NOT;
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				set.close();
				pstmt.close();
				connection.close();				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return ri;
	}
	
	public MemberDto getMember(String id) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "SELECT * FROM member WHERE id = ?";
		MemberDto dto = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,  id);
			set = pstmt.executeQuery();
			
			if (set.next()){
				dto = new MemberDto();
				dto.setId(set.getString("id"));
				dto.setPw(set.getString("pw"));				
				dto.setName(set.getString("name"));
				dto.setPhone(set.getString("phone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				set.close();
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return dto;
	}
	
	public int insertMember(MemberDto dto){
		int ri = 0;
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO member VALUES(?,?,?,?)";
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getPhone());
			pstmt.executeUpdate();
			ri = MemberDao.MEMBER_JOIN_SUCCESS;			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				if (pstmt != null) pstmt.close();
				if (connection != null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
				
		return ri;
	}

	public int updateMember(MemberDto dto){
		int ri = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "UPDATE member SET pw=?, phone=? WHERE id=?";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.getPhone());
			pstmt.setString(3, dto.getId());
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
	
	public ArrayList<MemberDto> membersAll(){
		ArrayList<MemberDto> dtos = new ArrayList<MemberDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM member";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while (rs.next()){
				MemberDto dto = new MemberDto();
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				
				dtos.add(dto);				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				rs.close();
				pstmt.close();
				con.close();				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return dtos;
		
	}
}
