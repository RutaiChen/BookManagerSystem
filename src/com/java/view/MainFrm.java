package com.java.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrm extends JFrame {

	private JPanel contentPane;

	private JDesktopPane table = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
		setTitle("\u56FE\u4E66\u7BA1\u7406\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u57FA\u672C\u6570\u636E\u7EF4\u62A4");
		mnNewMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/base.png")));
		menuBar.add(mnNewMenu);
		
		JMenu menu = new JMenu("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		menu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookTypeManager.png")));
		mnNewMenu.add(menu);
		
		JMenuItem menuItem_1 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeAddInterFrm bookTypeAddInterFrm = new BookTypeAddInterFrm();
				bookTypeAddInterFrm.setVisible(true);
				table.add(bookTypeAddInterFrm);
			}
		});
		menuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
		menu.add(menuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeMannagerInterFrm bookTypeMannagerInterFrm = new BookTypeMannagerInterFrm();
				bookTypeMannagerInterFrm.setVisible(true);
				table.add(bookTypeMannagerInterFrm);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png")));
		menu.add(mntmNewMenuItem);
		
		JMenu menu_1 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		menu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookManager.png")));
		mnNewMenu.add(menu_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u56FE\u4E66\u6DFB\u52A0");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAddInterFrm bookAddInterFrm = new BookAddInterFrm();
				bookAddInterFrm.setVisible(true);
				table.add(bookAddInterFrm);
			}
		});
		menuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
		menu_1.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u56FE\u4E66\u7EF4\u62A4");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookMannagerInterFrm bookMannagerInterFrm = new BookMannagerInterFrm();
				bookMannagerInterFrm.setVisible(true);
				table.add(bookMannagerInterFrm);
			}
		});
		menuItem_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png")));
		menu_1.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("\u5B89\u5168\u9000\u51FA");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "是否退出系统");
				if(result == 0){
					dispose();
				}
			}
		});
		menuItem_4.setIcon(new ImageIcon(MainFrm.class.getResource("/images/exit.png")));
		mnNewMenu.add(menuItem_4);
		
		JMenu mnNewMenu_1 = new JMenu("\u5173\u4E8E\u6211\u4EEC");
		mnNewMenu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/about.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem menuItem = new JMenuItem("\u6211\u7684\u4E3B\u9875");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutInterFrm aboutInterFrm = new AboutInterFrm();
				aboutInterFrm.setVisible(true);
				table.add(aboutInterFrm);
			}
		});
		menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/me.png")));
		mnNewMenu_1.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		table = new JDesktopPane();
		table.setBackground(Color.BLUE);
		contentPane.add(table, BorderLayout.CENTER);
		/**
		 * 编辑部分
		 */
		//窗体最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
