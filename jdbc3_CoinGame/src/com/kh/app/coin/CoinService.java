package com.kh.app.coin;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.kh.app.driver.JDBCTemplate;

public class CoinService {
    private CoinDao coinDao = new CoinDao();

    public int buyCoin(String playerName, int menuNo, int count) throws Exception {
        Connection conn = null;
        int result = 0;
        try {
            conn = JDBCTemplate.getConn();

            CoinVo coin = coinDao.getCoinByNo(conn, menuNo);
            PlayerVo player = coinDao.getPlayerByName(conn, playerName);

            int totalPrice = coin.getPrice() * count;
            if (player.getMoney() < totalPrice) {
                throw new Exception("잔액이 부족합니다.");
            }

            coinDao.minusPlayerMoney(conn, playerName, totalPrice);
            coinDao.insertPlayerCoin(conn, playerName, coin.getName(), count);

            conn.commit();
            result = 1;
        } catch (Exception e) {
            conn.rollback();
       
        } finally {
           conn.close();
        }
        return result;
    }

	public int sellCoin(String playerName, int menuNo, int count) throws Exception {
        Connection conn = null;
        int result = 0;
        try {
            conn = JDBCTemplate.getConn();

            CoinVo coin = coinDao.getCoinByNo(conn, menuNo);
            PlayerVo player = coinDao.getPlayerByName(conn, playerName);

            int totalPrice = coin.getPrice() * count;

            coinDao.plusPlayerMoney(conn, playerName, totalPrice);
            coinDao.updatePlayerCoin(conn, playerName, coin.getName(), count);

            conn.commit();
            result = 1;
        } catch (Exception e) {
            conn.rollback();
       
        } finally {
           conn.close();
        }
        return result;
	}


	public List<PlayerCoin> printmyCoin(String playerName) throws Exception {
        Connection conn = null;
        int result = 0;
        conn = JDBCTemplate.getConn();

        PlayerVo player = coinDao.getPlayerByName(conn, playerName);
        List<PlayerCoin> coinVoList = coinDao.printmyCoin(conn, playerName);
        
        conn.close();

        return coinVoList;
	}
}
