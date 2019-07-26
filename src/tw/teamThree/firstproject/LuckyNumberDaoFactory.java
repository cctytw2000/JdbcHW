package tw.teamThree.firstproject;

import java.io.IOException;
import java.sql.SQLException;



public class LuckyNumberDaoFactory {

	public static ILuckyNumberDao createLuckyNumber() throws IOException, SQLException {
		ILuckyNumberDao LNDao = new LuckyNumberDaoJdbcImpl();
		return LNDao;

	}

}


