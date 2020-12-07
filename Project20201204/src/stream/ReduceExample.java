package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntBinaryOperator;

public class ReduceExample {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student("Hong", 80), 
				new Student("Hong", 90), 
				new Student("Hong", 87)
		);
		int sum = list.stream().mapToInt(s -> s.getScore()).sum();
		System.out.println("점수 합계: " + sum);

		// reduce
		int result = list.stream().mapToInt(t -> t.getScore()).reduce(new IntBinaryOperator() {
			@Override
			public int applyAsInt(int left, int right) {
				System.out.println("left: " + left + ", right: " + right);
				return left + right;
			}
		}).getAsInt();
		System.out.println("결과값: " + result);

		result = list.stream()
				.mapToInt(t -> t.getScore())
				.reduce(0, ( left,  right) -> left + right);
		System.out.println("결과값: " + result);
		
		
		result = list.stream()
				.mapToInt(t -> t.getScore())
				.reduce(100, ( left,  right) -> left < right ? left : right ); //getAsint 쓰거나 초기값을 큰 수로 설정하거나 하면 최소값 구함.
		System.out.println("최소값: " + result);
		
		result = list.stream()
				.mapToInt(t -> t.getScore())
				.reduce(0 , ( left,  right) -> left > right ? left : right ); //최대값
		System.out.println("최대값: " + result);
		
		result = list.stream()
				.mapToInt(t -> t.getScore())
				.reduce(( left,  right) -> (left + right) / 2) //평균
				.getAsInt();
				
		System.out.println("평균값: " + result);
		
	}
}
