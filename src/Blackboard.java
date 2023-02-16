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

	public void renameBoxStatusBarUpdate() {
		statusBarMessage = "box renamed";
		setChanged();
		notifyObservers();
	}
  
	public void movedBoxStatusBarUpdate() {
		statusBarMessage = "box moved";
		setChanged();
		notifyObservers();
	}

	public void buildProjectStatusBarUpdate() {
		statusBarMessage = "Building project";
		setChanged();
		notifyObservers();
	}
  
  //	Lexer not currently being used so nowhere to put these functions just yet
	public void lexerSuccessStatusBarUpdate() {
		statusBarMessage = "Lexer success";
		setChanged();
		notifyObservers();
	}

	public void lexerFailedStatusBarUpdate() {
		statusBarMessage = "Lexer failed";
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

	public void setStatusBarMessage(String message){statusBarMessage = message;}
	
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
