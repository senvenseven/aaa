package shuben;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FieldDialog extends JFrame{
	private int judgement;
	private JFrame frame;
	private JButton labelE;
	public FieldDialog(int judgement){
		this.judgement = judgement;
		frame = new JFrame();
		labelE=new JButton("·µ»ØÖ÷²Ëµ¥");
		labelE.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new JudgeMenu(judgement).Judge();
			}
		});
	}	
	public void showMe(){
		JPanel p = new JPanel();
		p.add(labelE);
		frame.add(p);
		frame.add(BorderLayout.NORTH,p);
		frame.add(BorderLayout.CENTER,p);
		frame.setBounds(50,50,300,120);
		frame.setVisible(true);
	}
}