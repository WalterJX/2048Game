package edu.scu.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * Inherit BaseDao to achieve Game database connection
 * */

public class GameDao extends BaseDao{
	
	// get all game information
	public Integer[][] getGame() {
		Integer[][] game = null;
		
        try{
            String sql;
            sql = "SELECT * FROM games";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
            	game = getGame(rs);
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(Exception se){
            se.printStackTrace();
        }
		return game;
	}
	
	// a helper to access every column in game table
	private Integer[][] getGame(ResultSet rs) throws SQLException {
		Integer[][] res = new Integer[4][4];
		String[] strs = {"zero","one","two","three"};
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				res[i][j] = rs.getInt(strs[i]+"_"+strs[j]);
				
			}
		}
		return res;
	}
	// insert gamedate to game table
	public Integer insertGameData(Integer[][] game) {
		
		int res = 0;
        try{
    		String sql = "insert into games values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    		PreparedStatement ps = conn.prepareStatement(sql);
    		int idx = 1;
    		for (int i = 0; i < 4; i++) {
    			for (int j = 0; j < 4; j++) {
    				ps.setInt(idx++, game[i][j]);
    			}
    		}
    		res = ps.executeUpdate();
            stmt.close();
            conn.close();
        }catch(Exception se){
            se.printStackTrace();
        }
		return res;
	}
	
	// delete the first data in game table
	public Integer deleteGameData() {
		
		int res = 0;
        try{
    		String sql = "delete from games limit 1";
    		PreparedStatement ps = conn.prepareStatement(sql);
    		ps.executeUpdate();
            
            stmt.close();
            conn.close();
        }catch(Exception se){
            se.printStackTrace();
        }
		return res;
	}

	// test game table functions
	public static void main(String[] args) {
		GameDao dao = new GameDao();
//		Integer[][] array = {{1,2,3,4},{0,2,3,3}, {5,6,7,8}, {1,2,3,4}};
//		dao.insertScore(array);
//		Integer[][] array = dao.getGame();
//
//		for (int i = 0; i < 4; i++) {
//			for (int j = 0; j < 4; j++) {
//				System.out.println(array[i][j]);
//			}
//		}
		
		dao.deleteGameData();
	}
	
}
