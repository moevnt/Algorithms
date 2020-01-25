package revision;

public class Unit {

	private int number;
	private int r;
	private int c;

	public Unit(int number, int r, int c){
		this.number = number;
		this.r = r;
		this.c = c;
	}

	public int getNumber() {
		return number;
	}

	public int getC() {
		return c;
	}

	public int getR() {
		return r;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setC(int c) {
		this.c = c;
	}

	public void setR(int r) {
		this.r = r;
	}
}
