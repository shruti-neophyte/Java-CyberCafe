package yes;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.SystemColor;

public class test extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JPasswordField t2;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public test() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\logo.png"));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 50, 680, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\two.jpg"));
		label.setBounds(152, 57, 168, 163);
		contentPane.add(label);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(25, 25, 112));
		lblUsername.setFont(new Font("SansSerif", Font.BOLD, 25));
		lblUsername.setBounds(178, 303, 120, 33);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(25, 25, 112));
		lblPassword.setFont(new Font("SansSerif", Font.BOLD, 25));
		lblPassword.setBounds(178, 375, 118, 33);
		contentPane.add(lblPassword);

		t1 = new JTextField();
		t1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		t1.setBounds(320, 306, 155, 33);
		contentPane.add(t1);
		t1.setColumns(10);

		t2 = new JPasswordField();
		t2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		t2.setBounds(320, 378, 155, 32);
		contentPane.add(t2);

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a = t1.getText();
				String b = t2.getText();
				if (a.equals("a") && b.equals("a")) {
					fr obj = new fr();
					obj.show();
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Access Denied");
				}
			}
		});
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnLogin.setBackground(SystemColor.scrollbar);
		btnLogin.setBounds(285, 465, 131, 38);
		contentPane.add(btnLogin);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\bg1.png"));
		label_1.setBounds(314, 57, 193, 163);
		contentPane.add(label_1);
	}
}
