package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import vo.BoardVO;

public class BoardDAO {
	SqlSessionFactory factory = 
			MybatisConfig.getSqlSessionFactory();
	
	public int insertBoard(BoardVO board) {
		SqlSession session = null;
		int result = 0; 
		
		try {
			session = factory.openSession();
			BoardMapper bMapper = session.getMapper(BoardMapper.class);
			
			result = bMapper.insertBoard(board);
			session.commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return result;
	}
	
	public List<HashMap<String, Object>> selectAllBoard(){
		SqlSession session = null;
		List<HashMap<String, Object>> bList = null;
		
		try {
			session = factory.openSession();
			BoardMapper bMapper = session.getMapper(BoardMapper.class);
			
			bList = bMapper.selectAllBoard();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return bList;
	}
	
	public List<BoardVO> selectMyBoard(String memberId){
		SqlSession session = null;
		List<BoardVO> bList = null;
		
		try {
			session = factory.openSession();
			BoardMapper bMapper = session.getMapper(BoardMapper.class);
			
			bList = bMapper.selectMyBoard(memberId);
		} catch(Exception e) {
			e.printStackTrace();
		} finally { 
			if(session != null) session.close();
		}
		
		return bList;
	}
	
	
}
