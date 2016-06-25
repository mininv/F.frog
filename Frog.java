class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x =x;
        this.y = y;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
public class Frog {


    int[][] fillmap = new int[10][16]; // Pазмеp == pазмеpу лабиpинта !
    int[][] labyrinth = new int[10][16];
    Point[] buf= new Point[160];
    int position = 0;
    int XSIZE = 10;
    int YSIZe = 16;

    void ppprint() {// метод для обнуления всего массива
        for (int i = 0; i < 10; i++) {
            for (int z = 0; z < 16; z++){
                fillmap[i][z] = 0;
            }
            System.out.println();
        }
    }

    void ppprint1() {//метод для печати масчсива
        for (int i = 0; i < 10; i++) {
            for (int z = 0; z < 16; z++){
                System.out.print(fillmap[i][z] + " ");
            }
            System.out.println();
        }
    }

    void recr(Point start, Point end){
        int x = start.getX();
        int y = start.getY();
        int n =1;
        Point p = new Point(x,y);
        buf[position++] = p;
        for (Point tuper : buf){
            if (fillmap[tuper.getX()][(tuper.getY()+3)] == 0){
                fillmap[tuper.getX()][(tuper.getY()+3)] = n;
                buf[position++]= new Point(tuper.getX(), (tuper.getY()+3));
            }
            if (tuper!=null & fillmap[tuper.getX() + 2][tuper.getY() + 1] == 0) {
                fillmap[tuper.getX() + 2][tuper.getY() + 1] = n;
                buf[position++] = (new Point(tuper.getX() + 2, tuper.getY() + 1));
            }
            if (tuper!=null & fillmap[tuper.getX() + 1][tuper.getY() + 2] == 0) {
                fillmap[tuper.getX() + 1][tuper.getY() + 2] = n;
                buf[position++] = (new Point(tuper.getX() + 1, tuper.getY() + 2));
            }
            if (tuper!=null & fillmap[tuper.getX() - 1][tuper.getY() + 2] == 0) {
                fillmap[tuper.getX() - 1][tuper.getY() + 2] = n;
                buf[position++] = (new Point(tuper.getX() - 1, tuper.getY() + 2));
            }
            if (tuper!=null & fillmap[tuper.getX() - 2][tuper.getY() + 1] == 0) {
                fillmap[tuper.getX() - 2][tuper.getY() + 1] = n;
                buf[position++]=new Point(tuper.getX() - 2,tuper.getY() + 1);
            }
             break;
        }

        /*int x = start.getX();
        int y = start.getY();
        int n=1;
        boolean isEmpty = false;
        Point p = new Point(start.getX(), start.getY());
        buf[position++]= p;
        while(!isEmpty) {
            for (Point tuper : buf) {
                fillmap[tuper.getX()][tuper.getY() + 3] = n;
                if (tuper == null)break;
                if (tuper!=null &  fillmap[tuper.getX()][tuper.getY() + 3] == 0) {
                    fillmap[tuper.getX()][tuper.getY() + 3] = n;
                    buf[position++] = (new Point(tuper.getX(), tuper.getY() + 3));
                }
                if (tuper!=null & fillmap[tuper.getX() + 2][tuper.getY() + 1] == 0) {
                    fillmap[tuper.getX() + 2][tuper.getY() + 1] = n;
                    buf[position++] = (new Point(tuper.getX() + 2, tuper.getY() + 1));
                }
                if (tuper!=null & fillmap[tuper.getX() + 1][tuper.getY() + 2] == 0) {
                    fillmap[tuper.getX() + 1][tuper.getY() + 2] = n;
                    buf[position++] = (new Point(tuper.getX() + 1, tuper.getY() + 2));
                }
                if (tuper!=null & fillmap[tuper.getX() - 1][tuper.getY() + 2] == 0) {
                    fillmap[tuper.getX() - 1][tuper.getY() + 2] = n;
                    buf[position++] = (new Point(tuper.getX() - 1, tuper.getY() + 2));
                }
                if (tuper!=null & fillmap[tuper.getX() - 2][tuper.getY() + 1] == 0) {
                    fillmap[tuper.getX() - 2][tuper.getY() + 1] = n;
                    buf[position++]=new Point(tuper.getX() - 2,tuper.getY() + 1);
                }
                //else isEmpty = true;*/


            //}

       // }


    }
    private boolean outOfBounds(int x, int y) {
        return x < 0 || y < 0 || x >= XSIZE || y >= YSIZE;
    }

    public static void main(String[] args) {
        Frog fg = new Frog();
        System.out.println();
        fg.fillmap[2][8] = -1;
        fg.fillmap[4][5] = -1;
        Point start = new Point(4,3);
        Point end = new Point(2,6);
        fg.recr(start, end);
        System.out.println();
        fg.ppprint1();
    }
}
