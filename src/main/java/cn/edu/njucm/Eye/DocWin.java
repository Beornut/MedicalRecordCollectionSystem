package cn.edu.njucm.Eye;

import java.util.List;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridLayout;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;
import cn.edu.njucm.Eye.OCR;

public class DocWin {

	private JFrame frmDocwin;
	private JFrame frmLogin;
	private Font bigFont;
	private Font smallFont;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private Crawler cl;
	
/*
	public static void Main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DocWin window = new DocWin();
					window.frmDocwin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public DocWin() {
		initialize();
	}*/
	
	public DocWin(JFrame frmLogin) {
		this.frmLogin = frmLogin;
		initialize();
		frmDocwin.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDocwin = new JFrame();
		frmDocwin.setResizable(false);
		frmDocwin.setTitle("DocWin");
		frmDocwin.setBounds(100, 100, 756, 528);
		frmDocwin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bigFont = new Font("宋体",Font.BOLD, 18);
		smallFont = new Font("宋体",Font.BOLD, 28);
		
		ImageIcon back_img = new ImageIcon("tessdata\\back_img.jpg");
		JLabel back_label = new JLabel(back_img);
		back_label.setBounds(0, 0, frmDocwin.getWidth(), frmDocwin.getHeight());
        ((JPanel) frmDocwin.getContentPane()).setOpaque(false); 
        frmDocwin.getContentPane().setLayout(new GridLayout(1, 2, 0, 0));
        frmDocwin.getLayeredPane().add(back_label, new Integer(Integer.MIN_VALUE));
        
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		panel_1.setOpaque(false);
		frmDocwin.getContentPane().add(panel_1);
		
		JLabel label = new JLabel("文本编辑区");
		label.setFont(smallFont);
		panel_1.add(label);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setRows(23);
		textArea.setColumns(30);
		JScrollPane jsp = new JScrollPane(textArea);
		jsp.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel_1.add(jsp);
		
		JButton button = new JButton("保存");
		
		button.setFont(bigFont);
		panel_1.add(button);
		
		JButton button_5 = new JButton("退出");
		button_5.setFont(new Font("宋体", Font.BOLD, 18));
		panel_1.add(button_5);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		panel_2.setOpaque(false);
		frmDocwin.getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel_2.add(panel);
		panel.setLayout(new GridLayout(5, 1, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setOpaque(false);
		panel.add(panel_5);
		
		JLabel label_1 = new JLabel("爬虫功能区");
		label_1.setFont(new Font("宋体", Font.BOLD, 24));
		panel_5.add(label_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setOpaque(false);
		panel.add(panel_6);
		
		JLabel label_2 = new JLabel("爬取次数：");
		label_2.setFont(bigFont);
		panel_6.add(label_2);
		
		textField = new JTextField();
		textField.setFont(bigFont);
		panel_6.add(textField);
		textField.setColumns(20);
		
		JPanel panel_7 = new JPanel();
		panel_7.setOpaque(false);
		panel.add(panel_7);
		
		JLabel lblurl = new JLabel(" 起始URL：");
		lblurl.setFont(new Font("宋体", Font.BOLD, 18));
		panel_7.add(lblurl);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.BOLD, 18));
		textField_1.setColumns(20);
		panel_7.add(textField_1);
		
		JPanel panel_8 = new JPanel();
		panel_8.setOpaque(false);
		panel.add(panel_8);
		
		JLabel label_3 = new JLabel("  关键词：");
		label_3.setFont(new Font("宋体", Font.BOLD, 18));
		panel_8.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("宋体", Font.BOLD, 18));
		textField_2.setColumns(20);
		panel_8.add(textField_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panel.add(panel_4);
		
		JButton button_1 = new JButton("启动");
		
		button_1.setFont(new Font("宋体", Font.BOLD, 24));
		panel_4.add(button_1);
		
		JButton button_2 = new JButton("停止");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cl == null){
					JOptionPane.showMessageDialog(null, "尚未创建爬虫！");
					return;
				}else{
					cl.stop();
				}
			}
		});
		button_2.setFont(new Font("宋体", Font.BOLD, 24));
		panel_4.add(button_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		panel_3.setOpaque(false);
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_9.setOpaque(false);
		panel_3.add(panel_9);
		
		JLabel lblOcr = new JLabel("OCR功能区");
		lblOcr.setFont(new Font("宋体", Font.BOLD, 24));
		panel_9.add(lblOcr);
		
		JPanel panel_10 = new JPanel();
		panel_10.setOpaque(false);
		panel_3.add(panel_10);
		
		JButton button_3 = new JButton("打开图片");

		button_3.setFont(new Font("宋体", Font.BOLD, 18));
		panel_10.add(button_3);
		
		textField_3 = new JTextField();
		textField_3.setText("尚未选择图片");
		textField_3.setEnabled(false);
		panel_10.add(textField_3);
		textField_3.setColumns(15);
		textField_3.setFont(bigFont);
		
		JPanel panel_11 = new JPanel();
		panel_11.setOpaque(false);
		panel_3.add(panel_11);
		
		JLabel label_6 = new JLabel(" 识别状态：");
		label_6.setFont(new Font("宋体", Font.BOLD, 18));
		panel_11.add(label_6);
		
		JLabel label_5 = new JLabel("尚未开始            ");
		label_5.setFont(new Font("宋体", Font.ITALIC, 18));
		panel_11.add(label_5);
		
		JPanel panel_12 = new JPanel();
		panel_12.setOpaque(false);
		panel_3.add(panel_12);
		
		JButton button_4 = new JButton("开始识别");

		button_4.setFont(new Font("宋体", Font.BOLD, 24));
		panel_12.add(button_4);
		
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser jfc=new JFileChooser();  
		        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY ); 
		        FileNameExtensionFilter filter = new FileNameExtensionFilter(
		                "图像文件(*.jpg;*.bmp;*.png)", "jpg", "bmp", "png");
		        jfc.setFileFilter(filter);
		        jfc.showDialog(new JLabel(), "选择");  
		        File file=jfc.getSelectedFile();  
		        textField_3.setText(file.getAbsolutePath());
			}
		});
		
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_3.getText().equals("尚未选择图片")){
					JOptionPane.showMessageDialog(null, "请先选择待识别的图片！"); 
					return;
				}
				label_5.setText("正在识别");
				textArea.setText(textArea.getText() + OCR.img2txt(textField_3.getText()));
				JOptionPane.showMessageDialog(null, "识别完成！");   
				label_5.setText("尚未开始");
			}
		});
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FileNameExtensionFilter filter=new FileNameExtensionFilter("*.txt","txt");  
		        JFileChooser fc=new JFileChooser();  
		        fc.setFileFilter(filter);  
		        fc.setMultiSelectionEnabled(false);  
		        int result=fc.showSaveDialog(null);  
		        if (result==JFileChooser.APPROVE_OPTION) {  
		            File file=fc.getSelectedFile();  
		            if (!file.getPath().endsWith(".txt")) {  
		                file=new File(file.getPath()+".txt");  
		            }  
		            FileOutputStream fos=null;  
		            try {  
		                if (!file.exists()) {  
		                    file.createNewFile();  
		                }  
		                fos=new FileOutputStream(file);  
		                fos.write(textArea.getText().getBytes());  
		                fos.flush();  
		            } catch (IOException e) {  
		            	JOptionPane.showMessageDialog(null, "文件创建失败！");  
		                e.printStackTrace();  
		            }finally{  
		                if (fos!=null) {  
		                    try {  
		                        fos.close();  
		                    } catch (IOException e) {  
		                        e.printStackTrace();  
		                    }  
		                }  
		            }  
		        }
			}
		});
		
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmDocwin.dispose();
				frmLogin.setVisible(true);
			}
		});
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("")){
					JOptionPane.showMessageDialog(null, "请先设置爬取参数！");
					return;
				}
				cl = new Crawler(Integer.parseInt(textField.getText()), textField_1.getText(), textField_2.getText());
		    	cl.start();
		    	JOptionPane.showMessageDialog(null, "爬取成功！");
		    	List<String> res =  cl.getRes();
		    	for(int i = 0; i < res.size(); i++){
		    		textArea.setText(textArea.getText() + res.get(i) + "\n");
		    	}
			}
		});
	}

}
