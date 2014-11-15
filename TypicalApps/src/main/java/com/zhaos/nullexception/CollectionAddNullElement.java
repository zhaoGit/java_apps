package com.zhaos.nullexception;

import java.util.ArrayList;
import java.util.List;
class Person{
	
}
/*
 * 如果一个元素是null，也是可以被add到List集合中的，
 */
public class CollectionAddNullElement {

	public static void main(String[] args) {
		List<String> stringList = new ArrayList<String>();
		String string1 = "aa";
		String string2 = null;
		stringList.add(string1);
		stringList.add(string2);
		for (String string : stringList) {
			System.out.println(string);
		}
		
		List<Person> personList = new ArrayList<Person>();
		Person person1 = new Person();
		Person person2 = null;
		personList.add(person1);
		
		assert person2 != null : "person不可以为null";
		personList.add(person2);	
		System.out.println(personList.size());
	}

}
