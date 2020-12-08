package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectExample {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student("Hong", 80), 
				new Student("Hong", 90), 
				new Student("Hong", 87)
		);

//		List<Student> student80s = list.stream()
//				.filter(s -> s.getScore() / 10 == 8)
//				.sorted() // 사용하려면 <Student>에 compareTo 가 정의 되어 있어야	함.
//				.collect(Collectors.toList());
//
//		for (Student student : student80s) {
//			System.out.println("학생 이름: " + student.getName() + ", 점수 :" + student.getScore());
//		}

		Map<String, Integer> map = list.stream()
				.filter(s -> s.getScore() / 10 == 8)
				.sorted()
				.collect(
						Collectors.toMap(
						(t) -> t.getName(), 
						(t) -> t.getScore()
				//map은 return 값이 있고, foreach는 없다.
				)
			);
		
		Set<String> set = map.keySet();
		for(String key : set) {
			System.out.println("Key: " + key + ", val: " + map.get(key));
		}

//		.forEach(System.out::println); //student 타입을 호출하주세요 라는 뜻임. student 클래스에 toString 만들어줌. (System.out::실행되는 거 적기)

//	//	.collect
//		(Collectors.toMap(
//				new Function<Student, String>(){
//
//					@Override
//					public String apply(Student t) {
//						return t.getName();
//					}
//					
//				}, new Function<Student, Integer>() {
//
//					@Override
//					public Integer apply(Student t) {
//						return t.getScore();
//					}
//		        })
//		//		
//		);
	}
}
