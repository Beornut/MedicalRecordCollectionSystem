package cn.edu.njucm.Eye;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frmLogin;
	private JTextField textField;
	private JPasswordField passwordField;
	private Font bigFont;
	private Font smallFont;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public JFrame getFrm(){
		return frmLogin;
	}
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setResizable(false);
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 597, 460);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(new GridLayout(3, 1, 0, 30));
		bigFont = new Font("宋体",Font.BOLD, 36);
		smallFont = new Font("宋体",Font.BOLD, 24);
		
		ImageIcon back_img = new ImageIcon("tessdata\\back_img.jpg");
		JLabel back_label = new JLabel(back_img);
		back_label.setBounds(0, 0, frmLogin.getWidth(), frmLogin.getHeight());
        ((JPanel) frmLogin.getContentPane()).setOpaque(false); 
        frmLogin.getLayeredPane().add(back_label, new Integer(Integer.MIN_VALUE));
        
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		frmLogin.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel l_tit = new JLabel("一目医案采集系统");
		l_tit.setFont(bigFont);
		
		
		JPanel panel_7 = new JPanel();
		panel_7.setOpaque(false);
		panel_1.add(panel_7);
		
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		panel_5.setOpaque(false);
		panel_5.add(l_tit);
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setLayout(new GridLayout(2, 1, 0, 0));
		frmLogin.getContentPane().add(panel_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panel_2.add(panel_4);
		
		JLabel label = new JLabel("帐号：");
		label.setFont(smallFont);
		panel_4.add(label);
		
		textField = new JTextField();
		textField.setFont(smallFont);
		panel_4.add(textField);
		textField.setColumns(15);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel_2.add(panel);
		
		JLabel label_1 = new JLabel("密码：");
		label_1.setFont(smallFont);
		panel.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(smallFont);
		passwordField.setColumns(15);
		panel.add(passwordField);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setHgap(50);
		panel_3.setOpaque(false);
		frmLogin.getContentPane().add(panel_3);
		
		JButton button = new JButton("登录");
		
		button.setFont(smallFont);
		panel_3.add(button);
		
		JButton button_1 = new JButton("退出");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		button_1.setFont(smallFont);
		panel_3.add(button_1);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().equals("") || new String(passwordField.getPassword()).equals("")){
					JOptionPane.showMessageDialog(null, "帐号和密码不能为空！"); 
					return;
				}
				int res = DB.select(textField.getText(), new String(passwordField.getPassword()));
				if(res == 0)
					JOptionPane.showMessageDialog(null, "帐号或密码错误！"); 
				else if(res == 1){
					JOptionPane.showMessageDialog(null, "医生登录成功！");
					DocWin dw = new DocWin(frmLogin);
					frmLogin.setVisible(false);
				}else{
					JOptionPane.showMessageDialog(null, "管理员登录成功！");
					ManWin mw = new ManWin(frmLogin);
					frmLogin.setVisible(false);
				}
			}
		});
		
	}

}
