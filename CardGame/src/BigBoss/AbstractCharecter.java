package BigBoss;

import java.util.ArrayList;

public abstract class AbstractCharecter {

	private ArrayList<Stat> stats = new ArrayList<Stat>();
	private AbstractAbility [] abilities = new AbstractAbility[3];
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
	
	public String getStatsAsString () {
		String ret = "";
		for (Stat s : stats) {
			ret += s + " ";
		}
		return ret;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AbstractAbility getAbility(int index) {
		return abilities[index];
	}

	public void addAbility(AbstractAbility ability, int index) {
		abilities[index] = ability;
	}
	
	public String getAbilitiesAsString () {
		String ret = "";
		for (AbstractAbility s : abilities) {
			if (s != null) {
				ret += s + " ";				
			}
		}
		return ret;
	}
}
