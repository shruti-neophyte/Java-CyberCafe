package yes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class dr extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dr frame = new dr();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public dr() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\eclipse\\java pics\\logo.png"));
		setTitle("Daily Report");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 150, 566, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(191, 60, 124, 27);
		contentPane.add(comboBox);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Serif", Font.PLAIN, 20));
		lblDate.setBounds(122, 60, 37, 27);
		contentPane.add(lblDate);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Serif", Font.PLAIN, 20));
		lblAmount.setBounds(122, 222, 74, 27);
		contentPane.add(lblAmount);
		
		JLabel res = new JLabel("");
		res.setBounds(191, 222, 91, 24);
		contentPane.add(res);
		
		JButton btnUpdate = new JButton("update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnUpdate.setBounds(118, 143, 89, 23);
		contentPane.add(btnUpdate);
		
		JLabel label = new JLabel("");
		label.setBounds(305, 190, 113, 107);
		contentPane.add(label);
		
		JButton button = new JButton("Daily Report");
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button.setBackground(new Color(153, 204, 204));
		button.setBounds(289, 315, 171, 29);
		contentPane.add(button);
	}
}
