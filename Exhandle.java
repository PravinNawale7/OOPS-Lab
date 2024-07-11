/* Practical 9
Write a java program to create User defined exception to check the
following conditions and throw the exception if the criterion does not
meet. (a) User has age between 18 and 55 (b)User stays has income
between Rs.50,000 – Rs. 1,00,000 per month (c) User stays in Pune/
Mumbai/ Bangalore / Chennai (d)User has 4-wheeler Accept age, Income,
City, Vehicle from the user and check for the conditions mentioned above.
If any of the condition not met then throw the exception.
*/
import java.util.Scanner;
class UserDefinedException extends Exception {
public UserDefinedException(String message) {
super(message);
}
}
class User {
private int age;
private double income;
private String city;
private boolean hasFourWheeler;
public void setAge(int age) {
this.age = age;
}
public void setIncome(double income) {
this.income = income;
}
public void setCity(String city) {
this.city = city;
}
public void setHasFourWheeler(boolean hasFourWheeler) {
this.hasFourWheeler = hasFourWheeler;
}
public int getAge() {
return age;
}
public double getIncome() {
return income;
}
public String getCity() {
return city;
}
public boolean getHasFourWheeler() {
return hasFourWheeler;
}
}
public class Exhandle {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
User user = new User();
System.out.print("Enter age: ");
user.setAge(scanner.nextInt());
System.out.print("Enter income: ");
user.setIncome(scanner.nextDouble());
System.out.print("Enter city: ");
user.setCity(scanner.next());
System.out.print("Do you have a 4-wheeler? (true/false) ");
user.setHasFourWheeler(scanner.nextBoolean());
try {
if (user.getAge() < 18 || user.getAge() > 55) {
throw new UserDefinedException("Age must be between 18 and 55");
}
if (user.getIncome() < 50000 || user.getIncome() > 100000) {
throw new UserDefinedException("Income must be between Rs. 50,000 - Rs. 1,00,000 per
month");
}
if (!user.getCity().equalsIgnoreCase("Pune") && !user.getCity().equalsIgnoreCase("Mumbai") &&
!user.getCity().equalsIgnoreCase("Bangalore") && !user.getCity().equalsIgnoreCase("Chennai"))
{
throw new UserDefinedException("User must stay in Pune, Mumbai, Bangalore or Chennai");
}
if (!user.getHasFourWheeler()) {
throw new UserDefinedException("User must have a 4-wheeler");
}
System.out.println("All criteria met");
} catch (UserDefinedException e) {
System.out.println("Exception: " + e.getMessage());
}
}
}
