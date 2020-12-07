package stream;

public class Student implements Comparable<Student> {
	private String name;
	private int score;

	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	@Override
	public String toString() { // 재정의
		return "Student [name=" + name + ", score=" + score + "]";
	}

	@Override
	public int compareTo(Student o) {
//		if (this.score < o.score)
//			return -1;
//		else
//			return 1;
		//오름차순 : 음수 , 같다 : 0, 내림차순 : 양수 숫자에 따라 오름차순, 내림차순 달라짐
		return o.score - this.score  ;

	}
}
