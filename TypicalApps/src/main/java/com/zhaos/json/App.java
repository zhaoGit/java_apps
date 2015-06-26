package com.zhaos.json;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.TypeReference;

class Person{
	private MyDate birthday;
	private Date weddingDay;
	
	public MyDate getBirthday() {
		return birthday;
	}

	public void setBirthday(MyDate birthday) {
		this.birthday = birthday;
	}

	public Date getWeddingDay() {
		return weddingDay;
	}

	public void setWeddingDay(Date weddingDay) {
		this.weddingDay = weddingDay;
	}
}
/**
 * 对自定义类型MyDate的序列化和反序列化. MyDate是自定义的类型，继承自JDK的Date，
 * 里面只是封装了日期，没有时间;
 * @author zhaosheng
 *
 */
public class App {
	public static void main(String[] args){
		System.out.println("***********包含自定义类型的序列化和反序列化*************");
		Person person1 = new Person();
		person1.setBirthday(new MyDate());
		person1.setWeddingDay(new Date());
		String personJSONString1 = MyJSON.toJSONStringWithDateFormat(person1);
		System.out.println(personJSONString1);
		Person jsonPerson = MyJSON.parseObject(personJSONString1, Person.class);
		System.out.println(jsonPerson.getBirthday() + "   " + jsonPerson.getWeddingDay());
		Person person2 = new Person();
		person2.setBirthday(MyDate.yyyyMMdd("19880808"));
		person2.setWeddingDay(new Date());
		
		List<Person> personList = new ArrayList<Person>();
		personList.add(person1);
		personList.add(person2);
		System.out.println("************集合的序列化和反序列化************");
		String personText = MyJSON.toJSONStringWithDateFormat(personList);
		System.out.println(personText);
		
		List<Person> personArray = MyJSON.parseObject(personText, new TypeReference<List<Person>>(){});
		for (Person person : personArray) {
			System.out.println(person.getBirthday() + "---" + person.getWeddingDay());
		}
	}
}
