import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class App {
    public static void main(String[] args) throws Exception {
        ChessMatch chessMatch = new ChessMatch();

        Scanner sc = new Scanner(System.in);

        while (true){
            try{
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces());
                System.out.println();

                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);
                
                System.out.println();

                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
            
            }catch (ChessException err) {
                System.out.println(err.getMessage());
                sc.nextLine();
            }
            catch (InputMismatchException err) {
                System.out.println(err.getMessage());
                sc.nextLine();
            }

        }

    }
}
