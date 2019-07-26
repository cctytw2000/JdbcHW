package tw.teamThree.firstproject;

import java.sql.SQLException;

public interface ILuckyNumberDao {
	public void add(LuckyNumbers LN,int memberid) throws SQLException;

	public void update(LuckyNumbers LN) throws SQLException;

	public void delete(int member_id, int ln_id) throws SQLException;

	public void fintById(int member_id) throws SQLException;

	public void createConn() throws SQLException ;

	public void closeConn() throws SQLException;


}
