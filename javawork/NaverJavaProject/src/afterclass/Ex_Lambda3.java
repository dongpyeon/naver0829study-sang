package afterclass;
class Button{
	@FunctionalInterface
	interface ClickListener{
		public void onClick();
	}
	private ClickListener clickListener;
	
	public void setClickListener(ClickListener clickListener) {
		this.clickListener = clickListener;
	}
	public void click() {
		this.clickListener.onClick();
	}
}
public class Ex_Lambda3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Button btn = new Button();
		btn.setClickListener(()->{
			System.out.println("Ok버튼을 클릭했습니다.");
		});
		btn.click();
		
		Button btnCancel = new Button();
		
		btnCancel.setClickListener(()->{
			System.out.println("Cancel 버튼을 클릭했습니다.");
		});
		btnCancel.click();
	}

}
