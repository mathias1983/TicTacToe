/**
 * Created by mathias on 19.10.2014.
 */
public class Coordinate {

    char firstComponent;
    char secondComponent;
    int  position;

    public Coordinate( String coordinate ){
        initCoordinate( coordinate.trim() );
        coordinateToPosition();
    }

    public Coordinate( int position ){
        this.position = position;
        this.positionToCoordinate();
    }

    public void initCoordinate( String coordinate ){
        try{
            this.firstComponent  = coordinate.charAt(0);
            this.secondComponent = coordinate.charAt(1);
        }
        catch( StringIndexOutOfBoundsException e){
            System.out.println( "Fehler: Coordinate muss zweistellig sein" );
        }
    }

    public static final int ASCIInumericValue = 10;
    private void coordinateToPosition(  ){
        this.position = Character.getNumericValue( Character.toLowerCase(this.firstComponent) ) - ASCIInumericValue;
        this.position += (Character.getNumericValue( this.secondComponent ) - 1 ) * Config.fieldCountWidth;
    }

    public static final int ASCIIcharacterValue = 97;
    private void positionToCoordinate(){
       firstComponent  = Character.toUpperCase( (char)((position % Config.fieldCountWidth) + ASCIIcharacterValue) );
       secondComponent = (char)Math.round( (position /  Config.fieldCountWidth) + 1 );
    }

}