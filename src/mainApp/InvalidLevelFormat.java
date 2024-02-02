package mainApp;

public class InvalidLevelFormat extends Exception {
	
	private String errMessage;
	
	public InvalidLevelFormat() {
		
		this.errMessage = "Invalid Level Format. Back to the lobby bud...";
		
	}
	
	public String getErrMessage() {
		return this.errMessage;
	}

}
