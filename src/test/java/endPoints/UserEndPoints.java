package endPoints;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payLoad.User;

public class UserEndPoints {
	
//create user
	public static Response createUser(User payload)
	{
       Response res= given()
      .baseUri(Routes.base_url)
      .accept(ContentType.JSON)
      .contentType(ContentType.JSON)
      .body(payload)
      .when()
      .post(Routes.post_url);
       return res;   
	}
	
//get user
		public static Response readUser(String userName)
		{
	       Response res= given()
	      .baseUri(Routes.base_url)
	      .pathParam("username", userName)
	      .when()
	      .get(Routes.get_url);
	       return res;   
		}
//update User		
		public static Response updateUser(String userName,User payload)
		{
	       Response res= given()
	      .baseUri(Routes.base_url)
	      .pathParam("username",userName)
	      .accept(ContentType.JSON)
	      .contentType(ContentType.JSON)
	      .body(payload)
	      .when()
	      .put(Routes.update_url);
	       return res;   
		}
//delete User
		public static Response deleteUser(String userName)
		{
	       Response res= given()
	      .baseUri(Routes.base_url)
	      .pathParam("username", userName)
	      .when()
	      .delete(Routes.delete_url);
	       return res;   
		}

}
