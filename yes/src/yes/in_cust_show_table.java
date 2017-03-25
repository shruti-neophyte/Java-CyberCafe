package yes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class in_cust_show_table extends JFrame {

	private JPanel contentPane;
	JTable t;
	String[] col = {"login_time", "date", "name","age","contact_no","address","address_proof","computer_allot"};
	Object[][] row = new Object[25][25];
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					in_cust_show_table frame = new in_cust_show_table();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public in_cust_show_table() throws Exception { 
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\logo.png"));
		setTitle("Customer Details");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 0, 940, 730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Connection con = null;
		Statement start = null;

		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", "root", "root");
		start = con.createStatement();
		String sql = "select * from in_cust_show";
		ResultSet rs = start.executeQuery(sql);
		int i = 0;
		while (rs.next()) {
			int j = 0;
			row[i][j] = rs.getString(1);
			j++;
			row[i][j] = rs.getString(2);
			j++;
			row[i][j] = rs.getString(3);
			j++;
			row[i][j] = rs.getString(4);
			j++;
			row[i][j] = rs.getInt(5);
			j++;
			row[i][j] = rs.getString(6);
			j++;
			row[i][j] = rs.getString(7);
			j++;
			row[i][j] = rs.getInt(8);
			i++;
		}
		t = new JTable(row,col);
		add(t.getTableHeader(), BorderLayout.NORTH);
		add(t);
		t.setBounds(5,50, 910, 690);
		setVisible(true);
	//	setSize(900, 900);
		
	}

}
