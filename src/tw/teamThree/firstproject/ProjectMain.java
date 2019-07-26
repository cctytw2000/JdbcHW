package tw.teamThree.firstproject;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProjectMain {

	public static void main(String[] args) throws IOException, SQLException {
		while (true) {
			System.out.println("please insert your username");
			Scanner username_sca = new Scanner(System.in);
			String username = username_sca.next();
			System.out.println("please insert your password");
			Scanner password_sca = new Scanner(System.in);
			String password = password_sca.next();
			Member mb = new Member();
			mb.setAccount(username);
			mb.setPassword(password);
//			System.out.println(mb.getAccount());
//			System.out.println(mb.getPassword());

			IMemberDao MBDF = MemberDaoFactory.createMember();
			MBDF.createConn();
			int member_id = MBDF.fintById(mb);
			System.out.println(member_id);
			MBDF.closeConn();
			if (member_id != 0) {
				System.out.println("您需要甚麼");
				System.out.println("1.產生數組");
				System.out.println("2觀看數組");
				Scanner change_sca = new Scanner(System.in);
				int change = change_sca.nextInt();

				if (change == 1) {

					System.out.println("你需要產生多少數組");
					Scanner count_sca = new Scanner(System.in);
					int count = count_sca.nextInt();
					for (int i = 0; i < count; i++) {
						LuckyNumbers LNS = new LuckyNumbers();
						ArrayList<Integer> LN_list = new ArrayList<Integer>();
						LuckNumberMaker LNM = new LuckNumberMaker();

						int[][] MathArry = LNM.makeArray();
						int[] LuckNumber_top6 = new int[6];
						int[][] ArrayFormat = LNM.NumberFormat(MathArry);

						for (int i1 = 0; i1 < 6; i1++) {
							LuckNumber_top6[i1] = ArrayFormat[0][i1];

						}
						int[] formatLuckNumber = LNM.NumberFormat(LuckNumber_top6);
						for (int j = 0; j < formatLuckNumber.length; j++) {
							LN_list.add(j, formatLuckNumber[j]);
						}

						LNS.setLuckyNumber(LN_list);

						ILuckyNumberDao LNDF = LuckyNumberDaoFactory.createLuckyNumber();
						LNDF.createConn();
						LNDF.add(LNS, member_id);
						LNDF.closeConn();
					}
				} else if (change == 2) {
					ILuckyNumberDao LNDF = LuckyNumberDaoFactory.createLuckyNumber();
					LNDF.createConn();
					LNDF.fintById(member_id);
					LNDF.closeConn();
				}
			} else {
				System.out.println("帳號或密碼錯誤");
			}
		}
	}
}
