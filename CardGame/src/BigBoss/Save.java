package BigBoss;

public class Save {

	private String name;
	
	public Save() {
		this("Empty Save");
	}
	
	public Save(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
