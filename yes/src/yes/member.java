package yes;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;
import javax.swing.*;

import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.Color;

public class member extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JLabel lblName;
	private JTextField t2;
	private JLabel lblAge;
	private JTextField t3;
	private JLabel lblGender;
	private JLabel lblAddress;
	private JTextField t5;
	private JTextField t6;
	private JLabel label;
	private JLabel label_1;
	private JLabel lblAddMember;
	private JLabel lblDateOfJoining;
	private JLabel l1;
	private JLabel label_2;
	private JLabel ph;
	private JLabel lblAddPhoto;
	private JButton btnBrowse;
	private JButton btnSave;
	private JButton btnBack;
	private JButton btnReset;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					member frame = new member();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void date() {
		Calendar cr = new GregorianCalendar();
		int day = cr.get(Calendar.DAY_OF_MONTH);
		int month = cr.get(Calendar.MONTH) + 1;
		int yr = cr.get(Calendar.YEAR);
		l1.setText(day + " / " + month + " / " + yr);

	}

	/**
	 * Create the frame.
	 */
	public member() {
		setTitle("Empolyee Details");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 0, 740, 680);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Employee ID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(54, 106, 131, 32);
		contentPane.add(lblNewLabel);

		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t1.setBounds(184, 108, 182, 29);
		contentPane.add(t1);
		t1.setColumns(10);

		lblName = new JLabel("Name");
		lblName.setFont(new Font("Serif", Font.PLAIN, 20));
		lblName.setBounds(94, 176, 61, 32);
		contentPane.add(lblName);

		t2 = new JTextField();
		t2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t2.setBounds(184, 177, 182, 31);
		contentPane.add(t2);
		t2.setColumns(12);

		lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Serif", Font.PLAIN, 20));
		lblAge.setBounds(78, 230, 36, 44);
		contentPane.add(lblAge);

		t3 = new JTextField();
		t3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t3.setBounds(124, 237, 50, 31);
		contentPane.add(t3);
		t3.setColumns(12);

		lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Serif", Font.PLAIN, 20));
		lblGender.setBounds(196, 240, 78, 24);
		contentPane.add(lblGender);

		final JComboBox c1 = new JComboBox();
		c1.setBackground(new Color(220, 220, 220));
		c1.setFont(new Font("Serif", Font.PLAIN, 20));
		c1.setBounds(295, 237, 91, 31);
		c1.addItem("Female");
		c1.addItem("Male");
		getContentPane().add(c1);

		lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Serif", Font.PLAIN, 20));
		lblAddress.setBounds(58, 303, 78, 44);
		contentPane.add(lblAddress);

		final JTextPane t4 = new JTextPane();
		t4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		t4.setBounds(145, 303, 241, 111);
		contentPane.add(t4);

		JLabel lblMobileNo = new JLabel("Mobile No");
		lblMobileNo.setFont(new Font("Serif", Font.PLAIN, 20));
		lblMobileNo.setBounds(59, 443, 96, 32);
		contentPane.add(lblMobileNo);

		t5 = new JTextField();
		t5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t5.setBounds(174, 444, 167, 31);
		contentPane.add(t5);
		t5.setColumns(12);

		JLabel lblEmailId = new JLabel("Email ID");
		lblEmailId.setFont(new Font("Serif", Font.PLAIN, 20));
		lblEmailId.setBounds(64, 506, 91, 32);
		contentPane.add(lblEmailId);

		t6 = new JTextField();
		t6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t6.setBounds(174, 507, 167, 31);
		contentPane.add(t6);
		t6.setColumns(12);

		label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\bg2.jpg"));
		label.setBounds(45, 95, 358, 60);
		contentPane.add(label);

		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\bg2.jpg"));
		label_1.setBounds(47, 166, 356, 405);
		contentPane.add(label_1);

		lblAddMember = new JLabel("Add Employee\r\n");
		lblAddMember.setFont(new Font("Century Gothic", Font.PLAIN, 23));
		lblAddMember.setBounds(285, 22, 169, 30);
		contentPane.add(lblAddMember);

		lblDateOfJoining = new JLabel("Date Of Joining");
		lblDateOfJoining.setFont(new Font("Serif", Font.PLAIN,20));
		lblDateOfJoining.setBounds(78, 582, 139, 29);
		contentPane.add(lblDateOfJoining);

		l1 = new JLabel("");
		l1.setFont(new Font("Serif", Font.PLAIN, 20));
		l1.setBounds(231, 584, 155, 25);
		contentPane.add(l1);

		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\bg2.jpg"));
		label_2.setBounds(45, 582, 358, 32);
		contentPane.add(label_2);

		ph = new JLabel("");
		ph.setBounds(441, 157, 248, 231);
		contentPane.add(ph);

		lblAddPhoto = new JLabel("Add Photo");
		lblAddPhoto.setFont(new Font("Times New Roman",

				Font.PLAIN, 22));
		lblAddPhoto.setBounds(524, 106, 102, 32);
		contentPane.add(lblAddPhoto);

		btnBrowse = new JButton("Browse");
		btnBrowse.setBackground(new Color(220, 220, 220));
		btnBrowse.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new

				JFileChooser();
				fileChooser.setCurrentDirectory(new

				File(System.getProperty("user.home")));
				fileChooser.showOpenDialog(null);

			}
		});
		btnBrowse.setBounds(524, 410, 114, 32);
		contentPane.add(btnBrowse);

		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a = t1.getText();
				int mid = Integer.parseInt(a);
				String name = t2.getText();
				String ab = t3.getText();
				int age = Integer.parseInt(ab);
				String gender = (String) c1.getSelectedItem();
				String add = t4.getText();
				String mno = t5.getText();
				int mn = Integer.parseInt(mno);
				String email = t6.getText();
				String dof = l1.getText();
				Connection con = null;
				PreparedStatement ps = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", "root", "root");
					String sql = "INSERT INTO member (member_id,name,age,gender,address,mobile_no,email,doj) VALUES (?,?,?,?,?,?,?,?);";
					ps = con.prepareStatement(sql);
					ps.setInt(1, mid);
					ps.setString(2, name);
					ps.setInt(3, age);
					ps.setString(4, gender);
					ps.setString(5, add);
					ps.setFloat(6, mn);
					ps.setString(7, email);
					ps.setString(8, dof);
					int i = ps.executeUpdate();
					if (i == 1)
						JOptionPane.showMessageDialog(null, "record inserted");

				} catch (Exception e1) {

					JOptionPane.showMessageDialog(null, e1);
				}

			}

		});
		btnSave.setForeground(Color.BLACK);
		btnSave.setBackground(new Color(72, 209, 204));
		btnSave.setFont(new Font("Times New Roman",

				Font.PLAIN, 20));
		btnSave.setBounds(474, 478, 196, 32);
		contentPane.add(btnSave);

		btnBack = new JButton("Cancel");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose(); 
			}
		});
		btnBack.setBackground(new Color(72, 209, 204));
		btnBack.setFont(new Font("Times New Roman",

				Font.PLAIN, 20));
		btnBack.setBounds(537, 599, 89, 33);
		contentPane.add(btnBack);

		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t2.setText("");
				t1.setText("");

				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
			}
		});
		btnReset.setForeground(Color.BLACK);
		btnReset.setBackground(new Color(72, 209, 204));
		btnReset.setFont(new Font("Times New Roman",

				Font.PLAIN, 20));
		btnReset.setBounds(474, 538, 196, 32);
		contentPane.add(btnReset);

		label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\mem.png"));
		label_3.setBounds(680, 478, 25, 32);
		contentPane.add(label_3);

		label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\three.gif"));
		label_4.setBounds(680, 538, 25, 37);
		contentPane.add(label_4);

		label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\three.png"));
		label_5.setBounds(636, 599, 25, 26);
		contentPane.add(label_5);
		date();
	}
}