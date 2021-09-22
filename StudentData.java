package studentData;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Color;

public class StudentData {

	private JFrame frame;
	private JTextField gid;
	private JTextField gname;
	private JTextField gphone;
	private JTable table;
	private String Branch;
	private String Gender;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentData window = new StudentData();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentData() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 1010, 715);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final String url = "jdbc:mysql://localhost:3306/sdata";
		final String uname = "";
		final String pass = "";

		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				gid.setText(null);
				gname.setText(null);
				gphone.setText(null);
				
				
			}
		});
		btnClear.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnClear.setBackground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("Student ID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JLabel lblStudentBranch = new JLabel("Student Branch");
		lblStudentBranch.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JLabel lblStudentPhone = new JLabel("Student Phone");
		lblStudentPhone.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JLabel lblStudGender = new JLabel("Stud Gender");
		lblStudGender.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		gid = new JTextField();
		gid.setColumns(10);
		
		gname = new JTextField();
		gname.setColumns(10);
		
		gphone = new JTextField();
		gphone.setColumns(10);
		
		
		
		
		JRadioButton CS = new JRadioButton("Computer Science");
		CS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Branch = "Computer Science";
			}
		});
		CS.setBackground(SystemColor.activeCaption);
		CS.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JRadioButton ELC = new JRadioButton("Electrical");
		ELC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Branch = "Electrical";
			}
		});
		ELC.setBackground(SystemColor.activeCaption);
		ELC.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JRadioButton MEC = new JRadioButton("Mechanical");
		MEC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Branch = "Mechanical";
			}
		});
		MEC.setBackground(SystemColor.activeCaption);
		MEC.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JRadioButton ELCT = new JRadioButton("Electronics");
		ELCT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Branch = "Electronics"; 
			}
		});
		ELCT.setBackground(SystemColor.activeCaption);
		ELCT.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JRadioButton M = new JRadioButton("MALE");
		M.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gender = "Male";
			}
		});
		M.setBackground(SystemColor.activeCaption);
		M.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JRadioButton FM = new JRadioButton("FEMALE");
		FM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gender = "Female";
			}
		});
		FM.setBackground(SystemColor.activeCaption);
		FM.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		
		ButtonGroup Bran = new ButtonGroup();
		Bran.add(CS);
		Bran.add(ELC);
		Bran.add(MEC);
		Bran.add(ELCT);
		
		ButtonGroup gen = new ButtonGroup();
		gen.add(FM);
		gen.add(M);
		
		JButton btnNewButton = new JButton("INSERT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a = gid.getText();
				String b = gname.getText();
				String c = Branch;
				String d = gphone.getText();
				String e1 = Gender;
				
				try { 
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con =  DriverManager.getConnection(url, uname, pass);
					PreparedStatement stmt = con.prepareStatement("insert into studentd values(?,?,?,?,?)");
					
					stmt.setString(1, a);
					stmt.setString(2, b);
					stmt.setString(3, c);
					stmt.setString(4, d);
					stmt.setString(5, e1);
					stmt.executeUpdate();
					
					JOptionPane.showMessageDialog(frame, "Data Inserted Sucessfully...!");
			}
				catch(Exception e11) {
					}
				}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setForeground(SystemColor.text);
		btnUpdate.setBackground(SystemColor.controlDkShadow);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con =  DriverManager.getConnection(url, uname, pass);
					
					String a = gid.getText();
					String c = gphone.getText();
					String b = gname.getText();
					String z = Gender;
					String x = Branch;
					
					Statement stmt = con.createStatement();
					String st = "UPDATE studentd SET name='"+b+"',MobileNo='"+c+"',Gender='"+z+"',Gender='"+x+"' WHERE id='"+a+"'";
					stmt.execute(st);
					
					
					JOptionPane.showMessageDialog(frame, "Data Updated Sucessfully...!");
			}
				catch(Exception e11) {
					}
				}
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con =  DriverManager.getConnection(url, uname, pass);
					
					String a = gid.getText();
					
					
					Statement stmt = con.createStatement();
					String st = "DELETE FROM studentd WHERE id='"+a+"'";
					stmt.execute(st);
					
					
					JOptionPane.showMessageDialog(frame, "Data Deleted Sucessfully...!");
			}
				catch(Exception e11) {
					}
				}
				
		});
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JButton btnShow = new JButton("SHOW");
		btnShow.setForeground(SystemColor.text);
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con =  DriverManager.getConnection(url, uname, pass);
					String que = "SELECT *FROM studentd";
					PreparedStatement stmt = con.prepareStatement(que);
					ResultSet rs = stmt.executeQuery(que);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
			}
				catch(Exception e11) {
					}
			}
		});
		btnShow.setBackground(SystemColor.controlDkShadow);
		btnShow.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		table = new JTable();
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(table, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 972, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
									.addGap(33)
									.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
									.addGap(31)
									.addComponent(btnDelete)
									.addGap(26)
									.addComponent(btnShow, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblStudentName, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblStudentPhone, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblStudentBranch, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblStudGender, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
									.addGap(108)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(gphone, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
										.addComponent(gid, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
										.addComponent(gname, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(CS)
												.addComponent(ELC, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
												.addComponent(M, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
											.addGap(44)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(FM, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
												.addComponent(ELCT, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
												.addComponent(MEC, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))))))
							.addContainerGap(199, Short.MAX_VALUE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(gid, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblStudentName, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(gname, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStudentBranch, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(CS)
						.addComponent(MEC, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(ELC, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(ELCT, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblStudentPhone, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblStudGender, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
										.addComponent(M, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
								.addComponent(gphone, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(86)
							.addComponent(FM, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnShow, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))))
					.addGap(47)
					.addComponent(table, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
