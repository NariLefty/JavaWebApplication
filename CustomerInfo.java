package freeasg;

public class CustomerInfo {

	private int number;
	private String name;
	private int cusCount;
	private String seat;
	private String cusTime;

	public CustomerInfo(int number,String name,int cusCount,String seat,String cusTime) {
		this.number = number;
		this.name = name;
		this.cusCount = cusCount;
		this.seat = seat;
		this.cusTime = cusTime;
	}

	public CustomerInfo() {

	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCusCount() {
		return cusCount;
	}

	public void setCusCount(int cusCount) {
		this.cusCount = cusCount;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getCusTime() {
		return cusTime;
	}

	public void setCusTime(String cusTime) {
		this.cusTime = cusTime;
	}
}
