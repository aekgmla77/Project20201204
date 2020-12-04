package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class LambdaExample {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(new Student("Hong", "MALE", 70), new Student("Hwang", "FEMALE", 80),
				new Student("Park", "MALE", 90), new Student("Choi", "FEMALE", 85));

		// 1. 여학생 정보 : 이름 - 점수
		for (Student student : list) {
			if (student.getSex().equals("FEMALE")) {
				System.out.println(student.getName() + "-" + student.getScore());
			}

		}
		System.out.println();

		// 2. 전체학생 : 점수 80점 초과 학생.
		for (Student student : list) {
			if (student.getScore() > 80) {
				System.out.println(student.getName() + "," + student.getSex() + "," + student.getScore());
			}

		}
		System.out.println();

		// 3.남학생의 총점 : 160
		int sum = 0;
		for (Student student : list) {
			if (student.getSex().equals("MALE")) {
				sum += student.getScore();
			}
		}
		System.out.println("남학생 총점: " + sum);
		System.out.println();

		// 4.여학생 평균: 82.5
		double avg = 0;
		int count = 0;
		int sum1 = 0;
		for (Student student : list) {
			if (student.getSex().equals("FEMALE")) {
				sum1 += student.getScore();
				count++;

			}
		}
		avg = (double) sum1 / count;
		System.out.println("여학생 평균: " + avg);

		
		
		
		
		System.out.println("====================");
		// 반복문(반복자) : 스트림(반복자)
		// 스트림 생성 -> 소진.
		Stream<Student> stream = list.stream(); //소진하면 다시 만들어야 함. (스트림)
		stream.filter((Student t) -> t.getSex().equals("FEMALE"))
              .forEach((Student t) -> System.out.println(t.getName() + "-" + t.getScore()));
		
		System.out.println();
		stream = list.stream();
		stream.filter((Student t) -> t.getScore() > 80)//중간처리 - filter
		      .forEach((Student t) -> System.out.println(t.getName() + "-" + t.getScore()));
			
		
		System.out.println();
		int sum2 = list.stream().filter(t -> t.getSex().equals("MALE"))
		.mapToInt((Student value) -> value.getScore()) //score만 가져와서 sum 에 넣어준다
	    .sum();
		System.out.println("합계: " + sum);
		
		System.out.println();
		list.stream().filter(t -> t.getSex().equals("FEMALE"))
		.mapToInt(s -> s.getScore())
		.average()
		.getAsDouble();
		System.out.println("평균: " +avg);
	}
}
