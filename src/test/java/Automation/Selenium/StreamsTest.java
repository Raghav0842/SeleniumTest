package Automation.Selenium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsTest {

	public static void main(String[] args) 
	{
		ArrayList<String> lst = new ArrayList<String>();
		lst.add("Hello");
		lst.add("aa");
		lst.add("My");
		lst.add("Name is");
		lst.add("Raghav");
		lst.add("M");
		
		//First convert to streams
		lst.stream().filter(s->s.startsWith("M")).forEach(s-> System.out.println(s));
		System.out.println("===========================");
	    lst.stream().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	    System.out.println("===========================");
        lst.stream().limit(1).forEach(s->System.out.println(s));
        System.out.println("===========================");
        lst.stream().filter(s->s.contains("Raghav")).forEach(s->System.out.println(s));
        System.out.println("===========================");
        lst.stream().filter(s->s.contains("a")).sorted().forEach(s->System.out.println(s));
        System.out.println("===========================");
        System.out.println(lst.stream().anyMatch(s->s.equalsIgnoreCase("M")));
        System.out.println("=============Conacatenate==============");
        ArrayList<String> lst2 = new ArrayList<String>();
		lst2.add("Hey");
		lst2.add("there");
		lst2.add("What is ur ");
		lst2.add("Name?");
	   
		Stream<String> s1 = lst.stream();
		Stream<String> s2 = lst2.stream();
		
		Stream<String> s3 = Stream.concat(s1, s2);
		//s3.sorted().forEach(s->System.out.println(s));
		
		//convert back to ArrayList
		List<String> list = s3.filter(s->s.length()>4).collect(Collectors.toList());//s3.collect(Collectors.toList());
		System.out.println(list.toString());
		
		
        
		List<Integer> num = Arrays.asList(4,5,1,3,7,3,5,9);
 		num.stream().distinct().forEach(n->System.out.println(n));
	}

}
