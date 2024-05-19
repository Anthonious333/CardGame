package BigBoss;

import java.util.ArrayList;

public abstract class AbstractAbility {
	
	String name;
	
	public AbstractAbility(String name) {
		this.name = name;
	}

	public abstract void use();
	
	@Override
	public String toString () {
		return name;
	}
}
