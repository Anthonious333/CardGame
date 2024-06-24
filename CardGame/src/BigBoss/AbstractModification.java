package BigBoss;

import java.util.ArrayList;

public abstract class AbstractModification extends SAM{

	private String name;
	private boolean unlockable;
	private boolean unlocked;
	private ArrayList<AbstractModification> next = new ArrayList<AbstractModification>();
	private AbstractModification last;
	private double magicNumber;
	private boolean locksOnLast;


	public AbstractModification (String name, AbstractModification last) {
		this(name, last, true);
	}
	
	public AbstractModification (String name, AbstractModification last, boolean locks) {
		this.setUnlockable(true);
		this.setLast(last);
		this.name = name;
		unlocked = false;
		setLocksOnLast(locks);
	}
	

	public void setPath() {
		if (last != null) {
			for (AbstractModification m : last.getNext()) {
				if (!m.equals(this) && locksOnLast && !m.isUnlocked()) {
					m.closePath();
				}
			}
		}
	}

	public void closePath() {
		this.setUnlockable(false);
		for(AbstractModification m : next) {
			m.closePath();
		}
	}



	@Override
	public String toString () {
		return name;
	}

	public boolean canUnlock() {
		if (this.getLast() == null) {
			return (this.isUnlockConditionMet() && isUnlockable());			
		}
		return (this.isUnlockConditionMet() && getLast().isUnlocked() && isUnlockable());			

	}
	
	
	public int endPoints() {
		if (next.isEmpty()) {
			return 1;
		} else {
			int total = 0;
			for (AbstractModification m : next) {
				total += m.endPoints();
			}
			return total;
		}
	}
	
	
	
	public boolean isUnlocked() {
		return unlocked;
	}
	
	public void onUnlock() {
		
	}
	
	public boolean unlock() {
		if (!unlocked && canUnlock()) {			
			this.unlocked = true;
			this.setPath();
			onUnlock();
			return true;
		}
		return false;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<AbstractModification> getNext() {
		return next;
	}

	public void setNext(AbstractModification... next) {
		for (AbstractModification m : next) {
			this.next.add(m);			
		}
	}



	public double getMagicNumber() {
		return magicNumber;
	}



	public void setMagicNumber(double magicNumber) {
		this.magicNumber = magicNumber;
	}



	public AbstractModification getLast() {
		return last;
	}



	public void setLast(AbstractModification last) {
		this.last = last;
	}



	public abstract boolean isUnlockConditionMet();

	public boolean isUnlockable() {
		return unlockable;
	}


	public void setUnlockable(boolean unlockable) {
		this.unlockable = unlockable;
	}

	public boolean isLocksOnLast() {
		return locksOnLast;
	}

	public void setLocksOnLast(boolean locksOnLast) {
		this.locksOnLast = locksOnLast;
	}
	
}
