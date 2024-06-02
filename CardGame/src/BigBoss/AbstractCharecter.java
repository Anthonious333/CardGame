package BigBoss;

import java.util.ArrayList;

import BigBoss.Abilities.EmptyAbility;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;

public abstract class AbstractCharecter {
	
	public final int SKILL_SIZE = 70;

	private ArrayList<Stat> stats = new ArrayList<Stat>();
	private ArrayList<AbstractAbility> abilities = new ArrayList<AbstractAbility>();
	private ArrayList<AbstractAbility> posibleAbilities = new ArrayList<AbstractAbility>();
	private ArrayList<AbstractModification> mods = new ArrayList<AbstractModification>();
	private String name;
	private int statPoints;
	
	public AbstractCharecter (String name) {
		this.setName(name);
		
		//default ability setup
		AbstractAbility a1 = new EmptyAbility(this);
		AbstractAbility a2 = new EmptyAbility(this);
		AbstractAbility a3 = new EmptyAbility(this);
		abilities.add(a1);
		abilities.add(a2);
		abilities.add(a3);
		a1.setUnlocked(true);
		a2.setUnlocked(true);
		a3.setUnlocked(true);
		a1.setEquiped(true);
		a2.setEquiped(true);
		a3.setEquiped(true);
		this.setPosibleAbilities(a1, a2, a3);

	}
	
	public void addStatsToList (Stat...stats) {
		for (Stat s : stats) {
			this.stats.add(s);
		}
	
	}
	
	public Stat findStat(String ID) {
        for (Stat i : stats) { 
            if (i.getName().equals(ID)) { 
                return i;
            }
        }
        return null;
    }
	
	public AbstractAbility findAbility(String ID) {
        for (AbstractAbility a : posibleAbilities) { 
            if (a.getName().equals(ID)) { 
                return a;
            }
        }
        return null;
    }
	
	public int getStat(String ID) {
		Stat i = findStat(ID);
        if (i != null) {
            return i.getValue() + i.getTempValue();
        }
        return -1;
    }
	
	public ArrayList<Stat> getStats() {
		return stats;
    }
	
	public void removeStatsFromList (Stat...stats) {
		for (Stat s : stats) {
			if (this.stats.contains(s)) {
				this.stats.remove(s);
			}
		}
	}
	
	public String getStatsAsString () {
		String ret = "";
		for (Stat s : stats) {
			ret += getStatAsString(s.getName());
		}
		return ret;
	}
	
	public void addStat (String id, int amount) {
		this.findStat(id).addValue(amount);
	}
	
	public void reduceStat (String id, int amount) {
		this.findStat(id).addValue(-amount);
	}
	
	public void damage (int amount) {
		this.reduceStat("HP", amount);
	}
	
	public void heal (int amount) {
		this.addStat("HP", amount);
	}
	
	
	
	public String getStatAsString (String id) {
		Stat s = findStat(id);
		
		String ret = s.getName() + " :";
		int value = this.getStat(s.getName());
		ret += value;
		if (s.isLimited()) {
			ret += "/" +  (this.findStat(s.getName()).getMax() + s.getTempValue());
		}
		ret += " ";
		
		return ret;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AbstractAbility getAbility(int index) {
		if(abilities.get(index) != null) {
			return abilities.get(index);			
		} else {
			return new EmptyAbility(this);
		}
		
	}

	public void equipAbility(String id, int index) {
		equipAbility(findAbility(id), index);
	}
	
	public void equipAbility(AbstractAbility a, int index) {
		a.setUnlocked(true);
		a.setEquiped(true);
		unequipAbility(index);
		abilities.set(index, a);
	}
	
	public void unequipAbility(int index) {
		abilities.get(index).setEquiped(false);
		abilities.set(index, new EmptyAbility(this));
	}
	
	public void unequipAbility(AbstractAbility a) {
		a.setEquiped(false);
		if (abilities.contains(a)) {
			abilities.set(abilities.indexOf(a), new EmptyAbility(this));
		}
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
		for (AbstractModification m : mods) {
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

	public ArrayList<AbstractModification> getMods() {
		return mods;
	}

	public void setMods(AbstractModification... mods) {
		for (AbstractModification m : mods) {
			this.mods.add(m);
		}
	}

	public int getStatPoints() {
		return statPoints;
	}

	public void addStatPoints(int statPoints) {
		this.statPoints += statPoints;
	}


}
