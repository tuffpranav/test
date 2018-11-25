package com.tutorialspoint;  

import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path; 
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;  
@Path("/UserService") 

public class UserService {  
   UserDao userDao = new UserDao();  
   public static final Logger LOG = Logger.getLogger("UserService");
   public static int count = 0;
   @GET 
   @Path("/users") 
   @Produces(MediaType.APPLICATION_XML) 
   public List<User> getUsers(){ 
	   count++;
	  System.out.println("Received read request count : " + count );
	  LOG.info("Received read request " + count);
      return userDao.getAllUsers(); 
   } 
   
   
   
//   <user>
//   <id>1</id>
//   <name>Mahesh</name>
//   <profession>Teacher</profession>
//   </user>
   @POST 
   @Path("/users") 
   @Consumes(MediaType.APPLICATION_XML) 
   public void postUsers(User u){ 
	   System.out.println("Received write request with id" + u.getId() + " and name :" + u.getName());
//      return userDao.getAllUsers(); 
   } 
}