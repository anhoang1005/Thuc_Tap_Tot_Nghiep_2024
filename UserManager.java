package VCCORP;

class User{
	private String name;
	private String email;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

public class UserManager{
	
	private static UserManager instance;
	
	private UserManager() {
    }
	
	public static synchronized UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }
	
	public void addUser(User user) {
		//Phuong thuc
    }
}

