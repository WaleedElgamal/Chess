package exceptions;

public class InvalidTargetCell extends GameActionException {
	public InvalidTargetCell() {
		super();
	}
	
	public InvalidTargetCell(String s) {
		super(s);
	}
}
