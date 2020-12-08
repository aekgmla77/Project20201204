package stream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample4 {
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

		Stream<EmployeeVO> stream = list.stream();
		stream.forEach(s -> s.showEmpInfo());
		System.out.println();

		// 1. salary > 10000
		System.out.println("salary가 10,000 이상인 사원.");
		list.stream().filter(t -> t.getSalary() > 10000).forEach(t -> t.showEmpInfo());
		System.out.println();

		// 2. 선적부서 : 급여합계(평균)
		System.out.println("선적 부서의 급여합계(평균)");
//		int sum = list.stream().filter(new Predicate<EmployeeVO>() //sum에 값을 담아줘야 함. 
		double avg = list.stream().filter(t -> t.getDepartmentId() == 50) // 없는 값을 넣으면 오류가 뜬다.
				.mapToInt(new ToIntFunction<EmployeeVO>() { // mapping 처리. int로 변환해줌.
					// IntStream,
					@Override
					public int applyAsInt(EmployeeVO value) {
						return value.getSalary();
					}

				}).average() // .sum(); -> 합계 , > 중간처리
				.getAsDouble(); // average 랑 getAsdouble은 같이 와야 함. > 최종처리
		System.out.println("평균: " + avg);
//		System.out.println("합계: " + sum);
		System.out.println();

		// 3.급여 (5000~10000)
		System.out.println("급여가 5000 < ? > 10000");
		list.stream().filter(t -> t.getSalary() > 5000 && t.getSalary() < 10000).forEach(t -> t.showEmpInfo());

		// sorted
		list.stream()
				.sorted()
				.forEach(s -> s.showEmpInfo());
//				.collect(Collectors.toMap((t) -> t.getFirstName(), (t) -> t.getSalary()));
//
//		Set<String> set = map.keySet();
//		for (String key : set) {
//			System.out.println("Key: " + key + ", val: " + map.get(key));
//		}
		System.out.println();
		//first name 기준
		list.stream()
				.sorted()
				.forEach(s -> s.showEmpInfo());

	}
}