package shuben;

public class JudgeMenu {
	private int judgement;
	public JudgeMenu(int judgement) {
		this.judgement = judgement;
	}
	public void Judge() {
		if(judgement == 1) {
			new Menu().showMe();
		}
		if(judgement == 0) {
			new Menu1().showMe();
		}
	}
}
