/**
 * Created by mathias on 19.10.2014.
 */
public class GridPrinter {

    public static void print( String[] grid ){

        printChars();
        printHorizontalLine('#');
        printCells(grid);
        printHorizontalLine('#');
    }

    private static void printCells( String[] grid ){
        String line = "";
        LocalTime currentTime = new LocalTime();

        for( int i = 0; i < grid.length; ++i ){
            String value = getPrintableValue(grid[i]);
            printTokenCell(value);
            printRowBoundary(grid, i);
        }
    }

    private static void printChars(){
        for( int i = 0; i < Config.fieldCountWidth; ++i ){
            char c = Character.toUpperCase( (char)((i % Config.fieldCountWidth) + 97) );
            System.out.print("  " + c + " ");
        }
        System.out.println();
    }

    private static String getPrintableValue(String s) {
        if( s != null ){
           return s;
        }
        return " ";
    }

    private static void printTokenCell(String value) {
        System.out.print("| " + value + " ");
    }

    private static void printRowBoundary(String[] grid, int i) {
        String lineNumber = "" + Math.round( (i /  Config.fieldCountWidth) + 1 );


        if( (i != 0) && ( i != (grid.length - 1) ) && (i + 1) % Config.fieldCountWidth == 0 ){
            System.out.println( "| " + lineNumber );
            printHorizontalLine('-');
        }


        if( i == (grid.length - 1) ){
            System.out.print( "| " + lineNumber );
            System.out.println();
        }
    }


    private static void printHorizontalLine( char limiter){
        String line = " ";
        for( int i = 0; i < Config.fieldCountWidth * 4; ++i ){
            line += limiter;
        }
        System.out.println( line );
    }

}
