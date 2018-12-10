package com.java8.demo.trade;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Main {

	/*
	 *  (1) 找出2011年发生的所有交易，并按交易额排序（从低到高）。
	 *	(2) 交易员都在哪些不同的城市工作过？
	 *	(3) 查找所有来自于剑桥的交易员，并按姓名排序。
	 *	(4) 返回所有交易员的姓名字符串，按字母顺序排序。
	 *	(5) 有没有交易员是在米兰工作的？
	 *	(6) 打印生活在剑桥的交易员的所有交易额。
	 *	(7) 所有交易中，最高的交易额是多少？
	 *	(8) 找到交易额最小的交易。
	 */
	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));
		// (1)
		List<Transaction> tr2011 = transactions.stream().filter(transaction -> transaction.getYear() == 2011)
				.sorted(comparing(Transaction::getValue)).collect(toList());
		tr2011.stream().forEach(o->System.out.println(o.getTrader().getCity()+"_"+o.getTrader().getCity()+"_"+o.getYear()+"_"+o.getValue()));
		System.out.println("------------------(1)分割线------------------");
		// (2)
		List<String> cities = transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct()
				.collect(toList());
		cities.stream().forEach(System.out::println);
		System.out.println("------------------(2)分割线------------------");
		Set<String> cities1 = transactions.stream().map(transaction -> transaction.getTrader().getCity())
				.collect(toSet());
		cities1.stream().forEach(System.out::println);
		System.out.println("------------------(2)分割线------------------");
		// (3)
		List<Trader> traders = transactions.stream().map(Transaction::getTrader).filter(trader -> trader.getCity().equals("Cambridge"))
				.sorted(comparing(Trader::getName)).collect(toList());
		traders.stream().map(Trader::getName).forEach(System.out::println);
		System.out.println("------------------(3)分割线------------------");
		// (4)
		String traderStr = transactions.stream().map(transaction -> transaction.getTrader().getName()).distinct()
				.sorted().reduce("", (n1, n2) -> n1 + n2);
		String traderStr1 = transactions.stream().map(transaction -> transaction.getTrader().getName()).distinct()
				.sorted().collect(joining());
		System.out.println(traderStr);
		System.out.println(traderStr1);
		System.out.println("------------------(4)分割线------------------");
		// (5)
		boolean hasMilan = transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan"));
		System.out.println(hasMilan);
		System.out.println("------------------(5)分割线------------------");
		// (6)
		transactions.stream().filter(t -> t.getTrader().getCity().equals("Cambridge")).map(Transaction::getValue).forEach(System.out::println);
		System.out.println("------------------(6)分割线------------------");
		// (7)
		Optional<Integer> highestValue = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
		if(highestValue.isPresent())System.out.println(highestValue.get());
		System.out.println("------------------(7)分割线------------------");
		// (8)
		Optional<Transaction> smallestTransaction = transactions.stream().reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
		if (smallestTransaction.isPresent()) System.out.println(smallestTransaction.get().getTrader().getName());
		Optional<Transaction> smallestTransaction1 = transactions.stream().min(comparing(Transaction::getValue));
		if (smallestTransaction.isPresent()) System.out.println(smallestTransaction1.get().getTrader().getName());
		System.out.println("------------------(8)分割线------------------");
	}

}
