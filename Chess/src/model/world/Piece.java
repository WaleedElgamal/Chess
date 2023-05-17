package model.world;

import java.awt.Point;
import java.util.ArrayList;

public abstract class Piece {
	private String color;
	private Point location;
	private ArrayList<Point> validMoves;
	private ArrayList<Point> legitMoves;
	
	
	public Piece(String color) {
		this.color = color;
		this.location = new Point();
		validMoves = new ArrayList<>();
		legitMoves = new ArrayList<>();
	}
	
	public abstract void validateMoves();
	
	public  ArrayList<Point> getValidMoves(){
		return validMoves;
	}
	
	public ArrayList<Point> getLegitMoves() {
		return legitMoves;
	}
	
	public Point getLocation() {
		return location;
	}


	public void setLocation(Point location) {
		this.location = location;
	}

	public String getColor() {
		return color;
	}

	
	

	
}
