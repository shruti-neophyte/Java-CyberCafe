package yes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Color;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class emember extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t4;
	private JTextField t5;
	int id;
	final JComboBox<Integer> c1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					emember frame = new emember();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public emember() throws Exception {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\logo.png"));
		Connection con = null;
		Statement start = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", "root", "root");
			start = con.createStatement();
			String sql = "select * from member";
			rs = start.executeQuery(sql);

		} catch (Exception e) {
			System.out.println(e);
		}
		setTitle("Change Details");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 0, 700, 730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEditMember = new JLabel("Edit Employee\r\n");
		lblEditMember.setFont(new Font("Century Gothic", Font.PLAIN, 23));
		lblEditMember.setBounds(273, 23, 167, 32);
		contentPane.add(lblEditMember);

		JLabel label = new JLabel("Member ID");
		label.setFont(new Font("Times New Roman", Font.BOLD, 22));
		label.setBounds(232, 92, 131, 32);
		contentPane.add(label);

		JLabel label_2 = new JLabel("Name");
		label_2.setFont(new Font("Serif", Font.PLAIN, 20));
		label_2.setBounds(211, 226, 78, 32);
		contentPane.add(label_2);

		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t1.setColumns(12);
		t1.setBounds(310, 227, 182, 31);
		contentPane.add(t1);

		JLabel label_3 = new JLabel("Age");
		label_3.setFont(new Font("Serif", Font.PLAIN, 20));
		label_3.setBounds(222, 305, 36, 44);
		contentPane.add(label_3);

		t2 = new JTextField();
		t2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t2.setColumns(12);
		t2.setBounds(285, 312, 65, 31);
		contentPane.add(t2);

		JLabel label_5 = new JLabel("Address");
		label_5.setFont(new Font("Serif", Font.PLAIN, 20));
		label_5.setBounds(197, 368, 78, 44);
		contentPane.add(label_5);

		final JTextPane t3 = new JTextPane();
		t3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		t3.setBounds(285, 370, 241, 111);
		contentPane.add(t3);

		JLabel label_6 = new JLabel("Mobile No");
		label_6.setFont(new Font("Serif", Font.PLAIN, 20));
		label_6.setBounds(211, 505, 96, 32);
		contentPane.add(label_6);

		t4 = new JTextField();
		t4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t4.setColumns(12);
		t4.setBounds(325, 506, 167, 31);
		contentPane.add(t4);

		JLabel label_7 = new JLabel("Email ID");
		label_7.setFont(new Font("Serif", Font.PLAIN, 20));
		label_7.setBounds(211, 547, 91, 32);
		contentPane.add(label_7);

		t5 = new JTextField();
		t5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t5.setColumns(12);
		t5.setBounds(325, 548, 167, 31);
		contentPane.add(t5);

		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\bg2.jpg"));
		label_8.setBounds(163, 287, 378, 330);
		contentPane.add(label_8);

		JButton btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id =  (int)c1.getSelectedItem();
				String n = t1.getText();
				int a = Integer.parseInt(t2.getText());
				String ad = t3.getText();
				String m = t4.getText();
				int mn = Integer.parseInt(m);
				String e = t5.getText();
				Connection con = null;
				PreparedStatement ps = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", "root", "root");
					String sql = "update member set name=?,age=?,address=?,mobile_no=?,email=? where member_id=?";
					ps = con.prepareStatement(sql);
					ps.setString(1, n);
					ps.setInt(2, a);
					ps.setString(3, m);
					ps.setInt(4, mn);
					ps.setString(5, e);
					ps.setInt(6, id);
					int i = ps.executeUpdate();
					if (i == 1)
						JOptionPane.showMessageDialog(null, "Employee Details Modified Successfully");

				} catch (Exception eu) {
					JOptionPane.showMessageDialog(null, eu);
				}

			}
		});

		btnModify.setForeground(new Color(0, 0, 0));
		btnModify.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnModify.setBackground(new Color(64, 224, 208));
		btnModify.setBounds(130, 628, 196, 32);
		contentPane.add(btnModify);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id =  (int)c1.getSelectedItem();
				Connection con = null;
				PreparedStatement ps = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe","root","root");
					String sql="delete from member where member_id=?";
					ps=con.prepareStatement(sql);
					ps.setInt(1,id);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Deleted");			
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnDelete.setForeground(new Color(0, 0, 0));
		btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnDelete.setBackground(new Color(64, 224, 208));
		btnDelete.setBounds(407, 628, 196, 32);
		contentPane.add(btnDelete);

		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\four.png"));
		label_10.setBounds(330, 628, 20, 24);
		contentPane.add(label_10);

		JLabel label_11 = new JLabel("");
		label_11.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\five.png"));
		label_11.setBounds(613, 628, 24, 24);
		contentPane.add(label_11);

		JButton hit = new JButton("Search");
		hit.setBackground(new Color(72, 209, 204));
		hit.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		hit.setBounds(285, 150, 131, 32);
		contentPane.add(hit);
		hit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 id=(Integer) c1.getSelectedItem();
				 try
		          {
					 Connection con;
					 Statement start=null;
					 ResultSet rs=null;
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe","root","root");
		               start=con.createStatement();
				String sql="select * from member where member_id="+id+"";               
		              rs=start.executeQuery(sql);	
		              while(rs.next())
		              {
		            	  String name=rs.getString(2);
		                    int age=rs.getInt(3);
		                     String addr=rs.getString(5);
		                     int mn=rs.getInt(6);
		                    String em=rs.getString(7);
		                    t1.setText(name);
		                    t2.setText(String.valueOf(age));
		                    t3.setText(addr);
		                    t4.setText(String.valueOf(mn));
		                    t5.setText(em);
		              }
		             

		          }
		          catch(Exception e1)
		          {
					 System.out.println(e1);
		          }
				
			}
		});
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\bg2.jpg"));
		label_9.setBounds(163, 215, 378, 61);
		contentPane.add(label_9);

		JLabel label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\sea.png"));
		label_12.setBounds(554, 33, 120, 113);
		contentPane.add(label_12);
		c1 = new JComboBox<Integer>();
		while (rs.next()) {
			int r=rs.getInt(1);            
            c1.addItem(r);
		}
		
		
		c1.setBounds(375, 92, 78, 32);
		contentPane.add(c1);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\bg2.jpg"));
		label_1.setBounds(163, 66, 378, 128);
		contentPane.add(label_1);
	}
}
