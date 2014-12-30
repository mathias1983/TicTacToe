/**
 * Created by mathias on 19.10.2014.
 */
public class WinningStreak {

    GridData grid;
    String token;

    public WinningStreak( GridData gridData, String token ){
        this.grid = gridData;
        this.token = token;
    }

    public boolean isSuccessful(){

        if( isStreakVertical() || isStreakHorizontal() || isStreakDiagonalLeft() || isStreakDiagonalRight() ){
            return true;
        }

        return false;
    }

    private boolean isStreakVertical(){
        String[] data = grid.getData();

        for( int i = 0; i < Config.fieldCountWidth; ++i ){
            int count = 0;
            for( int j = 0; j < Config.fieldCountHeight; ++j ){
                int position = i + (j * Config.fieldCountWidth)  ;

                if(isTokenFound(data[position])){
                    ++count;
                }

                if( isWinningSequenceReached(count) ){
                    return true;
                }

            }
        }
        return false;
    }

    private boolean isTokenFound(String s) {
        return ( s != null ) && s.equals(token);
    }

    private boolean isStreakHorizontal(){
        String[] data = grid.getData();

        for( int i = 0; i < Config.fieldCountHeight; ++i ){
            int count = 0;
            for( int j = 0; j < Config.fieldCountWidth; ++j ){

                int position = (i * Config.fieldCountWidth) +   j  ;

                if(isTokenFound(data[position])){
                    ++count;
                }

                if( isWinningSequenceReached(count) ){
                    return true;
                }
            }

        }
        return false;
    }

    private boolean isWinningSequenceReached(int count){
        return count == Config.fieldCountWidth;
    }

    private boolean isStreakDiagonalRight(){
        String[] data = grid.getData();

        for( int i = 0; i < Config.fieldCountWidth; ++i ){
            int count = 0;
            for( int j = 0; j < Config.fieldCountHeight; ++j ){

                int position = i + ( (Config.fieldCountWidth + 1) * j );

                if( !isDiagonalField(position) ){
                    count = 0;
                    continue;
                }

                if(isPositionOutOfGridBoundary(data, position)){
                    count = 0;
                    continue;
                }

                if(isTokenFound(data[position])){
                    ++count;
                }

                if( isWinningSequenceReached(count) ){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isPositionOutOfGridBoundary(String[] data, int position) {
        return position >= data.length;
    }

    private boolean isDiagonalField(int position) {
        return position != 0 && position  % Config.fieldCountWidth == 0;
    }

    /**
     * "Einfache" Vergleichsversion aus zeitmangel. Siegreihenanzahl muss wurzel aus breite mal höhe sein, mit breite == höhe.
     * @return
     */
    private boolean isStreakDiagonalLeft() {
        String[] data = grid.getData();
        int count = 0;
        int position = 0;
        for( int i = 0; i < Config.fieldCountHeight; ++i ){
            position += Config.fieldCountWidth -1;
            if(isTokenFound(data[position])){
                ++count;
            }
            if( isWinningSequenceReached(count) ){
                return true;
            }
        }
        return false;
    }

}
