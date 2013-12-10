
public class Player {
private String username;
private String password;
private Integer balance;
	
	
	public Player()
	{
		setUsername("Player1");
		setPassword("pw");
		setBalance(30);
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Integer getBalance() {
		return balance;
	}


	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	
	
}
