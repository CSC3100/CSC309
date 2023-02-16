import javax.swing.*;
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

	public void renameBox(Box clickedBox) {
		String name = JOptionPane.showInputDialog("Please input name");
		if(name != null) {
			clickedBox.setName(name);
			clickedBox.resize();
			setChanged();
			notifyObservers();
			statusBarMessage = "box renamed";
		}
	}
	
	public Point getNextPositionAvailable(){
		return new Point(0, 0);
	}
	
}
