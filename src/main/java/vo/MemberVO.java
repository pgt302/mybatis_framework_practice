package vo;

public class MemberVO {
	private String memberId;
	private String password;
	private String email;
	private String phone;
	
	public MemberVO() {}
	public MemberVO(String memberId, String password, String email, String phone) {
		this.memberId = memberId;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		String info = 	"접속하신 회원님의 정보는 ";
		info += "id: " + memberId;
		info += " 이메일: " + email;
		info += " 전화번호: " + phone;
		info += "입니다.";
		return info;
	}
}
