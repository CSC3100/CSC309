import java.awt.*;
import java.util.LinkedList;
import java.util.Observable;

public class Blackboard extends Observable {
	
	private static Blackboard blackboard;
	private LinkedList<Box> boxes;
	private String statusBarMessage;
	
	public static Blackboard getInstance() {
		if (blackboard == null) {
			blackboard = new Blackboard();
		}
		return blackboard;
	}
	
	private Blackboard() {
		boxes = new LinkedList<>();
	}
	
	public void addBox(Box b) {
		statusBarMessage = "box added";
		boxes.add(b);
		setChanged();
		notifyObservers();
	}

	public Point calculatePosition() {
		int xSum = 0;
		int ySum = 0;
		int newX, newY;
		for (Box b: boxes) {
			xSum += b.getPoint().getX();
			ySum += b.getPoint().getY();
		}
		newX = xSum / boxes.size();
		newY = ySum / boxes.size();
		Point p = new Point(newX, newY);
		return p;
	}
	
	public LinkedList<Box> getBoxes() {
		return boxes;
	}
	
	public void clean() {
		boxes.clear();
	}
	
	public String getStatusBarMessage() {
		return statusBarMessage;
	}
	
	public void deleteBox(Box clickedBox) {
		if (Blackboard.getInstance().getBoxes().remove(clickedBox)) {
			statusBarMessage = "box deleted";
			setChanged();
			notifyObservers();
		}
	}
	
	public Point getNextPositionAvailable(){
		return new Point(0, 0);
	}
	
}
