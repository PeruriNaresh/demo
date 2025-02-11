package demo_maven01.dto;

public class User 
{
	private int id;
	private String name,email,pwd;
	public User(int id, String name, String email, String pwd) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.pwd = pwd;
	}
	
	public User() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", pwd=" + pwd + "]";
	}
}
