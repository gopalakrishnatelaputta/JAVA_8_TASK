package java8New_Task;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Java8Streams 
{
	public static void main(String[] args) 
	{
		List<String>strList=Arrays.asList("abc","","bcd"," ","defg","jk");
		long count=strList.stream().filter(x->x.isEmpty()).count();
		System.out.printf("List %s has %d empty Strings %n",strList,count);
		
		
		long num=strList.stream().filter(x->x.length()>3).count();
	System.out.printf("List %s has %d Strings of length more then 3 letters %n",strList,num);
	

	count=strList.stream().filter(x->x.startsWith("a")).count();
	System.out.printf("List %s has %d Strings starts with letter 'a' %n",strList,count);
	 
	
	List<String>filtered=strList.stream().filter(x->!x.isEmpty()).collect(Collectors.toList());
	System.out.printf("Original List : %s ,List Without Empty Strings : %s %n",strList,filtered);
	
	
	List<String>G7=Arrays.asList("USA","Japan","France","Germany","Italy","U.K","Canada");
	String G7Countries =G7.stream().map(x->x.toUpperCase()).collect(Collectors.joining(", "));
	System.out.println("List Of G7 Countries are :"+G7Countries);
	
	
	List<Integer>numbers=Arrays.asList(9,7,45,12,74,86,95,42,36,59,89,63,75,84,45);
	List<Integer>distinct=numbers.stream().map(i->i*i).distinct().collect(Collectors.toList());
	System.out.printf("Original List : %s, Square Without Duplicates : %s %n",numbers,distinct);
	
	
	List<Integer>primes=Arrays.asList(2,3,5,7,9,11,13);
	IntSummaryStatistics starts=primes.stream().mapToInt((x)->x).summaryStatistics();
	
	
	System.out.println("Highest prime number in List :"+starts.getMax());
	
	System.out.println("Lowest prime number in List :"+starts.getMin());
	
	System.out.println("Sum of prime numbers in List :"+starts.getSum());
	
	System.out.println("Average prime number in List :"+starts.getAverage());
	}

}
