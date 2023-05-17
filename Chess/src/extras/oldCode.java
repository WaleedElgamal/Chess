package extras;

import java.awt.Point;

import engine.Player;
import model.world.Piece;

public class oldCode {
	
	/*public Player checkGameState() {
		if (firstPlayer.getTeam().size() == 0)
			return secondPlayer;
		else if (secondPlayer.getTeam().size() == 0)
			return firstPlayer;
		else
			return null;
	}
	*/
	
	/*public void moveFirstPlayer(Piece p, int x, int y) throws UnallowedMovementException {
	int currx = p.getLocation().x;
	int curry = p.getLocation().y;
	if (p instanceof Pawn) {
		if (x>= p.getLocation().x || y!=p.getLocation().y){
			throw new UnallowedMovementException("Can only move vertically upwards");
		}
		else if ((p.getLocation().x==6 && p.getLocation().x-x >2) || (p.getLocation().x!=6 && p.getLocation().x-x!=1)){
			throw new UnallowedMovementException("Can only move vertically upwards");
		}
		else {
			if (board[x][y]==null) {
				board[p.getLocation().x][p.getLocation().y]=null;
				board[x][y]=p;
				p.setLocation(new Point(x, y));
			}
			else {
				throw new UnallowedMovementException("target cell not empty");
			}
		}
	}
	else if (p instanceof Rook) {
		if (x!= p.getLocation().x && y!=p.getLocation().y) {
			throw new UnallowedMovementException("Can only move vertically");
		}
		else {
			checkRookMove(p,x,y);
		}
	}
	else if (p instanceof Knight) {
		if (board[x][y]!=null) {
			throw new UnallowedMovementException("target cell not empty");
		}
		else {
			if ( (currx+1 ==x && curry-2==y) || (currx+2==x && curry-1==y) || (currx+1 ==x && curry+2==y) || (currx+2==x && curry+1==y) || (currx-1 ==x && curry-2==y) || (currx-2==x && curry-1==y) || (currx-1 ==x && curry+2==y) || (currx-2==x && curry+1==y) ) {
				board[p.getLocation().x][p.getLocation().y]=null;
				board[x][y]=p;
				p.setLocation(new Point(x, y));
			}
			else {
				throw new UnallowedMovementException("Invalid move");
			}
		}
	}
	else if (p instanceof Bishop) {
		int difx = Math.abs(x-currx);
		int dify = Math.abs(y-curry);
		if(difx!=dify) {
			throw new UnallowedMovementException("Can only move diagonally");
		}
		else if (board[x][y]!=null){
			throw new UnallowedMovementException("target cell not empty");
		}
		else {
			checkBishopMove(p,x,y);
		}
	}
	else if (p instanceof Queen) {
		int difx = Math.abs(x-currx);
		int dify = Math.abs(y-curry);
		if (difx!=dify && (x!= p.getLocation().x && y!=p.getLocation().y) ) {
			throw new UnallowedMovementException("Invalid move");	
		}
		else {
			checkRookMove(p,x,y);
			checkBishopMove(p,x,y);
			if (p.getLocation().x!=x && p.getLocation().y!=y)
				throw new UnallowedMovementException("Invalid move");
		}
	}
	else if (p instanceof King) {
		if(board[x][y]!=null) {
			throw new UnallowedMovementException("target cell not empty");
		}
		else {
			if ( (currx-1==x && curry-1==y) || (currx==x && curry-1==y) || (currx+1==x && curry-1==y) || (currx-1==x && curry==y) || (currx+1==x && curry==y) || (currx-1==x && curry+1==y) || (currx==x && curry+1==y) || (currx+1==x && curry+1==y)) {
				board[p.getLocation().x][p.getLocation().y]=null;
				board[x][y]=p;
				p.setLocation(new Point(x, y));
			}
			else {
				throw new UnallowedMovementException("Invalid move");
			}
		}
	}
}

public void moveSecondPlayer(Piece p, int x, int y) throws UnallowedMovementException {
	int currx = p.getLocation().x;
	int curry = p.getLocation().y;
	if (p instanceof Pawn) {
		if (x<= p.getLocation().x || y!=p.getLocation().y){
			throw new UnallowedMovementException("Can only move vertically upwards");
		}
		else if ((p.getLocation().x==1 && x-p.getLocation().x >2) || (p.getLocation().x!=1 && x-p.getLocation().x!=1)){
			throw new UnallowedMovementException("Can only move vertically upwards");
		}
		else {
			if (board[x][y]==null) {
				board[p.getLocation().x][p.getLocation().y]=null;
				board[x][y]=p;
				p.setLocation(new Point(x, y));
			}
			else {
				throw new UnallowedMovementException("target cell not empty");
			}
		}
	}
	else if (p instanceof Rook) {
		if (x!= p.getLocation().x && y!=p.getLocation().y) {
			throw new UnallowedMovementException("Can only move vertically");
		}
		else {
			checkRookMove(p,x,y);
		}
	}
	else if (p instanceof Knight) {
		if (board[x][y]!=null) {
			throw new UnallowedMovementException("target cell not empty");
		}
		else {
			if ( (currx+1 ==x && curry-2==y) || (currx+2==x && curry-1==y) || (currx+1 ==x && curry+2==y) || (currx+2==x && curry+1==y) || (currx-1 ==x && curry-2==y) || (currx-2==x && curry-1==y) || (currx-1 ==x && curry+2==y) || (currx-2==x && curry+1==y) ) {
				board[p.getLocation().x][p.getLocation().y]=null;
				board[x][y]=p;
				p.setLocation(new Point(x, y));
			}
			else {
				throw new UnallowedMovementException("Invalid move");
			}
		}
	}
	else if (p instanceof Bishop) {
		int difx = Math.abs(x-currx);
		int dify = Math.abs(y-curry);
		if(difx!=dify) {
			throw new UnallowedMovementException("Can only move diagonally");
		}
		else if (board[x][y]!=null){
			throw new UnallowedMovementException("target cell not empty");
		}
		else {
			checkBishopMove(p,x,y);
		}
	}
	else if (p instanceof Queen) {
		int difx = Math.abs(x-currx);
		int dify = Math.abs(y-curry);
		if (difx!=dify && (x!= p.getLocation().x && y!=p.getLocation().y) ) {
			throw new UnallowedMovementException("Invalid move");	
		}
		else {
			checkRookMove(p,x,y);
			checkBishopMove(p,x,y);
			if (p.getLocation().x!=x && p.getLocation().y!=y)
				throw new UnallowedMovementException("Invalid move");
		}
	}
	else if (p instanceof King) {
		if(board[x][y]!=null) {
			throw new UnallowedMovementException("target cell not empty");
		}
		else {
			if ( (currx-1==x && curry-1==y) || (currx==x && curry-1==y) || (currx+1==x && curry-1==y) || (currx-1==x && curry==y) || (currx+1==x && curry==y) || (currx-1==x && curry+1==y) || (currx==x && curry+1==y) || (currx+1==x && curry+1==y)) {
				board[p.getLocation().x][p.getLocation().y]=null;
				board[x][y]=p;
				p.setLocation(new Point(x, y));
			}
			else {
				throw new UnallowedMovementException("Invalid move");
			}
		}
	}
}

public void checkRookMove (Piece p, int x, int y) throws UnallowedMovementException {
	int currx = p.getLocation().x;
	int curry = p.getLocation().y;
	int c = 0;
	boolean flag = true;
	if (x==currx) {
		if (y>curry) {
			for (int i = curry+1; i<=y && flag;i++) {
				if (board[x][i]!=null)
					flag  = false;
			}
		}
		else {
			for (int i = curry-1; i>=y && flag;i--) {
				if (board[x][i]!=null)
					flag  = false;
			}
		}
	}
	else if (y==curry) {
		if (x>currx) {
			for (int i = currx+1; i<=x && flag;i++) {
				if (board[i][y]!=null)
					flag  = false;
			}
		}
		else {
			for (int i = currx-1; i>=x && flag;i--) {
				if (board[x][y]!=null)
					flag  = false;
			}
		}
	}
	else {
		c=1;
	}
	if (flag && c==0) {
		board[p.getLocation().x][p.getLocation().y]=null;
		board[x][y]=p;
		p.setLocation(new Point(x, y));
	}
	/*else {
		throw new UnallowedMovementException("target cell not empty");
	}*
}


public void checkBishopMove (Piece p, int x, int y) throws UnallowedMovementException {
	boolean flag = true;
	int currx = p.getLocation().x;
	int curry = p.getLocation().y;
	int c = 0;
	if (x<currx && y<curry) {
		for (int i = currx-1; i>=x && flag; i--) {
			for (int j = curry-1; j>=y && flag; j--) {
				if (board[i][j]!=null) {
					flag = false;
				}
			}
		}
	}
	else if (x>currx && y<curry) {
		for (int i = currx+1; i<=x && flag; i++) {
			for (int j = curry-1; j>=y && flag; j--) {
				if (board[i][j]!=null) {
					flag = false;
				}
			}
		}
	}
	else if (x<currx && y>curry) {
		for (int i = currx-1; i>=x && flag; i--) {
			for (int j = curry+1; j<=y && flag; j++) {
				if (board[i][j]!=null) {
					flag = false;
				}
			}
		}
	}
	else if (x>currx && y>curry) {
		for (int i = currx+1; i<=x && flag; i++) {
			for (int j = curry+1; j<=y && flag; j++) {
				if (board[i][j]!=null) {
					flag = false;
				}
			}
		}
	}
	else {
		c=1;
	}
	if (flag && c==0) {
		board[p.getLocation().x][p.getLocation().y]=null;
		board[x][y]=p;
		p.setLocation(new Point(x, y));
	}
	/*else {
		throw new UnallowedMovementException("Invalid move");
	}*

}

public void attack(Piece p, int x, int y) throws InvalidTargetCell, UnallowedMovementException {
	int currx = p.getLocation().x;
	int curry = p.getLocation().y;
	boolean flag = true;
	Piece temp = (Piece) board[x][y];
	if (p instanceof Pawn) {
		if(firstPlayer.getTeam().contains(p)) {
			if ((currx-1==x && curry-1==y) || (currx-1==x && curry+1==y)) {
				board[x][y]=p;
				board[currx][curry]=null;
				p.setLocation(new Point(x, y));
			}
			else {
				flag = false;
				//throw new InvalidTargetCell("Cannot attack this cell");
			}
		} 
		else {
			if ((currx+1==x && curry-1==y) || (currx+1==x && curry+1==y)) {
				board[x][y]=p;
				board[currx][curry]=null;
				p.setLocation(new Point(x, y));
			}
			else {
				flag = false;
				//throw new InvalidTargetCell("Cannot attack this cell");
			}
		}
	}
	else if (p instanceof Rook) {
		if (x!= p.getLocation().x && y!=p.getLocation().y) {
			throw new UnallowedMovementException("Can only move vertically");
		}
		else {
			checkRookAttack(p,x,y);
			if (p.getLocation().x!=x && p.getLocation().y!=y) {
				flag = false;
			}
		}
	}
	else if (p instanceof Knight) {
		if ( (currx+1 ==x && curry-2==y) || (currx+2==x && curry-1==y) || (currx+1 ==x && curry+2==y) || (currx+2==x && curry+1==y) || (currx-1 ==x && curry-2==y) || (currx-2==x && curry-1==y) || (currx-1 ==x && curry+2==y) || (currx-2==x && curry+1==y) ) {
			board[p.getLocation().x][p.getLocation().y]=null;
			board[x][y]=p;
			p.setLocation(new Point(x, y));
		}
		else {
			flag = false;
		}
	}
	else if (p instanceof Bishop) {
		int difx = Math.abs(x-currx);
		int dify = Math.abs(y-curry);
		if(difx!=dify) {
			throw new UnallowedMovementException("Can only move diagonally");
		}
		else {
			checkBishopAttack(p,x,y);
			if (p.getLocation().x!=x && p.getLocation().y!=y) {
				flag = false;
			}
		}
	}
	else if (p instanceof Queen) {
		int difx = Math.abs(x-currx);
		int dify = Math.abs(y-curry);
		if (difx!=dify && (x!= p.getLocation().x && y!=p.getLocation().y) ) {
			throw new UnallowedMovementException("Invalid move");	
		}
		else {
			checkRookAttack(p,x,y);
			checkBishopAttack(p,x,y);
			if (p.getLocation().x!=x && p.getLocation().y!=y)
				throw new UnallowedMovementException("Invalid move");
		}
	}
	else if (p instanceof King) {
		if ( (currx-1==x && curry-1==y) || (currx==x && curry-1==y) || (currx+1==x && curry-1==y) || (currx-1==x && curry==y) || (currx+1==x && curry==y) || (currx-1==x && curry+1==y) || (currx==x && curry+1==y) || (currx+1==x && curry+1==y)) {
			board[p.getLocation().x][p.getLocation().y]=null;
			board[x][y]=p;
			p.setLocation(new Point(x, y));
		}
		else {
			flag=false;
		}
	}
	if (flag) {
		if (firstPlayer.getTeam().contains(temp)) {
			firstPlayer.getTeam().remove(temp);
		}
		else {
			secondPlayer.getTeam().remove(temp);
		}
	}
	
}

public void checkRookAttack (Piece p, int x, int y){
	int currx = p.getLocation().x;
	int curry = p.getLocation().y;
	int c = 0;
	boolean flag = true;
	if (x==currx) {
		if (y>curry) {
			for (int i = curry+1; i<y && flag;i++) {
				if (board[x][i]!=null)
					flag  = false;
			}
		}
		else {
			for (int i = curry-1; i>y && flag;i--) {
				if (board[x][i]!=null)
					flag  = false;
			}
		}
	}
	else if (y==curry) {
		if (x>currx) {
			for (int i = currx+1; i<x && flag;i++) {
				if (board[i][y]!=null)
					flag  = false;
			}
		}
		else {
			for (int i = currx-1; i>x && flag;i--) {
				if (board[x][y]!=null)
					flag  = false;
			}
		}
	}
	else {
		c=1;
	}
	if (flag && c==0) {
		board[p.getLocation().x][p.getLocation().y]=null;
		board[x][y]=p;
		p.setLocation(new Point(x, y));
	}
}

public void checkBishopAttack (Piece p, int x, int y){
	boolean flag = true;
	int currx = p.getLocation().x;
	int curry = p.getLocation().y;
	int c = 0;
	if (x<currx && y<curry) {
		for (int i = currx-1; i>x && flag; i--) {
			for (int j = curry-1; j>y && flag; j--) {
				if (board[i][j]!=null) {
					flag = false;
				}
			}
		}
	}
	else if (x>currx && y<curry) {
		for (int i = currx+1; i<x && flag; i++) {
			for (int j = curry-1; j>y && flag; j--) {
				if (board[i][j]!=null) {
					flag = false;
				}
			}
		}
	}
	else if (x<currx && y>curry) {
		for (int i = currx-1; i>x && flag; i--) {
			for (int j = curry+1; j<y && flag; j++) {
				if (board[i][j]!=null) {
					flag = false;
				}
			}
		}
	}
	else if (x>currx && y>curry) {
		for (int i = currx+1; i<x && flag; i++) {
			for (int j = curry+1; j<y && flag; j++) {
				if (board[i][j]!=null) {
					flag = false;
				}
			}
		}
	}
	else {
		c=1;
	}
	if (flag && c==0) {
		board[p.getLocation().x][p.getLocation().y]=null;
		board[x][y]=p;
		p.setLocation(new Point(x, y));
	}
	/*else {
		throw new UnallowedMovementException("Invalid move");
	}*

} */

	
	/*public boolean canMove(Player player2) throws UnallowedMovementException, InvalidTargetCell {
	King k = null;
	boolean flag = false;
	for (Piece p: player2.getTeam()) {
		if (p instanceof King)
			k = (King) p;
	}
	int currx = k.getLocation().x;
	int curry = k.getLocation().y;
	int x1 = currx-1;
	int x2 = currx;
	int x3 = currx+1;
	int y1 = curry-1;
	int y2 = curry;
	int y3 = curry+1;
	
	if (x1>=0) {
		if (y1>=0) {
			if (board[x1][y1]!=null)
				flag = flag || false;
			else
				flag = flag || helpMove(k,x1,y1);
			if (board[x2][y1]!=null)
				flag = flag || false;
			else
				flag = flag || helpMove(k,x2,y1);
			if (board[x1][y2]!=null)
				flag = flag || false;
			else
				flag = flag || helpMove(k,x1,y2);
		}
		else {
			if (board[x1][y2]!=null)
				flag = flag || false;
			else
				flag = flag || helpMove(k,x1,y2);
		}
	}
	else {
		if (y1>=0) {
			if (board[x2][y1]!=null)
				flag = flag || false;
			else
				flag = flag || helpMove(k,x2,y1);
		}
	}
	if (x3<=7) {
		if (y3<=7) {
			if (board[x3][y2]!=null)
				flag = flag || false;
			else
				flag = flag || helpMove(k,x3,y2);
			if (board[x3][y3]!=null)
				flag = flag || false;
			else
				flag = flag || helpMove(k,x3,y3);
			if (board[x2][y3]!=null)
				flag = flag || false;
			else
				flag = flag || helpMove(k,x2,y3);
		}
		else {
			if (board[x3][y2]!=null)
				flag = flag || false;
			else
				flag = flag || helpMove(k,x3,y2);
		}
	}
	if (x1>=0) {
		if (y3<=7) {
			if (board[x1][y3]!=null)
				flag = flag || false;
			else
				flag = flag || helpMove(k,x1,y3);
		}
	}
	if (x3<=7) {
		if (y1>=0) {
			if (board[x3][y1]!=null)
				flag = flag || false;
			else 
				flag = flag || helpMove(k,x3,y1);
		}
	}
	return flag;
}

public boolean helpMove(Piece p, int x, int y) throws UnallowedMovementException, InvalidTargetCell {
	int tempx = p.getLocation().x;
	int tempy = p.getLocation().y;
	boolean flag = false;
	p.setLocation(new Point(x,y));
	Player player;
	if (firstPlayer.getTeam().contains(p))
		player = secondPlayer;
	else
		player = firstPlayer;
	for (Piece t: player.getTeam()) {
		flag = flag || canAttack(t,p);
	}
	p.setLocation(new Point(tempx,tempy));
	return flag;
	
}

public boolean canAttack(Piece p1, Piece p2) throws InvalidTargetCell, UnallowedMovementException {
	int currx = p1.getLocation().x;
	int curry = p1.getLocation().y;
	int x = p2.getLocation().x;
	int y = p2.getLocation().y;
	Player p = null;
	if (firstPlayer.getTeam().contains(p2))
		p = firstPlayer;
	else 
		p = secondPlayer;
	attack(p1,x,y);
	if (p1.getLocation().x==x && p1.getLocation().y==y) {
		board[currx][curry]=p1;
		board[x][y]=p2;
		p1.setLocation(new Point(currx, curry));
		p.getTeam().add(p2);
		return true;
	}
	return false;
}
*/
	
	
	/*
	for (int i=0; i<checking.size();i++) {
					Piece p2 = checking.get(i);
					for (int j =0; j<temp.size(); j++) {
						Piece p3 = temp.get(i);
						p3.getValidMoves().clear();
						p3.validateMoves();
						for (Point pt: p3.getValidMoves()) {
							if (pt.x == p2.getLocation().x && pt.y== p2.getLocation().y) {
								checking.remove(i);
								temp.remove(j);
								j--;
								i--;
								break;
							}
						}
						if (checking.size()<c) {
							c--;
							break;
						}
					}
				}
				if (checking.size()==0) {
					gameStatus = GameStatus.ONGOING;
				}
				else {
					for (int i = 0; i<checking.size();i++) {
						Piece p2 = checking.get(i);
						for (int j = 0; j<temp.size();j++) {
							Piece p3 = temp.get(j);
							for (Point pt: p3.getValidMoves()) {
								move(p3, pt.x, pt.y);
								//after move, check the new valid moves of current attack piece
								//if can attack king, still in checkmate
							}
						}
						
					}
				} 
	 
	 */
	
	
	/*public boolean canMove(Piece k, Player player1) {
		boolean flag = true;
		boolean res = false;
		k.getValidMoves().clear();
		k.validateMoves();
		for (Point pt: k.getValidMoves()) {
			flag = true;
			for (Piece p : player1.getPieces()) {
				p.getValidMoves().clear();
				p.validateMoves();
				for (Point pt2 : p.getValidMoves()) {
					if (pt.x==pt2.x && pt.y== pt2.y) {
						flag &= false;
					}
				}
			}
			res |= flag;
		}
		return res;
	}*/
	
}
