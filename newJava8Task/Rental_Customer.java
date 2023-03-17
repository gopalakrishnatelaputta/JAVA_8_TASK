package newJava8Task;

public class Rental_Customer 
{
	int id;
    
    String name;
     
    int age;
     
    String gender;
     
    String Flat;
     
    int yearOfJoining;
     
    double Rent;
     
    public Rental_Customer(int id, String name, int age, String gender, String Flat, int yearOfJoining, double Rent) 
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.Flat = Flat;
        this.yearOfJoining = yearOfJoining;
        this.Rent = Rent;
    }
     
    public int getId() 
    {
        return id;
    }
     
    public String getName() 
    {
        return name;
    }
     
    public int getAge() 
    {
        return age;
    }
     
    public String getGender() 
    {
        return gender;
    }
     
    public String getFlat() 
    {
        return Flat;
    }
     
    public int getYearOfJoining() 
    {
        return yearOfJoining;
    }
     
    public double getRent() 
    {
        return Rent;
    }
     
    @Override
    public String toString() 
    {
        return "Id : "+id
                +", Name : "+name
                +", age : "+age
                +", Gender : "+gender
                +", Flat : "+Flat
                +", Year Of Joining : "+yearOfJoining
                +", Rent : "+Rent;
    }
}


