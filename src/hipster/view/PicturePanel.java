package hipster.view;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PicturePanel extends JPanel
{
	/**
	 * @author Alex Johsnon
	 * @param Declaration Section
	 * @verison 1.3 11/28/13
	 */
	private static final long serialVersionUID = 1L;
	private Image baseImage;
	private ImageIcon pictureSource;
	private int width;
	private int height;
	
	/**
	 * Creates a PicturePanel object with the specified URL path, width and height.
	 * @param imagePath The URL address for the picture.
	 * @param width The Widther of the panel.
	 * @param height The Height of the panel.
	 */
	
	public PicturePanel(URL imagePath, int width, int height)
	{
		this.width = width;
		this.height = height;
		this.pictureSource = new ImageIcon(imagePath);
	}
	//Overrides the pointComponent method of the JPanel to draw the image to fill the entire panel.
	//@Overrides
	protected void pointComponent(Graphics panelGraphics)
	{
		super.paintComponent(panelGraphics);
		baseImage = pictureSource.getImage();
		panelGraphics.drawImage(baseImage, 0, 0, width, height, null);
	}
	public void setPictureSource(URL imageURL) 
	{
		
	}
}
