package chatProgram;

/*
 * KwangWoon University
 * 2019�⵵ 1�б� ��ü�������α׷��ֽǽ� 
 * ����������Ʈ
 * ������Ű��а� 2014707073 ���ȯ
 * ���� : ��Ƽĳ��Ʈ ���� ä�� ���α׷�
 * Class : �� user�� �����͸� ������ �ִ� Ŭ����
 */

public class UserData {
	private String id;
	private String pw;
	private String name;
	
	/* UserData ������ */
	UserData(){
		id=null;
		pw=null;
		name=null;
	}

	/* Set & Get Method */

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/* Set & Get Method */
}
