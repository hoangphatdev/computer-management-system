package ite.computer_management.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextArea;

public class ChatView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatView frame = new ChatView();
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
	
	public ChatView() {
		setBackground(new Color(0, 0, 51));
		init();
	}
	public void init() {
		 setLayout(null); 
		setBounds(100, 100, 1250, 800);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 188, 1250, 478);
		add(scrollPane);
		
		JButton btnSend = new JButton("");
		btnSend.setBackground(Color.DARK_GRAY);
		btnSend.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\send.png"));
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSend.setBounds(1099, 676, 141, 36);
		add(btnSend);
		
		JLabel CHATROOM = new JLabel("CHAT ROOM");
		CHATROOM.setForeground(Color.WHITE);
		CHATROOM.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\Chat-room2 - Copy.png"));
		CHATROOM.setFont(new Font("Magneto", Font.PLAIN, 56));
		CHATROOM.setBounds(221, 0, 900, 212);
		add(CHATROOM);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(159, 679, 930, 33);
		add(textArea);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	}
}
