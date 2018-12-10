package com.java8.demo;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
//		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//		List<Integer> squares = numbers.stream().map(n -> n * n).collect(toList());
//		squares.stream().forEach(b -> {System.out.print(b);System.out.print(",");});
//		
//		System.out.println();System.out.println("------------割-包-皮------------");
//		
//		List<Integer> numbers1 = Arrays.asList(1, 2, 3);
//		List<Integer> numbers2 = Arrays.asList(3, 4);
//		List<int[]> pairs = numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[] { i, j }))
//				.collect(toList());
//		List<int[]> pairs1 = numbers1.stream().flatMap(i -> numbers2.stream().filter(j -> (i + j) % 3 == 0).map(j -> new int[] { i, j }))
//				.collect(toList());
//		
////		Optional<Integer> sum = numbers.stream().reduce((a, b) -> (a + b));
////		Optional<Integer> max = numbers.stream().reduce(Integer::max);
//		pairs.stream().forEach(a -> {
//			Arrays.stream(a).forEach(System.out::print);
//			System.out.print(",");
//		});
//		System.out.println();
//		pairs1.stream().forEach(a -> {
//			Arrays.stream(a).forEach(System.out::print);
//			System.out.print(",");
//		});
//		
//		System.out.println();System.out.println("------------割-包-皮------------");
//		
//		Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
//				.flatMap(a -> IntStream.rangeClosed(a, 100).filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
//						.mapToObj(b -> new int[] { a, b, (int) Math.sqrt(a * a + b * b) }));
//		pythagoreanTriples.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
//		
//		System.out.println();System.out.println("------------割-包-皮------------");
//		
//		getPrimeNumber(100);
//		
//		System.out.println();System.out.println("------------割-包-皮------------");
//		
//		Stream<double[]> pythagoreanTriples2 = IntStream.rangeClosed(1, 100).boxed()
//				.flatMap(a -> IntStream.rangeClosed(a, 100)
//						.mapToObj(b -> new double[] { a, b, Math.sqrt(a * a + b * b) }).filter(t -> t[2] % 1 == 0));
//		pythagoreanTriples2.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
//		
//		System.out.println();System.out.println("------------割-包-皮------------");
//		
//		Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
//		stream.map(String::toUpperCase).forEach(System.out::println);
//		System.out.println();System.out.println("------------割-包-皮------------");
//		
//		int[] numbersArray = {2, 3, 5, 7, 11, 13};
//		int sum = Arrays.stream(numbersArray).sum();
//		System.out.println(sum);
//		System.out.println();System.out.println("------------割-包-皮------------");
//		
//		long uniqueWords = 0;
//		try (Stream<String> lines = Files.lines(Paths.get("D:\\\\demo\\\\a.txt"), Charset.defaultCharset())) 
//		{
//			uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println(uniqueWords);
//		System.out.println();System.out.println("------------割-包-皮------------");
		
//		Stream.iterate(0, n -> n + 2).forEach(System.out::println);
		
//		Stream.iterate(new int[] { 0, 1 }, t -> new int[] { t[1], t[0] + t[1] }).limit(100).map(t -> t[0])
//				.forEach(System.out::println);
		
		Stream.generate(Math::random).limit(5).forEach(System.out::println);
		IntStream twos = IntStream.generate(new IntSupplier() {
			public int getAsInt() {
				return 2;
			}
		});
		
		IntSupplier fib = new IntSupplier() {
			private int previous = 0;
			private int current = 1;
			
			public int getAsInt() {
				int oldPrevious = this.previous;
				int nextValue = this.previous + this.current;
				this.previous = this.current;
				this.current = nextValue;
				return oldPrevious;
			}
		};
		IntStream.generate(fib).limit(10).forEach(System.out::println);
		
	}
	
	
	public static void getPrimeNumber(int max) {
        int j;
        for (int i = 2; i <= max; i++) // 1不是素数，所以直接从2开始循环
        {
            j = 2;
            while (i % j != 0) {
                j++; // 测试2至i的数字是否能被i整除，如不能就自加
            }
            if (j == i) // 当有被整除的数字时，判断它是不是自身
            {
                System.out.print(i+","); // 如果是就打印出数字
            }
        }
    }

}
