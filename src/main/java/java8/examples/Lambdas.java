package java8.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import java8.examples.dto.Person;
import java8.examples.dto.enums.Country;
import java8.examples.dto.enums.Hobby;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.commons.lang3.RandomStringUtils;

public class Lambdas
{

	public static void main(String[] args)
	{
		filterAndStreams();
		System.out.println("--------------------");

		collections();
		System.out.println("\t\t\t--------------");
		threadRun();
		System.out.println("\t\t\t--------------");
		biFunction();
	}

	private static void filterAndStreams()
	{
		List<Person> persons = generatePersons(10);
		persons.forEach((s) -> {
			System.out.println(s);
		});
		Predicate<Person> spanish = p -> {
			return Country.SPAIN.equals(p.country);
		};
		Predicate<Person> american = p -> {
			return Country.USA.equals(p.country);
		};
		Predicate<Person> travelers = p -> {
			return Hobby.TRAVEL.equals(p.hobby);
		};
		System.out.println("Spanish\t\n");
		persons.stream().filter(spanish).forEach((person) -> {
			System.out.println(person);
		});
		System.out.println("American travelers\t");
		persons.stream().filter(american).filter(travelers).forEach((person) -> {
			System.out.println(person);
		});
		System.out.println("-- with and predicate ");
		persons.stream().filter(american.and(travelers)).forEach((person) -> {
			System.out.println(person);
		});
		System.out.println("-- count ");
		long count = persons.stream().filter(american.and(travelers)).count();
		System.out.println("count\t" + count);
		Optional<Person> max = persons.stream().max((p1, p2) -> p1.age - p2.age);
		if (max.isPresent())
			System.out.println("oldest person\t" + max.get());
	}

	private static List<Person> generatePersons(int count)
	{
		List<Person> list = new ArrayList<Person>();

		for (int a = 0; a < count; a++)
		{
			Person person = new Person();
			person.name = RandomStringUtils.randomAlphabetic(7);
			person.country = Country.values()[RandomUtils.nextInt(Country.values().length)];
			person.hobby = Hobby.values()[RandomUtils.nextInt(Hobby.values().length)];
			person.age = RandomUtils.nextInt(45);
			list.add(person);
		}
		return list;
	}

	private static void collections()
	{
		Arrays.asList("element", "other", "another one").forEach(e -> System.out.println(e));
		/* sorts all elements in a collection using a lambda expression as comparator */
		System.out.println("\t\t\t--------------");
		List<String> names = Arrays.asList("prado", "gugenheim", "reina sofia", "louvre");
		Collections.sort(names, (String a, String b) -> a.compareTo(b));
		names.forEach(e -> System.out.println(e));
	}

	private static void threadRun()
	{
		Runnable runnable = () -> System.out.println("run run run" + Thread.currentThread());
		Thread thread = new Thread(runnable);
		thread.start();
	}

	private static void biFunction()
	{
		BiFunction<Integer, Integer, Integer> addition = (x, y) -> x + y;
		BiFunction<Integer, Integer, Integer> subtract = (x, y) -> x - y;
		BiFunction<Integer, Integer, Integer> divide = (x, y) -> x / y;

		System.out.println("main\t" + addition.apply(45, 52));
		System.out.println("main\t" + subtract.apply(45, 52));
		System.out.println("main\t" + divide.apply(45, 52));
		System.out.println("main\t" + divide.apply(45, 0));
	}
}
