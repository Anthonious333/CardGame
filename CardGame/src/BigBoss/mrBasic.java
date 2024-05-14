package BigBoss;

public class mrBasic extends AbstractCharecter{

	public mrBasic() {
		super("Mr. Basic");
		this.addStats(
				new Stat("ATK", 5), 
				new Stat("HP", 100, 0, 100)
				);
	}

}
