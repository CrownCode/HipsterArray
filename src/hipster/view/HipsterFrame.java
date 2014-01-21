package hipster.view;
import hipster.controller.HipsterController;

import javax.swing.JFrame;
/**
 * @author Alex Johnson
 * @verison 1.3  11/28/13
 * Creates a JFrame for das products.
 */
public class HipsterFrame extends JFrame //Hipster Frame is the Parent class of JFrame
{
	private static final long serialVersionUID = 1L;
	private HipsterController baseController;
	private HipsterPanel basePanel;
	
	public HipsterFrame(HipsterController baseController) //Hipster Frame from Controller
	{
		this.setBaseController(baseController);
		basePanel = new HipsterPanel(baseController);
		
		setupFrame();
	}
	public HipsterController getBaseController() {
		return baseController;
	}
	public void setBaseController(HipsterController baseController) {
		this.baseController = baseController;
	}
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(500,500);
		this.setVisible(true);
	}
}

