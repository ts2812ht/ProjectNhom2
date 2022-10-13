package Dto;

public class UserDTO {
	private int id;
	private String name;
	private String username;
	private String email;
	private String password;
	private int type;
	private String phone;
	private String avatar;
	private int tinhtrang;
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserDTO(String name, String username, String email, String password, String phone, String avatar) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.avatar = avatar;
	}

	public UserDTO(int id, String name, String username, String email, String password, int type, String phone,
			String avatar, int tinhtrang) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.type = type;
		this.phone = phone;
		this.avatar = avatar;
		this.tinhtrang = tinhtrang;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getTinhtrang() {
		return tinhtrang;
	}

	public void setTinhtrang(int tinhtrang) {
		this.tinhtrang = tinhtrang;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", username=" + username + ", email=" + email + ", password="
				+ password + ", type=" + type + ", phone=" + phone + ", avatar=" + avatar + ", tinhtrang=" + tinhtrang
				+ "]";
	}
	
	
}
