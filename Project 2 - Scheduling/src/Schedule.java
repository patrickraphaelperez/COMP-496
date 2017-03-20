/*
 *	Patrick Raphael Perez & Irvin Alo
 *	Copyright 2017
 *	All rights reserved
 */
import java.util.ArrayList;

class Schedule
{
  ArrayList<Job> schedule;
  int profit;
   
  public Schedule()
  {
     profit = 0;
     schedule = new ArrayList<Job>();
  }
  
  public void add(NPJob job)
  {  
	  
  }
    
 
 public int getProfit()
  {
	return profit;    
  }
      
  public String toString()
  {
     String s = "Schedule Profit = " + profit ;
     for(int k = 0 ; k < schedule.size(); k++)
     {
        s = s + "\n"  + schedule.get(k);
         
     }
         
     return s;
  }     
}// end of Schedule class