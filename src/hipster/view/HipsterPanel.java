package hipster.view;
import hipster.controller.HipsterController;
import hipster.model.Hipster;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
/**
 * @param HipsterPanel extending JPanel.
 * @author Alex Johnson
 * @version 1.3 12/5/13
 */
public class HipsterPanel extends JPanel
{
	/**
	 * @param Declaration Section
	 * @author Alex Johnson
	 * @verison 1.3 11/28/13
	 */
	private static final long serialVersionUID = 1L;

	private HipsterController baseController;
	
	private JButton addHipsterButton; //Hipster Button
	private JButton showRandomButton; //RandomButton
	private JButton showSpecificButton; //Specific Hipster Button
	private JButton showSelfButton; //Self Button
	private JLabel nameLabel; //Name Label
	private JLabel phraseLabel; //Phrase Label
	private JLabel typeLabel; //Type Label
	private JLabel booksLabel; //Books Label
	private JComboBox selectedHipsterComboBox; //Selected Hipster Combo Box
	private JTextField nameField; //Name Field
	private JTextField phraseField; //Phrase Field
	private JTextField typeField; //Type Field
	private JTextArea booksArea; //Books Area
	private PicturePanel picturePanel; //Picture Panel
	private URL imageURL; //Image directory
	private SpringLayout baseLayout; //First level of GUI
	private String [] baseArray; //First Array
	/**
	 * 
	 * @param baseController
	 */
	public HipsterPanel(HipsterController baseController)
	{
		this.baseController = baseController;
		
		addHipsterButton = new JButton("Add a Hipster"); //Button name
		showRandomButton = new JButton("Show a random Hipster"); //Random Button name
		showSpecificButton = new JButton("Show a certain Hipster"); //Specific Button name
		showSelfButton = new JButton("Show the Orginal Hipster"); //Self Button name
		nameField = new JTextField(25); //Name Field with 25 entries
		phraseField = new JTextField(25); //Phrase Field with 25 entries
		typeField = new JTextField(25); //Type Field with 25 entries
		nameLabel = new JLabel("Hipster's Name:"); //Name Label name
		booksLabel = new JLabel("Hipster's Book:"); //Books Label name
		phraseLabel = new JLabel("Hipster's Phrase"); //Phrase Label name
		typeLabel = new JLabel("Hipster's Label:"); //Type Label name
		booksArea = new JTextArea(5, 25); //Books Area parameters
		baseArray = new String[3]; //Base Array with 3 string parameter
		
		imageURL = getClass().getResource("/hipster/view/pictures/dfg.jpg"); //Path directory for picture in view.file.dfg.jpg
		picturePanel = new PicturePanel(imageURL, 200, 200);
		
		baseLayout = new SpringLayout();
		
		setupComboBox(); //Setup ComboBox method call
		setupPanel(); //Steup Panel method call
		setupLayout(); //Setup Layout mehod call
		setupListeners(); //Setup Listenres method call
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	/**
	 * @param setupComboBox
	 */
	private void setupComboBox() 
	{
		baseArray[0] = "Alex";
		baseArray[1] = "Mikel";
		baseArray[2] = "Kyler";
		
		selectedHipsterComboBox = new JComboBox(baseArray);
	}
	/**
	 * 
	 * @param currentHipster
	 */
	protected void populateFields(Hipster currentHipster)
	{
		imageURL = getClass().getResource("/hipster/view/images/" + currentHipster.getName() + ".jpg");
		picturePanel.setPictureSource(imageURL);
		
		nameField.setText(currentHipster.getName());
		typeField.setText(currentHipster.getName());
		phraseField.setText(currentHipster.getHipsterPhrase());
		booksArea.setText("");
		
		for (String temp : currentHipster.getHipsterBooks())
		{
			booksArea.append(temp + ", ");
		}
	}
	/**
	 * 
	 * @param poorInput
	 */
	private void blankFields(boolean poorInput)
	{
		nameField.setText("");
		typeField.setText("");
		phraseField.setText("");
		booksArea.setText("");
		
		if(poorInput)
		{
			JOptionPane.showMessageDialog(this, "Please use valid options Senor!");
		}
	}
	/**
	 * 
	 */
	private void sendHipsterInfoToController()
	{
		String [] books = booksArea.getText().split(", ");
		baseController.addHipster(books, nameField.getText(), typeField.getText(), phraseField.getText());
		JOptionPane.showMessageDialog(this, "Hipster added to the array");
	}
	public HipsterController getBaseController() 
	{
		return baseController;
	}
	public void setBaseController(HipsterController baseController) 
	{
		this.baseController = baseController;
	}
	/**
	 * @param setupPanel
	 */
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(addHipsterButton);
		this.add(showRandomButton);
		this.add(showSpecificButton);
		this.add(showSelfButton);
		this.add(nameLabel);
		this.add(phraseLabel);
		this.add(typeLabel);
		this.add(booksLabel);
		this.add(nameField);
		this.add(typeField);
		this.add(phraseField);
		this.add(booksArea);
		this.add(picturePanel);
		this.add(selectedHipsterComboBox);
		
		this.setBackground(new Color(130, 100, 50));
		this.setSize(1000, 450);
		booksArea.setWrapStyleWord(true);
		booksArea.setLineWrap(true);
	}
	/**
     * Autogenerated layout information for the SpringLayout settings.
     */
    private void setupLayout()
    {
        baseLayout.putConstraint(SpringLayout.NORTH, showSelfButton, 65, SpringLayout.SOUTH, showRandomButton);
        baseLayout.putConstraint(SpringLayout.WEST, showSpecificButton, 263, SpringLayout.WEST, this);
        baseLayout.putConstraint(SpringLayout.SOUTH, showSpecificButton, -83, SpringLayout.SOUTH, this);
        baseLayout.putConstraint(SpringLayout.WEST, showSelfButton, 0, SpringLayout.WEST, nameLabel);
        baseLayout.putConstraint(SpringLayout.WEST, showRandomButton, 0, SpringLayout.WEST, nameLabel);
        baseLayout.putConstraint(SpringLayout.NORTH, addHipsterButton, 22, SpringLayout.SOUTH, booksArea);
        baseLayout.putConstraint(SpringLayout.WEST, addHipsterButton, 0, SpringLayout.WEST, nameLabel);
        baseLayout.putConstraint(SpringLayout.NORTH, selectedHipsterComboBox, 18, SpringLayout.SOUTH, showRandomButton);
        baseLayout.putConstraint(SpringLayout.WEST, selectedHipsterComboBox, 0, SpringLayout.WEST, addHipsterButton);
        baseLayout.putConstraint(SpringLayout.NORTH, booksLabel, 0, SpringLayout.NORTH, booksArea);
        baseLayout.putConstraint(SpringLayout.WEST, booksLabel, 0, SpringLayout.WEST, nameLabel);
        baseLayout.putConstraint(SpringLayout.NORTH, nameField, 22, SpringLayout.NORTH, this);
        baseLayout.putConstraint(SpringLayout.NORTH, nameLabel, 6, SpringLayout.NORTH, nameField);
        baseLayout.putConstraint(SpringLayout.WEST, nameLabel, 0, SpringLayout.WEST, phraseLabel);
        baseLayout.putConstraint(SpringLayout.NORTH, typeLabel, 6, SpringLayout.NORTH, typeField);
        baseLayout.putConstraint(SpringLayout.WEST, typeLabel, 0, SpringLayout.WEST, phraseLabel);
        baseLayout.putConstraint(SpringLayout.NORTH, phraseLabel, 6, SpringLayout.NORTH, phraseField);
        baseLayout.putConstraint(SpringLayout.WEST, phraseLabel, 10, SpringLayout.WEST, this);
        baseLayout.putConstraint(SpringLayout.NORTH, booksArea, 18, SpringLayout.SOUTH, phraseField);
        baseLayout.putConstraint(SpringLayout.WEST, booksArea, 0, SpringLayout.WEST, nameField);
        baseLayout.putConstraint(SpringLayout.NORTH, phraseField, 17, SpringLayout.SOUTH, typeField);
        baseLayout.putConstraint(SpringLayout.NORTH, typeField, 11, SpringLayout.SOUTH, nameField);
        baseLayout.putConstraint(SpringLayout.WEST, typeField, 0, SpringLayout.WEST, nameField);
        baseLayout.putConstraint(SpringLayout.WEST, phraseField, 0, SpringLayout.WEST, nameField);
        baseLayout.putConstraint(SpringLayout.WEST, nameField, 175, SpringLayout.WEST, this);
        baseLayout.putConstraint(SpringLayout.NORTH, picturePanel, -220, SpringLayout.SOUTH, this);
        baseLayout.putConstraint(SpringLayout.WEST, picturePanel, -200, SpringLayout.EAST, this);
        baseLayout.putConstraint(SpringLayout.SOUTH, picturePanel, -20, SpringLayout.SOUTH, this);
        baseLayout.putConstraint(SpringLayout.EAST, picturePanel, -20, SpringLayout.EAST, this);
        baseLayout.putConstraint(SpringLayout.NORTH, showRandomButton, 18, SpringLayout.SOUTH, addHipsterButton);
    }
    /**
     * 
     * @return tempNames
     */
	private String[] getNamesForComboBox()
	{
		int realValues = 0;
		for(int count = 0; count < baseController.getCubbyHipsters().length; count++)
		{
			if(baseController.getCubbyHipsters()[count] != null)
			{
				realValues++;
			}
		}
		String [] tempNames = new String[realValues];
		
		for (int realSize = 0; realSize < realValues; realSize++)
		{
			tempNames[realSize] = baseController.getCubbyHipsters()[realSize].getName();
		}
		return tempNames;
	}
	/**
	 * @param updates
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void updateHipsterComboBox()
	{
		String [] comboValues = getNamesForComboBox();
		selectedHipsterComboBox.setModel(new DefaultComboBoxModel(comboValues));
	}
	private void setupListeners()
	{
		addHipsterButton.addActionListener(new ActionListener()
		{
			@SuppressWarnings("unused")
			public void actionPreformed(ActionEvent click)
			{
				sendHipsterInfoToController();
				updateHipsterComboBox();
				blankFields(false);
			}

			@Override
			public void actionPerformed(ActionEvent click) 
			{
				
			}
		});
		
		showSelfButton.addActionListener(new ActionListener()
		{
			@SuppressWarnings("unused")
			public void actionPreformed(ActionEvent click)
			{
				Hipster selfHipster = baseController.getSelfHipster();
				populateFields(selfHipster);
			}

			@Override
			public void actionPerformed(ActionEvent click) 
			{
				
			}
		});
		
		showSpecificButton.addActionListener(new ActionListener()
		{
			@SuppressWarnings("unused")
			public void actionPreformed(ActionEvent click)
			{
				Hipster selectedHipster = baseController.getSpecifiedHipster(0);
				if(selectedHipster != null)
				{
					populateFields(selectedHipster);
				}
				else
				{
					blankFields(true);
				}
			}

			@Override
			public void actionPerformed(ActionEvent click) 
			{
				
			}
		});
		
		showRandomButton.addActionListener(new ActionListener()
		{
			@SuppressWarnings("unused")
			public void actionPreformed(ActionEvent click)
			{
				Hipster randomHipster = baseController.getRandomHipster();
				if (randomHipster != null)
				{
					populateFields(randomHipster);
				}
				else
				{
					blankFields(true);
				}
			}

			@Override
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
		selectedHipsterComboBox.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent itemSelected)
			{
				int currentSelection = selectedHipsterComboBox.getSelectedIndex();
				if(currentSelection >= 0)
				{
					Hipster selectedHipster = baseController.getSpecifiedHipster(currentSelection);
					if(selectedHipster != null)
					{
						populateFields(selectedHipster);
					}
					else
					{
						blankFields(true);
					}
				}
				
			}
		});
	}
}
