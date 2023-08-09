package chess.pieces;

import boardGame.Board;
import boardGame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	public Pawn(Board board, Color color) {
		super(board, color);
		
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0, 0);
		if (getColor() == Color.WHITE) {
			p.setValues(position.getRow() - 1, position.getColumn());// testa se o peao pode mover UMA casa pra cima
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow() - 2, position.getColumn()); // testa se o peao pode mover DUAS casas pra cima
			Position p2 = new Position(position.getRow() - 1, position.getColumn()); // alem de testar se a posiçao -2 existe e esta vaga, tem q testar se a posiçao -1 tambem está vaga e se é a primeira vez que está movendo o peao(moveCount) 
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getMoveCount() == 0 && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow() - 1, position.getColumn() -1); // comer peça na diagonal a esquerda
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow() - 1, position.getColumn() +1); // comer peça na diagonal a direita
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
		}
		else {// color = BLACK
			p.setValues(position.getRow() + 1, position.getColumn());// testa se o peao pode mover UMA casa pra baixo
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow() + 2, position.getColumn()); // testa se o peao pode mover DUAS casas pra baixo
			Position p2 = new Position(position.getRow() + 1, position.getColumn()); // alem de testar se a posiçao +2 existe e esta vaga, tem q testar se a posiçao +1 tambem está vaga e se é a primeira vez que está movendo o peao(moveCount) 
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getMoveCount() == 0 && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow() + 1, position.getColumn() -1); // comer peça na diagonal a esquerda
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow() + 1, position.getColumn() +1); // comer peça na diagonal a direita
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
		}
		return mat;
	}
	
	@Override
	public String toString() {
		return "P";
	}
	

}
