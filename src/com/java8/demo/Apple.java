package com.java8.demo;

public class Apple {
	
	private String color;
	
	private Integer weight;
	
//	public static boolean isGreenApple(Apple apple) {
//		return "green".equals(apple.getColor());
//	}
//
//	public static boolean isHeavyApple(Apple apple) {
//		return apple.getWeight() > 150;
//	}
	
	public Apple(){
	}
	
	public Apple(String color,Integer weight){
		this.color = color;
		this.weight=weight;
	}
	
	public Apple(Integer weight){
		this.weight=weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
}
