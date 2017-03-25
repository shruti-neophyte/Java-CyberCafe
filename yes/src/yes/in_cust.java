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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

public class in_cust extends JFrame {

	private JPanel contentPane;
	private JTextField t3;
	private JTextField t5;
	private JTextField t4;
	public JLabel t1, t2;
	public JSpinner s1;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					in_cust frame = new in_cust();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void time() {
		Calendar cr = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss a");
		t2.setText(dateFormat.format(cr.getTime()));
	}

	public void date() {
		Calendar cr2 = new GregorianCalendar();
		int day = cr2.get(Calendar.DAY_OF_MONTH);
		int month = cr2.get(Calendar.MONTH) + 1;
		int yr = cr2.get(Calendar.YEAR);
		t1.setText(day + " / " + month + " / " + yr);
	}

	/*
	 * public void date() { Calendar cr = Calendar.getInstance();
	 * SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
	 * t1.setText(dateFormat.format(cr.getTime())); }
	 */

	public in_cust() {
		computers e = new computers();
		e.ab.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\green.jpg"));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\logo.png"));

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 0, 740, 730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAddCustomer = new JLabel("Add Customer");
		lblAddCustomer.setFont(new Font("Century Gothic", Font.PLAIN, 23));
		lblAddCustomer.setBounds(285, 22, 167, 44);
		contentPane.add(lblAddCustomer);

		JLabel label = new JLabel("Name");
		label.setFont(new Font("Serif", Font.PLAIN, 20));
		label.setBounds(209, 187, 61, 32);
		contentPane.add(label);

		t3 = new JTextField();
		t3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t3.setColumns(12);
		t3.setBounds(285, 188, 182, 31);
		contentPane.add(t3);

		JLabel label_3 = new JLabel("Address");
		label_3.setFont(new Font("Serif", Font.PLAIN, 20));
		label_3.setBounds(209, 316, 78, 44);
		contentPane.add(label_3);

		final JTextPane t6 = new JTextPane();
		t6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		t6.setBounds(303, 313, 241, 111);
		contentPane.add(t6);

		JLabel lblContactNo = new JLabel("Contact No");
		lblContactNo.setFont(new Font("Serif", Font.PLAIN, 20));
		lblContactNo.setBounds(320, 250, 96, 32);
		contentPane.add(lblContactNo);

		t5 = new JTextField();
		t5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t5.setColumns(14);
		t5.setBounds(419, 251, 167, 31);
		contentPane.add(t5);

		JLabel lblCurrentDate = new JLabel(" Date");
		lblCurrentDate.setFont(new Font("Serif", Font.PLAIN, 20));
		lblCurrentDate.setBounds(428, 100, 50, 29);
		contentPane.add(lblCurrentDate);

		JLabel lblComputerNo = new JLabel("Computer No");
		lblComputerNo.setFont(new Font("Serif", Font.PLAIN, 20));
		lblComputerNo.setBounds(294, 556, 113, 29);
		contentPane.add(lblComputerNo);

		JLabel lblLoginTime = new JLabel("Login Time");
		lblLoginTime.setFont(new Font("Serif", Font.PLAIN, 20));
		lblLoginTime.setBounds(209, 101, 91, 27);
		contentPane.add(lblLoginTime);

		JLabel label_1 = new JLabel("Age");
		label_1.setFont(new Font("Serif", Font.PLAIN, 20));
		label_1.setBounds(215, 244, 36, 44);
		contentPane.add(label_1);

		t4 = new JTextField();
		t4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t4.setColumns(12);
		t4.setBounds(260, 251, 50, 31);
		contentPane.add(t4);

		JLabel lblAddressProofType = new JLabel("Address Proof Type");
		lblAddressProofType.setFont(new Font("Serif", Font.PLAIN, 20));
		lblAddressProofType.setBounds(194, 440, 160, 27);
		contentPane.add(lblAddressProofType);

		final JComboBox c5 = new JComboBox();
		c5.setBackground(new Color(230, 230, 250));
		c5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		c5.setModel(new DefaultComboBoxModel(
				new String[] { "Driving License", "Voter ID", "Aadhar Card", "Pan Card", "Passport", "Student ID" }));
		c5.setBounds(397, 442, 135, 25);
		contentPane.add(c5);

		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\bg2.jpg"));
		label_7.setBounds(150, 163, 456, 369);
		contentPane.add(label_7);

		t1 = new JLabel("");
		t1.setFont(new Font("Serif", Font.PLAIN, 20));
		t1.setBounds(476, 101, 104, 27);
		contentPane.add(t1);
		date();

		t2 = new JLabel("");
		t2.setFont(new Font("Serif", Font.PLAIN, 20));
		t2.setBounds(318, 102, 105, 27);
		contentPane.add(t2);
		time();

		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\bg2.jpg"));
		label_4.setBounds(148, 91, 456, 44);
		contentPane.add(label_4);

		s1 = new JSpinner();
		s1.setEnabled(false);
		s1.setFont(new Font("Serif", Font.BOLD, 22));
		s1.setModel(new SpinnerNumberModel(0, 0, 5, 1));
		s1.setBounds(417, 555, 50, 31);
		contentPane.add(s1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\bg2.jpg"));
		lblNewLabel.setBounds(150, 548, 456, 51);
		contentPane.add(lblNewLabel);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = t2.getText();
				String r = t1.getText();
				String name = t3.getText();
				String f = t4.getText();
				int age = Integer.parseInt(f);
				String add = t4.getText();
				String mno = t5.getText();
				// int mn = Integer.parseInt(mno);
				String addr = t6.getText();
				String t = (String) c5.getSelectedItem();
				int t5 = (int) s1.getValue();

				Connection conn = null;
				PreparedStatement ps = null;
				Connection conn2 = null;
				PreparedStatement ps2 = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", "root", "root");
					String sql = "INSERT INTO in_cust (login_time,date,name,age,contact_no,address,adddress_proof,computer_allot) VALUES (?,?,?,?,?,?,?,?)";
					ps = conn.prepareStatement(sql);
					Class.forName("com.mysql.jdbc.Driver");
					conn2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", "root", "root");
					String sql1 = "INSERT INTO in_cust_show (login_time,date,name,age,contact_no,address,adddress_proof,computer_allot) VALUES (?,?,?,?,?,?,?,?)";
					ps2 = conn.prepareStatement(sql1);
					ps.setString(1, s);
					ps.setString(2, r);
					ps.setString(3, name);
					ps.setInt(4, age);
					ps.setString(5, mno);
					ps.setString(6, addr);
					ps.setString(7, t);
					ps.setInt(8, t5);
					ps2.setString(1, s);
					ps2.setString(2, r);
					ps2.setString(3, name);
					ps2.setInt(4, age);
					ps2.setString(5, mno);
					ps2.setString(6, addr);
					ps2.setString(7, t);
					ps2.setInt(8, t5);
					int i = ps.executeUpdate();
					int i2 = ps2.executeUpdate();
					if (i2 == 1) {
						System.out.println("yes");
					}
					int y = (int) s1.getValue();
					System.out.println(y);
					if (i == 1 && y == 1) {
						System.out.println("in 1");
						JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
						dispose();
						computers e1 = new computers();
						e1.show();
						e1.ab.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\green.jpg"));

					} else {
						if (i == 1 && y == 2) {
							System.out.println("in 2");
							JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
							dispose();
							computers e11 = new computers();
							e11.show();
							e11.cd.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\green.jpg"));
						}
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);

				}

			}
		});

		btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnSave.setBackground(new Color(72, 209, 204));
		btnSave.setBounds(321, 621, 131, 32);
		contentPane.add(btnSave);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				s1.setValue(0);
			}
		});
		btnReset.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnReset.setBackground(new Color(72, 209, 204));
		btnReset.setBounds(86, 621, 131, 32);
		contentPane.add(btnReset);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnCancel.setBackground(new Color(72, 209, 204));
		btnCancel.setBounds(541, 621, 131, 32);
		contentPane.add(btnCancel);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\cust.gif"));
		label_2.setBounds(35, 22, 91, 92);
		contentPane.add(label_2);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\mem.png"));
		lblNewLabel_1.setBounds(462, 627, 17, 17);
		contentPane.add(lblNewLabel_1);

		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\four.png"));
		label_5.setBounds(224, 627, 20, 20);
		contentPane.add(label_5);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\three.png"));
		lblNewLabel_2.setBounds(677, 628, 16, 16);
		contentPane.add(lblNewLabel_2);
	}

}
