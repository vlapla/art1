/**
 * Created by vlado on 10.03.17.
 */

class LifeSim {
    private int counter = 0;
    private int activeSide = 0;
    private int otherSide = 1;
    private SimpleField[] myField;
    private int width;
    private int height;

    LifeSim(int width, int height){
        this.width = width;
        this.height = height;
        myField = new SimpleField[2];
        myField[activeSide] = new SimpleField(width, height);
        myField[otherSide] = new SimpleField(width, height);
    }

    void step(){
        counter++;
        System.out.println("\nStep " + counter);
        for (int y = 1; y <= height; y++) {
            for (int x = 1; x <= width; x++) {
                int newVal = myField[activeSide].getNewFieldVal(x,y);
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

    void printField(){
        System.out.print(myField[activeSide]);
    }

    String getFieldPrint() {
        return myField[activeSide].toString();
    }

    void setVirtualField(int x, int y){
        int xCenter = (int)Math.floor(width / 2) + 1;
        int yCenter = (int)Math.floor(height / 2) + 1;
        myField[activeSide].setField( xCenter + x, yCenter - y, 1);
    }

    // init names from https://bitstorm.org/gameoflife/
    void initSmallExploder(){
        setVirtualField(0, 2);
        setVirtualField(-1, 1);
        setVirtualField(0, 1);
        setVirtualField(1, 1);
        setVirtualField(-1, 0);
        setVirtualField(1, 0);
        setVirtualField(0, -1);
    }

    void initGlider(){
        setVirtualField(0,1);
        setVirtualField(1,0);
        setVirtualField(-1,-1);
        setVirtualField(0,-1);
        setVirtualField(1,-1);
    }

}
