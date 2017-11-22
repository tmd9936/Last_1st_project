package human.vo;

public class Admin {
	private int ano;
	private String id;
	private String pass;

	public Admin() {
	}

	public Admin(String id, String pass) {
		super();
		ano = 1;
		this.id = id;
		this.pass = pass;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
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

	@Override
	public String toString() {
		return "Admin [ano=" + ano + ", id=" + id + ", pass=" + pass + "]";
	}
	
	

}
