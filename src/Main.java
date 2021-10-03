import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			
			String dbFile = "myfirst.db";
			try {
				con = DriverManager.getConnection("jdbc:sqlite:"+dbFile);
				
				System.out.println("\n*** ������ ��ȸ ***");
				Statement stat1 = con.createStatement();
				String sql1 = "select * from g_artists";
				ResultSet rs1 = stat1.executeQuery(sql1);
				while (rs1.next()) {
					String id = rs1.getString("id");
					String name = rs1.getString("name");
					String a_type = rs1.getString("a_type");
					String a_year = rs1.getString("a_year");
					String debut = rs1.getString("debut");
					String regdate = rs1.getString("regdate");
					System.out.println(id+" "+name+" "+a_type+" "+a_year+" "+debut+" "+regdate);
				}
				stat1.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} //finally {
//			if (con != null) {
//				try {
//					con.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}


// ������ �߰�
//		System.out.println("\n*** �� ������ �߰� ***");
//		try {
//			Statement stat2 = con.createStatement();
//			
//			String[] sql2 = new String[]{"insert into g_artists (name, a_type, a_year, debut, regdate)"+ " values ('BTS', 'male', '2010s', '2013', datetime('now', 'localtime'))",
//			"insert into g_artists (name, a_type, a_year, debut, regdate)"+ " values ('Espa', 'female', '2020s', '2019', datetime('now', 'localtime'))",
//			"insert into g_artists (name, a_type, a_year, debut, regdate)"+ " values ('Girlfriend', 'female', '2010s', '2014', datetime('now', 'localtime'))",
//			"insert into g_artists (name, a_type, a_year, debut, regdate)"+ " values ('BigBang', 'male', '2000s', '2005', datetime('now', 'localtime'))",
//			"insert into g_artists (name, a_type, a_year, debut, regdate)"+ " values ('2ne1', 'female', '2010s', '2008', datetime('now', 'localtime'))"};
//			
//			for(int i = 0; i < 4; i++) {
//				int cnt = stat2.executeUpdate(sql2[i]);
//				if(cnt > 0)
//					System.out.println("���ο� �����Ͱ� �߰��Ǿ����ϴ�.");
//				else
//					System.out.println("[Error] ������ �߰� ����!");
//				stat2.close();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if (con != null) {
//			try {
//				con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	������ ����
//		System.out.println("\n*** ������ ���� ***");
//		try {
//			Statement stat3 = con.createStatement();
//			String sql3 = "update g_artists set name = 'Boyfriends' " + "where id=5;";
//			int cnt3 = stat3.executeUpdate(sql3);
//			if(cnt3 > 0)
//				System.out.println("�����Ͱ� �����Ǿ����ϴ�.");
//			else
//				System.out.println("[Error] ������ ���� ����!");
//			stat3.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if (con != null) {
//				try {
//					con.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		
//	������ ���� 
		System.out.println("\n*** ������ ���� ***");
		try {
			Statement stat4 = con.createStatement();
			String sql4 = "delete from g_artists where id=7;";
			int cnt4 = stat4.executeUpdate(sql4);
			if(cnt4 > 0)
				System.out.println("�����Ͱ� �����Ǿ����ϴ�.");
			else
				System.out.println("[Error] ������ ���� ����!");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
		

