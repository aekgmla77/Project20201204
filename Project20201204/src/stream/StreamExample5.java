package stream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class StreamExample5 {
	public static void main(String[] args) {
		Connection conn = DAO.getConnection();
		List<EmployeeVO> list = new ArrayList<>(); // collection 선언
		try {
			PreparedStatement psmt = conn.prepareStatement("select * from emp1"); // 예외처리
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				EmployeeVO emp = new EmployeeVO(); // 초기값. 필드에 값이 안 들어있음
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setSalary(rs.getInt("salary"));
				emp.setDepartmentId(rs.getInt("department_id"));
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 2. 선적부서 : 급여합계(평균)
		System.out.println("40부서 사원");
		OptionalDouble avg = list.stream().filter(t -> t.getDepartmentId() == 40) // 없는 값을 넣으면 오류가 뜬다.
				.mapToInt((value) -> value.getSalary())
				.average();
		System.out.println("평균: " + avg.orElse(0.0)); //값이 없으면 () 안에 든 걸로 대체함.(OptionalDouble이 가진 기능)
		
//		avg.ifPresent(new DoubleConsumer() {// avg 값이 있는지 확인용. 있다면 출력하라는 거.
//			@Override
//			public void accept(double value) {
//				System.out.println("평균: " + avg.getAsDouble()); // 오류는 안 뜨고 값은 안 뜬다.
//			}
//		});
	}
}