package com.tinkus_backend.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.tinkus_backend.dto.UserDTO;
import com.tinkus.backend.util.*;

public class UserDAO {
	
	private final String Q_USER_SAVE = "insert into user (id ,first_name, last_name, email, mobile_number ,dob,address , gender) values ( ?, ?, ?, ?, ?, ? ,? , ? )";
	private final String Q_USER_UPDATE = "update user set first_name = ?, last_name = ?, email = ?, mobile_number = ? where id =?";
	private final String Q_USER_DELETE_BY_ID = "delete from user where id = ?";
	private final String Q_USER_FIND_BY_ID = "select * from user where id = ? ";
	private final String Q_USER_FIND_ALL = "select  * from user ";
	private final String Q_USER_FIND_BY_MOBILE = "select * from user where mobile_number = ?";
	private final String Q_USER_FIND_BY_CITY_ID = "select * from user where city_id = ?";
	
	private DBUtil dbUtil ;
	public UserDAO(DBUtil dbUtil) {
		this.dbUtil = dbUtil;
	}

	
	// -------------------------------------------------- Insert / Save 
	
	public int save(UserDTO userDTO) throws ClassNotFoundException , SQLException {	
//		step 1 connection 
		Connection connection = dbUtil.getConnection();
//		step 2 STMT/PSTMT
		PreparedStatement pstmt = connection.prepareStatement (Q_USER_SAVE ) ;			
				pstmt.setInt(1,userDTO.getId()) ;
				pstmt.setString(2,userDTO.getFirstName());
				pstmt.setString(3,userDTO.getLastName());
				pstmt.setString(4,userDTO.getEmail());
				pstmt.setString(5,userDTO.getMobileNumber());
				
				pstmt.setString(6,userDTO.getAddress());
				pstmt.setString(7,userDTO.getGender());
//		step 3 exc.
			int count = pstmt.executeUpdate() ;	
//		step 4 Close 
			dbUtil.close(connection , pstmt);
			return count ; 
	}
	
	// --------------------------------------------------Update By id
	
	public int updateById(UserDTO userDTO) throws ClassNotFoundException, SQLException {
		
//		step 1 connection 
		Connection connection = dbUtil.getConnection();
		
//		step 2 STMT/PSTMT
		PreparedStatement pstmt = connection.prepareStatement(Q_USER_UPDATE);
		pstmt.setString(1, userDTO.getFirstName());
		pstmt.setString(2, userDTO.getLastName());
		pstmt.setString(3, userDTO.getEmail());
		pstmt.setString(4, userDTO.getMobileNumber());
		pstmt.setInt(5, userDTO.getId());
		
//		step 3 exc.
		int count = pstmt.executeUpdate();
		
//		step 4 Close 
		dbUtil.close(connection, pstmt);
		return count;
	}

	
	
	
	// --------------------------------------------------Find By Id
	
	public UserDTO findById(int id ) throws ClassNotFoundException, SQLException {
		
//		Step-1 : Connection 
		Connection connection = dbUtil.getConnection();
		
//		Step-2 : STMT/PSTMT 
		 PreparedStatement pstmt = connection.prepareStatement(Q_USER_FIND_BY_ID);
		 pstmt.setInt(1, id);
		 
//		Step-3 : Exc. 
		 ResultSet RS =  pstmt.executeQuery();
		 UserDTO userDTO = null;
		if(RS.next()) {
			userDTO  = new UserDTO( );
			userDTO.setFirstName(RS.getString("first_name"));
			userDTO.setLastName(RS.getString("last_name"));
			userDTO.setEmail(RS.getString("email"));
			userDTO.setMobileNumber("mobile_number");
			}
		
//			Step-4 : Close 
			dbUtil.close(connection, pstmt);
			return userDTO;
	}
	
	
	// --------------------------------------------------Find By All
	
	
	public List<UserDTO> findByAll() throws ClassNotFoundException, SQLException {
		
//		connection 
		Connection connection = dbUtil.getConnection();
		
//		Step-2 : STMT/PSTMT 
		PreparedStatement pstmt = connection.prepareStatement(Q_USER_FIND_ALL);
		
//		Step-3 : Exc. 
		ResultSet RS = pstmt.executeQuery();
		List<UserDTO> users = new ArrayList<UserDTO>() ;
		while (RS.next()) {
			UserDTO userDTO = new UserDTO(); 	
			userDTO.setId(RS.getInt("id"));
			userDTO.setFirstName(RS.getString("first_name"));
			userDTO.setLastName(RS.getString("last_name"));
//			userDTO.setEmail(RS.getString("email"));
//			userDTO.setMobileNumber(RS.getString("mobile_number"));
//			userDTO.setAddress(RS.getString("adddress"));
//			userDTO.setGender(RS.getString("gender"));
			
			
			
			users.add(userDTO);
	}
//		Step-4 : Close 
//		dbUtil.close(connection, pstmt);
		return users;
	}
	// --------------------------------------------------Find By Mobile Number
	
	public UserDTO findByMobileNumber(String mobileNumber) throws ClassNotFoundException, SQLException {
		
//		Step-1 : Connection
		Connection connection = dbUtil.getConnection() ; 
		PreparedStatement pstmt = connection.prepareStatement(Q_USER_FIND_BY_MOBILE);
		
//		Step-2 : STMT/PSTMT 
		pstmt.setString(1, mobileNumber);
		UserDTO userDTO = null ;
		
//		Step-3 : Exc. 
		ResultSet resultSet =  pstmt.executeQuery();
		if(resultSet.next()) {
			userDTO  = new UserDTO( );
			userDTO.setFirstName(resultSet.getString("first_name"));
			userDTO.setLastName(resultSet.getString("last_name"));
			userDTO.setEmail(resultSet.getString("email"));
			userDTO.setAddress(resultSet.getString("address"));
		}
//		Step-4 : Close 
		dbUtil.close(connection, pstmt);
		return userDTO ;
	}

	
	// --------------------------------------------------Delete By Id
	
	public int deleteById(Integer id) throws ClassNotFoundException, SQLException {
		Connection connection = dbUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(Q_USER_DELETE_BY_ID);
		pstmt.setInt(1, id);

		int count = pstmt.executeUpdate();// 

		dbUtil.close(connection, pstmt);
		return count;
	}
}
