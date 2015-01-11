import java.sql.Array;

/**
 * Created by mathias on 19.10.2014.
 */
public class GridData {






    private String[] data;

    public GridData( int fields ){
        this.initData( fields );
    }

    public void add( int position, String value ){
        this.data[ position ] = value;
    }

    public String[] getData(){
        return this.data;
    }

    public void reset(){
        this.initData( data.length );
    }

    public boolean isEmpty( int position ){
        if( this.data[ position ] == null ){
            return true;
        }
        return false;
    }

    public boolean isGridFilled(){
        for( int i = 0; i < this.data.length; ++i  ){
            if( isEmpty( i ) == true ){
                return false;
            }
        }
        return true;
    }

    private void initData( int fields ){
        data = new String[ fields];
    }

}
