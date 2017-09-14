package com.java.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.java.util.LinkLabelUtil;

public class AboutInterFrm extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutInterFrm frame = new AboutInterFrm();
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
	public AboutInterFrm() {
		getContentPane().setFont(new Font("Courier New", Font.PLAIN, 15));
		setClosable(true);
		setIconifiable(true);
		setTitle("\u6211\u7684\u4E3B\u9875");
		setBounds(100, 100, 450, 300);
		
		LinkLabelUtil lblHttpsrutaichengithubio = new LinkLabelUtil("https://rutaichen.github.io/","rutaichen.github.io/");
		//JLabel lblHttpsrutaichengithubio = new JLabel("https://rutaichen.github.io/");
		lblHttpsrutaichengithubio.setFont(new Font("Courier New", Font.PLAIN, 15));
		
		JLabel label = new JLabel("\u4E2A\u4EBA\u4E3B\u9875");
		label.setFont(new Font("¿¬Ìå", Font.PLAIN, 19));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(107, Short.MAX_VALUE)
					.addComponent(lblHttpsrutaichengithubio)
					.addGap(97))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addContainerGap(348, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(97, Short.MAX_VALUE)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblHttpsrutaichengithubio)
					.addGap(123))
		);
		getContentPane().setLayout(groupLayout);

	}

}
