/*Hetvi Patel
This program prints calender of a year or a month, according to the user. This prompts the user to choose the calendar for 
the month or the year. If they select “year” then the program displays the calendar for the given year. 
If they select “month” then it prompts the user to enter the month and then displays the calendar for the given month.
3/22/2020*/ 
import java.util.*;
public class PrintCalenderMain
{
   /*this main method does all the main work of the program. it prompts user to enter a year
   and month accordingly. It then asks if they want to print another year*/
   public static void main(String[] args)
   {
      Scanner kb = new Scanner(System.in);
      boolean repeat = true;
      do
      {
         System.out.print("Enter a year between 1800 and 3000: ");
         int year = kb.nextInt();
         System.out.println("Select one of the following options:");  
         System.out.println("To get the month calendar press m or M");
         System.out.println("To get the calendar for the year enter y or Y");
         System.out.print("Enter your choice: ");
         kb.nextLine();
         String answer = kb.nextLine();
         if(answer.equalsIgnoreCase("m"))
         {
            System.out.print("Enter the month of the year (1 through 12):");
            int month = kb.nextInt();
            if(month<1||month>12)
            {
               System.out.print("Enter the month of the year (1 through 12):");
               month = kb.nextInt();
            }
            printMonth(year,month);  
         }
         else if(answer.equalsIgnoreCase("y"))
         {
            for(int i=1;i<=12;i++)
            {
               printMonth(year,i);
            }                    
         }
         do 
         {
            System.out.print("Do you have another year to print the calender:yes/no-->");
            answer = kb.next();
         } 
         while(!answer.equalsIgnoreCase("no") && !answer.equalsIgnoreCase("yes"));
         repeat = answer.equalsIgnoreCase("yes");
      } 
      while (repeat); 
   }
   //this method prints the title of the month
   public static void printMonthTitle(int year, int month)
   {
      String monthtitle = PrintCalenderHelper.getMonthName(month);
      System.out.print("        " + monthtitle + " " + year);   
      System.out.print("\n---------------------------\n");
      System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
   }
   //the below method prints the body of the month i.e., the days of the month in a proper format 
   public static void printMonthBody(int month, int year)
   {
      int startday = PrintCalenderHelper.getStartDay(year,month);
      print(startday,year,month);
   }
   //this method prints the whole month with the title and body together
   public static void printMonth(int year, int month)
   {
      printMonthTitle(year,month);
      printMonthBody(month,year);
   }
   //this method is for the proper format of the body of month. The spaces between displaying each day.
   public static void print(int startDay, int year, int month)
   {
      int numberOfDaysInMonth = PrintCalenderHelper.getNumberOfDaysInMonth(year, month);
      for(int i = 0;i<startDay;i++)
      {
         System.out.print("    ");
      }
      for (int i=1;i<=numberOfDaysInMonth; i++) 
      {
         if (i < 10)
            System.out.print("   " + i);
         else
            System.out.print("  " + i);
         if ((i + startDay) % 7 == 0)
            System.out.println();            
      }
      //if the month is november it prints the thanksgving day
      if(month==11)
      {
         int thanksday = PrintCalenderHelper.thanks(startDay);
         System.out.println("\n**Thanks giving day is on the " + thanksday + "th");
      }
      System.out.println();
      System.out.println();
   }
}