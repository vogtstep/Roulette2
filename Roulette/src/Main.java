import java.io.*;
import java.util.ArrayList;

public class Main {
	
// FELDZUWEISUNGEN IN INT
	final static int red = 37,
					black = 38,
					odd = 39,
					even = 40,
					dozen1 = 41,
					dozen2 = 42,
					dozen3 = 43,
					col1 = 44,
					col2 = 45,
					col3 = 46,
					low = 47,
					high = 48					
					;
	

	public static void main(String[] args) throws IOException {
		ArrayList<Bet> BetList = new ArrayList<Bet>();
		Player player1 = new Player();
		System.out.print("\n\tHERZLICH WILLKOMMEN "+player1.getUsername()+" IM CASINO WEINGARTEN\n");

		
		BufferedReader eingabe = new BufferedReader (new InputStreamReader (System.in));
		String inputChoice;
		int selectedField;
		
		System.out.print("\nAuf was wollen Sie setzen ? \n" +
				"	Zahl			[0]-[36]\n" +
				"	Rot	 			[r]\n" +
				"	Schwarz	 		[b]\n" +
				"   gerade Zahl 	[o]\n" +
				"	ungerade Zahl 	[e]\n" +
				"	erstes Dutzend	[d1]\n" +
				"	zweites Dutzend	[d2]\n" +
				"	drittes Dutzend	[d3]\n" +
				"	erste Kolonne	[c1]\n" +
				"	zweite Kolonne	[c2]\n" +
				"	dritte Kolonne	[c3]\n" +
				"	niedrig (1-18)	[l]\n" +
				"	hoch (19-36)	[h]\n\n" +
				
				"   Auswerten		[a]");
	
		do {
		
		do {
			
		selectedField = -1;
		inputChoice = (eingabe.readLine());
		switch (inputChoice)
		{
		case "r":
			System.out.println("Auf Rot gesetzt");
			selectedField=red;
			break;
			
		case "b":
			System.out.println("Auf Schwarz gesetzt");
			selectedField=black;
			break;
			
		case "o":
			System.out.println("Auf Ungerade gesetzt");
			selectedField=odd;
			break;
			
		case "e":
			System.out.println("Auf Gerade gesetzt");
			selectedField=even;
			break;
			
		case "d1":
			System.out.println("Auf erste Duzend gesetzt");
			selectedField=dozen1;
			break;
			
		case "d2":
			System.out.println("Auf zweite Duzend gesetzt");
			selectedField=dozen2;
			break;
			
		case "d3":
			System.out.println("Auf dritte Duzend gesetzt");
			selectedField=dozen3;
			break;
			
		case "c1":
			System.out.println("Auf erste Kolonne gesetzt");
			selectedField=col1;
			break;
			
		case "c2":
			System.out.println("Auf zweite Kolonne gesetzt");
			selectedField=col2;
			break;
			
		case "c3":
			System.out.println("Auf dritte Kolonne gesetzt");
			selectedField=col3;
			break;
			
		case "l":
			System.out.println("Auf niedrig gesetzt");
			selectedField=low;
			break;
			
		case "h":
			System.out.println("Auf hoch gesetzt");
			selectedField=high;
			break;
			
		case "a":
			inputChoice="a";
			break;
			
		default:
			int i=Integer.parseInt(inputChoice);
			if (i>=0 && i<=36)
				{
					selectedField=i;
					System.out.println("Auf die Zahl: "+selectedField+" gesetzt");
				}
			else System.out.println("Ungültige Eingabe");
		}
		
		if (selectedField!=-1)
		{
			Bet bet = new Bet();				
			bet.setPlayer(player1);
			bet.setField(selectedField);
			player1.setBalance(player1.getBalance()-bet.getWager());
			BetList.add(bet);
		}
		
		}
		while (inputChoice != "a" && player1.getBalance()>=1);
		
		RandomNumber randomNum = new RandomNumber();
		String color;
		if (randomNum.getColor()==-1) color ="Grün";
		else if (randomNum.getColor()==red) color = "Rot";
		else color = "Schwarz";
			
		System.out.println("Die Kugel ist auf der Zahl "+randomNum.getNumber()+" mit der Farbe "+color+" liegen geblieben");

		for (int i=0; i<BetList.size(); i++)
		{
			scoring(BetList.get(i),randomNum);
		}
		System.out.println("Auswertung beendet");
		BetList.clear();
		System.out.println("Guthaben: "+player1.getBalance());
		
		}
		while (player1.getBalance()>=1);
	}
	
	static void scoring(Bet bet, RandomNumber randomNum)
	{
		//Zufallszahl ermitteln
		int betField = bet.getField();
		int win=0;
		if (betField<=36 && betField==randomNum.getNumber())
			{
				win= bet.getWager()*36;
				System.out.println("Spieler "+bet.getPlayer().getUsername()+" hat auf die richtige Zahl gesetzt und gewinnt "+win);
				bet.getPlayer().setBalance(bet.getPlayer().getBalance()+win);
			}
		else switch(betField)
		{
			case red:
				if (randomNum.getColor()==red)
				{
					win = bet.getWager()*2;
					System.out.println("Spieler "+bet.getPlayer().getUsername()+" hat auf die richtige Farbe gesetzt und gewinnt "+win);
					bet.getPlayer().setBalance(bet.getPlayer().getBalance()+win);
				}
				break;
			case black:
				if (randomNum.getColor()==black)
				{
					win = bet.getWager()*2;
					System.out.println("Spieler "+bet.getPlayer().getUsername()+" hat auf die richtige Farbe gesetzt und gewinnt "+win);
					bet.getPlayer().setBalance(bet.getPlayer().getBalance()+win);
				}	
				break;
			case odd:
				if (randomNum.getEvenOdd()==odd)
				{
					win = bet.getWager()*2;
					System.out.println("Spieler "+bet.getPlayer().getUsername()+" hat auf ungerade gesetzt und gewinnt "+win);
					bet.getPlayer().setBalance(bet.getPlayer().getBalance()+win);
				}
				break;
			case even:
				if (randomNum.getEvenOdd()==even)
				{
					win = bet.getWager()*2;
					System.out.println("Spieler "+bet.getPlayer().getUsername()+" hat auf gerade gesetzt und gewinnt "+win);
					bet.getPlayer().setBalance(bet.getPlayer().getBalance()+win);
				}
				break;
			case dozen1:
				if (randomNum.getDozen()==dozen1)
				{
					win = bet.getWager()*3;
					System.out.println("Spieler "+bet.getPlayer().getUsername()+" hat aufs richtige Duzend gesetzt und gewinnt "+win);
					bet.getPlayer().setBalance(bet.getPlayer().getBalance()+win);
				}
				break;
				
			case dozen2:
				if (randomNum.getDozen()==dozen2)
				{
					win = bet.getWager()*3;
					System.out.println("Spieler "+bet.getPlayer().getUsername()+" hat aufs richtige Duzend gesetzt und gewinnt "+win);
					bet.getPlayer().setBalance(bet.getPlayer().getBalance()+win);
				}
				break;
			case dozen3:
				if (randomNum.getDozen()==dozen3)
				{
					win = bet.getWager()*3;
					System.out.println("Spieler "+bet.getPlayer().getUsername()+" hat aufs richtige Duzend gesetzt und gewinnt "+win);
					bet.getPlayer().setBalance(bet.getPlayer().getBalance()+win);
				}
				break;
			case col1:
				if (randomNum.getColumn()==col1)
				{
					win = bet.getWager()*3;
					System.out.println("Spieler "+bet.getPlayer().getUsername()+" hat auf die richtige Kolonne gesetzt und gewinnt "+win);
					bet.getPlayer().setBalance(bet.getPlayer().getBalance()+win);
				}
				break;
			case col2:
				if (randomNum.getColumn()==col2)
				{
					win = bet.getWager()*3;
					System.out.println("Spieler "+bet.getPlayer().getUsername()+" hat auf die richtige Kolonne gesetzt und gewinnt "+win);
					bet.getPlayer().setBalance(bet.getPlayer().getBalance()+win);
				}
				break;
			case col3:
				if (randomNum.getColumn()==col3)
				{
					win = bet.getWager()*3;
					System.out.println("Spieler "+bet.getPlayer().getUsername()+" hat auf die richtige Kolonne gesetzt und gewinnt "+win);
					bet.getPlayer().setBalance(bet.getPlayer().getBalance()+win);
				}
				break;
			case low:
				if (randomNum.getLowHigh()==low)
				{
					win = bet.getWager()*2;
					System.out.println("Spieler "+bet.getPlayer().getUsername()+" hat auf die richtige Hälfte gesetzt und gewinnt "+win);
					bet.getPlayer().setBalance(bet.getPlayer().getBalance()+win);
				}
				break;
			case high:
				if (randomNum.getLowHigh()==high)
				{
					win = bet.getWager()*2;
					System.out.println("Spieler "+bet.getPlayer().getUsername()+" hat auf die richtige Hälfte gesetzt und gewinnt "+win);
					bet.getPlayer().setBalance(bet.getPlayer().getBalance()+win);
				}
				break;
				
		}
		
	}
}