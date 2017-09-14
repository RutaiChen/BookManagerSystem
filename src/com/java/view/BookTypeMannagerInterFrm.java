package com.java.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.java.dao.BookDao;
import com.java.dao.BookTypeDao;
import com.java.model.BookType;
import com.java.util.DbUtil;
import com.java.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookTypeMannagerInterFrm extends JInternalFrame {
	private JTable bookTypeTable;
	private JTextArea bookTypeDescTxt;
	
	private DbUtil dbUtil = new DbUtil();
	private BookTypeDao bookTypeDao = new BookTypeDao();
	private BookDao bookDao = new BookDao();
	
	private JTextField s_bookTypeNameTxt;
	private JTextField idTxt;
	private JTextField bookTypeNameTxt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeMannagerInterFrm frame = new BookTypeMannagerInterFrm();
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
	public BookTypeMannagerInterFrm() {
		setBorder(new TitledBorder(null, "\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 613, 590);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");
		
		s_bookTypeNameTxt = new JTextField();
		s_bookTypeNameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeSearchActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(BookTypeMannagerInterFrm.class.getResource("/images/search.png")));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addGap(18)
							.addComponent(s_bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
							.addGap(39)
							.addComponent(btnNewButton))
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE))
					.addContainerGap(41, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(48)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(s_bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(32)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addGap(55)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(32, Short.MAX_VALUE))
		);
		
		JLabel label_1 = new JLabel("\u7F16\u53F7\uFF1A");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");
		
		bookTypeNameTxt = new JTextField();
		bookTypeNameTxt.setColumns(10);
		
		JLabel label_3 = new JLabel("\u63CF\u8FF0\uFF1A");
		
		bookTypeDescTxt = new JTextArea();
		
		JButton button = new JButton("\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeUpdateActionEvent(e);
			}
		});
		button.setIcon(new ImageIcon(BookTypeMannagerInterFrm.class.getResource("/images/modify.png")));
		
		JButton button_1 = new JButton("\u5220\u9664");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeDeleteActionEvent(e);
			}
		});
		button_1.setIcon(new ImageIcon(BookTypeMannagerInterFrm.class.getResource("/images/delete.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(31)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_3)
									.addGap(18)
									.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 431, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_1)
									.addGap(18)
									.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(60)
									.addComponent(label_2)
									.addGap(29)
									.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(143)
							.addComponent(button)
							.addGap(117)
							.addComponent(button_1)))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		bookTypeTable = new JTable();
		bookTypeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookTypeTableMousePressed(e);
			}
		});
		bookTypeTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u7C7B\u522B\u540D\u79F0", "\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTypeTable.getColumnModel().getColumn(1).setPreferredWidth(202);
		bookTypeTable.getColumnModel().getColumn(2).setPreferredWidth(288);
		scrollPane.setViewportView(bookTypeTable);
		getContentPane().setLayout(groupLayout);

		/**
		 * 设置文本域边框
		 */
		bookTypeDescTxt.setBorder(new LineBorder(new java.awt.Color(127, 157, 185),1,false));
		
		this.fillTable(new BookType());//界面初始化时 直接查询全部图书类别数据进行展示
	}
	
	private void bookTypeDeleteActionEvent(ActionEvent evt) {
		// TODO Auto-generated method stub
		String id = idTxt.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选择要删除的记录！");
			return;
		}
		Connection con = null;
		try {
			con = dbUtil.getCon();
			boolean flag = bookDao.existBookByBookTypeId(con, id);
			if(flag){
				JOptionPane.showMessageDialog(null, "当前图书类别下有图书，不能删除此类别！");
				return;
			}
			int deleteNum = bookTypeDao.delete(con, id);
			if(deleteNum == 1){
				JOptionPane.showMessageDialog(null, "删除成功！");
				resetValue();
				this.fillTable(new BookType());
			}
			else{
				JOptionPane.showMessageDialog(null, "删除失败！");
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

	private void bookTypeUpdateActionEvent(ActionEvent evt) {
		// TODO Auto-generated method stub
		String id = idTxt.getText();
		String bookTypeName = bookTypeNameTxt.getText();
		String bookTypeDesc = bookTypeDescTxt.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选择要修改的记录！");
			return;
		}
		if(StringUtil.isEmpty(bookTypeName)){
			JOptionPane.showMessageDialog(null, "要修改的图书类别名称不能为空！");
			return;
		}
		BookType bookType = new BookType(Integer.parseInt(id),bookTypeName,bookTypeDesc);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int modifyNum = bookTypeDao.update(con, bookType);
			if(modifyNum == 1){
				JOptionPane.showMessageDialog(null, "修改成功！");
				resetValue();
				this.fillTable(new BookType());
			}
			else{
				JOptionPane.showMessageDialog(null, "修改失败！");
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
	 * 重置表单
	 */
	private void resetValue() {
		// TODO Auto-generated method stub
		this.idTxt.setText("");
		this.bookTypeNameTxt.setText("");
		this.bookTypeDescTxt.setText("");
	}

	/**
	 * 表格行点击事件处理
	 * @param evt
	 */
	private void bookTypeTableMousePressed(MouseEvent evt) {
		// TODO Auto-generated method stub
		int row = bookTypeTable.getSelectedRow();
		idTxt.setText((String)bookTypeTable.getValueAt(row, 0));
		bookTypeNameTxt.setText((String)bookTypeTable.getValueAt(row, 1));
		bookTypeDescTxt.setText((String)bookTypeTable.getValueAt(row, 2));
		
	}

	/**
	 * 图书类别查询事件处理
	 * @param evt
	 */
	private void bookTypeSearchActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String s_bookTypeName = this.s_bookTypeNameTxt.getText();
		BookType bookType = new BookType();
		bookType.setBookTypeName(s_bookTypeName);
		this.fillTable(bookType);
	}

	/**
	 * 初始化表格
	 * @param bookType
	 */
	private void fillTable(BookType bookType){
		DefaultTableModel dtm = (DefaultTableModel)bookTypeTable.getModel();
		dtm.setRowCount(0);//设置成零行 清空表格
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = bookTypeDao.list(con, bookType);
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("bookTypeName"));
				v.add(rs.getString("bookTypeDesc"));
				dtm.addRow(v);
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
}
