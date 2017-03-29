/*
 *	Patrick Raphael Perez & Irvin Alo
 *	Copyright 2017
 *	All rights reserved
 */
class Job
{
  int jobNumber;
  int length;
  int deadline;
  int profit;
  int start;
  int finish;   
   
  public Job(int jn , int len, int d, int p)
  {
     jobNumber = jn; 
     length = len; 
     deadline = d;
     profit = p;  
     start = -1;  
     finish = -1;
  }
   
     
  public String toString()
  {
     return "#" + jobNumber + ":(" + length + "," 
              + deadline + "," + profit + 
              "," + start + "," + finish + ")";
  }

}//end of Job class