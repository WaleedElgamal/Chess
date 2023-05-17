package model.world;

import java.awt.Point;
import engine.Game;


public class Rook extends Piece{
	public Rook(String color) {
		super(color);
	}

	public void validateMoves() {
		getValidMoves().clear();
		getLegitMoves().clear();
		int i = this.getLocation().x+1;
		int j = this.getLocation().y;
		while (i<=7 && Game.getBoard()[i][j]==null) {
			getValidMoves().add(new Point(i,j));
			i++;
		}
		if (i<=7 && !((Piece) (Game.getBoard()[i][j])).getColor().equals(this.getColor())) {
			getValidMoves().add(new Point(i,j));
		}
		i = this.getLocation().x-1;
		while (i>=0 && Game.getBoard()[i][j]==null) {
			getValidMoves().add(new Point(i,j));
			i--;
		}
		if (i>=0 && !((Piece) (Game.getBoard()[i][j])).getColor().equals(this.getColor())) {
			getValidMoves().add(new Point(i,j));
		}
		i = this.getLocation().x;
		j = this.getLocation().y+1;
		while (j<=7 && Game.getBoard()[i][j]==null) {
			getValidMoves().add(new Point(i,j));
			j++;
		}
		if (j<=7 && !((Piece) (Game.getBoard()[i][j])).getColor().equals(this.getColor())) {
			getValidMoves().add(new Point(i,j));
		}	
		j = this.getLocation().y-1;
		while (j>=0 && Game.getBoard()[i][j]==null) {
			getValidMoves().add(new Point(i,j));
			j--;
		}
		if (j>=0 && !((Piece) (Game.getBoard()[i][j])).getColor().equals(this.getColor())) {
			getValidMoves().add(new Point(i,j));
		}
	}
	
	
}
