/**
 * Created by vlado on 06.03.17.
 */
public class SimpleField {
    private int[][] field;
    private int width;
    private int height;

    /* Usable area is height x width, but the internal array has to be one field bigger in all four directions! */
    public SimpleField(int myWidth, int myHeight){
        width = (myWidth + 1);
        height = (myHeight + 1);
        field = new int[width+1][height+1];
        for (int y = 0; y <= height; y++) {
            for (int x = 0; x <= width; x++) {
                field[x][y] = 0;
            }
        }
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                if (field[j][i] == 1) {
                    s.append("1");
                } else {
                    s.append("0");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }

    int getNeighbourSum(int x, int y){
        checkCoord(x,y);
        int nSum = field[x-1][y-1] + field[x][y-1] +  field[x+1][y-1] +
                field[x-1][y]  +  field[x+1][y] +
                field[x-1][y+1] + field[x][y+1] +  field[x+1][y+1];
        return nSum;
    }
    
    int getNewFieldVal(int x, int y){
        int newFieldVal;
        int neighbourSum = getNeighbourSum(x, y);
        checkCoord(x,y);
        if (field[x][y] == 1) { // lebende Zelle
            if (neighbourSum <= 1 || neighbourSum > 3){ // mit weniger als zwei oder mehr als drei Nachbarn -> tot
                newFieldVal = 0;
            } else {
                newFieldVal = 1; // mit zwei oder drei Nachbarn bleiben sie am Leben
            }
        } else { // tote Zelle
            if (neighbourSum == 3){
                newFieldVal = 1; // mit genau drei Nachbarn erwacht sie zum Leben
            } else {
                newFieldVal = 0; // ansonsten bleibt sie tot
            }
        }
        return newFieldVal;
    }

    void setField(int x, int y, int val){
        checkCoord(x,y);
        field[x][y] = val;
    }

    private void checkCoord(int x, int y) {
        assert (x > 0 && x < width) : "X-Wert außerhalb der Feldgröße versucht!";
        assert (y > 0 && x < height) : "Y-Wert außerhalb der Feldgröße versucht!";
    }
}
