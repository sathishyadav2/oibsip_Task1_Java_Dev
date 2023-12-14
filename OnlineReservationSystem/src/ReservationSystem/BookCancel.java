package ReservationSystem;

import java.awt.EventQueue;
import java.util.random.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class BookCancel extends JFrame implements ActionListener{

	/**
	 * 
	 */

	public JPanel contentPane;
	public JTextField name;
	public JTextField tno;
public JTextField tname;
	public JTextField classtype;
	public JTextField dj;
	public JTextField from;
	public JTextField to;
	public JTextField pnrnum;
	public JTextField detail;
	public JButton submit1, clear,submit2,okbtn,tnok;	
	public int re=1;
	public String pno;
	private JTextField sex;
	JLabel mainHeading,secHead,fname,booking,gender,trainname,tnum,To,dtails;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					BookCancel frame = new BookCancel();
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
	public BookCancel() {
		setForeground(Color.PINK);
		setBackground(Color.PINK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1068, 788);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 mainHeading = new JLabel("ONLINE RESERVATION SYSTEM");
		 mainHeading.setHorizontalAlignment(SwingConstants.CENTER);
		mainHeading.setBackground(new Color(51, 255, 255));
		mainHeading.setFont(new Font("Tahoma", Font.BOLD, 24));
		mainHeading.setBounds(282, 40, 394, 69);
		contentPane.add(mainHeading);
		
		 secHead = new JLabel("GOVERNMENT OF TELANGANA,24/7 BOOKING SERVICE AVILABLE");
		 secHead.setHorizontalAlignment(SwingConstants.CENTER);
		secHead.setForeground(new Color(255, 0, 51));
		secHead.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		secHead.setBounds(200, 106, 571, 34);
		contentPane.add(secHead);
		
		 fname = new JLabel("ENTER FULL NAME");
		fname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fname.setBounds(102, 190, 127, 25);
		contentPane.add(fname);
		
		booking = new JLabel("BOOKING");
		booking.setFont(new Font("Cambria", Font.BOLD, 20));
		booking.setBounds(401, 141, 245, 40);
		contentPane.add(booking);
		
		name = new JTextField();
		name.setToolTipText("lower case");
		name.setBounds(239, 192, 201, 24);
		contentPane.add(name);
		name.setColumns(10);
		
		gender = new JLabel("SEX");
		gender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gender.setBounds(549, 195, 46, 14);
		contentPane.add(gender);
		
		tnum = new JLabel("TRAIN NUMBER");
		tnum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tnum.setBounds(102, 226, 127, 25);
		contentPane.add(tnum);
		
		tno = new JTextField();
		tno.setToolTipText("enter train number");
		tno.setBounds(241, 227, 201, 25);
		contentPane.add(tno);
		tno.setColumns(10);
		
		tname = new JTextField();
		tname.setBounds(629, 228, 209, 24);
		contentPane.add(tname);
		tname.setColumns(10);
		
		 trainname = new JLabel("TRAIN");
		trainname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		trainname.setBounds(549, 231, 46, 14);
		contentPane.add(trainname);
		
		JLabel clsstyp = new JLabel("CLASS TYPE");
		clsstyp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		clsstyp.setBounds(112, 264, 102, 25);
		contentPane.add(clsstyp);
		
		classtype = new JTextField();
		classtype.setToolTipText("enter class type");
		classtype.setBounds(239, 263, 201, 25);
		contentPane.add(classtype);
		classtype.setColumns(10);
		
		JLabel doj = new JLabel("DATE OF JOURNEY");
		doj.setFont(new Font("Tahoma", Font.PLAIN, 14));
		doj.setBounds(549, 252, 127, 48);
		contentPane.add(doj);
		
		dj = new JTextField();
		dj.setBounds(710, 266, 128, 24);
		contentPane.add(dj);
		dj.setColumns(10);
		
		JLabel frm = new JLabel("FROM");
		frm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frm.setBounds(122, 292, 61, 34);
		contentPane.add(frm);
		
		from = new JTextField();
		from.setBounds(239, 299, 201, 25);
		contentPane.add(from);
		from.setColumns(10);
		
		 To = new JLabel("TO");
		To.setFont(new Font("Tahoma", Font.PLAIN, 14));
		To.setBounds(132, 338, 46, 14);
		contentPane.add(To);
		
		to = new JTextField();
		to.setBackground(new Color(245, 255, 250));
		to.setBounds(241, 335, 201, 25);
		contentPane.add(to);
		to.setColumns(10);
		
		 submit1 = new JButton("SUBMIT");
		submit1.setBackground(new Color(240, 248, 255));
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
		submit1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		submit1.setBounds(568, 393, 89, 34);
		contentPane.add(submit1);
		
		 clear = new JButton("CLEAR");
		clear.setFont(new Font("Tahoma", Font.PLAIN, 11));
//		btnNewButton_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
		clear.setBounds(307, 393, 89, 34);
		contentPane.add(clear);
		
		JLabel hpyjrny = new JLabel("HAPPY JOURNEY");
		hpyjrny.setFont(new Font("Sylfaen", Font.PLAIN, 39));
		hpyjrny.setBounds(515, 305, 318, 63);
		contentPane.add(hpyjrny);
		
		JLabel cncl = new JLabel("CANCELING");
		cncl.setForeground(new Color(204, 0, 0));
		cncl.setFont(new Font("Cambria", Font.BOLD, 20));
		cncl.setBounds(384, 433, 201, 40);
		contentPane.add(cncl);
		
		JLabel pnum = new JLabel("ENTER PNR NUMBER");
		pnum.setToolTipText("");
		pnum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnum.setBounds(313, 484, 173, 29);
		contentPane.add(pnum);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(874, 450, 32, -437);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(874, 69, -28, 2);
		contentPane.add(scrollPane_1);
		
		pnrnum = new JTextField();
		pnrnum.setToolTipText("Enter pnr number");
		pnrnum.setBounds(499, 486, 199, 29);
		contentPane.add(pnrnum);
		pnrnum.setColumns(10);
		
		submit2 = new JButton("SUBMIT");
		submit2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		submit2.setBounds(708, 483, 89, 31);
		contentPane.add(submit2);
		
		detail = new JTextField();
		detail.setToolTipText("check name and click ok for cancellation");
		detail.setBounds(499, 526, 199, 29);
		contentPane.add(detail);
		detail.setColumns(10);
		
		okbtn = new JButton("OK");
		okbtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		okbtn.setBounds(708, 525, 89, 31);
		contentPane.add(okbtn);
		
		 dtails = new JLabel("DETAILS");
		dtails.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dtails.setBounds(384, 531, 79, 14);
		contentPane.add(dtails);
		
		 tnok = new JButton("ok");
		tnok.setBounds(449, 228, 56, 25);
		contentPane.add(tnok);
		
		sex = new JTextField();
		sex.setBounds(629, 189, 209, 25);
		contentPane.add(sex);
		sex.setColumns(10);
		tnok.addActionListener(this);
		submit1.addActionListener(this);
		clear.addActionListener(this);
		submit2.addActionListener(this);
		okbtn.addActionListener(this);
		
		
	
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
				
		if(e.getSource()==clear) {
			name.setText("");
			dj.setText("");
			tno.setText("");
			tname.setText("");
			from.setText("");
			to.setText("");
			classtype.setText("");
			gender.setText("");
			
		}
		String a="s21";
		String b,c,d,f;
		//String str="TSPNR23"+Integer.toString(ref);
		b="s23";
		c="s24";
		d="s25";
		f="s26";
		String t1,t2,t3,t4,t5,t6,t7;
		t1=tname.getText();
		t2=classtype.getText();
		t3=tno.getText();
		t4=dj.getText();
		t5=from.getText();
		t6=to.getText();
		t7=name.getText();
		if(e.getSource()==tnok) {
		if(t3.equals(a))
		tname.setText("Vishaka Express");
		else if(t3.equals(b))
			tname.setText("Delhi Express");
		else if(t3.equals(c))
			tname.setText("Mumbai Express");
		else if(t3.equals(d))
			tname.setText("Kanyakumari General");
		else if(t3.equals(f))
			tname.setText("Nalgonda Express");
		else
			tname.setText("Invalid Train number");
		}
	 if(e.getSource()==submit1) {
			try {
				String str;
				str="TSPNR23"+Integer.toString(re);
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","bvrit");
				String q1="select * from tdetails where pnrno=?";
				PreparedStatement ps1=con.prepareStatement(q1);
				ps1.setString(1, str);
				ResultSet rs=ps1.executeQuery();
				while(rs.next())
				{
					re++;
					str="TSPNR23"+Integer.toString(re);
					ps1.setString(1, str);
					 rs=ps1.executeQuery();
				}
				String q="insert into tdetails values(?,?)";
				PreparedStatement ps=con.prepareStatement(q);
				ps.setString(1, str);
				ps.setString(2, t7);
				int n=ps.executeUpdate();
				if(n>0)
				{
					re=re+1;
					JOptionPane.showMessageDialog(this,"Dear "+t7+"\n your Pnrno: "+str,"success",JOptionPane.INFORMATION_MESSAGE);
					name.setText("");
					dj.setText("");
					tno.setText("");
					tname.setText("");
					from.setText("");
					to.setText("");
					classtype.setText("");
					
				}else {
					JOptionPane.showMessageDialog(this,"Failed","error",JOptionPane.ERROR_MESSAGE);
				}
				con.close();
				ps.close();
			}catch(Exception ee) {
				ee.printStackTrace();
			}
		}
		if(e.getSource()==submit2) {
		
		pno=pnrnum.getText();
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","bvrit");
//		String str="TSPNR23"+Integer.toString(re);
			String q2="select * from tdetails where pnrno=?";
			PreparedStatement p2=con.prepareStatement(q2);
			p2.setString(1, pno);
			ResultSet rs=p2.executeQuery();
			if(rs.next()) {
				 String fn=rs.getString("fullname");
				detail.setText(rs.getString("fullname"));
				JOptionPane.showMessageDialog(this,"press ok","error",JOptionPane.ERROR_MESSAGE);
				
			}else {
				JOptionPane.showMessageDialog(this,"Ticket not found","error",JOptionPane.ERROR_MESSAGE);
				pnrnum.setText("");
				detail.setText("");		
			}		
				
			con.close();
		
	}catch(Exception ee) {
			System.out.println(ee);
		}
	}
		if(e.getSource()==okbtn) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","bvrit");
			String q3="delete from tdetails where pnrno=?";
			PreparedStatement p3=cn.prepareStatement(q3);
			p3.setString(1, pno);
			int K=p3.executeUpdate();
			if(K>0) {
			JOptionPane.showMessageDialog(this,"Ticket Successfully cancelled","success",JOptionPane.INFORMATION_MESSAGE);
			pnrnum.setText("");
			detail.setText("");
			}else {
				JOptionPane.showMessageDialog(this,"Failed","failed",JOptionPane.INFORMATION_MESSAGE);
			}
			cn.close();
			}catch(Exception ee) {
				ee.printStackTrace();
			}
		}
		
	}
}
