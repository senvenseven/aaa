package shuben;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class Menu1 extends JFrame{
	private int judgement = 0;
	private JFrame frame;
	private JButton labelS;
	private JButton label1;
	private JButton label2;
	private JToolBar toolBar1;
	private JToolBar toolBar2;
	private JToolBar toolBar3;
	private JMenuItem jmiField,jmiVague,jmiCondition;
	private UserDao userDao;
	JPanel p = new JPanel();
	JPanel p1 = new JPanel();
//	public static void main(String[] args) throws IOException{
//		new Menu().showMe();
//	}
	public Menu1() {
		frame = new JFrame("文献管理系统");
		toolBar1 = new JToolBar();
		toolBar2 = new JToolBar();
		toolBar3 = new JToolBar();
		userDao=new UserDaoImplForList();
		labelS=new JButton("文献查询", new ImageIcon(this.getClass().getResource("Select1.gif")));
		label1=new JButton("关于", new ImageIcon(this.getClass().getResource("Concern.gif")));
		label2=new JButton( new ImageIcon(this.getClass().getResource("Exit.gif")));
		label2.setToolTipText("退出");
		labelS.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new SelectDialog(judgement).showMe();
			}
		});
		label1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new ConcernDialog().showMe();
			}
		});	
	}
	public void createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu selectMenu = new JMenu("文献查询");
		selectMenu.setMnemonic(KeyEvent.VK_N);
		menuBar.add(selectMenu);
		selectMenu.add(jmiField = new JMenuItem("按字段查询"));
		//jmiField.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		selectMenu.add(jmiCondition = new JMenuItem("按条件查询"));
		//jmiCondition.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		selectMenu.add(jmiVague = new JMenuItem("模糊查询"));
		
		//jmiVague.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		frame.setJMenuBar(menuBar);
	}
public void init() {
	
		//JPanel jpanel=new JPanel();
		//setLayout(new FlowLayout(FlowLayout.RIGHT,100,100));
		//setLayout(new GridLayout(2,2,50,50));
		createMenuBar();
		
	//	GridLayout grid=new GridLayout(2,1,20,20);
	//  frame.setLayout(grid);
	//	frame.setPreferredSize(new Dimension(400,200));
		//this.add("Center",p);
		toolBar1.add(labelS);
		p.add(toolBar1);
		toolBar2.add(label1);
		toolBar3.add(label2);
		FlowLayout flo=new FlowLayout(FlowLayout.CENTER,60,1);
		p1.setLayout(flo);
		//p.add(labelS);
		p1.add(toolBar2);
		//p1.add(label1);
		p1.add(toolBar3);
		//p1.add(label2);	
//		frame.add(p,BorderLayout.NORTH);
//		frame.add(p1,BorderLayout.CENTER);
		
//		this.add(BorderLayout.SOUTH,p);
//		this.add(BorderLayout.CENTER,p);
		
	}
	public void showMe(){
		init();
		this.addEventHandler();
		GridLayout grid=new GridLayout(2,1,20,20);
		frame.setLayout(grid);
		
		frame.setTitle("文献管理系统");
		frame.setBounds(0,0,400,200);
//		frame.pack();
		frame.setVisible(true);
		frame.add(p,BorderLayout.CENTER);
		frame.add(p1,BorderLayout.SOUTH);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void addEventHandler(){
		jmiField.addActionListener(new FieldHandler());
		jmiVague.addActionListener(new VagueHandler());
		jmiCondition.addActionListener(new ConditionHandler());
		label2.addActionListener(new ExitHandler());
	}
	private class FieldHandler implements ActionListener{
		public void actionPerformed(ActionEvent events) {
			frame.dispose();
			new FieldDialog(judgement).showMe();
		}  		
	}
	private class VagueHandler implements ActionListener{
		public void actionPerformed(ActionEvent events) {
			frame.dispose();
			new VagueDialog(judgement).showMe();
		}  		
	}
	private class ConditionHandler implements ActionListener{
		public void actionPerformed(ActionEvent events) {
			frame.dispose();
			new ConditionDialog(judgement).showMe();
		}  		
	}
	public class ExitHandler implements ActionListener{
		public void actionPerformed(ActionEvent events) {
			new Interface().showMe();
			frame.dispose();
		}  		
	}
}
