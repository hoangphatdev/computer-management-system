package ite.computer_management.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import chart.MailCode;
import ite.computer_management.database.ConnectDatabase;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class ChangepassView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField gmailtext;
    private JPasswordField mk_text;
    private JTextField textcode;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ChangepassView frame = new ChangepassView();
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
    public ChangepassView() {
        setTitle("Computer mangement");
        setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\lgo - Copy - Copy.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 935, 568);
        contentPane = 	new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel gmail = new JLabel("Gmail:");
        gmail.setForeground(SystemColor.window);
        gmail.setFont(new Font("Arial", Font.BOLD, 17));
        gmail.setBounds(331, 159, 115, 29);
        contentPane.add(gmail);
        
        gmailtext = new JTextField();
        gmailtext.setBounds(331, 194, 232, 29);
        contentPane.add(gmailtext);
        gmailtext.setColumns(10);
        
        JLabel mk = new JLabel("New Password:");
        mk.setForeground(SystemColor.window);
        mk.setFont(new Font("Arial", Font.BOLD, 17));
        mk.setBounds(331, 278, 147, 29);
        contentPane.add(mk);
        
        mk_text = new JPasswordField();
        mk_text.setBounds(331, 307, 232, 27);
        contentPane.add(mk_text);
        
        JButton Nut_Dangki = new JButton("LOG IN");
        Nut_Dangki.setBackground(SystemColor.activeCaptionBorder);
        Nut_Dangki.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               LogInView view = new LogInView();
               dispose();
               view.setVisible(true);
            }
        });
        
        Nut_Dangki.setFont(new Font("Arial", Font.BOLD, 14));
        Nut_Dangki.setBounds(331, 345, 88, 29);
        contentPane.add(Nut_Dangki);
        
        JButton Nut_Dangnhap = new JButton("CHANGE PASS");
        Nut_Dangnhap.setBackground(SystemColor.activeCaptionBorder);
        Nut_Dangnhap.addActionListener(new ActionListener() {
            ResultSet rs;
            @SuppressWarnings("deprecation")
            public void actionPerformed(ActionEvent e) {
            	 String TC_danhap = textcode.getText().trim();
                 String TC_dagui = MailCode.laymaTeenCode();
 
                 if (TC_danhap.equals(TC_dagui)) {
                     try {
                         String newPassword = new String(mk_text.getPassword());
                         String username = gmailtext.getText(); 

                         if (changePasswordInDatabase(username, newPassword)) {
                             JOptionPane.showMessageDialog(null, "Password changed successfully!");

                      
                         } else {
                             JOptionPane.showMessageDialog(null, "fail");
                         }
                     } catch (SQLException e1) {
                         e1.printStackTrace();
                         JOptionPane.showMessageDialog(null, "Error when querying the database: " + e1.getMessage());
                     }
                 } else {
                     // Mã xác nhận không khớp
                     JOptionPane.showMessageDialog(null, "Incorrect code. Please try again!");
                 }
            }
        }
        );
        Nut_Dangnhap.setFont(new Font("Arial", Font.BOLD, 13));
        Nut_Dangnhap.setBounds(416, 345, 147, 29);
        contentPane.add(Nut_Dangnhap);
        
        JButton Nut_thoat = new JButton("Cancel");
        Nut_thoat.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\anhhhhhhhhh\\Screenshot 2023-12-23 152951.png"));
        Nut_thoat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                  System.exit(0);
            }
        });
        Nut_thoat.setBackground(SystemColor.activeCaptionBorder);
        Nut_thoat.setFont(new Font("Arial", Font.BOLD, 12));
        Nut_thoat.setBounds(484, 376, 79, 29);
        contentPane.add(Nut_thoat);
        
        JButton Nut_DoiMk = new JButton("get code");
        Nut_DoiMk.setBackground(SystemColor.activeCaptionBorder);
        Nut_DoiMk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try {
					Connection c = ConnectDatabase.getConnection();
					ResultSet rs;
					if (gmailtext.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "please enter gmail");
					}
					String sql = "select * from account where userName=?";
					PreparedStatement ps = c.prepareStatement(sql);
					
					ps.setString(1, gmailtext.getText());
					rs = ps.executeQuery();
					
					if(rs.next()) {
						MailCode.guiTeenCodequa_gmail(gmailtext.getText());
						JOptionPane.showMessageDialog(null, "sent successfully" + gmailtext.getText());
					} else {
						JOptionPane.showMessageDialog(null, "Gmail doesn't exist");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
              
            }
        });
        Nut_DoiMk.setFont(new Font("Arial", Font.BOLD, 12));
        Nut_DoiMk.setBounds(331, 376, 147, 29);
        contentPane.add(Nut_DoiMk);
        
        JToggleButton Nut_hienMK = new JToggleButton("");
        Nut_hienMK.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\anhhhhhhhhh\\Screenshot 2023-12-23 194914.png"));
        Nut_hienMK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 if (Nut_hienMK.isSelected()) {
                        mk_text.setEchoChar('\0');
                    } else {
                        mk_text.setEchoChar('*');
                    }
                
            }
        });
        Nut_hienMK.setFont(new Font("Arial", Font.BOLD, 18));
        Nut_hienMK.setBackground(Color.LIGHT_GRAY);
        Nut_hienMK.setForeground(Color.BLACK);
        Nut_hienMK.setBounds(510, 285, 53, 22);
        contentPane.add(Nut_hienMK);
        
        JLabel dangnhap_1 = new JLabel("");
        dangnhap_1.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\lgo - Copy - Copy.png"));
        dangnhap_1.setFont(new Font("Arial", Font.BOLD, 27));
        dangnhap_1.setBounds(450, 39, 154, 114);
        contentPane.add(dangnhap_1);
        
        JLabel dangnhap_1_1 = new JLabel("");
        dangnhap_1_1.setIcon(new ImageIcon("D:\\C++ Tren lop\\chap7\\Screenshot 2023-12-06 202316.png"));
        dangnhap_1_1.setFont(new Font("Arial", Font.BOLD, 27));
        dangnhap_1_1.setBounds(275, 39, 184, 114);
        contentPane.add(dangnhap_1_1);
        
        JLabel lblLogIn = new JLabel("SISN UP");
        lblLogIn.setForeground(SystemColor.window);
        lblLogIn.setFont(new Font("Freestyle Script", Font.BOLD, 74));
        lblLogIn.setBounds(648, 105, 341, 177);
        contentPane.add(lblLogIn);
        
        textcode = new JTextField();
        textcode.setColumns(10);
        textcode.setBounds(331, 253, 232, 29);
        contentPane.add(textcode);
        
        JLabel lblGmail = new JLabel("Code:");
        lblGmail.setForeground(SystemColor.window);
        lblGmail.setFont(new Font("Arial", Font.BOLD, 17));
        lblGmail.setBounds(331, 227, 115, 29);
        contentPane.add(lblGmail);
        
        Box verticalBox = Box.createVerticalBox();
        verticalBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        verticalBox.setBounds(275, 120, 335, 303);
        contentPane.add(verticalBox);
        
        JLabel dangnhap_1_2 = new JLabel("");
        verticalBox.add(dangnhap_1_2);
        dangnhap_1_2.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\backkkkkkkê.jpg"));
        dangnhap_1_2.setFont(new Font("Arial", Font.BOLD, 27));
        
        JLabel đ = new JLabel("");
        đ.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\backkkkkkkê.jpg"));
        đ.setFont(new Font("Arial", Font.BOLD, 27));
        đ.setBounds(-10, -13, 929, 542);
        contentPane.add(đ);
    }  
    private boolean changePasswordInDatabase(String username, String newPassword) throws SQLException {
        try (Connection conn = ConnectDatabase.getConnection()) {
            String sql = "UPDATE account SET password = ? WHERE userName = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newPassword);
            pstmt.setString(2, username);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        }
    }
}