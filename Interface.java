package shuben;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Interface extends JFrame{
	private JFrame f;
	private JButton labelA;
	private JButton labelU;
	private JLabel label1;
	public Interface() {
		f = new JFrame();
		label1=new JLabel("欢迎来到文献管理系统");
		labelU=new JButton("用户入口");
		labelA=new JButton("管理员入口");
		labelA.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				new LoginInterface().showMe();
			}
		});	
	}
	public void init() {
		
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		p1.setLayout(new FlowLayout());
		p1.add(label1);
		p2.setLayout(new FlowLayout());
		p2.add(labelA);
		p2.add(labelU);
		f.add(p1);
		f.add(p2);
		f.add(BorderLayout.NORTH,p1);
		f.add(BorderLayout.CENTER,p2);
	}
	public void showMe() {
		init();
		labelU.addActionListener(new A());
		f.setBounds(30,60,300,150);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public class A implements ActionListener{
		public void actionPerformed(ActionEvent events) {
			f.dispose();
			new Menu1().showMe();
		
		}  		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Interface().showMe();
	}

}
