package net.fooddelivery.restaurant.win;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.filechooser.FileNameExtensionFilter;
import net.fooddelivery.restaurant.models.*;

import net.fooddelivery.restaurant.func.ResManagement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
public class UpdateResWin {
	public static ResManagement resman;

	private JFrame frame;
	private JTextField Name;
	private JTextField Add;
	private JTextField OT;
	private JTextField CT;
	private JTextField textField;
	private JTextField FileAdd;
	byte[] bFile ;
	private JTextField DelFee;

	/**
	 * Launch the application.
	 */
	public void show() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateResWin window = new UpdateResWin(resman);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UpdateResWin(ResManagement r) {
		resman=r;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(72, 40, 72, 18);
		frame.getContentPane().add(lblNewLabel);
		
		Name = new JTextField();
		Name.setBounds(227, 37, 355, 24);
		frame.getContentPane().add(Name);
		Name.setColumns(10);
		Name.setText(resman.res.getName());
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(72, 341, 96, 18);
		frame.getContentPane().add(lblDescription);
		
		JLabel lblNewLabel_1 = new JLabel("Address:");
		lblNewLabel_1.setBounds(72, 405, 72, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		Add = new JTextField();
		Add.setColumns(10);
		Add.setBounds(227, 402, 355, 24);
		frame.getContentPane().add(Add);
		Add.setText(resman.res.getAddress());
		
		JLabel lblOpentime = new JLabel("OpenTime:");
		lblOpentime.setBounds(72, 469, 72, 18);
		frame.getContentPane().add(lblOpentime);
		
		
		OT = new JTextField();
		OT.setBounds(227, 466, 126, 24);
		frame.getContentPane().add(OT);
		OT.setColumns(10);
		OT.setText(resman.res.getOpenTime());
		
		JLabel label = new JLabel("-");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(367, 469, 21, 18);
		frame.getContentPane().add(label);
		
		CT = new JTextField();
		CT.setColumns(10);
		CT.setBounds(402, 466, 126, 24);
		frame.getContentPane().add(CT);
		CT.setText(resman.res.getCloseTime());
		


		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(227, 338, 355, 24);
		frame.getContentPane().add(textField);
		
		JLabel lblPhoto = new JLabel("Photo:");
		lblPhoto.setBounds(72, 115, 72, 18);
		frame.getContentPane().add(lblPhoto);
		
		FileAdd = new JTextField();
		FileAdd.setText(" Choose a image file from disk");
		FileAdd.setBounds(227, 228, 328, 24);
		frame.getContentPane().add(FileAdd);
		FileAdd.setColumns(10);
		
		JLabel Photo = new JLabel("New label");
		Photo.setBounds(330, 91, 100, 100);
		frame.getContentPane().add(Photo);
		ImageIcon icon = new ImageIcon(resman.res.getPhoto());
		bFile=resman.res.getPhoto();
		Photo.setIcon(icon);
		
		
		JButton btnChooseFile = new JButton("Choose File");
		btnChooseFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    JFileChooser chooser = new JFileChooser();
			    FileNameExtensionFilter filter = new FileNameExtensionFilter(
			        "JPEG", "jpg");
			    chooser.setFileFilter(filter);
			    int returnVal = chooser.showOpenDialog(frame);
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
					ImageIcon icon = new ImageIcon(bFile);
					Photo.setIcon(icon);
			    }
			}
		});
		
		JLabel lblDeliverFee = new JLabel("Deliver Fee:");
		lblDeliverFee.setBounds(72, 292, 96, 18);
		frame.getContentPane().add(lblDeliverFee);
		
		DelFee = new JTextField();
		DelFee.setColumns(10);
		DelFee.setBounds(227, 289, 178, 24);
		frame.getContentPane().add(DelFee);
		DelFee.setText(Double.toString(resman.res.getDeliverFee()));
		
		btnChooseFile.setBounds(569, 227, 145, 27);
		frame.getContentPane().add(btnChooseFile);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				Restaurant newres=new Restaurant();
				newres.setName(Name.getText());
				newres.setAddress(Add.getText());
				newres.setOpenTime(OT.getText());
				newres.setCloseTime(CT.getText());
				newres.setPhoto(bFile);
				newres.setDeliverFee(Double.parseDouble(DelFee.getText()));
				resman.UpdateRes(newres);
				JOptionPane.showMessageDialog(null, "Information of Restaurant Updated Successfully!", "Success!", JOptionPane.INFORMATION_MESSAGE);
				frame.dispose();
				
			}
		});
		btnUpdate.setBounds(596, 502, 113, 27);
		frame.getContentPane().add(btnUpdate);
		

		


	}
}