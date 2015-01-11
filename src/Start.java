

import java.util.Scanner;


/**
 * Created by mathias on 19.10.2014.
 */
public class Start {

    private static int player = 1;

    public static void main(String [] args){
        GridData grid = new GridData( Config.fieldCountWidth * Config.fieldCountHeight );
        Coordinate coordinate;
        boolean isGameWon = false;

        while( !grid.isGridFilled() ){
            printQuestionForCoordinateInput();
            coordinate = new Coordinate( getCoordinateFromUserInput() );
            if( isCoordinateOccupied( grid, coordinate ) ){
                informPlayerOfoccupiedCoordinate();
                continue;
            }

            String token = getToken();
            grid.add( coordinate.position, token );
            GridPrinter.print( grid.getData() );
            isGameWon = new WinningStreak( grid, token ).isSuccessful();

            if( isGameWon ){
                printGameWon();
                break;
            }
            switchPlayer();
        }

        if( isGameWon == false ){
            printGameDraw();
        }

    }

    private static void printGameDraw( ){

        System.out.println( "!!!!!!!!!!!!!!ENDE!!!!!!!!!!!!!!!!" );
        System.out.println( "Unentschieden" );
        System.out.println( "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" );
    }

    private static void printGameWon(){
        System.out.println( "!!!!!!!!!!!!!!ENDE!!!!!!!!!!!!!!!!" );
        System.out.println( "Spieler " + player + " hat gewonnen." );
        System.out.println( "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" );
    }

    private static boolean isCoordinateOccupied( GridData grid, Coordinate coordinate ){
        return !grid.isEmpty( coordinate.position );
    }

    private static void informPlayerOfoccupiedCoordinate(){
        System.out.println( "-- Hier liegt schon ein Stein! Bitte neu setzen. --" );
    }

    private static void printQuestionForCoordinateInput(){
        System.out.println( "****" );
        System.out.println( "Spieler " + player + " bitte Koordinate eingeben (a1,a2... c3 usw):" );
        System.out.println( "****" );
    }

    private static String getCoordinateFromUserInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static int switchPlayer(){
        player = (player % 2) + 1;
        return player;
    }

    private static String getToken(){
        if( (player % 2) + 1 == 1  ){
            return "X";
        }
        return "O";
    }

}
