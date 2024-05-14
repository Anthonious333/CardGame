package BigBoss;

import java.util.ArrayList;

public abstract class AbstractCharecter {

	protected ArrayList<Stat> stats = new ArrayList<Stat>();
	protected String name;
	
	public AbstractCharecter (String name) {
		this.name = name;
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
}
