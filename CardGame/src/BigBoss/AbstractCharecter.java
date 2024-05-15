package BigBoss;

import java.util.ArrayList;

public abstract class AbstractCharecter {

	private ArrayList<Stat> stats = new ArrayList<Stat>();
	private String name;
	
	public AbstractCharecter (String name) {
		this.setName(name);
	}
	
	public void addStats (Stat...stats) {
		for (Stat s : stats) {
			this.stats.add(s);
		}
	}
	
	public void removeStats (Stat...stats) {
		for (Stat s : stats) {
			if (this.stats.contains(s)) {
				this.stats.remove(s);
			}
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
