package lab1;

/**
 * @author Clayton Engle
 * Lab 1 Time Class
 */

public class Time {
	
	private int hours;
	private int minutes;
	private int seconds;
	
	
	/**
	* Constructs a Time object with the specified hours, minutes, and seconds.
	* @param hours The hours component of the time.
	* @param minutes The minutes component of the time.
	* @param seconds The seconds component of the time.
	*/
	public Time(int hours, int minutes, int seconds) {
		super();
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}
	
	//default constructor which sets the time to 9:00:00
	public Time() {
		this.hours = 9;
		this.minutes = 0;
		this.seconds = 0;
	}
	
	/**
	 * Compares this Time object to another Object.
	 * 
	 * @param obj the Object to compare to
	 * @return true if object is a Time object with the same hours, minutes, and seconds, false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		// Check if this Time object and object refer to the same object
		if (this == obj)
			return true;
		
		// Check if object is null
		if (obj == null)
			return false;
		
		// Check if object is an instance of the same class as this Time object
		if (getClass() != obj.getClass())
			return false;
		
		// Cast object to Time and compare the hours, minutes, and seconds
		Time other = (Time) obj;
		return hours == other.hours && minutes == other.minutes && seconds == other.seconds;
	}

	/**
	 * This method increments the seconds by 1.
	 * If seconds are 59 or more, it sets seconds to 0 and calls the incrementMinutes() method.
	 */
	public void incrementSeconds() {
	    // Check if seconds are 59 or more
	    if (seconds >= 59) {
	        // If yes, set seconds to 0 and call incrementMinutes() method
	        seconds = 0;
	        incrementMinutes();
	    } else {
	        // If no, just increment seconds by 1
	        seconds += 1;
	    }
	}

	/**
	 * Method to increment the minutes in the Time object.
	 * If the current minutes is greater than or equal to 59, 
	 * then it sets the minutes to 0 and increments the hours.
	 * Else, it increments the minutes by 1.
	 */
	public void incrementMinutes() {
		if(minutes >= 59) {
			minutes = 0;
			incrementHours();
		} else {
			minutes += 1;
		}
	}

	/**
	 * Method to increment the hours in the Time object.
	 * If the current hours is greater than or equal to 23, 
	 * then it sets the hours to 0.
	 * Else, it increments the hours by 1.
	 */
	public void incrementHours() {
		if(hours >= 23) {
			hours = 0;
		} else {
			hours += 1;
		}
	}

	//Getters and Setters for fields
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	public int getSeconds() {
		return seconds;
	}
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	
	// Returns a string representation of the time in hours, minutes, and seconds format.
	@Override
	public String toString() {
		return  hours + ":" + minutes + ":" + seconds;
	}
}
Footer
© 2023 GitHub, Inc.
