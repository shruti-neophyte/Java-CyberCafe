package yes;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class comp extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					comp frame = new comp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public comp() throws Exception{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\logo.png"));
		setTitle("Add Computer");
		setBounds(400, 150, 566, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblComputerNo = new JLabel("Computer No");
		lblComputerNo.setFont(new Font("Serif", Font.PLAIN, 20));
		lblComputerNo.setBounds(77, 88, 106, 27);
		contentPane.add(lblComputerNo);
		
		JLabel lblCompany = new JLabel("Company");
		lblCompany.setFont(new Font("Serif", Font.PLAIN, 20));
		lblCompany.setBounds(29, 167, 74, 27);
		contentPane.add(lblCompany);
		
		JLabel lblIpAddress = new JLabel("IP Address");
		lblIpAddress.setFont(new Font("Serif", Font.PLAIN, 20));
		lblIpAddress.setBounds(29, 246, 88, 27);
		contentPane.add(lblIpAddress);
		
		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t1.setColumns(12);
		t1.setBounds(206, 86, 54, 31);
		contentPane.add(t1);
		
		t2 = new JTextField();
		t2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t2.setColumns(12);
		t2.setBounds(161, 165, 167, 31);
		contentPane.add(t2);
		
		t3 = new JTextField();
		t3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t3.setColumns(12);
		t3.setBounds(161, 244, 167, 31);
		contentPane.add(t3);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t=t1.getText();
				int y=Integer.parseInt(t);
				String d=t2.getText();
				String s=t3.getText();
				Connection conn = null;
				PreparedStatement ps = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", "root", "root");
					String sql = "INSERT INTO pcs (computer_no,company,ip_address) VALUES (?,?,?)";
					ps = conn.prepareStatement(sql);

					ps.setInt(1,y);
					ps.setString(2, d);
					ps.setString(3, s);
					int i = ps.executeUpdate();
					if (i == 1) {
						JOptionPane.showMessageDialog(null, "Computer Added Successfully");

					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);

				}
				
			}
		});
		btnAdd.setForeground(Color.BLACK);
		btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnAdd.setBackground(new Color(64, 224, 208));
		btnAdd.setBounds(77, 325, 74, 31);
		contentPane.add(btnAdd);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnBack.setBackground(new Color(64, 224, 208));
		btnBack.setBounds(220, 325, 80, 31);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\mem.png"));
		label.setBounds(161, 331, 17, 17);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\three.gif"));
		label_1.setBounds(311, 331, 17, 17);
		contentPane.add(label_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\monitor-add.png"));
		lblNewLabel.setBounds(379, 126, 128, 128);
		contentPane.add(lblNewLabel);
	}
}
