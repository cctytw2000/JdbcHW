package tw.teamThree.firstproject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import tw.projectnumber35.firstproject.ConnSQLserver;

public class LuckyNumberDaoJdbcImpl implements ILuckyNumberDao {
	private Connection conn;
	private ConnSQLserver jdbc;

	public LuckyNumberDaoJdbcImpl() throws IOException, SQLException {
		jdbc = new ConnSQLserver();
	}

	@Override
	public void createConn() throws SQLException {
		conn = jdbc.getConnection();
		System.out.println("status  " + !conn.isClosed());

	}

	@Override
	public void closeConn() throws SQLException {
		jdbc.closeConn();

	}

	@Override
	public void update(LuckyNumbers LN) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int member_id, int ln_id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void fintById(int member_id) throws SQLException {
		String sqlcode = "select top1,top2,top3,top4,top5,top6,createDate from LuckyNumber where members_id =?";
		PreparedStatement state = conn.prepareStatement(sqlcode);
		state.setInt(1, member_id);
		ResultSet rs = state.executeQuery();
		ResultSetMetaData metadata = rs.getMetaData();
		int columnCount = metadata.getColumnCount();
		for (int i = 1; i <= columnCount; i++) {

			String name = metadata.getColumnName(i);
			System.out.print(name + "\t");

		}
		System.out.println();
		while (rs.next()) {
			for (int i = 1; i <= columnCount; i++) {

				System.out.print(rs.getString(i) + "\t");

			}
			System.out.println();
		}

	}

	@Override
	public void add(LuckyNumbers LN, int memberid) throws SQLException {
		String sqlcode = "insert into LuckyNumber(top1,top2,top3,top4,top5,top6,members_id) values(?,?,?,?,?,?,?)";
		PreparedStatement state = conn.prepareStatement(sqlcode);
		for (int i = 0; i < LN.getLuckyNumber().size(); i++) {

			state.setInt(i + 1, LN.getLuckyNumber().get(i));
		}
		state.setInt(7, memberid);
		int count = state.executeUpdate();
		System.out.printf("您新增%d筆資料\n", count);
		state.close();

	}

}
