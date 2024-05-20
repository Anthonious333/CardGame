package BigBoss;

import java.util.ArrayList;

public class Modification {

	private String name;
	private boolean unlockable;
	private boolean unlocked;
	private ArrayList<Modification> next = new ArrayList<Modification>();
	private Modification last;
	

	public Modification (String name, Modification last, Modification... next) {
		for (Modification m : next) {
			this.next.add(m);
		}
		this.unlockable = true;
		this.last = last;
		this.name = name;
		setUnlocked(false);
	}
	
	
	
	public void setPath() {
		for (Modification m : last.getNext()) {
			if (!m.equals(this)) {
				m.closePath();
			}
		}
	}
	
	public void closePath() {
		this.unlockable = false;
		for(Modification m : next) {
			m.closePath();
		}
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

	public ArrayList<Modification> getNext() {
		return next;
	}

	public void setNext(ArrayList<Modification> next) {
		this.next = next;
	}
	
}
