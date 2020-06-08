package shuben;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class ConcernDialog extends JFrame{

	private JButton labelE;
	private JToolBar toolBar1;
	private JFrame jframe=new JFrame();
	private JLabel text = new JLabel("成员：");
	public ConcernDialog() {
		labelE=new JButton(new ImageIcon(this.getClass().getResource("menu.gif")));
		labelE.setToolTipText("返回主菜单");
		labelE.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				jframe.dispose();
				new Menu().showMe();
			}
		});
	}
	private void init(){
		GridLayout grid1=new GridLayout(2,1,100,10);
		jframe.setLayout(grid1);
		
		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();
		toolBar1 = new JToolBar();
		toolBar1.add(labelE);
		panel.add(text);
		panel1.add(toolBar1);
//		jframe.add(panel);
//		jframe.add(panel1);
		jframe.add(BorderLayout.NORTH,panel);
		jframe.add(BorderLayout.CENTER,panel1);
	}
	public void showMe(){
		
		init(); 
		jframe.setVisible(true);
		jframe.validate();	
		jframe.setBounds(50,50,300,200);
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
