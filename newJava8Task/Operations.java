package newJava8Task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Operations 
{
	public static void main(String[] args)
	{
		List<Rental_Customer> Rental_List = new ArrayList<Rental_Customer>();
        
		Rental_List.add(new Rental_Customer(111, "Gopala Krishna", 26, "Male", "2BHK", 2078, 15000.0));
		Rental_List.add(new Rental_Customer(122, "Pavan Kumar", 25, "Male", "1BHK", 2015, 8500.0));
		Rental_List.add(new Rental_Customer(133, "Nikhil Kumar", 29, "Male", "2BHK", 2014, 15000.0));
		Rental_List.add(new Rental_Customer(144, "Mahesh", 28, "Male", "1BHK", 2019, 7500.0));
		Rental_List.add(new Rental_Customer(155, "Sai Krishna", 27, "Male", "3BHK", 2022, 22700.0));
		Rental_List.add(new Rental_Customer(166, "Rahul Kumar", 25, "Male", "2BHK", 2018, 14500.0));
		Rental_List.add(new Rental_Customer(177, "Manu Sharma", 35, "Male", "2BHK", 2010, 27000.0));
		Rental_List.add(new Rental_Customer(188, "Wang Liu", 31, "Male", "1BHK", 2015, 34500.0));
		Rental_List.add(new Rental_Customer(199, "Amelia Zoe", 24, "Female", "1BHK", 2016, 11500.0));
		Rental_List.add(new Rental_Customer(200, "Jaden Dough", 38, "Male", "3BHK", 2015, 11000.5));
		Rental_List.add(new Rental_Customer(211, "Jasna Kaur", 27, "Female", "1BHK", 2014, 15700.0));
		Rental_List.add(new Rental_Customer(222, "Nitin Joshi", 25, "Male", "3BHK", 2016, 28200.0));
		Rental_List.add(new Rental_Customer(233, "Jyothi Reddy", 27, "Female", "2BHK", 2013, 21300.0));
		Rental_List.add(new Rental_Customer(244, "Nicolus Den", 24, "Male", "3BHK", 2017, 10700.5));
		Rental_List.add(new Rental_Customer(255, "Ali Baig", 23, "Male", "3BHK", 2018, 12700.0));
		Rental_List.add(new Rental_Customer(266, "Sanvi Pandey", 26, "Female", "2BHK", 2015, 28900.0));
		Rental_List.add(new Rental_Customer(277, "King Maker", 28, "Male", "3BHK", 2015, 35700.0));

		System.out.println("===========  G K Apartments ====================");
		System.out.println();
		System.out.println("No of Males and Females in the Apartment");
		Map<String ,Long> noOfMalesAndFemales= Rental_List.stream().collect(Collectors.groupingBy(Rental_Customer::getGender,Collectors.counting()));
		System.out.println(noOfMalesAndFemales);
		
		System.out.println();
		System.out.println("===============================================================");
		System.out.println("Type of Flats In the Apartment");
		Rental_List.stream().map(Rental_Customer::getFlat).distinct().forEach(System.out::println);
		
		
		System.out.println();
		System.out.println("=============================================================");
		System.out.println("==============Avarege Rent on each Flat=====================");
		Map<String,Double>avgRentonFlats =Rental_List.stream().collect(Collectors.groupingBy(Rental_Customer::getFlat,Collectors.averagingDouble(Rental_Customer::getRent)));
		Set<Entry<String,Double>>entrySet=avgRentonFlats.entrySet();
		for(Entry<String,Double>entry:entrySet)
		{
			System.out.println(entry.getKey()+" : "+entry.getValue());
			
			
		}
		
		
		System.out.println();
		System.out.println("==========================================================");
		System.out.println("====================Number of People Staying in Different Flats===============");
		Map<String,Long>RentalCountByFlat=Rental_List.stream().collect(Collectors.groupingBy(Rental_Customer::getFlat,Collectors.counting()));
		Set<Entry<String,Long>>entrySet1=RentalCountByFlat.entrySet();
		for(Entry<String,Long>entry:entrySet1)
		{
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
		
		System.out.println();
		System.out.println("===========================================================================");
		System.out.println("==========================People Came for After 2016=====================");
		Rental_List.stream().filter(e->e.getYearOfJoining()>2018).map(Rental_Customer::getName).forEach(System.out::println);
		
		
		Optional<Rental_Customer>HighestRentPaidMate=Rental_List.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Rental_Customer::getRent)));
		Rental_Customer HighestRentPaid=HighestRentPaidMate.get();
		System.out.println();
		System.out.println("===============================================================");
		System.out.println("=========================Details of Highest Rent paid Mate=====================");
		System.out.println("Id  : "+HighestRentPaid.getId());
		System.out.println("Nmae  : "+HighestRentPaid.getName());
		System.out.println("Age  : "+HighestRentPaid.getAge());
		System.out.println("Gender  : "+HighestRentPaid.getGender());
		System.out.println("Flat Type  : "+HighestRentPaid.getFlat());
		System.out.println("Year Of Joining  : "+HighestRentPaid.getYearOfJoining());
		System.out.println("Rent  : "+HighestRentPaid.getRent());
		
		
		Optional<Rental_Customer>LowestRentPaidMate=Rental_List.stream().collect(Collectors.minBy(Comparator.comparingDouble(Rental_Customer::getRent)));
		Rental_Customer LowestRentPaid=LowestRentPaidMate.get();
		System.out.println();
		System.out.println("===============================================================");
		System.out.println("=========================Details of Lowest Rent paid Mate=====================");
		System.out.println("Id  : "+LowestRentPaid.getId());
		System.out.println("Nmae  : "+LowestRentPaid.getName());
		System.out.println("Age  : "+LowestRentPaid.getAge());
		System.out.println("Gender  : "+LowestRentPaid.getGender());
		System.out.println("Flat Type  : "+LowestRentPaid.getFlat());
		System.out.println("Year Of Joining  : "+LowestRentPaid.getYearOfJoining());
		System.out.println("Rent  : "+LowestRentPaid.getRent());
		
	}

}
