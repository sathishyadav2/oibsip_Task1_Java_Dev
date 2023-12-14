package ReservationSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class LoginForm extends JFrame implements ActionListener{

	public JPanel contentPane;
	public JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6,textField_7,textField_8,
	textField_9;
	public JPasswordField passwordField;
	public JPasswordField passwordField_1;
	public JButton btnNewButton,Register,btnNewButton_2,btnNewButton_3,btnNewButton_4,btnNewButton_5,btnNewButton_6,clear;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
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
	public LoginForm() {
		setBackground(new Color(255, 255, 128));
		setTitle("Login Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 903, 498);
		contentPane = new JPanel();
		contentPane.setForeground(Color.CYAN);
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(248, 111, 142, 40);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setBackground(Color.WHITE);
		textField.setBounds(384, 123, 150, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(248, 201, 142, 40);
		contentPane.add(lblNewLabel_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(378, 209, 156, 28);
		contentPane.add(passwordField_1);
		
	 btnNewButton = new JButton("Login");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setBounds(445, 300, 89, 28);
		contentPane.add(btnNewButton);
		
		 Register = new JButton("Register");
		Register.setForeground(Color.BLACK);
		Register.setBackground(Color.WHITE);
		Register.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Register.setBounds(248, 300, 89, 28);
		contentPane.add(Register);
		btnNewButton.addActionListener(this);
		Register.addActionListener(this);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String t1=textField.getText();
		String t2=passwordField_1.getText();
		if(e.getSource()==btnNewButton) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","bvrit");
			String sql="select * from logtable where username=? and password=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, t1);
			st.setString(2, t2);
			ResultSet rs=st.executeQuery();
			if(rs.next())
			{
				
				JOptionPane.showMessageDialog(this,"login successful","success",JOptionPane.INFORMATION_MESSAGE);
				textField.setText("");
				passwordField_1.setText("");
				BookCancel b=new BookCancel();
				b.setVisible(true);
				//new pagesetForeground(Color.PINK);
				
				
				}else {
					JOptionPane.showMessageDialog(this,"User Not found or Invalid Credentials","error",JOptionPane.ERROR_MESSAGE);
				}
			
		}
		catch(Exception ee) {
			System.out.println(ee);
		}
			}
		
		if(e.getSource()==Register) {
			RigisterForm frame = new RigisterForm();
			
		}
	
	}	
	
}
