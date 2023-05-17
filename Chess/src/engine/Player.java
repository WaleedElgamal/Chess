package engine;

import java.util.ArrayList;

import model.world.Piece;

public class Player {
	private String name;
	private ArrayList<Piece> pieces;
	private Piece king;
	
	public Player(String name) {
		this.name = name;
		pieces = new ArrayList<Piece>();
		king = null;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Piece> getPieces() {
		return pieces;
	}

	public Piece getKing() {
		return king;
	}

	public void setKing(Piece king) {
		this.king = king;
	}
	
	
}
