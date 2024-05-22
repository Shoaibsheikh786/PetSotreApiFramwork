package endPoints;

public class Routes {
	/*
	 * Create User(POST)  : https://petstore.swagger.io/v2/user
	 * Read User(GET)     : https://petstore.swagger.io/v2/user/{username} 
	 * Update User(PUT)   : https://petstore.swagger.io/v2/user/{username} 
	 * Delete User(DELETE): https://petstore.swagger.io/v2/user/{username}
	 * 
	 */
	//https://petstore.swagger.io/v2/user/hello
	public static String base_url="https://petstore.swagger.io";
	public static String post_url="/v2/user";
	public static String get_url="/v2/user/{username}";
	public static String update_url="/v2/user/{username}";
	public static String delete_url="/v2/user/{username}";

}
