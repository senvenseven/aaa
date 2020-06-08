package shuben;
	import java.awt.BorderLayout;
	import java.awt.FlowLayout;
	import java.awt.GridLayout;
	import java.awt.Panel;
import java.awt.Window;
import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JTextField;

	public class LoginInterface extends JFrame{
		private JFrame jFrame;
		private JButton button1;
		private JButton button2;
		private JButton button3;
//		private JButton button4;
		private JLabel label;
		private JTextField textField;
		public LoginInterface() {
			jFrame = new JFrame("管理员登录");
			label = new JLabel("密码");
			textField = new JTextField(20);
			button1 = new JButton("登录");
			button2 = new JButton("清除");
			button3 = new JButton("退出");
//			button3.addActionListener(new ActionListener(){
//				public void actionPerformed(ActionEvent e) {
//					new Menu().showMe();
//				}
//			});
			
		}
		
		private void init() {
			Panel northPanel = new Panel();
			northPanel.add(label);
			northPanel.add(textField);
			Panel centerPanel = new Panel();
			FlowLayout grid = new FlowLayout();
			centerPanel.setLayout(grid);
			centerPanel.add(button1);
			centerPanel.add(button2);
			centerPanel.add(button3);
			jFrame.add(northPanel,BorderLayout.NORTH);
			jFrame.add(centerPanel,FlowLayout.CENTER);
		}
		
		public void showMe() {
			init();
			button1.addActionListener(new LoginButtonActionHandler());
			button2.addActionListener(new ClearButtonActionHandler());
			button3.addActionListener(new ExitButtonActionHandler());
			jFrame.setBounds(50,50,400,200);
			jFrame.setVisible(true);
			
		}
		private class LoginButtonActionHandler implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				String password;
				password = textField.getText();
				Session session;
				session = new SessionController().adminLogin(password);
				if(!(session.equals(null))) {
					jFrame.dispose();
					new Menu().showMe();
				}
			}
		}
		private class ClearButtonActionHandler implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}	
		}
		private class ExitButtonActionHandler implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
				new Interface().showMe();
				jFrame.dispose();
			}
		}
//		public static void main(String[] args) {
//			new LoginInterface().showMe();
//		}
	}

