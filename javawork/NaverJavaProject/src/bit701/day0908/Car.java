package bit701.day0908;

public class Car {
	//필드 선언
	private String company;
	private String model;
	private String color;
	private boolean start;
	private int maxSpeed;
	private int speed;
	
	public void setCompany(String company) {
		this.company=company;
	}
	public void setModel(String model) {
		this.model=model;
	}
	public void setColor(String color) {
		this.color=color;
	}
	public void setStart(boolean start) {
		this.start=start;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed=maxSpeed;
	}
	public void setSpeed(int speed) {
		this.speed=speed;
	}
	
	public String getCompany() {
		return company;
	}
	public String getModel() {
		return model;
	}
	public String getColor() {
		return color;
	}
	public boolean getStart() {
		return start;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public int getSpeed() {
		return speed;
	}
}
