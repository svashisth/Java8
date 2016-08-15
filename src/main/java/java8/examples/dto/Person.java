package java8.examples.dto;

import java8.examples.dto.enums.Country;
import java8.examples.dto.enums.Hobby;

public class Person
{
	public String name;
	public Country country;
	public Hobby hobby;
	public int age;

	@Override
	public String toString()
	{
		return String.format("Person [name=%s, country=%s, hobby=%s, age=%s]", name, country, hobby, age);
	}

}
