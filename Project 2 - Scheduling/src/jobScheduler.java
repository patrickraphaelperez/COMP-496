/*
 *	Patrick Raphael Perez & Irvin Alo
 *	Copyright 2017
 *	All rights reserved
 */
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Comparator;

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
	  Schedule bruteForceSolution = new Schedule();
	return null;   }

 
  public Schedule makeScheduleEDF()  
  //earliest deadline first schedule. Schedule items contributing 0 to total profit last
  {
	  Schedule earliestDeadlineFirst = new Schedule();
	  
	  //Sort tasks by earliest deadline---------------
	  int d = 0; 
	  for (int i = 0; i >= nJobs; i++){
		  
	  }
	  //----------------------------------------------
	  
	  

	return null;  }

  public Schedule makeScheduleSJF() //PAT
//shortest job first schedule. Schedule items contributing 0 to total profit last
  {
	  Schedule shortestJobFirst = new Schedule();
	return null; } 
 
  public Schedule makeScheduleHPF(){
 /* highest profit first schedule. Schedule items contributing 0 to total profit last
  * we must compare the profit of all the jobs to each other, and sort them as such
  * idea: use a priority queue to sort the jobs according to a comparator that compares profit
  */
	  Schedule highestProfitFirst = new Schedule();
	  Comparator<Job> comparator = new hpfComparison();
	  PriorityQueue<Job> queue = new PriorityQueue<Job>(nJobs, comparator);
	  
	  for(int i = 0; i < nJobs; i++){
		  queue.add(jobs[i]);
	  }
	  
	  
	return highestProfitFirst; 
	}

 public Schedule newApproxSchedule() //Your own creation. Must be <= O(n3)
{
	return null;  }

}//end of JobScheduler class

//Job class
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

   public int getDeadline() {
      return deadline;
   }
   
   public int getProfit(){
	   return profit;
   }
   
   public int getLength(){
	   return length;
   }
     
  public String toString()
  {
     return "#" + jobNumber + ":(" + length + "," 
              + deadline + "," + profit + 
              "," + start + "," + finish + ")";
  }

}//end of Job class

//Schedule Class
class Schedule
{
  ArrayList<Job> schedule;
  ArrayList<Job> unprofitableSchedule;
  int profit;
   
  public Schedule()
  {
     profit = 0;
     schedule = new ArrayList<Job>();
     //this temporary schedule is for unprofitable jobs
     unprofitableSchedule = new ArrayList<Job>();
  }
  
  //adding a job to the schedule (which is an array list)
  public void add(Job job)
  {  
	  if(this.schedule.size() == 0){
		  job.start = 0;
		  job.finish = job.length + job.start;
		  /*
		   * if a job finishes before its deadline, we get a profit
		   * otherwise, we store the job in a temprorary array and then add them to our schedule at the end
		   */
		  if(job.finish <= job.deadline){
			  this.profit += job.profit;
			  this.schedule.add(job);
		  } else {
			  this.unprofitableSchedule.add(job);
		  }
	  } else {
		  Job previousJob = this.schedule.get(this.schedule.size() - 1);
		  job.start = previousJob.finish;
		  job.finish = job.start + job.length;
		  if(job.finish <= job.deadline){
			  this.profit += job.profit;
			  this.schedule.add(job);
		  } else {
			  this.unprofitableSchedule.add(job);
		  }
	  }
  }
  
  public void completeSchedule(){
	  int n = unprofitableSchedule.size();
	  for(int i = 0; i < n; i++){
		  Job lastJob = this.schedule.get(this.schedule.size() - 1);
		  Job job = this.unprofitableSchedule.get(0);
		  this.unprofitableSchedule.remove(0);
		  job.start = lastJob.finish;
		  job.finish = job.start + job.length;
		  this.schedule.add(job);
	  }
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

// Highest Profit First Comparator
class hpfComparison implements Comparator<Job> {
	public int compare(Job a, Job b){
		/*
		 * return 1 if b goes before a
		 * return -1 if a goes before b
		 * return 0 otherwise
		 */
		if (a.profit > b.profit){
			return -1;
		} 
		else if (a.profit < b.profit){
			return 1;
		}
		else {
			return 0;
		}
	}
}

