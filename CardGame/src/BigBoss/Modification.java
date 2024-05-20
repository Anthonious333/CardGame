package BigBoss;


public class Modification {

	String name;
	private boolean unlocked;
	

	public Modification (String name) {
		this.name = name;
		setUnlocked(false);
	}
	
	@Override
	public String toString () {
		return name;
	}

	public boolean isUnlocked() {
		return unlocked;
	}

	public void setUnlocked(boolean unlocked) {
		this.unlocked = unlocked;
	}
	
}
