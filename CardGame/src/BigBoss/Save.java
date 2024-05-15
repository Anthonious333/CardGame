package BigBoss;

public class Save {

	private String name;
	private Boolean isEmpty;
	private AbstractCharecter charecter;
	
	public Save() {
		this("Empty Save");
		isEmpty = true;
	}
	
	public Save(String name) {
		this.setName(name);
		isEmpty = false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsEmpty() {
		return isEmpty;
	}

	public void setIsEmpty(Boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	public AbstractCharecter getCharecter() {
		return charecter;
	}

	public void setCharecter(AbstractCharecter charecter) {
		this.charecter = charecter;
	}
	
	
}
