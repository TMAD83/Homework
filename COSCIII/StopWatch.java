/**
Class StopWatch supports objects representing a stop watch for measuring the time required to execute a process.  Time is measured in seconds.
*/
public class StopWatch
{
      	private long startTime, stopTime;
		/**
		Initializes this StopWatch object<p>
		<b>Post:</b><br> startTime and stopTime of this StopWatch object initialized to 0<p>
		*/
		public StopWatch()
      	{
      		startTime = stopTime = 0;
      	}
		/**
		Starts this StopWatch <p>
		<b>Post:</b><br> startTime of this StopWatch set to the current system clock time in 
		nanosecond <p>
		*/
      	public void start()
      	{
     		startTime = System.nanoTime();
      	}
		/**
		Stops this StopWatch <p>
		<b>Post:</b><br> stopTime of this StopWatch set to the current system clock time in 
		nanosecond <p>
		<b>Return:</b><br>Interval of time from start to stop measured in seconds.
		*/
      	public double stop()
      	{
         		stopTime = System.nanoTime();
         		return (stopTime - startTime)/1000000000.0;
		}
}