package dao;

import java.util.HashMap;
import java.util.List;

import vo.BoardVO;
// 인터페이스
public interface BoardMapper {
	// 추상 메서드 
	public int insertBoard(BoardVO board);
	
	public List<HashMap<String, Object>> selectAllBoard();
	
	public List<BoardVO> selectMyBoard(String memberId);
	
}
