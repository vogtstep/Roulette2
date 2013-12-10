
public class Bet {
	private Player player;
	private Integer wager;
	private Integer field;

	public Bet()
	{
		setWager(1);
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Integer getWager() {
		return wager;
	}

	public void setWager(Integer wager) {
		this.wager = wager;
	}

	public Integer getField() {
		return field;
	}

	public void setField(Integer field) {
		this.field = field;
	}
}
