package com.java.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.java.dao.UserDao;
import com.java.model.User;
import com.java.util.DbUtil;
import com.java.util.StringUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class LodOnFrm extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTxt;
	private JPasswordField passwordTxt;

	private DbUtil dbUtil = new DbUtil();
	private UserDao userDao = new UserDao();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LodOnFrm frame = new LodOnFrm();
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
	public LodOnFrm() {
		
		//改变系统默认字体
		Font font = new Font("Dialog", Font.PLAIN, 12);
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource) {
				UIManager.put(key, font);
			}
		}
		
		setResizable(false);
		setTitle("\u7BA1\u7406\u5458\u767B\u9646");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("仿宋", Font.BOLD, 19));
		lblNewLabel.setIcon(new ImageIcon(LodOnFrm.class.getResource("/images/logo.png")));
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setIcon(new ImageIcon(LodOnFrm.class.getResource("/images/userName.png")));
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6  \u7801\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(LodOnFrm.class.getResource("/images/password.png")));
		
		passwordTxt = new JPasswordField();
		
		JButton button = new JButton("\u767B\u9646");
		//登陆按钮事件
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(LodOnFrm.class.getResource("/images/login.png")));
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		//重置按钮事件
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		button_1.setIcon(new ImageIcon(LodOnFrm.class.getResource("/images/reset.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(95)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(label)
										.addComponent(lblNewLabel_1))
									.addGap(43)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(passwordTxt, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
										.addComponent(userNameTxt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(button, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(125, Short.MAX_VALUE)
							.addComponent(lblNewLabel)))
					.addGap(121))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		//窗口居中显示
		this.setLocationRelativeTo(null);
	}

	/**
	 * 登陆事件处理
	 * @param e
	 */
	private void loginActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String userName = this.userNameTxt.getText();
		String password = new String(this.passwordTxt.getPassword());
		if(StringUtil.isEmpty(userName)){
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		}
		if(StringUtil.isEmpty(password)){
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}
		User user = new User(userName,password);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			User currentUser = userDao.login(con, user);
			if(currentUser != null){
				dispose();
				new MainFrm().setVisible(true);
			}
			else{
				JOptionPane.showMessageDialog(null, "用户名或者密码错误！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * 重置事件处理
	 * @param e
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		this.userNameTxt.setText("");
		this.passwordTxt.setText("");
	}
}
