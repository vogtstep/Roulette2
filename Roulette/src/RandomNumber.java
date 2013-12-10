
public class RandomNumber {
	
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
	
private int number;
private int evenOdd;
private int color;
private int column;
private int dozen;
private int lowHigh;
	

public RandomNumber()
{
	//ZAHL
	number=(int) (Math.random()*37);
	
	//GERADE UNGERADE
	if (number==0)
	{
		evenOdd=-1;
	}
	else if (number%2==0)
	{
		evenOdd=even;
	}
	else
	{
		evenOdd=odd;
	}
	
	//FARBE
	if (number==0)
	{
		color=-1;
	}
	else if (number == 1 || number == 3 || number == 5 || number == 7 || 
			number == 9 || number == 12 || number == 14 || number == 16 || 
			number == 18 || number == 19 || number == 21 || number == 23 || 
			number == 25 || number == 27 || number == 30 || number == 32 || 
			number == 34 || number == 36)
	{
		color=red;
	}
	else
	{
		color=black;
	}
	
	//Kolonne
	if (number==0)
	{
		column=-1;
	}
	else if (number%3==1 && number !=0)
	{
		column=col1;
	}
	else if (number%3==2 && number !=0)
	{
		column=col2;
	}
	else
	{
		column=col3;
	}
	
	//Duzend
	if (number>0 && number <=12)
	{
		dozen=dozen1;
	}
	else if (number>12 && number <=24)
	{
		dozen=dozen2;
	}
	else 
	{
		dozen=dozen3;
	}
	
	//Hoch Tief
	if (number>0 && number<=18)
	{
		lowHigh=low;
	}
	else
	{
		lowHigh=high;
	}
}


public int getNumber() {
	return number;
}

//@Schedule(minute="5")
public int getEvenOdd() {
	return evenOdd;
}


public int getColor() {
	return color;
}


public int getColumn() {
	return column;
}


public int getDozen() {
	return dozen;
}


public int getLowHigh() {
	return lowHigh;
}

}
