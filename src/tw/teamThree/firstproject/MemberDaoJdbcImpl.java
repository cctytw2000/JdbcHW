package tw.teamThree.firstproject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tw.projectnumber35.firstproject.ConnSQLserver;

public class MemberDaoJdbcImpl implements IMemberDao {
	private ConnSQLserver jdbc;
	private Connection conn;

	public MemberDaoJdbcImpl() throws IOException, SQLException {
		jdbc = new ConnSQLserver();
	}

	@Override
	public int add(Member mb) throws SQLException {
		String account = mb.getAccount();
		String pwd = mb.getPassword();
		String sqlcode = "select * from members where username = ? and password = ?  ";// and isactive = 1
		PreparedStatement state = conn.prepareStatement(sqlcode);
		state.setString(1, mb.getAccount());
		state.setString(2, mb.getPassword());
		ResultSet rs = state.executeQuery();
		boolean checkstatus = rs.next();
		System.out.println("checkstatus====" + checkstatus);

		if (checkstatus) {
			int id = rs.getInt(1);
			System.out.println("welcome to Data Base.");
//			System.out.println("id=" + rs.getInt(1));
//			callTestjdbcConnDataSource self_class = new callTestjdbcConnDataSource();
//			self_class.insertMemberLoginTime(rs.getInt(1));

			rs.close();
			state.close();
			return id;
		} else {
//			System.out.println("username or password Error");
			rs.close();
			state.close();
			return 0;
		}

	}

	@Override
	public void update(Member mb) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int member_id, int ln_id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public int fintById(Member mb) throws SQLException {
		String sqlcode = "select * from members where username = ? and password = ?  ";// and isactive = 1
		PreparedStatement state = conn.prepareStatement(sqlcode);
		state.setString(1, mb.getAccount());
		state.setString(2, mb.getPassword());
		ResultSet rs = state.executeQuery();
		boolean checkstatus = rs.next();
		System.out.println("checkstatus====" + checkstatus);

		if (checkstatus) {
			int id = rs.getInt(1);
			System.out.println("welcome to Data Base.");
//			System.out.println("id=" + rs.getInt(1));
//			callTestjdbcConnDataSource self_class = new callTestjdbcConnDataSource();
//			self_class.insertMemberLoginTime(rs.getInt(1));

			rs.close();
			state.close();
			return id;
		} else {
//			System.out.println("username or password Error");
			rs.close();
			state.close();
			return 0;
		}

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

}
