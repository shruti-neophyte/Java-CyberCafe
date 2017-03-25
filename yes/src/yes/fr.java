package yes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class fr extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fr frame = new fr();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public fr() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 35, 1280, 680);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\two.jpg"));
		label.setBounds(0, 0, 168, 163);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\one.png"));
		label_1.setBounds(505, 11, 294, 131);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\cicon.gif"));
		label_2.setBounds(119, 208, 125, 104);
		contentPane.add(label_2);
		
		JButton btnViewTerminals = new JButton("Add Connection");
		btnViewTerminals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				computers o=new computers();
				o.show();
			}
		});
		btnViewTerminals.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnViewTerminals.setBackground(new Color(153, 204, 204));
		btnViewTerminals.setBounds(105, 333, 171, 29);
		contentPane.add(btnViewTerminals);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\memb.jpg"));
		label_3.setBounds(431, 208, 119, 104);
		contentPane.add(label_3);
		
		JButton btnNewButton = new JButton("Add Employee");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				member o=new member();
						o.show();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBackground(new Color(153, 204, 204));
		btnNewButton.setBounds(399, 333, 171, 29);
		contentPane.add(btnNewButton);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\customer.jpg"));
		label_4.setBounds(716, 219, 187, 93);
		contentPane.add(label_4);
		
		JButton btnCustomerDetails = new JButton("Customer Details");
		btnCustomerDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				in_cust_show_table o=new in_cust_show_table();
				o.show();
				
				
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			
				
			}
		});
		btnCustomerDetails.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCustomerDetails.setBackground(new Color(153, 204, 204));
		btnCustomerDetails.setBounds(732, 333, 171, 29);
		contentPane.add(btnCustomerDetails);
		
		JLabel label_7 = new JLabel("");
		label_7.setBounds(269, 559, 46, 14);
		contentPane.add(label_7);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\edit.png"));
		label_6.setBounds(581, 436, 125, 104);
		contentPane.add(label_6);
		
		JButton btnEditMember = new JButton("Edit Employee");
		btnEditMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emember o;
				try {
					o = new emember();
					o.show();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnEditMember.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEditMember.setBackground(new Color(153, 204, 204));
		btnEditMember.setBounds(563, 569, 171, 29);
		contentPane.add(btnEditMember);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\add-computer-icon.png"));
		label_8.setBounds(1043, 206, 128, 128);
		contentPane.add(label_8);
		
		JButton btnAddNewComputer = new JButton("Add New Computer");
		btnAddNewComputer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comp u;
				try {
					u = new comp();u.show();
				} catch (Exception e) {
			
					e.printStackTrace();
				}
				
			}
		});
		btnAddNewComputer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddNewComputer.setBackground(new Color(153, 204, 204));
		btnAddNewComputer.setBounds(1034, 333, 179, 29);
		contentPane.add(btnAddNewComputer);
	}
}
