package freeasg;

public class BookkingCusInfo {

	String name;
	int cusCount;
	String seat;

	public BookkingCusInfo(String name,int cusCount,String seat) {
		super();
		this.name = name;
		this.cusCount = cusCount;
		this.seat = seat;
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
}
