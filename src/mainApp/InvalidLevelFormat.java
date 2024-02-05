package mainApp;

/**
 * Class: InvalidLevelFormat
 * <br>Purpose: Our own Exception, which is used when the level specificiations in the text file is invalid.
 */
public class InvalidLevelFormat extends Exception {
	
	private String errMessage;
	
	public InvalidLevelFormat() {
		
		this.errMessage = "Invalid Level Format. Line 1 & 2 are for Normal and Electric Barriers. They take in an x-coord, y-coord, and angle. Line 3 is for coins. They take in an x & y coordinate.";
		
	}
	/**
	 * Returns this Excpetion's error message
	 * @return this.errMessage
	 */
	public String getErrMessage() {
		return this.errMessage;
	}

}
