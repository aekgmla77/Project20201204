package stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Predicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args) {
		List<String> list = null;
		list = Arrays.asList("Hong", "Hwang", "Park", "Choi"); // 초기값.
//		list.add("Kim");

		Stream<String> stream = list.stream();
		stream.filter((t) -> t.length() > 3)
		.forEach((t) -> System.out.println(t)); //매개값 consumer
		
		//BaseStrea -> 상속 Stream<T>, IntStream, LongStream, DoubleStream
		//IntStream : Stream<Integer>, LongStream : Stream<Long>
		
		String[] strAry = {"Hong", "Hwang", "Park"};
		Stream<String> strStream = Arrays.stream(strAry);
		
	    int[] intAry = {1, 2, 3, 4, 5};
	    IntStream intStream = Arrays.stream(intAry);
	    int sum = intStream.sum();
	    System.out.println("합: " + sum);
	    
	    double[] dblAry = {1.1, 2.2, 3.3, 4.4, 5.5};
	    DoubleStream dblStream = Arrays.stream(dblAry);
	   
	    dblStream.forEach(new DoubleConsumer() { //dblstream에 들어있는 요소들을 어떤 처리를 한다. 
	    	 double result = 0;
			@Override
			public void accept(double value) { //배열을 통한 stream
				result += value;
				System.out.println(result);
			}
	    });
	    
	    IntStream is = IntStream.range(1, 10); //return > intstream (숫자)
	    is.forEach(n -> System.out.println(n));
	    
	    is = IntStream.range(1, 10);
	    System.out.println("합: " + is.sum());
	    
	    Path path = Paths.get("list.txt"); //파일을 통한 Stream C:\Dev\workspace\Project20201204 - list.txt 가져온 거.
	    try {
			Stream<String> stream1 = Files.lines(path);
			stream1.forEach(s -> System.out.println(s));
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    path = Paths.get("c:/Program Files");//c:/경로 설정
	    try {
			Stream<Path> pStream = Files.list(path);
			pStream.forEach(s -> System.out.println(s));
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    
	}
}
