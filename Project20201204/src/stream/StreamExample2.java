package stream;

import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class StreamExample2 {
	public static void main(String[] args) {
		// 1 ~ 100
		// 짝수만 결과를 출력....

//람다식		IntStream.rangeClosed(1, 100).filter(t -> t % 2 == 0).forEach(n -> System.out.println(n));  
		                                                                    //closed > 가까운 숫자 다 출력.
																									 
		// intstream > 이미 int가 포함이라 타입이 없음 // range - 98까지
		
        //람다식 이전. Predicate, Consumer 타입 주의!
		IntStream.range(1, 100).filter(new IntPredicate() {

			@Override
			public boolean test(int value) {
				return value % 2 == 0;
			}

		}).forEach(new IntConsumer() {

			@Override
			public void accept(int value) {
				System.out.println(value);
			}

		});
		;

		System.out.println();
		
		int sum = IntStream.rangeClosed(1, 100).filter(t -> t % 2 == 0).sum();

		int[] intAry = { 2, 6, 4, 8, 1, 9 };
		IntStream is = Arrays.stream(intAry);
//		OptionalInt max = is.max(); //max - 제일 큰 값을 가져오세요
//		int iMax = max.getAsInt();
//		System.out.println(iMax);

		int max = is.min().getAsInt(); // min - 최소값
		System.out.println(max);
		
		System.out.println();
		
		is = Arrays.stream(intAry);
		double avg = is.average().getAsDouble();
		System.out.println(avg);

		
		//조건(filter)
		Arrays.stream(intAry).filter((a) ->  a % 2 == 0)
		.forEach((a) -> System.out.println(a));
	}
}
