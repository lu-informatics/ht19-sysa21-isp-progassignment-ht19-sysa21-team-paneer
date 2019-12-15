
public class IdGenerator {

	private int lastID;
	private int minID;
	private int maxID;
	private String letterID;
	
	public IdGenerator(int minID, int maxID, String letterID) {
		this.minID = minID;
		this.maxID = maxID;
		this.letterID = letterID;
	}
	public String next() {
		int value = lastID;
		lastID++;
		String newID =letterID + value;
		
		if(value >= minID  && value <= maxID) {
			return newID;
		}
		
		return null;
		
	 	
		
	}
}
