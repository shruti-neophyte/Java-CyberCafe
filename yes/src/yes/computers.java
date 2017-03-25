package yes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

public class computers extends JFrame {

	private JPanel contentPane;
	public JLabel ab, cd;
	String r4 = "";
	String r5 = "";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					computers frame = new computers();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public computers() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\logo.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Connections");
		setBounds(50, 45, 1280, 680);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\conn.jpg"));
		label.setBounds(74, 86, 94, 92);
		contentPane.add(label);

		JLabel lblC = new JLabel("C-1");
		lblC.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblC.setBounds(103, 55, 28, 23);
		contentPane.add(lblC);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\conn.jpg"));
		label_1.setBounds(310, 86, 94, 92);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\conn.jpg"));
		label_2.setBounds(565, 86, 94, 92);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\conn.jpg"));
		label_3.setBounds(836, 86, 94, 92);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\conn.jpg"));
		label_4.setBounds(1091, 86, 94, 92);
		contentPane.add(label_4);

		JLabel lblC_1 = new JLabel("C-2");
		lblC_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblC_1.setBounds(338, 55, 28, 23);
		contentPane.add(lblC_1);

		JLabel lblC_2 = new JLabel("C-3");
		lblC_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblC_2.setBounds(598, 55, 28, 23);
		contentPane.add(lblC_2);

		JLabel lblC_3 = new JLabel("C-4");
		lblC_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblC_3.setBounds(868, 55, 28, 23);
		contentPane.add(lblC_3);

		JLabel lblC_4 = new JLabel("C-5");
		lblC_4.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblC_4.setBounds(1122, 55, 28, 23);
		contentPane.add(lblC_4);

		JButton btnNewButton = new JButton("IN");
		btnNewButton.setBackground(new Color(144, 238, 144));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				in_cust obj = new in_cust();
				obj.show();
				obj.s1.setValue(1);
				hide();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(61, 201, 54, 34);
		contentPane.add(btnNewButton);

		JButton btnOut = new JButton("OUT");
		btnOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				String t = "";
				Connection con = null;
				java.sql.Statement start = null;
				Connection con2 = null;
				java.sql.Statement start2 = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", "root", "root");
					start = con.createStatement();
					String sql = "select login_time from in_cust where computer_allot=1";
					ResultSet rs = start.executeQuery(sql);
					while (rs.next()) {
						t = rs.getString(1);
					}
				}

				catch (Exception e1) {
					System.out.println(e1);
				}
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", "root", "root");
					start2 = con2.createStatement();
					String sql2 = "select date from in_cust where computer_allot=1";
					ResultSet rs2 = start2.executeQuery(sql2);
					while (rs2.next()) {
						r4 = rs2.getString(1);
						
					}
				}

				catch (Exception e2) {
					System.out.println(e2);
				}
				out_cust o = new out_cust();
				o.show();
				o.s2.setValue(1);
				o.t2.setText(t);
				o.d1.setText(r4);
			}

		});
		btnOut.setBackground(new Color(255, 99, 71));
		btnOut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOut.setBounds(125, 201, 67, 34);
		contentPane.add(btnOut);

		JButton button = new JButton("IN");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				in_cust obj = new in_cust();
				obj.show();
				obj.s1.setValue(2);
				hide();
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBackground(new Color(144, 238, 144));
		button.setBounds(296, 201, 54, 34);
		contentPane.add(button);

		JButton button_1 = new JButton("OUT");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				String t = "";
				Connection con = null;
				java.sql.Statement start = null;
				Connection con2 = null;
				java.sql.Statement start2 = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", "root", "root");
					start = con.createStatement();
					String sql = "select login_time from in_cust where computer_allot=2";
					ResultSet rs = start.executeQuery(sql);
					while (rs.next()) {
						t = rs.getString(1);
					}
				} catch (Exception e1) {
					System.out.println(e1);
				}
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", "root", "root");
					start2 = con2.createStatement();
					String sql2 = "select date from in_cust where computer_allot=2";
					ResultSet rs2 = start2.executeQuery(sql2);
					while (rs2.next()) {
						r5 = rs2.getString(1);
						
					}
				}

				catch (Exception e2) {
					System.out.println(e2);
				}
				out_cust o = new out_cust();
				o.show();
				o.s2.setValue(2);
				o.t2.setText(t);
				o.d1.setText(r5);
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_1.setBackground(new Color(255, 99, 71));
		button_1.setBounds(360, 201, 67, 34);
		contentPane.add(button_1);

		ab = new JLabel("");
		ab.setBounds(61, 46, 131, 144);
		contentPane.add(ab);

		cd = new JLabel("");
		cd.setBounds(296, 46, 131, 144);
		contentPane.add(cd);

	}
}
