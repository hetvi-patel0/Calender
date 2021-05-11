import java.util.*;
public class PrintCalenderHelper
{
      //this method gets proper valid integer for the year
      public static int getValidInt(Scanner s, String prompt, int min, int max) 
      {
           int result;// Loop until valid input is read in
           do 
           {
               // Prompt user and loop until they have entered a number 
               System.out.print(prompt);
               while (!s.hasNextInt())
               {
                   s.nextLine();
                   System.out.print(prompt);
               }// Read in the number
               result = s.nextInt();
           } 
           while (result < min || result > max);// Return the result
           return result;
      }
      //this methid returns the date for thanksgiving on the month of november
      public static int thanks(int startDay)
      {  
         int thanks =(12-startDay)%7+21;
         return thanks;  
      }
      //the method below gets the months name and then returns it
      public static String getMonthName(int month) 
      {
           String monthname = null; 
           switch(month)
           {
                   case 1: monthname = "January";break;
                   case 2: monthname = "Febuary";break;
                   case 3: monthname = "March";break;
                   case 4: monthname = "April";break;
                   case 5: monthname = "May";break;
                   case 6: monthname = "June";break;
                   case 7: monthname = "July";break;
                   case 8: monthname = "August";break;
                   case 9: monthname = "September";break;
                   case 10: monthname = "October";break;
                   case 11: monthname = "November";break;
                   case 12: monthname = "December";break;
            }
            return monthname;
      }
      //this method gets the starting date of the month
      public static int getStartDay(int year, int month) 
      {
          int start = 3;
          int total = getTotalNumberOfDays(year, month);
          int fintotal = (total+start)%7;
          return fintotal;
      }
      //the method below gets the total number pf days in the year entered by the user
      public static int getTotalNumberOfDays(int year, int month) 
      {
          int total = 0;
          for (int i = 1800; i < year; i++)
          if (isLeapYear(i))
            total = total + 366;
          else
            total = total + 365;
          for (int i = 1; i < month; i++)
            total = total + getNumberOfDaysInMonth(year, i);
          return total;          
      }
      //this method gets the total number of days in the month
      public static int getNumberOfDaysInMonth(int year, int month) 
      {
          int days = 0;
          switch(month)
          {
               case 1: days = 30;
                       break;
               case 2: if(isLeapYear(year))
                       { 
                          days = 29;
                       }
                       else 
                       {
                          days = 28;
                       }
                       break;          
               case 3: days = 31;
                       break;
               case 4: days = 30;
                       break;
               case 5: days = 31;
                       break;
               case 6: days = 30;
                       break;
               case 7: days = 31;
                       break;
               case 8: days = 31;
                       break;
               case 9: days = 30;
                       break;
               case 10: days = 31;
                        break;
               case 11: days = 30;
                        break;
               case 12: days = 31;
                        break;
          }   
          return days;                    
      }  
      //this method checks whether the prompted year is a leapyear is not      
      public static boolean isLeapYear(int year)
      {
          if(year%400==0)
          {
             return true;
          }
          else
          {          
             return false;
          }
      }
}