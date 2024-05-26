package BigBoss;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;

public abstract class AbstractCharecter {
	
	public final int SKILL_SIZE = 70;

	private ArrayList<Stat> stats = new ArrayList<Stat>();
	private AbstractAbility [] abilities = new AbstractAbility[3];
	private ArrayList<AbstractAbility> posibleAbilities = new ArrayList<AbstractAbility>();
	private ArrayList<Modification> mods = new ArrayList<Modification>();
	private String name;
	
	public AbstractCharecter (String name) {
		this.setName(name);
	}
	
	public void addStats (Stat...stats) {
		for (Stat s : stats) {
			this.stats.add(s);
		}
	}
	
	public Stat findInfo(String ID) {
        for (Stat i : stats) { 
            if (i.getName().equals(ID)) { 
                return i;
            }
        }
        return null;
    }
	
	public int getStat(String ID) {
		Stat i = findInfo(ID);
        if (i != null) {
            return i.getValue();
        }
        return -1;
    }
	
	public ArrayList<Stat> getStats() {
		return stats;
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
			ret += this.findInfo(s.getName()).getName() + " :" + this.getStat(s.getName()) + (this.findInfo(s.getName()).isLimited()? "/" +  this.findInfo(s.getName()).getMax(): "") + " ";
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
	
	public String LastUnlockedMod() {
		String ret = "NONE";
		for (Modification m : mods) {
			if (m.isUnlocked()) {
				ret = m.getName();
			}
		}
		return ret;
	}
	
	public ArrayList<AbstractAbility> getPosibleAbilities() {
		return posibleAbilities;
	}

	public void setPosibleAbilities(AbstractAbility... posibleAbilities) {
		for (AbstractAbility a : posibleAbilities) {
			this.posibleAbilities.add(a);
		}
	}

	public ArrayList<Modification> getMods() {
		return mods;
	}

	public void setMods(Modification... mods) {
		for (Modification m : mods) {
			this.mods.add(m);
		}
	}

}
