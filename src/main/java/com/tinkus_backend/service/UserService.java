package com.tinkus_backend.service;

import java.sql.SQLException;
import java.util.List;

import com.tinkus_backend.dto.UserDTO;
import com.tinkus_backend.dao.UserDAO;

public class UserService {
	
	private UserDAO userDAO ;
	
	public UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	
	public int save (UserDTO userDTO) throws ClassNotFoundException , SQLException {
//		pre porocess 
		int count = userDAO.save(userDTO);
//	post process
		return count ;
	}
	
	
	public int update(UserDTO userDTO) throws ClassNotFoundException , SQLException {
//		pre porocess 
		int count = userDAO.updateById(userDTO);
//	post process
		return count ;
	}
	
	
	public int delete(Integer id)throws ClassNotFoundException , SQLException {
//		pre porocess 
		int count = userDAO.deleteById(id);
//	post process
		return count ;
	} 
	
	public UserDTO findByMobileNumber(String mobileNumber) throws ClassNotFoundException, SQLException {
		return userDAO.findByMobileNumber(mobileNumber);
	}

	public UserDTO findById(int id) throws ClassNotFoundException, SQLException {
		return userDAO.findById(id);
	}
	
	public List<UserDTO> findByAll(UserDTO userDTO) throws ClassNotFoundException, SQLException {
		return userDAO.findByAll() ;
	}
}