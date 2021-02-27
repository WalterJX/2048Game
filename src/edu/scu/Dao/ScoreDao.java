package edu.scu.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScoreDao extends BaseDao{
	
	private List<Score> getAllScores() {
		List<Score> res = new ArrayList<>();
		
        try{
            String sql;
            sql = "SELECT * FROM scores";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
            	res.add(new Score(rs.getInt("id"), rs.getString("name"), rs.getInt("score"), rs.getDate("date")));
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(Exception se){
            se.printStackTrace();
        }
		return res;
	}
	public Integer insertScore(Score score) {
		
		int res = 0;
        try{
    		String sql = "insert into scores(name,score,date)values(?,?,?)";
    		PreparedStatement ps = conn.prepareStatement(sql);
    		ps.setString(1,score.getName());
    		ps.setInt(2, score.getScore());
    		ps.setDate(3, new java.sql.Date(new java.util.Date().getTime()));

    		res = ps.executeUpdate();

            
            stmt.close();
            conn.close();
        }catch(Exception se){
            se.printStackTrace();
        }
		return res;
	}
	public static void main(String[] args) {
		ScoreDao dao = new ScoreDao();
		for (Score s : dao.getAllScores()) {
			System.out.println(s.getDate());
		}
	}
}
