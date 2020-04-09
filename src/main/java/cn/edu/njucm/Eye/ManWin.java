package cn.edu.njucm.Eye;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileNameExtensionFilter;



import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;

public class ManWin {

	private JFrame frmManwin;
	private JFrame frmLogin;
	private Font bigFont;
	private Font smallFont;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private Pattern p = Pattern.compile("#(.*?)#", Pattern.MULTILINE);
	private Matcher m;

	
	public ManWin(JFrame frmLogin) {
		this.frmLogin = frmLogin;
		initialize();
		frmManwin.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmManwin = new JFrame();
		frmManwin.setResizable(false);
		frmManwin.setTitle("ManWin");
		frmManwin.setBounds(100, 100, 762, 549);
		frmManwin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bigFont = new Font("宋体",Font.BOLD, 18);
		smallFont = new Font("宋体",Font.BOLD, 28);
		
		ImageIcon back_img = new ImageIcon("tessdata\\back_img.jpg");
		JLabel back_label = new JLabel(back_img);
		back_label.setBounds(0, 0, frmManwin.getWidth(), frmManwin.getHeight());
        ((JPanel) frmManwin.getContentPane()).setOpaque(false); 
        frmManwin.getLayeredPane().add(back_label, new Integer(Integer.MIN_VALUE));
        frmManwin.getContentPane().setLayout(new GridLayout(1, 2, 0, 0));
        
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		panel_1.setOpaque(false);
		frmManwin.getContentPane().add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label = new JLabel("文本编辑区");
		label.setFont(smallFont);
		panel_1.add(label);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setRows(25);
		textArea.setColumns(30);
		JScrollPane jsp = new JScrollPane(textArea);
		jsp.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel_1.add(jsp);
		
		JButton button = new JButton("导入文本");

		button.setFont(bigFont);
		panel_1.add(button);
		
		JButton button_3 = new JButton("退出");
		button_3.setFont(new Font("宋体", Font.BOLD, 18));
		panel_1.add(button_3);
		
		JPanel panel_2 = new JPanel();
        panel_2.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		panel_2.setOpaque(false);
		frmManwin.getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(5, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel_2.add(panel);
		panel.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_7.setOpaque(false);
		panel.add(panel_7);
		
		JButton button_1 = new JButton("编辑");
		
		panel_7.add(button_1);
		
		JButton button_2 = new JButton("导出");
		
		panel_7.add(button_2);
		
		JPanel panel_8 = new JPanel();
		panel_8.setOpaque(false);
		panel.add(panel_8);
		
		JLabel label_1 = new JLabel("姓名：");
		panel_8.add(label_1);
		
		textField = new JTextField();
		panel_8.add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("性别：");
		panel_8.add(label_2);
		
		textField_1 = new JTextField();
		panel_8.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_9 = new JPanel();
		panel_9.setOpaque(false);
		panel.add(panel_9);
		
		JLabel label_3 = new JLabel("年龄：");
		panel_9.add(label_3);
		
		textField_2 = new JTextField();
		panel_9.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_4 = new JLabel("诊次：");
		panel_9.add(label_4);
		
		textField_3 = new JTextField();
		panel_9.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel_2.add(panel_3);
		
		JLabel label_5 = new JLabel("主诉：");
		panel_3.add(label_5);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		textArea_1.setRows(5);
		textArea_1.setColumns(20);
		JScrollPane jsp_1 = new JScrollPane(textArea_1);
		jsp_1.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel_3.add(jsp_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panel_2.add(panel_4);
		
		JLabel label_6 = new JLabel("诊察：");
		panel_4.add(label_6);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setLineWrap(true);
		textArea_2.setRows(5);
		textArea_2.setColumns(20);
		JScrollPane jsp_2 = new JScrollPane(textArea_2);
		jsp_2.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel_4.add(jsp_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setOpaque(false);
		panel_2.add(panel_5);
		panel_5.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_10 = new JPanel();
		panel_10.setOpaque(false);
		panel_5.add(panel_10);
		
		JLabel label_7 = new JLabel("病名：");
		panel_10.add(label_7);
		
		textField_4 = new JTextField();
		textField_4.setColumns(20);
		panel_10.add(textField_4);
		
		JPanel panel_11 = new JPanel();
		panel_11.setOpaque(false);
		panel_5.add(panel_11);
		
		JLabel label_8 = new JLabel("辨证：");
		panel_11.add(label_8);
		
		textField_5 = new JTextField();
		textField_5.setColumns(20);
		panel_11.add(textField_5);
		
		JPanel panel_12 = new JPanel();
		panel_12.setOpaque(false);
		panel_5.add(panel_12);
		
		JLabel label_9 = new JLabel("治法：");
		panel_12.add(label_9);
		
		textField_6 = new JTextField();
		textField_6.setColumns(20);
		panel_12.add(textField_6);
		
		JPanel panel_6 = new JPanel();
		panel_6.setOpaque(false);
		panel_2.add(panel_6);
		
		JLabel label_10 = new JLabel("药方：");
		panel_6.add(label_10);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setLineWrap(true);
		textArea_3.setRows(5);
		textArea_3.setColumns(20);
		JScrollPane jsp_3 = new JScrollPane(textArea_3);
		jsp_3.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel_6.add(jsp_3);
		
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmManwin.dispose();
				frmLogin.setVisible(true);
			}
		});
        
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser jfc=new JFileChooser();  
		        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY ); 
		        FileNameExtensionFilter filter = new FileNameExtensionFilter(
		                "文本文件(*.txt)", "txt");
		        jfc.setFileFilter(filter);
		        jfc.showDialog(new JLabel(), "选择");  
		        File file=jfc.getSelectedFile();
		        InputStreamReader reader = null;
				try {
					reader = new InputStreamReader(new FileInputStream(file));
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} 
                BufferedReader br = new BufferedReader(reader);   
                String line = "";  
                try {
					line = br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}  
                while (line != null) {  
                	textArea.setText(textArea.getText() + line + "\n");
                    try {
						line = br.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					} 
                }  
			}
		});
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new DB(textField.getText(), 
						textField_1.getText(),
						textField_2.getText(),
						textField_3.getText(),
						textArea_1.getText(),
						textArea_2.getText(),
						textField_4.getText(),
						textField_5.getText(),
						textField_6.getText(),
						textArea_3.getText()
						).insert();
			}
		});
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textArea.getText().replaceAll("\n", " ");
				//JOptionPane.showMessageDialog(null, text);
				m = p.matcher(text);
				if(m.find()){
					String txt = m.group(1);
					Pattern p1 = Pattern.compile("姓名：(.*?)\\s", Pattern.MULTILINE);
					Matcher m1 = p1.matcher(txt);
					if(m1.find()){
						textField.setText(m1.group(1));
					}
					Pattern p2 = Pattern.compile("性别：(.*?)\\s", Pattern.MULTILINE);
					Matcher m2 = p2.matcher(txt);
					if(m2.find()){
						textField_1.setText(m2.group(1));
					}
					Pattern p3 = Pattern.compile("年龄：(.*?)\\s", Pattern.MULTILINE);
					Matcher m3 = p3.matcher(txt);
					if(m3.find()){
						textField_2.setText(m3.group(1));
					}
					Pattern p4 = Pattern.compile("诊次：(.*?)\\s", Pattern.MULTILINE);
					Matcher m4 = p4.matcher(txt);
					if(m4.find()){
						textField_3.setText(m4.group(1));
					}
					Pattern p5 = Pattern.compile("主诉：(.*?)\\s", Pattern.MULTILINE);
					Matcher m5 = p5.matcher(txt);
					if(m5.find()){
						textArea_1.setText(m5.group(1));
					}
					Pattern p6 = Pattern.compile("诊察：(.*?)\\s", Pattern.MULTILINE);
					Matcher m6 = p6.matcher(txt);
					if(m6.find()){
						textArea_2.setText(m6.group(1));
					}
					Pattern p7 = Pattern.compile("病名：(.*?)\\s", Pattern.MULTILINE);
					Matcher m7 = p7.matcher(txt);
					if(m7.find()){
						textField_4.setText(m7.group(1));
					}
					Pattern p8 = Pattern.compile("辨证：(.*?)\\s", Pattern.MULTILINE);
					Matcher m8 = p8.matcher(txt);
					if(m8.find()){
						textField_5.setText(m8.group(1));
					}
					Pattern p9 = Pattern.compile("治法：(.*?)\\s", Pattern.MULTILINE);
					Matcher m9 = p9.matcher(txt);
					if(m9.find()){
						textField_6.setText(m9.group(1));
					}
					Pattern p0 = Pattern.compile("药方：(.*)\\s?", Pattern.MULTILINE);
					Matcher m0 = p0.matcher(txt);
					if(m0.find()){
						textArea_3.setText(m0.group(1));
					}
				}
			}
		});
	}

}
