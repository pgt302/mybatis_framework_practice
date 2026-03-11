package dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import vo.MemberVO;

public class MemberDAO {
	
	//전역변수로 선언한 SqlSessionFactory 객체
	SqlSessionFactory factory 
		= MybatisConfig.getSqlSessionFactory();
	
	public MemberVO selectOneMember(String memberId) {
		SqlSession session = null;
		MemberVO member = null;
		try {
			session = factory.openSession();
			MemberMapper mMapper = session.getMapper(MemberMapper.class);
			
			member = mMapper.selectOneMember(memberId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return member;
	}
	
	
	public int insertMember(MemberVO member) {
		SqlSession session = null;
		int result = 0; 
		
		try {
			session = factory.openSession();
			MemberMapper mMapper = session.getMapper(MemberMapper.class);
			
			result = mMapper.insertMember(member);
			session.commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return result;
	}
	
	public int updatePassword(MemberVO member) {
		SqlSessionFactory factory
			= MybatisConfig.getSqlSessionFactory();
		SqlSession session = null;
		int result = 0;
		try {
			session = factory.openSession();
			MemberMapper mMapper = session.getMapper(MemberMapper.class);
			
			result = mMapper.updatePassword(member);
			session.commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return result;
	}
	
	public int updatePhone(MemberVO member) {
		SqlSessionFactory factory 
			= MybatisConfig.getSqlSessionFactory();
		SqlSession session = null;
		int result = 0;
			
		try {
			session = factory.openSession();
			MemberMapper mMapper = session.getMapper(MemberMapper.class);
			
			result = mMapper.updatePhone(member);
			session.commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return result;
	}
	
	public int updateEmail(MemberVO member) {
		SqlSession session = null;
		int result = 0;
		
		try {
			session = factory.openSession();
			MemberMapper mMapper = session.getMapper(MemberMapper.class);
			
			result = mMapper.updateEmail(member);
			session.commit();
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return result;
	}
	
	public int deleteMember(String memberId) {
		SqlSession session = null;
		int result = 0;
		
		try {
			session = factory.openSession();
			MemberMapper mMapper = session.getMapper(MemberMapper.class);
			
			result = mMapper.deleteMember(memberId);
			session.commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return result;
	}
}
