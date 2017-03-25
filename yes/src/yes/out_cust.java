package yes;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class out_cust extends JFrame {

	private JPanel contentPane;
	JLabel t1,d1;
	private JTextField t3;
	private JTextField t4;
	public JLabel t2;
	JSpinner s2;
	String total = "";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					out_cust frame = new out_cust();
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
		t1.setText(dateFormat.format(cr.getTime()));
	}

	public out_cust() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\logo.png"));
		setTitle("Logout");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 0, 720, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblExitCustomer = new JLabel("Logout Customer");
		lblExitCustomer.setFont(new Font("Century Gothic", Font.PLAIN, 26));
		lblExitCustomer.setBounds(256, 37, 216, 33);
		contentPane.add(lblExitCustomer);

		JLabel lblLogoutTime = new JLabel("LogOut Time");
		lblLogoutTime.setFont(new Font("Serif", Font.PLAIN, 20));
		lblLogoutTime.setBounds(166, 101, 104, 27);
		contentPane.add(lblLogoutTime);

		t1 = new JLabel("");
		t1.setFont(new Font("Serif", Font.PLAIN, 20));
		t1.setBounds(304, 101, 108, 27);
		contentPane.add(t1);
		time();

		JLabel lblLoginTime = new JLabel("LogIn Time");
		lblLoginTime.setFont(new Font("Serif", Font.PLAIN, 20));
		lblLoginTime.setBounds(166, 162, 91, 27);
		contentPane.add(lblLoginTime);

		t2 = new JLabel("");
		t2.setFont(new Font("Serif", Font.PLAIN, 20));
		t2.setBounds(304, 162, 108, 27);
		contentPane.add(t2);

		JLabel label = new JLabel("Computer No");
		label.setFont(new Font("Serif", Font.PLAIN, 20));
		label.setBounds(166, 221, 113, 29);
		contentPane.add(label);

		s2 = new JSpinner();
		s2.setEnabled(false);
		s2.setFont(new Font("Serif", Font.BOLD, 22));
		s2.setBounds(304, 219, 50, 31);
		contentPane.add(s2);

		JLabel lblNewLabel = new JLabel("Job Done");
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		lblNewLabel.setBounds(166, 280, 75, 27);
		contentPane.add(lblNewLabel);

		t3 = new JTextField();
		t3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t3.setColumns(12);
		t3.setBounds(304, 278, 136, 31);
		contentPane.add(t3);

		JLabel lblTotalAmount = new JLabel("Total Amount");
		lblTotalAmount.setFont(new Font("Serif", Font.PLAIN, 20));
		lblTotalAmount.setBounds(152, 335, 108, 27);
		contentPane.add(lblTotalAmount);

		t4 = new JTextField();
		t4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t4.setColumns(12);
		t4.setBounds(304, 333, 136, 31);
		contentPane.add(t4);

		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String r = t1.getText();
				String y = t2.getText();

				SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss a");
				try {
					Date d1 = dateFormat.parse(r);
					Date d2 = dateFormat.parse(y);
					long dif = d1.getTime() - d2.getTime();
					long dif2 = dif / 1000;
					long sec = dif2 % 60;
					String h = String.valueOf(sec);
					int p = Integer.parseInt(h);
					JOptionPane.showMessageDialog(null, r + "  " + y + "  Difference=  " + sec + " seconds");
					if (p <= 30) {
						total = "36";
					} else if (p <= 60) {
						total = "70";
					} else if (p <= 120) {
						total = "130";
					}
					t4.setText("Rs " + total);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(e);
				}

				/*
				 * try { String t = ""; String u = ""; Connection con = null;
				 * Connection con2 = null; java.sql.Statement start = null;
				 * java.sql.Statement start2 = null; PreparedStatement ps =
				 * null; Class.forName("com.mysql.jdbc.Driver"); con =
				 * DriverManager.getConnection(
				 * "jdbc:mysql://localhost:3306/cafe", "root", "root"); con2 =
				 * DriverManager.getConnection(
				 * "jdbc:mysql://localhost:3306/cafe", "root", "root"); start =
				 * con.createStatement(); start2 = con2.createStatement();
				 * String sql =
				 * "select logout from out_cust where computer_allot=1"; String
				 * sql2 = "select login from out_cust where computer_allot=1";
				 * 
				 * ResultSet rs = start.executeQuery(sql); while (rs.next()) { t
				 * = rs.getString(1); JOptionPane.showMessageDialog(null, t);
				 * 
				 * } ResultSet rs2 = start2.executeQuery(sql2); while
				 * (rs2.next()) { u = rs.getString(2);
				 * JOptionPane.showMessageDialog(null, u); }
				 * 
				 * String sql3 =
				 * "SELECT TIMESTAMPDIFF(SECOND, '2010-11-29'+?, '2010-11-29'+?) from out_cust"
				 * ; ps = con.prepareStatement(sql); ps.setString(1,t);
				 * ps.setString(2,u); t4.setText(sql3); } catch (Exception e) {
				 * e.printStackTrace(); System.out.println(e);
				 * JOptionPane.showMessageDialog(null, e); }
				 */
			
			}
		});
		/*
		 * Connection con=null; PreparedStatement ps=null; try {
		 * Class.forName("com.mysql.jdbc.Driver");
		 * con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe",
		 * "root","root"); String sql=
		 * "SELECT TIMESTAMPDIFF(SECOND, '2010-11-29 ?', '2010-11-29 ?')"; ps =
		 * con.prepareStatement(sql); ps.set int i= ps.executeUpdate();
		 * if(i==1)JOptionPane.showMessageDialog(null, "record inserted");
		 * 
		 * } catch(Exception e) {
		 * 
		 * JOptionPane.showMessageDialog(null, e); }
		 * 
		 */

		btnCalculate.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnCalculate.setBackground(new Color(72, 209, 204));
		btnCalculate.setBounds(461, 333, 131, 32);
		contentPane.add(btnCalculate);

		JButton button = new JButton("Save");
		button.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent e) {
		String out = t1.getText();
		String work = t3.getText();
		String to = total;
		int t = (int) s2.getValue();
		// int tot = Integer.parseInt(to);
		String x = t2.getText();
		String dat=d1.getText();
		Connection conn = null;
		PreparedStatement ps = null;
		Connection conn2 = null;
		PreparedStatement ps2 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", "root", "root");
			String sql = "INSERT INTO out_cust (logout,date,login,computer_allot,jobdone,total_amt) VALUES (?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);

			Class.forName("com.mysql.jdbc.Driver");
			conn2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", "root", "root");
			String sql2 = "delete from in_cust where computer_allot=?";
			ps2 = conn2.prepareStatement(sql2);
			ps2.setInt(1, t);
			
			ps.setString(1, out);
			ps.setString(2, dat);
			ps.setString(3, x);
			ps.setInt(4, t);
			ps.setString(5, work);
			ps.setString(6, to);

			int i = ps.executeUpdate();
			int i2 = ps2.executeUpdate();
			int o = (int) s2.getValue();
			if (i == 1 && o == 1) {
				JOptionPane.showMessageDialog(null, "Logout Details Added Successfully");
				dispose();
				computers e1 = new computers();
				e1.show();
				e1.ab.setIcon(new ImageIcon(""));
			} else {
				if (i == 1 && o == 2) {
					JOptionPane.showMessageDialog(null, "Logout Details Added Successfully");
					dispose();
					computers e1 = new computers();
					e1.show();
					e1.cd.setIcon(new ImageIcon(""));
				}
			}
			if (i2 == 1) {
				JOptionPane.showMessageDialog(null, "Deleted Successfully");

			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1);

		}
		
	}});

	button.setFont(new Font("Times New Roman",Font.PLAIN,19));button.setBackground(new Color(72,209,204));button.setBounds(223,412,131,32);contentPane.add(button);

	JLabel label_1 = new JLabel(
			"");label_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\mem.png"));label_1.setBounds(364,423,17,17);contentPane.add(label_1);
JLabel lblLoginDate = new JLabel("LogIn Date");
lblLoginDate.setFont(new Font("Serif", Font.PLAIN, 20));
lblLoginDate.setBounds(443, 162, 91, 27);
contentPane.add(lblLoginDate);
d1 = new JLabel("");
d1.setFont(new Font("Serif", Font.PLAIN, 20));
d1.setBounds(554, 162, 104, 27);
contentPane.add(d1);
}	
}
