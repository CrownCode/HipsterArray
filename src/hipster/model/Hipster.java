package hipster.model;
/**
 * @author Alex Johsnon
 * @verison 1.3  11/28/13
 * Added getters/setters, overloaded constructor for additional hipsters. 
 */
public class Hipster
{
	private String hipsterName;
	private String hipsterType;
	private String hipsterPhrase;
	private String[] hipster;
	private String[] hipsterCar;
	private String[] hipsterBook;
	
	public Hipster()
	{
		hipsterCar = new String[7]; //"x" Strings in the list
		hipsterName = "Alex";
		hipsterType = "Level 1 Hipster";
		hipsterPhrase = "Shot Clock Cheese";
		hipsterBook = new String[3];
		
		fillTheCars(); //Helper Method
		fillTheBook();
	}
	
	/**
	 * @param name
	 * @param Type
	 * @param Phrase
	 * @param Cars
	 */
	
	public void fillTheCars() // = shoves String in Array Position <-----
	{
		hipsterCar[0] = "2013 Lamborghini Adventador";
		hipsterCar[1] = "2013 Masurati GT";
		hipsterCar[2] = "2014 Nissan GTR";
		hipsterCar[3] = "2014 Ferrari 458 Italia";
		hipsterCar[4] = "2013 Tesla Model S";
		hipsterCar[5] = "1965 Cadillac Coupe DeVille";
		hipsterCar[6] = "1964 Chevrolet Impala SS";
	}
	public void fillThePhrase() // = shoves in Array Position <-----
	{
		hipsterPhrase = "Shot Glock Cheese";
	}
	public void fillTheBook()
	{
		hipsterBook[0] = "For Whom the Bell Tolls";
		hipsterBook[1] = "V for Vendetta";
		hipsterBook[2] = "Fieldy: Got the Life";
	}
	public Hipster(String name, String hipsterType, String hipsterPhrase, String[] hipsterCars, String[] hipsterBook) //2 constructors create diffrent ways to make objects.
	{
		this.hipsterName = name;
		this.hipsterCar = hipsterCars;
		this.hipsterPhrase = hipsterPhrase;
		this.hipsterType = hipsterType;
	}
	/**
	 * getters and setters supreme.
	 * @author Alex Johnson 11/20/13
	 * @version 1.3
	 */
	/**
	 * 
	 * @return hipsterName
	 */
	public String getName()
	{
		return hipsterName;
	}
	public void setName(String name) //All setters give you void back
	{
		this.hipsterName = name;
	}
	public String getHipsterType() //getter for HipsterType
	{
		return hipsterType;
	}
	public void setHipsterType(String hipsterType) //setter for Hipster Type
	{
		this.hipsterType = hipsterType;
	}
	public String getHipsterPhrase() //getter for HipsterPhrase
	{
		return hipsterPhrase;
	}
	public void setHipsterPhrase(String hipsterPhrase) //setter for Hipster Phrase
	{
		this.hipsterPhrase = hipsterPhrase;
	}
	public String [] getHipster() //getter for Hipster
	{
		return hipster;
	}
	public void setHipster(String [] hipster) //setter for Hipster
	{
		this.hipster = hipster;
	}
	public String[] getHipsterBooks() //getter for HipsterBooks
	{
		return hipsterBook;
	}
}
