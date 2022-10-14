package Dto;

public class PostDTO {
	private int id;
	private String title;
	private String description;
	private int price;
	private int area;
	private int count_view;
	private String address;
	private String latlng;
	private String images;
	private String user_id;
	private String category_id;
	private String district_id;
	private String phuongxa_id;
	private String approve;
	private String phone;
	private String create_at;
	
	
	
	
	public PostDTO(String title, String description, int price, int area, String address, String images, String user_id,
			String category_id, String district_id, String phuongxa_id, String phone) {
		super();
		this.title = title;
		this.description = description;
		this.price = price;
		this.area = area;
		this.address = address;
		this.images = images;
		this.user_id = user_id;
		this.category_id = category_id;
		this.district_id = district_id;
		this.phuongxa_id = phuongxa_id;
		this.phone = phone;
	}


	public String getPhone() {
		return phone;
	}


	public String getPhuongxa_id() {
		return phuongxa_id;
	}


	public void setPhuongxa_id(String phuongxa_id) {
		this.phuongxa_id = phuongxa_id;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}


	public PostDTO(String title, String description, int price, int area, String address, String images, String user_id,
			String category_id, String district_id, String phone) {
		super();
		this.title = title;
		this.description = description;
		this.price = price;
		this.area = area;
		this.address = address;
		this.images = images;
		this.user_id = user_id;
		this.category_id = category_id;
		this.district_id = district_id;
		this.phone = phone;
	}


	public PostDTO(int id, String title, String description, int price, int area, int count_view, String address,
			String latlng, String images, String user_id, String category_id, String district_id, String approve,
			String create_at) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.area = area;
		this.count_view = count_view;
		this.address = address;
		this.latlng = latlng;
		this.images = images;
		this.user_id = user_id;
		this.category_id = category_id;
		this.district_id = district_id;
		this.approve = approve;
		this.create_at = create_at;
	}


	public String getLatlng() {
		return latlng;
	}


	public void setLatlng(String latlng) {
		this.latlng = latlng;
	}


	public String getImages() {
		return images;
	}


	public void setImages(String images) {
		this.images = images;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public PostDTO() {
		super();
	}


	public PostDTO(int id, String title, String description, int price, int area, int count_view, String address,
			String category_id, String district_id, String approve, String create_at) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.area = area;
		this.count_view = count_view;
		this.address = address;
		this.category_id = category_id;
		this.district_id = district_id;
		this.approve = approve;
		this.create_at = create_at;
	}

	
	public int getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public int getCount_view() {
		return count_view;
	}

	public void setCount_view(int count_view) {
		this.count_view = count_view;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public String getDistrict_id() {
		return district_id;
	}

	public void setDistrict_id(String district_id) {
		this.district_id = district_id;
	}

	public String getApprove() {
		return approve;
	}

	public void setApprove(String approve) {
		this.approve = approve;
	}

	public String getCreate_at() {
		return create_at;
	}

	public void setCreate_at(String create_at) {
		this.create_at = create_at;
	}

	public PostDTO(int id, String title, String address) {
		super();
		this.id = id;
		this.title = title;
		this.address = address;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	@Override
	public String toString() {
		return "PostDTO [id=" + id + ", title=" + title + ", description=" + description + ", price=" + price
				+ ", area=" + area + ", count_view=" + count_view + ", address=" + address + ", latlng=" + latlng
				+ ", images=" + images + ", user_id=" + user_id + ", category_id=" + category_id + ", district_id="
				+ district_id + ", approve=" + approve + ", create_at=" + create_at + "]";
	}
	
}