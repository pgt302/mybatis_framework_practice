package dao;

import java.util.HashMap;
import java.util.List;

import vo.BoardVO;

public interface BoardMapper {
	
	public int insertBoard(BoardVO board);
	
	public List<HashMap<String, Object>> selectAllBoard();
	
	public List<BoardVO> selectMyBoard(String memberId);
	
}
