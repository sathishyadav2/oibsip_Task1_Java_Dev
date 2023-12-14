package ReservationSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.Color;

public class RigisterForm extends JFrame implements ActionListener {

	public JPanel contentPane;
	public JLabel lblNewLabel_1;
	public JButton btnNewButton;
	public JButton btnNewButton_1;
	public JLabel  lblNewLabel;
	public JLabel lblNewLabel_2;
	public JLabel lblNewLabel_3;
	public JLabel lblNewLabel_4;
	public JLabel lblNewLabel_5;
	public static String txt;
	
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RigisterForm frame = new RigisterForm();
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
	public RigisterForm() {
		setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		setTitle("TS Registration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 513);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		 lblNewLabel = new JLabel("Enter FistName");
		 lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(300, 66, 140, 20);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Enter LastName");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(300, 111, 119, 32);
		contentPane.add(lblNewLabel_1);
		
		 lblNewLabel_2 = new JLabel("DOB");
		 lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(300, 165, 76, 14);
		contentPane.add(lblNewLabel_2);
		
		 lblNewLabel_3 = new JLabel("mobile no");
		 lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(300, 213, 73, 14);
		contentPane.add(lblNewLabel_3);
		
		 lblNewLabel_4 = new JLabel("Username");
		 lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(303, 260, 168, 14);
		contentPane.add(lblNewLabel_4);
		
		 lblNewLabel_5 = new JLabel("Password");
		 lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(300, 301, 155, 14);
		contentPane.add(lblNewLabel_5);
		
		 btnNewButton = new JButton("Confirm");
		 btnNewButton.setBackground(Color.WHITE);
		 btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		 btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(485, 391, 97, 32);
		contentPane.add(btnNewButton);
	
		
		 btnNewButton_1 = new JButton("Clear");
		 btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		 btnNewButton_1.setForeground(Color.BLACK);
		 btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(300, 391, 86, 32);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener( this);
		btnNewButton.addActionListener(this);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_6 = new JLabel("Confirm Password");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(300, 339, 155, 14);
		contentPane.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(427, 67, 155, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(429, 118, 153, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(427, 163, 155, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(427, 211, 155, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(427, 258, 155, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(427, 299, 155, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(427, 337, 155, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		lblNewLabel_7 = new JLabel("REGISTRATION PAGE");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_7.setBounds(304, 11, 329, 32);
		contentPane.add(lblNewLabel_7);
		setVisible(true);
		
	}
public int ref=1;
private JLabel lblNewLabel_6;
private JTextField textField;
private JTextField textField_1;
private JTextField textField_2;
private JTextField textField_3;
private JTextField textField_4;
private JTextField textField_5;
private JTextField textField_6;
private JLabel lblNewLabel_7;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String txt1,txt2,txt3,txt5,txt6;
		String txt4;
	 txt=textField.getText();
	 txt1=textField_1.getText();
		txt2=textField_2.getText();
		txt3=textField_3.getText();
		txt4=textField_4.getText();
		txt5=textField_5.getText();
		txt6=textField_6.getText();
		int size=txt3.length();
		if(e.getSource()==btnNewButton) {
		if(isNumeric(txt3) && size==10) {
		if(txt5.equals(txt6)) {
	
			try {
				
				//String str="TSPNR2023"+Integer.toString(ref);
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","bvrit");
				String sql="insert into Rsystem values(?,?,?,?,?,?)";
				String sql2="insert into logtable values(?,?)";
				PreparedStatement st=con.prepareStatement(sql);
				PreparedStatement st2=con.prepareStatement(sql2);

				st.setString(1, txt);
		        st.setString(2, txt1);
		        st.setString(3, txt2);
		        st.setString(4, txt3);
		        st.setString(5, txt4);
		        st.setString(6, txt6);
		       // st.setString(7, str);
		        st2.setString(1, txt4);
		        st2.setString(2, txt6);
		     
	int n=0,m=0;
	n=st.executeUpdate();
	m=st2.executeUpdate();
	if(n>0)
	{
		//ref=ref+1;
		JOptionPane.showMessageDialog(this, "Registration Succesful", "Success", JOptionPane.INFORMATION_MESSAGE);
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField_5.setText("");
		textField_6.setText("");
		LoginForm l=new LoginForm();
		l.setVisible(true);
		
	}else {
		JOptionPane.showMessageDialog(this, "Registration Failed!", "Error", JOptionPane.ERROR_MESSAGE);
		
	}
	con.close();
	st.close();

				}
				catch(Exception ae) {
					System.out.println(ae);
				}
			
		}
		
		else {
		JOptionPane.showMessageDialog(this, "Password mismatch", "Error", JOptionPane.ERROR_MESSAGE);
			//JOptionPane.showMessageDialog(this, "Invalid Mobile Number", "Error", JOptionPane.ERROR_MESSAGE);

		}
		}
		else {
			JOptionPane.showMessageDialog(this, "Invalid Mobile Number", "Error", JOptionPane.ERROR_MESSAGE);
			//JOptionPane.showMessageDialog(this, "Password mismatch", "Error", JOptionPane.ERROR_MESSAGE);
		}
		}
		if(e.getSource()==btnNewButton_1) {
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
			textField_5.setText("");
		}
			
	
}
	public static boolean isNumeric(String str) {
        try {
            // Attempt to parse the string as a double
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            // If an exception is caught, the string is not numeric
            return false;
        }
    }
}
	

