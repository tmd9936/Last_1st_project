package human.vo;

public class User {
	private int hno;
	private String name;
	private String jumin;
	private String id;
	private String pass;
	private int money;
	
	
	public User() {}



	public User(String name, String jumin, String id, String pass) {
		this.name = name;
		this.jumin = jumin;
		this.id = id;
		this.pass = pass;
	}


	public int getHno() {
		return hno;
	}


	public void setHno(int hno) {
		this.hno = hno;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getJumin() {
		return jumin;
	}


	public void setJumin(String jumin) {
		this.jumin = jumin;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money = money;
	}


	@Override
	public String toString() {
		return "User [hno=" + hno + ", name=" + name + ", jumin=" + jumin + ", id=" + id + ", pass=" + pass + ", money="
				+ money + "]";
	}
	
	
}
