package hipster.controller;

	/**
	 * Start the Hipster project 
	 * @author Alex Johnosn
	 * @verison 1.0 11/20/13
	 */
public class HipsterRunner 
{
	public static void main(String []args)
	{
		HipsterController myHipster = new HipsterController();
		myHipster.start();
	}
}