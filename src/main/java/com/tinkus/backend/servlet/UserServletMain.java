package com.tinkus.backend.servlet;
import java.sql.SQLException;
import java.util.List;

import com.tinkus.backend.util.DBUtil;
import com.tinkus_backend.dao.UserDAO;
import com.tinkus_backend.dto.UserDTO;
import com.tinkus_backend.service.UserService;

public class UserServletMain {
private UserService userService = new UserService(null);
public void save() 
{
	UserDTO userDTO =new UserDTO();
	userDTO.setFirstName("sawan");
	userDTO.setLastName("kumar");
	userDTO.setEmail("sk@gmail.com");
	userDTO.setMobileNumber("5858588745");
	userDTO.setCityId(1);
    userDTO.setPassword("sk@1234");
    userDTO.setGender("M");
    userDTO.setAddress("indore");
    
    try {
    	int count = userService.save(userDTO);
    	if (count>0) {
    		System.out.println("user saved successfully");
    	}else{
    		System.out.println("Failed to save user");
    	}
    	
    }catch(ClassNotFoundException e) {
    	e.printStackTrace();
    }catch(SQLException e) {
    	e.printStackTrace();
    }
} 
    
     public void delete( ) {
    		Integer id = 61; // request.getParam("id");
    		try {
    			int count = userService.delete(id);
    			if(count > 0) {
    				System.out.println("User deleted sccessfully.");
    			}else {
    				System.out.println("Failed to delete user.");
    			}
    		} catch (ClassNotFoundException | SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}
    	 
    	public void findByMobileNumber() {
    		String mobileNumber  = "88888" ;
    		try {
    			UserDTO userDTO = userService.findByMobileNumber(mobileNumber);
    			if (userDTO != null ) {
    				System.out.println ("User found with firstName : " + userDTO.getFirstName()) ;
    			}else {
    				System.out.println("No user found for Mobile Number :" + mobileNumber);
    			}
    		} catch (ClassNotFoundException | SQLException e) {
    			// TODO: handle exception
    			e.printStackTrace();
    		}
    		
    	}

    	public void findByAll() {
    		
    		try {
    			List<UserDTO> users = userService.findByAll(null);
    			if (users != null ) {
    				for(UserDTO user : users ) {
    		        System.out.println("Table contains" + user);
    				}
    			}else {
    				System.out.println("User table is empty");
    				
    				
    				
    				
//    				Iterator<UserDTO> itr = userDTO.iterator();
//    		        System.out.println(userDTO);
//    				?-----
//    				while (index < userDTOs.size()) {
//    					System.out.println(userDTOs.get(index));
//    					index++ ;
    				}
//    				System.out.println (userDTO.) ;
    			
    		} catch (ClassNotFoundException | SQLException e) {
    			// TODO: handle exception
    			e.printStackTrace();
    		}
    		
    		
    	}

    	public void findById () {
    		int id  = 1 ;
    		try {
    			UserDTO userDTO = userService.findById(id) ;
    			if (userDTO != null ) {
    				System.out.println ("User found with firstName : " + userDTO.getFirstName()) ;
    			}else {
    				System.out.println("No user found for Id :" + id);
    			}
    		} catch (ClassNotFoundException | SQLException e) {
    			// TODO: handle exception
    			e.printStackTrace();
    		}
    		
    	}
    	    
    	public static void main(String[] args) {
    		DBUtil dbUtil = new DBUtil();
    		UserDAO userDAO = new UserDAO(dbUtil);
    		UserService userService = new UserService(userDAO);
    		UserServletMain userServlet = new UserServletMain();

//    		userServlet.save();
//    		userServlet.update();
//    		userServlet.delete();
//    		userServlet.findByMobileNumber();
//    		userServlet.findById();
    		userServlet.findByAll();
    	}
    	}


