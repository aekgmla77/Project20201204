package stream;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class StreamMain {
	private static final int StreamVO = 0;
	Connection conn = null;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	
	public List {
		conn = DAO.getConnection();
		sql = "SELECT employee_id, first_name, email, salary"+
				"FROM emp1" +
				"WHERE salary >= 10000";
		List list = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
		}
	}
}
