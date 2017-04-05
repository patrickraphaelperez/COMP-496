/*
 *	Patrick Raphael Perez & Irvin Alo
 *	Copyright 2017
 *	All rights reserved
 *
 *	Comp 496
 *	Due April 6, 2017
 *	Project 2: Job Scheduler
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
    
  public Schedule scheduler(Job[] arr) {
	  //Scheduler object
	  
	  return null;
  }
  //Brute force. Try all n! orderings. Return the schedule with the most profit
  public Schedule bruteForceSolution()
  {
	  Schedule bruteForceSolution = new Schedule();
	  
	return null;   
  }

 
  public Schedule makeScheduleEDF()  
  //earliest deadline first schedule. Schedule items contributing 0 to total profit last
  {
	  
	  //Sort tasks by earliest deadline--------------- (insertion sort)
	  Job temp;
	  for (int i = 0; i >= nJobs; i++){
		  for (int j = i; j > 0; j--){
			  
			  if (jobs[i].getDeadline() < jobs[i+1].getDeadline()) {
				  
				  temp = jobs[j];
				  jobs[j] = jobs[j-1];
				  jobs[j-1] = temp;
			  
			  }
		  }
	  }
	  //Set schedule
	  Schedule earliestdeadline = new Schedule();
	  
	  
	  
	  
	  
	  

	return null;  
  }

  public Schedule makeScheduleSJF() //PAT
//shortest job first schedule. Schedule items contributing 0 to total profit last
  {
	  Schedule shortestJobFirst = new Schedule();
	return null; } 
 
  public Schedule makeScheduleHPF() //PAT
 /* highest profit first schedule. Schedule items contributing 0 to total profit last
  * we must compare the profit of all the jobs to each other, and sort them as such
  * idea: use a priority queue to sort the jobs according to a comparator that compares profit
  */
  
  {
	  Schedule highestProfitFirst = new Schedule();
	  Comparator<Job> comparator = new hpfComparison();
	  PriorityQueue<Job> queue = new PriorityQueue<Job>(nJobs, comparator)
	return null; }

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
  
  public int getLength() {
	  return length;
  }
  
  public int getProfit() {
	  return profit;
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
  
<<<<<<< HEAD
  public void add(Job job)
  {  
	  schedule.add(job);
=======
  //adding a job to the schedule (which is an array list)
  public void add(Job job)
  {  
	  if(this.schedule.size() == 0){
		  job.start = 0;
		  job.finish = job.length + job.start;
		  /*
		   * if a job finishes before its deadline, we get a profit
		   * otherwise, we store the job in a temprorary array and then add them to our schedule last
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
>>>>>>> master
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
	}
}

