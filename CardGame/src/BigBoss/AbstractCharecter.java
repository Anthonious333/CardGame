package BigBoss;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import BigBoss.Abilities.EmptyAbility;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

public abstract class AbstractCharecter {
	
	public final int SKILL_SIZE = 70;

	private ArrayList<Stat> stats = new ArrayList<Stat>();
	private ArrayList<AbstractAbility> abilities = new ArrayList<AbstractAbility>();
	private ArrayList<AbstractAbility> posibleAbilities = new ArrayList<AbstractAbility>();
	private ArrayList<AbstractModification> mods = new ArrayList<AbstractModification>();
	private String name;
	private int statPoints;
	private boolean isDead;
	private int rollTokens = 0;
	private int wins = 0;
	
	public AbstractCharecter (String name) {
		this.setName(name);
		this.setDead(false);
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
	
	public String getImageLocation() {
		return getClass().getResource("/images/" + this.getName() + ".png").toString();
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
			ret += getStatAsString(s.getName()) + "\n";
		}
		return ret;
	}
	
	//retruns the amoutn of stat added(positive
	public int addStat (String id, int amount) {
		return this.findStat(id).addValue(amount);
	}
	
	//returns the amount reduced (positive)
	public int reduceStat (String id, int amount) {
		if (id.equals("HP") && (this.getStat(id) - amount) <= 0) {
			this.setDead(true);
		}
		return -this.findStat(id).addValue(-amount);
	}
	
	//returns the amount of damage taken (positive)
	public int damage (int amount) {
		return this.reduceStat("HP", amount);
	}
	
	//returns the amount healed (positive)
	public int heal (int amount) {
		return this.addStat("HP", amount);
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
	
	public String[] getFightIntro () {
		ArrayList<String> toSay = new ArrayList<String>();
		FileReader intro;
		BufferedReader introReader;
		String line;
		
		try {
			intro = new FileReader("data/" + this.getName() + "FightIntro.txt");
			introReader = new BufferedReader(intro);

			//Continues until file is empty
			while ((line = introReader.readLine()) != null) {
				toSay.add(line);
			}

		} catch (FileNotFoundException e) {
			System.out.print("No file was found: " + e.getMessage());
		} catch (IOException e) {
			System.out.print("Error reading file: " + e.getMessage());
		}
		
		String[] ret = new String[toSay.size()];
		for (int i = 0; i < toSay.size(); i++) {
			ret[i] = toSay.get(i);
		}
		
		return ret;
	}
	
	public void reset() {
		this.setDead(false);
		for (Stat s : this.getStats()) {
			s.reset();
		}
	}
	
	public int numberOfLockedAbilities() {
		int ret = 0;
		for (AbstractAbility a : this.getPosibleAbilities()) {
			if (!a.isUnlocked() && ret < 3) {
				ret++;
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
	
	public void setStatPoints(int amount) {
		this.statPoints = amount;
	}

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	public int getRollTokens() {
		return rollTokens;
	}

	public void addRollTokens(int rollTokens) {
		this.rollTokens += rollTokens;
	}

	public int getWins() {
		return wins;
	}

	public void addWin() {
		this.wins++;
	}


}
