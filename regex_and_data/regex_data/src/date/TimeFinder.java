package date;






import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


import java.util.Scanner;

public class TimeFinder {


public void printDate(){

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter your birth data with the following format dd.MM.yyyy :");
    System.out.println("Enter day. Example: 07 ");
    String day = sc.next();
    System.out.println("Enter month. Example: 02 ");
    String month = sc.next();
    System.out.println("Enter year. Example: 1988 ");
    String year = sc.next();


    LocalDate localDate = LocalDate.now();
    LocalDate localDate2 = LocalDate.parse(day+"."+month+"."+year, DateTimeFormatter.ofPattern("dd.MM.yyyy"));


    Period p = Period.between(localDate2,localDate);

    System.out.println("You are " +p.getYears() +" years, "+p.getMonths()+" months, "+p.getDays() +" days.");


}


}
