package hipster.controller;
import hipster.model.Hipster;
import hipster.view.HipsterFrame;

import javax.swing.JOptionPane;
/**
 * Controller for the project
 * @author Alex Johnson
 * @version 1.3 11/28/13
 *
 */
public class HipsterController 
{		
	private HipsterFrame appFrame;
	private Hipster selfHipster;
	private Hipster [] cubbyHipsters;
	private int hipsterCount;
	

	public HipsterController() //Constructor
	{
		setSelfHipster(new Hipster());
		cubbyHipsters = new Hipster[3]; //3 hipsters in cubbyHipsters.
	}

	public Hipster getSelfHipster() 
	{
		return selfHipster;
	}
	public void setSelfHipster(Hipster selfHipster) 
	{
		this.selfHipster = selfHipster;
	}

	/** 
	 * Used to retrieve random Hipster object from the array of the Class Hipster
	 * @return
	 */
	public Hipster getRandomHipster()
	// Random hipster betweeon 0-length.
	{
		Hipster currentHipster = null;
	
		int randomIndex = 0;
		double random = Math.random();
		randomIndex = (int) (random*cubbyHipsters.length);
		currentHipster = cubbyHipsters[randomIndex];
		
		return currentHipster;
	}
	
	public void start()
	{
		appFrame = new HipsterFrame(this);
	}
	//Specify the Array - Check that your not greater than length and not less than zero spot.
	public Hipster getSpecifiedHipster(int position)
	{
		Hipster currentHipster = null;
		
		if(position < cubbyHipsters.length && position >= 0) //checks the length and position from zero spot.
		{
			currentHipster = cubbyHipsters[position];
		}
		
		return currentHipster;
	}	
	public Hipster[] getCubbyHipsters()
	{
		return cubbyHipsters;
	}
	
	public void addHipster(String name, String hipsterType, String hipsterPhrase, String[] hipsterCars, String[] hipsterBook) //Test keeps program from crashing
	{
		if(hipsterCount < cubbyHipsters.length) //int gives you your own copy
		{
			Hipster tempHipster = new Hipster(name, hipsterType, hipsterPhrase, hipsterCars, hipsterBook);
			cubbyHipsters[hipsterCount] = tempHipster;
			hipsterCount++;
		}
		else
		{
			JOptionPane.showMessageDialog(appFrame, "The class is full, you are too mainstream to be added"); //Frame owns this pop-up window
		}
	}
	public void addHipster(String[] books, String text, String text2, String text3)
	{	
		
	}
}
