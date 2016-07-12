import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlad on 12.07.16.
 */
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
 void setX(int x) {this.x = x; }
    public int getY() {
        return y;
    }

}
public class Frog {
    int width;
    int height;
    int wall = 99;
    int[][] map;
    List<Point> wave = new ArrayList<Point>();// лист точек

    public Frog(int width, int height) {
        this.width = width;
        this.height = height;
        map = new int[width][height];
//заполняем массив значениями -1
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                map[i][j] = -1;
            }
        }
        for (int i = 0; i < width; i++) {
            for (int z = 0; z < height; z++){
                System.out.print(map[i][z] + " ");
            }
            System.out.println();
        }
    }
    public void block(int x, int y) {
        // метод для установки препятствий
        map[y][x] = wall;
    }
    void mapOnmonitor () {
        for (int i = 0; i < width; i++) {
            for (int z = 0; z < height; z++){
                System.out.print(map[i][z] + " ");
            }
            System.out.println();
        }
    }
    private int[][] clone(int[][] map) {
        int[][] cloneMap = new int[width][height];
        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map[i].length; j++)
                cloneMap[i][j] = map[i][j];
        return cloneMap;
    }

    public void findPath(int x, int y, int nx, int ny) {
        if (map[y][x] == wall || map[ny][nx] == wall) {
            System.out.println("Невозможно построить путь");
            return;
        }
        
        int[][] cloneMap = clone(map);
        List<Point> oldWave = new ArrayList<Point>();
        oldWave.add(new Point(nx, ny));
        int nstep = 0;
        map[ny][nx] = nstep;

        int[] dx = { 2, 1, 3, 1 ,2 };
        int[] dy = { 1, 2, 0, -2, -1 };

        while (oldWave.size() > 0) {
            nstep++;
            wave.clear();
            for (Point i : oldWave) {
                for (int d = 0; d < 5; d++) {
                    nx = i.x + dx[d];
                    ny = i.y + dy[d];
                    if (nx > 15) nx = nx -16;
                    if ( ny <10  && ny>=0  && map[ny][nx] == -1) {
                        wave.add(new Point(nx, ny));
                        map[ny][nx] = nstep;
                    }
                }
            }
            oldWave = new ArrayList<Point>(wave);
        }
       System.out.println("мин число прыжков до точки - " + map[y][x]);

    }

    public static void main(String[] args) {
        Frog fg = new Frog(10,16);// задается массив в ширину и высоту
        fg.block(10,1);//препятствия
        fg.block(1,9);// препятствия

        System.out.println();
        fg.mapOnmonitor();// массив до
        fg.findPath(4,1,1,6); // здесь вводится конечная и начальная точка
        System.out.println();
        fg.mapOnmonitor(); //вывод на экран получившегося массива
    }
}
