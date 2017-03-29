/*
 *	Patrick Raphael Perez & Irvin Alo
 *	Copyright 2017
 *	All rights reserved
 */
import java.util.PriorityQueue;

public class jobScheduler
{
  private int nJobs;
  private Job[] jobs;   
  
  public JobScheduler(int[] jobLength, int[] deadline, int[] profit)
  {
     //Set nJobs
     //Fill "jobs" array. The kth job entered has JobNo = k;
	 nJobs = jobLength.length;
	 jobs = new Job[nJobs];
	 for (int k = 0; k < nJobs; k++){
		 jobs[k] = new Job(k, jobLength[k], deadline[k], profit[k]);
	 }
	
  }
  
  public void printJobs()  //prints the array jobs
  {  
	  for (int i = this.nJobs-1; i >= 0; i--){
		  System.out.println(jobs[i].toString());
	  }
  }
    
  //Brute force. Try all n! orderings. Return the schedule with the most profit
  public Schedule bruteForceSolution()
  {
	return null;   }

 
  public Schedule makeScheduleEDF()  
  //earliest deadline first schedule. Schedule items contributing 0 to total profit last
  {
	return null;  }

  public Schedule makeScheduleSJF()
//shortest job first schedule. Schedule items contributing 0 to total profit last
  {
	  Schedule shortestJobFirst = new Schedule();
	return null; } 
 
  public Schedule makeScheduleHPF()  
 //highest profit first schedule. Schedule items contributing 0 to total profit last
  {
	  Schedule highestProfitFirst = new Schedule();
	return null; }

 public Schedule newApproxSchedule() //Your own creation. Must be <= O(n3)
{
	return null;  }

}//end of JobScheduler class
