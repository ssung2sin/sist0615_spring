package spring.mvc.json;

public class PhotoDto {
	private String name;
	private String photo;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public PhotoDto(String name,String photo) {
		// TODO Auto-generated constructor stub
		super();
		this.name=name;
		this.photo=photo;
	}
}
