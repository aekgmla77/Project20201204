package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

import lambda.Student;

public class StreamExample3 {
	public static void main(String[] args) {
		
		String[] strs = "Java8 lambda".split(" "); // 문자열 배열 Java8 lambda 여기에 있는 공백을 기준으로 배열을 만든다는 뜻.

		List<String> strList = Arrays.asList("Java8 lambda", "stream mapping");
		strList.stream().flatMap((String t) -> Arrays.stream(t.split(" "))) // 배열
//		.filter( s -> s.startsWith("s"))
				.forEach(s -> System.out.println(s)); // start with 문자열 뭐가 처음으로 오는지 설정

		System.out.println();
		strList.stream().map(new Function<String, String>() { // map은 return 되는 타입만 정하면 string을 만들어줌.

			@Override
			public String apply(String t) {
				return t.toUpperCase();
			}
		}).forEach(s -> System.out.println(s));

		List<Student> students = Arrays.asList(
				new Student("송다희", "F", 80), 
				new Student("윤태현", "M", 75),
				new Student("이혜빈", "F", 85), 
				new Student("정병기", "M", 90));
		double avg = students.stream()
		.mapToInt(new ToIntFunction<Student>() {
			@Override
			public int applyAsInt(Student value) {
				System.out.println(value.getName() + "/" + value.getScore());
				return value.getScore();
			}
		}).average()//
		.getAsDouble();
		System.out.println(avg);
	}
}
