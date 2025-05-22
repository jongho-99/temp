package com.kh.app.coin;

import java.sql.Connection;

import com.kh.app.driver.JDBCTemplate;

public class PlayerService {
	PlayerDao playerDao = new PlayerDao();
	
	public int addPlayer(PlayerVo playerVo) throws Exception {
		int result = 0;
		Connection conn = null;
		try {
			//비즈니스 로직	
			if(playerVo.getName().length() < 2 || playerVo.getMoney() < 1000000) {
				throw new Exception();
			}
			
			//디비연결
			conn = JDBCTemplate.getConn();
			
			//DAO 호출
			result = playerDao.addPlayer(conn, playerVo);
			//트랜잭션 처리
			if(result == 1) {
				conn.commit();
			}
			else {
				conn.rollback();
			}
				
			
		} finally {
			//자원 반납
			conn.close();
			
		}
		return result;
	}
}
