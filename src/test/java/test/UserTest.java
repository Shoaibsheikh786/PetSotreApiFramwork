package test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import endPoints.UserEndPoints;
import io.restassured.response.Response;
import payLoad.User;

public class UserTest {
	
	
	Faker faker;
	User userPayload;
	Logger logger;   //apache logger for public log
	@BeforeClass
	public void setUpData()
	{
		faker=new Faker();
		userPayload=new User();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setUsername(faker.name().username());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setUserStatus(0);
        logger= LogManager.getLogger(this.getClass());
		
		logger.debug("debugging.....");


	}
	
	@Test(priority=1)
	public void testCreateUser()
	{ 
		logger.info("********** Creating user  ***************");
	  Response res=	UserEndPoints.createUser(userPayload);
	  res.then().log().all();
	  Assert.assertEquals(res.statusCode(), 200);
	  logger.info("********** Creating user  ***************");
	}
	
	
	@Test(priority=2)
	public void testGetUser()
	{   
		logger.info("********** Reading User Info ***************");
		
		Response res=UserEndPoints.readUser(userPayload.getUsername());
		res.then().log().all();
		
		logger.info("**********User info  is displayed ***************");
	}
	
	@Test(priority=3)
	public void testUpdateUser()
	{  
		logger.info("********** Updating User ***************");
		userPayload.setFirstName("SHOAIB UPDATED ....");
		Response res=UserEndPoints.updateUser(userPayload.getUsername(),userPayload);
		testGetUser();
		logger.info("********** Updating User ***************");
	}
	
	@Test(priority=4)
	public void testDelUser()
	{   logger.info("**********   Deleting User  ***************");
		Response res=UserEndPoints.deleteUser(userPayload.getUsername());
	    res.then().log().all();
	    logger.info("**********   Deleted User  ***************");
	}

}
