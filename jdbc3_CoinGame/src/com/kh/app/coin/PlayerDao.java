package com.kh.app.coin;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PlayerDao {
	//플레이어 생성
	public int addPlayer(Connection conn, PlayerVo playerVo) throws Exception {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			//쿼리준비
			String sql = "INSERT INTO PLAYER (NO, NAME, MONEY) VALUES(SEQ_PLAYER.NEXTVAL,?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, playerVo.getName());
			pstmt.setInt(2, playerVo.getMoney());
			
			//쿼리실행
			result = pstmt.executeUpdate();
		} finally {
			//자원 반납
			pstmt.close();
		}
		
		return result;
	}
}
