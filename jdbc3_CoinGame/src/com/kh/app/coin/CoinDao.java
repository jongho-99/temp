package com.kh.app.coin;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


//COinDao
public class CoinDao {
	
	//코인번호로 코인정보 객체 얻어오기
	 public CoinVo getCoinByNo(Connection conn, int menuNo) throws Exception {
	        String sql = "SELECT * FROM COIN WHERE NO = ?";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, menuNo);
	        ResultSet rs = pstmt.executeQuery();
	                if (rs.next()) {
	                	CoinVo coinVo = new CoinVo(rs.getInt("NO"), rs.getString("NAME"), rs.getInt("PRICE"));
	                	return coinVo;
	                } else {
	                    throw new Exception("해당 번호의 코인이 존재하지 않습니다.");
	                }
	  }
	 
	 //전체정보 코인 정보 얻어오기 (오버로딩)
	 public CoinVo getCoinByNo(Connection conn) throws Exception {
	        String sql = "SELECT * FROM COIN WHERE NO = ?";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	                if (rs.next()) {
	                	CoinVo coinVo = new CoinVo(rs.getInt("NO"), rs.getString("NAME"), rs.getInt("PRICE"));
	                	return coinVo;
	                } else {
	                    throw new Exception("해당 번호의 코인이 존재하지 않습니다.");
	                }
	            }
	        
	    
	 //플레이어 이름으로 플레이어정보 객체 얻어오기
	 public PlayerVo getPlayerByName(Connection conn, String name) throws Exception {
        	String sql = "SELECT * FROM PLAYER WHERE NAME = ?";
        	PreparedStatement pstmt = conn.prepareStatement(sql);
    		pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                	PlayerVo playerVo = new PlayerVo(name, rs.getInt("MONEY")); 
                    return playerVo;
                } else {
                    throw new Exception("해당 유저가 존재하지 않습니다.");
                }
            }
	
	 //플레이어 자산 변동 마이너스(UPDATE)
	 public void minusPlayerMoney(Connection conn, String name, int minusMoney) throws Exception {
        String sql = "UPDATE PLAYER SET MONEY = MONEY - ? WHERE NAME = ?";
        	PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, minusMoney);
            pstmt.setString(2, name);
            int result = pstmt.executeUpdate();
            if (result != 1) 
            	throw new Exception("자산 차감 실패");
            
      }
	 
	 //플레이어 자산 변동 플러스(UPDATE)
	 public void plusPlayerMoney(Connection conn, String name, int plusMoney) throws Exception {
	    String sql = "UPDATE PLAYER SET MONEY = MONEY + ? WHERE NAME = ?";
    	PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, plusMoney);
        pstmt.setString(2, name);
        int result = pstmt.executeUpdate();
        if (result != 1) 
        	throw new Exception("자산 증가 실패");
            
      }
	 
	 //플레이어 보유 코인 차감(UPDATE)
	 public void updatePlayerCoin(Connection conn, String name, String coinName, int count) throws Exception {
		 String sql = "UPDATE PLAYER_COIN SET CNT = CNT - ? WHERE NAME = ? AND COINNAME = ?";
		 PreparedStatement pstmt = conn.prepareStatement(sql);
		 pstmt.setInt(1, count);
		 pstmt.setString(2, name);
		 pstmt.setString(3, coinName);
		 
		 int result = pstmt.executeUpdate();
		 if (result != 1) {
			 throw new Exception("코인 cnt 감소 실패");
		 }
	 }
	 
	 
	 
    
	 //플레이어 보유 코인 추가(INSERT)
	 public void insertPlayerCoin(Connection conn, String name, String coinName, int count) throws Exception {
	    String sql = "INSERT INTO PLAYER_COIN (NAME, COINNAME, CNT) VALUES (?, ?, ?)";
	    PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, coinName);
        pstmt.setInt(3, count);
        int result = pstmt.executeUpdate();
        if (result != 1)
        	throw new Exception("코인 구매 기록 저장 실패");
	 }
	 
	 
	 //보유 코인 목록 출력(SELECT)
	public List<PlayerCoin> printmyCoin(Connection conn, String playerName) throws Exception {
		List<PlayerCoin> playerCoinList = new ArrayList<> ();
		String sql = "SELECT * FROM PLAYER_COIN WHERE NAME = ?";
	    PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, playerName);
        
        
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()) {
        	PlayerCoin playerCoin = new PlayerCoin();
        	playerCoin.setName(rs.getString("NAME"));
        	playerCoin.setCoinname(rs.getString("COINNAME"));
        	playerCoin.setCnt(rs.getInt("CNT"));
        	
        	
        	playerCoinList.add(playerCoin);
        }
        
        return playerCoinList;
	}
	 
	 
	 
	 

		 
}
	 

	
	




