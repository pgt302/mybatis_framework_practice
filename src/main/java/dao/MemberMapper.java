package dao;

import vo.MemberVO;

public interface MemberMapper {
	public int insertMember(MemberVO member);
	
	public MemberVO selectOneMember(String memberId);
	
	public int updatePassword(MemberVO member);
	
	public int updatePhone(MemberVO member);
	
	public int updateEmail(MemberVO member);
	
	public int deleteMember(String memberId);
	
}
