package shuben;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class SelectDialog {
	private int judgement;
	private UserDao userDao;
	private JFrame jFrame;
	private JButton labelE;
	private JPanel jpanel,jpane2,jpane3,jpane4;
	private JToolBar toolBar1,toolBar2,toolBar3,toolBar4,toolBarE;
	private JButton jbuttonCondition,jbuttonField,jbuttonVague,jbuttonExit;
	
	public SelectDialog(int judgement) {
		this.judgement = judgement;
		labelE=new JButton(new ImageIcon(this.getClass().getResource("menu.gif")));
		labelE.setToolTipText("返回主菜单");
		jFrame = new JFrame("文献查询");
		labelE.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				jFrame.dispose();
			//	new Menu().showMe();
				new JudgeMenu(judgement).Judge();;
			}
		});
	}
	public void createToolBar() {
		toolBar1 = new JToolBar();
		toolBar2 = new JToolBar();
		toolBar3 = new JToolBar();
		toolBar4 = new JToolBar();
		toolBarE = new JToolBar();
				
		jbuttonCondition = new JButton("按条件查询", new ImageIcon(this.getClass().getResource("Select.gif")));//
		jbuttonCondition.setToolTipText("按条件查询");
		
		jbuttonField = new JButton("按字段查询", new ImageIcon(this.getClass().getResource("Select.gif")));
		jbuttonField.setToolTipText("按字段查询");
		
		jbuttonVague = new JButton("模糊查询", new ImageIcon(this.getClass().getResource("Select.gif")));
		jbuttonVague.setToolTipText("模糊查询");
		
		
		jbuttonExit = new JButton( new ImageIcon(this.getClass().getResource("Exit.gif")));
		jbuttonExit.setToolTipText("退出");
		
//		toolBar1.setPreferredSize(new Dimension(60,140));
		toolBar1.add(jbuttonCondition);
		
//		toolBar2.setPreferredSize(new Dimension(60,140));
		toolBar2.add(jbuttonField);
		
	//	toolBar3.setPreferredSize(new Dimension(60,140));
		toolBar3.add(jbuttonVague);
		
	//	toolBar4.setPreferredSize(new Dimension(60,140));
		toolBar4.add(jbuttonExit);
		toolBarE.add(labelE);
		
	}
	public void init() {
		createToolBar();
		jpanel = new JPanel();
		jpane2 = new JPanel();
		jpane3 = new JPanel();
		jpane4 = new JPanel();

		jpanel.setLayout(new BorderLayout());	
//		jpanel.setPreferredSize(new Dimension(200,220));
		jpanel.add(toolBar1);
		jpane2.setLayout(new BorderLayout());
//		jpane2.setPreferredSize(new Dimension(200,200));
		jpane2.add(toolBar2);
		jpane3.setLayout(new BorderLayout());	
//		jpane3.setPreferredSize(new Dimension(200,200));
		jpane3.add(toolBar3);
		FlowLayout flo=new FlowLayout(FlowLayout.CENTER,60,1);
		jpane4.setLayout(flo);
		
//		jpane4.setPreferredSize(new Dimension(200,200));
		
		jpane4.add(toolBarE);	
		jpane4.add(toolBar4);
		
	}
	public void showMe() {
		this.init();
		this.addEventHandler();

		GridLayout grid = new GridLayout(4,1);
		jFrame.setLayout(grid);
		jFrame.setBounds(0,0,400,300);
		jFrame.setVisible(true);	
		
		jFrame.add(jpanel);
		jFrame.add(jpane2);
		jFrame.add(jpane3);
		jFrame.add(jpane4);
		//jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void addEventHandler() {
		jbuttonCondition.addActionListener(new ConditionQueryHandler());
		jbuttonField.addActionListener(new FieldQueryHandler());
		jbuttonVague.addActionListener(new VagueQueryHandler());
		jbuttonExit.addActionListener(new ExitHandler());
	}
	public class ConditionQueryHandler implements ActionListener{
		public void actionPerformed(ActionEvent events) {
			jFrame.dispose();
			new ConditionDialog(judgement).showMe();
		} 
	}
	public class FieldQueryHandler implements ActionListener{
		public void actionPerformed(ActionEvent events) {
			jFrame.dispose();
			new FieldDialog(judgement).showMe();
		} 
	}
	public class VagueQueryHandler implements ActionListener{
		public void actionPerformed(ActionEvent events) {
			jFrame.dispose();
			new VagueDialog(judgement).showMe();
		} 
	}
	private class ExitHandler implements ActionListener{
		public void actionPerformed(ActionEvent events) {
			jFrame.dispose();
		}
	}

}
