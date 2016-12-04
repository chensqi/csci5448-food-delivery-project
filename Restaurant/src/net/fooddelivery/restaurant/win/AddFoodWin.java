package net.fooddelivery.restaurant.win;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.UIManager;
import net.fooddelivery.restaurant.func.*;
import net.fooddelivery.restaurant.models.Food;
public class AddFoodWin {

	private JFrame frmAddFood;
	private JTextField name,des,FileAdd;
	private byte[]bFile;
	private JTextField price;
	private JTextField calorie;
	public FoodManagement foodman;
	private JButton btnChooseFile;
	/**
	 * Launch the application.
	 */
	public void show() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFoodWin window = new AddFoodWin(foodman);
					window.frmAddFood.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddFoodWin(FoodManagement f) {
		foodman=f;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddFood = new JFrame();
		frmAddFood.setTitle("Add Food");
		frmAddFood.getContentPane().setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
		final int width=800;
		final int height=600;
		Point p = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
	    frmAddFood.setBounds(p.x - width / 2, p.y - height / 2, width, height); 
		frmAddFood.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddFood.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name: ");
		lblNewLabel.setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
		lblNewLabel.setBounds(81, 75, 72, 18);
		frmAddFood.getContentPane().add(lblNewLabel);
		
		name = new JTextField();
		name.setBounds(217, 74, 232, 24);
		frmAddFood.getContentPane().add(name);
		name.setColumns(10);
		name.setText("Food Name");
		
		JLabel lblPhoto = new JLabel("Photo:");
		lblPhoto.setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
		lblPhoto.setBounds(81, 129, 72, 18);
		frmAddFood.getContentPane().add(lblPhoto);
		
		FileAdd = new JTextField();
		FileAdd.setText(" Choose a image file from disk");
		FileAdd.setBounds(217, 228, 328, 24);
		frmAddFood.getContentPane().add(FileAdd);
		FileAdd.setColumns(10);
		
		JLabel Photo = new JLabel("New label");
		Photo.setBounds(285, 115, 100, 100);
		frmAddFood.getContentPane().add(Photo);
		/*ImageIcon temp=new ImageIcon(foodman.food.getPhoto());
		ImageIcon icon = new ImageIcon(temp.getImage().getScaledInstance(Photo.getWidth(), Photo.getHeight(), Image.SCALE_DEFAULT));
		bFile=foodman.food.getPhoto();
		Photo.setIcon(icon);*/
		
		
		btnChooseFile = new JButton("Choose File");
		btnChooseFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    JFileChooser chooser = new JFileChooser();
			    FileNameExtensionFilter filter = new FileNameExtensionFilter(
			        "JPEG", "jpg");
			    chooser.setFileFilter(filter);
			    int returnVal = chooser.showOpenDialog(frmAddFood);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			    	FileAdd.setText(chooser.getSelectedFile().getPath());

			    	File file = new File(chooser.getSelectedFile().getPath());
			        bFile = new byte[(int) file.length()];
			        try {
			   	     FileInputStream fileInputStream = new FileInputStream(file);
			   	     //convert file into array of bytes
			   	     fileInputStream.read(bFile);
			   	     fileInputStream.close();
			           } catch (Exception err) {
			   	     err.printStackTrace();
			           }
					ImageIcon temp=new ImageIcon(bFile);
					ImageIcon icon = new ImageIcon(temp.getImage().getScaledInstance(Photo.getWidth(), Photo.getHeight(), Image.SCALE_DEFAULT));
					Photo.setIcon(icon);
			    }
			}
		});
		btnChooseFile.setBounds(569, 227, 145, 27);
		frmAddFood.getContentPane().add(btnChooseFile);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
		lblDescription.setBounds(81, 291, 108, 18);
		frmAddFood.getContentPane().add(lblDescription);
		
		des = new JTextField();
		des.setBounds(217, 290, 485, 24);
		frmAddFood.getContentPane().add(des);
		des.setColumns(10);
		des.setText("Description");
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
		lblPrice.setBounds(81, 384, 108, 18);
		frmAddFood.getContentPane().add(lblPrice);
		
		price = new JTextField();
		price.setBounds(161, 383, 100, 24);
		frmAddFood.getContentPane().add(price);
		price.setColumns(10);
		price.setText("Price");
		
		JLabel lblCalorie = new JLabel("Calorie:");
		lblCalorie.setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
		lblCalorie.setBounds(351, 386, 108, 18);
		frmAddFood.getContentPane().add(lblCalorie);
		
		calorie = new JTextField();
		calorie.setColumns(10);
		calorie.setBounds(473, 383, 100, 24);
		frmAddFood.getContentPane().add(calorie);
		calorie.setText("calorie");
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Food newf= new Food();
				newf.setCalorie(Integer.valueOf(calorie.getText()));
				newf.setDescription(des.getText());
				newf.setName(name.getText());
				newf.setPrice(Double.valueOf(price.getText()));
				newf.setPhoto(bFile);
				foodman.AddFood(newf);
				frmAddFood.dispose();

			}
		});
		btnAdd.setBounds(569, 495, 113, 27);
		frmAddFood.getContentPane().add(btnAdd);
		//lock();
	}
	private void lock(){
		name.setEditable(false);
		des.setEditable(false);
		FileAdd.setEnabled(false);
		btnChooseFile.setEnabled(false);
		price.setEditable(false);
		calorie.setEditable(false);
		
	}	
	private void unlock(){
		name.setEditable(true);
		des.setEditable(true);
		FileAdd.setEnabled(true);
		btnChooseFile.setEnabled(true);
		price.setEditable(true);
		calorie.setEditable(true);
	}

}
