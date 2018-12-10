package com.java8.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.Consumer;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo {

	public static List<Apple> filterGreenApples(List<Apple> inventory){
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple: inventory){
			if ("green".equals(apple.getColor())) {
				result.add(apple);
			}
		}
		return result;
	}
	
	public static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : inventory) {
			if (apple.getColor().equals(color)) {
				result.add(apple);
			}
		}
		return result;
	}
	
	public static List<Apple> filterHeavyApples(List<Apple> inventory) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (apple.getWeight() > 150) {
				result.add(apple);
			}
		}
		return result;
	}
	
	public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : inventory) {
			if (apple.getWeight() > weight) {
				result.add(apple);
			}
		}
		return result;
	}
	
	public static List<Apple> filterApples(List<Apple> inventory, String color, int weight, boolean flag) {
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : inventory) {
			if ((flag && apple.getColor().equals(color)) || (!flag && apple.getWeight() > weight)) {
				result.add(apple);
			}
		}
		return result;
	}

//	public interface Predicate<T> {
//		boolean test(T t);
//	}
	
	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> result = new ArrayList<>();
		for (T e : list) {
			if (p.test(e)) {
				result.add(e);
			}
		}
		return result;
	}

	static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
	
	static <T> Collection<T> filter(Collection<T> c, Predicate<T> p) {
		return null;
	}
	
//	public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
//		List<Apple> result = new ArrayList<>();
//		for (Apple apple : inventory) {
//			if (p.test(apple)) {
//				result.add(apple);
//			}
//		}
//		return result;
//	}
	
	public static void main(String[] args) {
/*		
//		File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
//			public boolean accept(File file) {
//				return file.isHidden();
//			}
//		});
		
//		File[] hiddenFiles1 = new File(".").listFiles(File::isHidden);
		
		Apple apple1 = new Apple();
		apple1.setColor("red");
		List<Apple> inventory = new ArrayList<Apple>();
		inventory.add(apple1);
		
//		filterApples(inventory, Apple::isGreenApple);
		
//		filterApples(inventory, Apple::isHeavyApple);
		
//		filterApples(inventory, (Apple a) -> "green".equals(a.getColor()) );
		
//		filterApples(inventory, (Apple a) -> a.getWeight() > 150 );
		
//		filterApples(inventory, (Apple a) -> a.getWeight() < 80 || "brown".equals(a.getColor()) );
		
//		inventory.sort(null);
		
//		List<Apple> greenApples = filterApplesByColor(inventory, "green");
		
//		List<Apple> redApples = filterApplesByColor(inventory, "red");
		
//		List<Apple> greenApples1 = filterApples(inventory, "green", 0, true);
		
//		List<Apple> heavyApples = filterApples(inventory, "", 150, false);
		
//		List<Apple> redAndHeavyApples = filterApples(inventory, new AppleRedAndHeavyPredicate());
		
//		List<Apple> redApples1 = filterApples(inventory, new ApplePredicate() {
//			public boolean test(Apple apple) {
//				return "red".equals(apple.getColor());
//			}
//		});
		
//		List<Apple> result = filterApples(inventory, (Apple apple) -> "red".equals(apple.getColor()));
//		
//		List<Apple> redApples = filter(inventory, (Apple apple) -> "red".equals(apple.getColor()));
//		
//		List<Integer> evenNumbers = filter(Arrays.asList(1,2,3), (Integer i) -> i % 2 == 0);
		
		inventory.sort(new Comparator<Apple>() {
			public int compare(Apple a1, Apple a2) {
				return a1.getWeight().compareTo(a2.getWeight());
			}
		});
		
		inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
		inventory.sort(Comparator.comparing(Apple::getWeight));
		
//		Thread t = new Thread(new Runnable() {
//			public void run() {
//				System.out.println("Hello world");
//			}
//		});
//		
//		Thread t1 = new Thread(() -> System.out.println("Hello world"));
		
//		Predicate
//		Consumer
//		Function
		
		forEach(Arrays.asList(1, 2, 3, 4, 5), (Integer i) -> System.out.println(i));
		
		// [7, 2, 6]
		List<Integer> l = map(Arrays.asList("lambdas", "in", "action"), (String s) -> s.length());
		
		BufferedReaderProcessor p = null;

		Function<String, Integer> stringToInteger = (String s) -> Integer.parseInt(s);
		Function<String, Integer> stringToInteger1 = Integer::parseInt;
		
		List<String> sl = Arrays.asList("lambdas", "in", "action");
		
		BiPredicate<List<String>, String> contains = (List, element) -> sl.contains(element);
		BiPredicate<List<String>, String> contains1 = List::contains;
		
		Supplier<Apple> c1 = () -> new Apple();
		Supplier<Apple> c2 = Apple::new;
		Apple a1 = c1.get();
		
		Function<Integer, Apple> c3 = Apple::new;
		Apple a2 = c3.apply(110);
		
		BiFunction<String, Integer, Apple> c4 = Apple::new;
		Apple a4 = c4.apply("green", 110);
		BiFunction<String, Integer, Apple> c41 = (color, weight) -> new Apple(color, weight);
		Apple a41 = c41.apply("green", 110);
		
		List<Integer> weights = Arrays.asList(7, 3, 4, 10);
		List<Apple> apples = map1(weights, Apple::new);
		
		inventory.sort(new AppleComparator());
		inventory.sort(new Comparator<Apple>() {
			public int compare(Apple a1, Apple a2) {
				return a1.getWeight().compareTo(a2.getWeight());
			}
		});
		inventory.sort((Apple a11, Apple a21) -> a11.getWeight().compareTo(a21.getWeight()));
		inventory.sort((a11, a21) -> a11.getWeight().compareTo(a21.getWeight()));
		inventory.sort(Comparator.comparing((a) -> a.getWeight()));
		inventory.sort(Comparator.comparing(Apple::getWeight).reversed());
		inventory.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));
		
		Predicate<Apple> redApple = (Apple a) -> "red".equals(a.getColor());
		Predicate<Apple> notRedApple = redApple.negate();
		Predicate<Apple> redAndHeavyApple = redApple.and(a -> a.getWeight() > 150);
		// and和or方法是按照在表达式链中的位置，从左向右确定优先级的。因此， a.or(b).and(c)可以看作(a || b) && c
		Predicate<Apple> redAndHeavyAppleOrGreen = redApple.and(a -> a.getWeight() > 150).or(a -> "green".equals(a.getColor()));
		
		Function<Integer, Integer> f = x -> x + 1;
		Function<Integer, Integer> g = x -> x * 2;
		Function<Integer, Integer> h = f.andThen(g);
		int result = h.apply(1); // result == 4
		
		Function<Integer, Integer> f1 = x -> x + 1;
		Function<Integer, Integer> g1 = x -> x * 2;
		Function<Integer, Integer> h1 = f.compose(g);
		int result1 = h1.apply(1); // result1 == 3
		
		Function<String, String> addHeader = Letter::addHeader;
		Function<String, String> transformationPipeline = addHeader.andThen(Letter::checkSpelling).andThen(Letter::addFooter);
		
		Function<String, String> addHeader1 = Letter::addHeader;
		Function<String, String> transformationPipeline1 = addHeader1.andThen(Letter::addFooter);*/
		
		/*
		 ----------------------------------------割包皮-------------------------------------------
		 */
		List<Dish> menu = Arrays.asList(
				new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER),
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH) );
		
//		List<Dish> lowCaloricDishes = new ArrayList<>();
//		for (Dish d : menu) {
//			if (d.getCalories() < 400) {
//				lowCaloricDishes.add(d);
//			}
//		}
//		Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
//			public int compare(Dish d1, Dish d2) {
//				return Integer.compare(d1.getCalories(), d2.getCalories());
//			}
//		});
//		List<String> lowCaloricDishesName = new ArrayList<>();
//		for (Dish d : lowCaloricDishes) {
//			lowCaloricDishesName.add(d.getName());
//		}
		
//		List<String> lowCaloricDishesName = menu.stream().filter(d -> d.getCalories() < 400)
//				.sorted(comparing(Dish::getCalories)).map(Dish::getName).collect(toList());
//		// 为了利用多核架构并行执行这段代码，你只需要把stream()换成parallelStream()：
//		List<String> lowCaloricDishesName1 = menu.parallelStream().filter(d -> d.getCalories() < 400)
//				.sorted(comparing(Dish::getCalories).reversed()).map(Dish::getName).collect(toList());
		
//		Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));
//		List<String> threeHighCaloricDishNames = menu.stream().filter(d -> d.getCalories() > 300).map(Dish::getName)
//				.limit(4).collect(toList());
//		System.out.println(threeHighCaloricDishNames);
//		
//		List<String> title = Arrays.asList("Java8", "In", "Action");
//		Stream<String> s = title.stream();
//		s.forEach(System.out::println);
//		s.forEach(System.out::println);
		
//		String[] arrayOfWords = {"Goodbye", "World"};
//		
//		Arrays.asList(arrayOfWords).stream().map(word -> word.split("")).map(Arrays::stream).distinct()
//				.collect(toList());
		
		int calories = menu.stream().map(Dish::getCalories).reduce(0, Integer::sum);
		int calories1 = menu.stream().mapToInt(Dish::getCalories).sum();
		System.out.println(calories);
		System.out.println(calories1);
		
		OptionalInt maxCalories = menu.stream().mapToInt(Dish::getCalories).max();
		maxCalories.orElse(1);
		System.out.println(maxCalories.isPresent());
		
		IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
		Stream<Integer> stream = intStream.boxed();
		
		IntStream evenNumbers = IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0);
		System.out.println(evenNumbers.boxed().count());

	}
	
	public double integrate(DoubleFunction<Double> f, double a, double b) {
		return (f.apply(a) + f.apply(b)) * (b-a) / 2.0;
	}

//	static Map<String, Function<Integer, Fruit>> map = new HashMap<>();
//	static {
//		map.put("apple", Apple::new);
//		map.put("orange", Orange::new);
//		// etc...
//	}
//
//	public static Fruit giveMeFruit(String fruit, Integer weight) {
//		return map.get(fruit.toLowerCase()).apply(weight);
//	}
	
	public static List<Apple> map1(List<Integer> list, Function<Integer, Apple> f){
		List<Apple> result = new ArrayList<>();
		for(Integer e: list){
			result.add(f.apply(e));
		}
		return result;
	}
	
	public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
		List<R> result = new ArrayList<>();
		for (T s : list) {
			result.add(f.apply(s));
		}
		return result;
	}
	
	public static <T> void forEach(List<T> list, Consumer<T> c){
		for(T i: list){
			c.accept(i);
		}
	}
	
}

class Letter {
	public static String addHeader(String text) {
		return "From Raoul, Mario and Alan: " + text;
	}

	public static String addFooter(String text) {
		return text + " Kind regards";
	}

	public static String checkSpelling(String text) {
		return text.replaceAll("labda", "lambda");
	}
}

//interface ApplePredicate {
//	boolean test(Apple apple);
//}

//class AppleGreenColorPredicate implements ApplePredicate {
//	public boolean test(Apple apple) {
//		return "green".equals(apple.getColor());
//	}
//}
//
//class AppleHeavyWeightPredicate implements ApplePredicate {
//	public boolean test(Apple apple) {
//		return apple.getWeight() > 150;
//	}
//}
//
//class AppleRedAndHeavyPredicate implements ApplePredicate {
//	public boolean test(Apple apple) {
//		return "red".equals(apple.getColor()) && apple.getWeight() > 150;
//	}
//}
