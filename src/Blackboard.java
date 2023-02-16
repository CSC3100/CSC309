import java.awt.*;
import java.util.LinkedList;
import java.util.Observable;


/**
 * This is the blackboard class it's structured
 * as a singleton. Primpary purpose is to store
 * applications metadata
 */
public class Blackboard extends Observable {
	
	private static Blackboard blackboard;
	private LinkedList<Box> boxes;
	private String statusBarMessage;
	
	/**
	 * Either creates new Blackboard object
	 * or returns the blackboard instance following
	 * the singleton pattern.
	 * 
	 * @return Blackboard instance
	 */
	public static Blackboard getInstance() {
		if (blackboard == null) {
			blackboard = new Blackboard();
		}
		return blackboard;
	}
	
	private Blackboard() {
		boxes = new LinkedList<>();
	}
	

	/**
	 * Addes the passed Box to the data structure
	 * 
	 * @param b an instance of the Box to be added
	 */
	public void addBox(Box b) {
		statusBarMessage = "box added";
		boxes.add(b);
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Getter for boxes
	 * 
	 * @return A linkedlist of Boxes
	 */
	public LinkedList<Box> getBoxes() {
		return boxes;
	}
	
	/**
	 * clears the boxes linkedlist
	 */
	public void clean() {
		boxes.clear();
	}
	
	/**
	 * returns the text for the status bar message
	 * 
	 * @return string of text message
	 */
	public String getStatusBarMessage() {
		return statusBarMessage;
	}

	public void setStatusBarMessage(String message){statusBarMessage = message;}

	/**
	 * Removes passed Box from the boxes linkedlist
	 * 
	 * @param clickedBox Box object to be removed
	 */
	public void deleteBox(Box clickedBox) {
		if (Blackboard.getInstance().getBoxes().remove(clickedBox)) {
			statusBarMessage = "box deleted";
			setChanged();
			notifyObservers();
		}
	}
	
	/**
	 * Returns the coordinates for the next availble 
	 * position
	 * 
	 * @return Point object
	 */
	public Point getNextPositionAvailable(){
		return new Point(0, 0);
	}
	
}

