package phonebook;

import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class UI {
	public Book book;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI window = new UI();
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
	public UI() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(){
		book=new Book();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addWindowListener(new java.awt.event.WindowAdapter(){
			
			public void windowClosing(java.awt.event.WindowEvent e) {
				
			book.save();
				
				
			}
			
		});
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(126, 92, 45, 13);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(184, 89, 96, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Data");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel_1.setBounds(126, 10, 154, 57);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(184, 132, 96, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Phone #");
		lblNewLabel_2.setBounds(126, 135, 45, 13);
		panel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(184, 179, 96, 19);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setBounds(126, 182, 45, 13);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=textField.getText();
				String number=textField_1.getText();
				String email=textField_2.getText();
				if (validate()) {
					
				JOptionPane.showMessageDialog(null,"error invlid input pleaase change","error",0);
					return;
				}
				book.addContact(new Contact(name,number,email));
				
				
			}
		});
		btnNewButton.setBounds(181, 218, 85, 21);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Show All");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().remove(panel);
				JPanel allpanel= new JPanel();
				JList<String> list= new JList<>();
				ArrayList<String> arr=book.getallstr();
				list.setListData(arr.toArray(new String[0]));
				
				JScrollPane Spanel=new JScrollPane(list);
				allpanel.add(Spanel);
				frame.getContentPane().add(allpanel);
				
				frame.revalidate();
				frame.repaint();
				
				
			}
		});
		btnNewButton_1.setBounds(323, 218, 85, 21);
		
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Seacrh/edit/del");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				frame.getContentPane().remove(panel);
				JPanel editpanel= new JPanel();
				frame.getContentPane().add(editpanel);
				editpanel.setLayout(null);
				
				textField_3 = new JTextField();
				textField_3.setBounds(168, 59, 96, 19);
				editpanel.add(textField_3);
				textField_3.setColumns(10);
				
				JLabel lblNewLabel_4 = new JLabel("Name");
				lblNewLabel_4.setBounds(91, 53, 45, 30);
				editpanel.add(lblNewLabel_4);
				
				textField_4 = new JTextField();
				textField_4.setBounds(168, 90, 96, 19);
				editpanel.add(textField_4);
				textField_4.setColumns(10);
				
				textField_5 = new JTextField();
				textField_5.setBounds(168, 134, 96, 19);
				editpanel.add(textField_5);
				textField_5.setColumns(10);
				
				JLabel lblNewLabel_5 = new JLabel("Phone Numner");
				lblNewLabel_5.setBounds(56, 93, 80, 13);
				editpanel.add(lblNewLabel_5);
				
				JLabel lblNewLabel_6 = new JLabel("Email");
				lblNewLabel_6.setBounds(91, 137, 45, 13);
				editpanel.add(lblNewLabel_6);
				
				JButton btnNewButton_3 = new JButton("Search");
				
				btnNewButton_3.setBounds(179, 197, 85, 21);
				btnNewButton_3.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e){
						Contact person=book.findcontact(textField_3.getText());
						if(person.name!=null) {
							JOptionPane.showMessageDialog(null, "Name: "+person.name+"phone: "+person.number+"email: "+person.email,"result",1);
							
							
						}else {
							JOptionPane.showMessageDialog(null,"Error couldnt find the person","result",0);
	
						}
				}});
				editpanel.add(btnNewButton_3);
				
				JButton btnNewButton_4 = new JButton("Edit Phone &Email");
				btnNewButton_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String name=textField_3.getText();
						String phone=textField_4.getText();
						String email=textField_5.getText();
						if(validate2()) {
							JOptionPane.showMessageDialog(null,"please nter valid info","message",0);
							
							
						}
						book.rmContact(name);

						book.addContact(new Contact(name,phone,email));
						JOptionPane.showMessageDialog(null,"successfly update","result",1);

						
						
						
						
					}
				});
				btnNewButton_4.setBounds(10, 197, 126, 21);
				editpanel.add(btnNewButton_4);
				
				JButton btnNewButton_5 = new JButton("Delete ");
				btnNewButton_5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(book.rmContact(textField_3.getText())) {
							JOptionPane.showMessageDialog(null, "Success","result",1);
							
							
						}else {
							JOptionPane.showMessageDialog(null, "Couldnt find matching record","result",0);

							
						}
						
						
					}
				});
				btnNewButton_5.setBounds(311, 197, 85, 21);
				editpanel.add(btnNewButton_5);
				
				JLabel lblNewLabel_7 = new JLabel("Search,Delete & Update");
				lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 24));
				lblNewLabel_7.setBounds(91, 10, 261, 39);
				editpanel.add(lblNewLabel_7);
				frame.revalidate();
				frame.repaint();
			
			
			}
		});
		btnNewButton_2.setBounds(31, 218, 85, 21);
		panel.add(btnNewButton_2);
		    
		frame.revalidate();
		frame.repaint();
		
		
		
	}
	public Boolean validate() {
		Pattern nameregex=Pattern.compile("^[a-zA-Z]{1,} [a-zA-Z]{1,}$");
		Pattern numberregex=Pattern.compile("^[0-9]{11}$");
		Pattern emailregex=Pattern.compile("^[a-zA-Z0-9]{1,}@[A-Za-z]{1,}.[A-Za-z]{1,}");
		String name=textField.getText();
		String number=textField_1.getText();
		String email=textField_2.getText();
		Matcher numbermatcher=numberregex.matcher(number);
		Matcher namematcher=nameregex.matcher(name);
		Matcher emailmatcher=emailregex.matcher(email);
		return (!(emailmatcher.find()&&namematcher.find()&&numbermatcher.find()));
	}
	public Boolean validate2() {
		Pattern nameregex=Pattern.compile("^[a-zA-Z]{1,} [a-zA-Z]{1,}$");
		Pattern numberregex=Pattern.compile("^[0-9]{11}$");
		Pattern emailregex=Pattern.compile("^[a-zA-Z0-9]{1,}@[A-Za-z]{1,}.[A-Za-z]{1,}");
		String name=textField_3.getText();
		String number=textField_4.getText();
		String email=textField_5.getText();
		Matcher numbermatcher=numberregex.matcher(number);
		Matcher namematcher=nameregex.matcher(name);
		Matcher emailmatcher=emailregex.matcher(email);
		return (!(emailmatcher.find()&&namematcher.find()&&numbermatcher.find()));
	}
	
}
