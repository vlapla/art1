/**
 * Created by vlado on 10.03.17.
 */

public class LifeSim {
    private int counter = 0;
    private int activeSide = 0;
    private int otherSide = 1;
    private SimpleField[] myField;
    private int width;
    private int height;

    public LifeSim(int width, int height){
        this.width = width;
        this.height = height;
        myField = new SimpleField[2];
        myField[activeSide] = new SimpleField(width, height);
        myField[otherSide] = new SimpleField(width, height);
    }

    public void step(){
        counter++;
        System.out.println("\nStep " + counter);
        for (int y = 1; y <= height; y++) {
            for (int x = 1; x <= width; x++) {
                int newVal = myField[activeSide].getNewFieldVal(x,y);
//                System.out.println("Other side: " + otherSide + " x: " + x + " y: " + y + " new: " + newVal);
                myField[otherSide].setField(x,y, newVal);
            }
        }
        swapSides();
    }

    private void swapSides(){
        int newActiveSide = otherSide;
        otherSide = activeSide;
        activeSide = newActiveSide;
    }

    public void print(){
        myField[activeSide].printField();
    }

    public void setVirtualField(int x, int y, int val){
        myField[activeSide].setField(width / 2 + x, height / 2 + 1, val);
    }

    public void initSmallExploder(){
        setVirtualField(0, 2, 1);
        setVirtualField(-1, 1, 1);
        setVirtualField(0, 1, 1);
        setVirtualField(1, 1, 1);
        setVirtualField(-1, 0, 1);
        setVirtualField(1, 0, 1);
        setVirtualField(0, -1, 1);
    }

}
