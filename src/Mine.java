import java.util.Arrays;

public class Mine {

    private static final int MINE = 9;
    int num;
    int mineNum;
    int emptyNum;
    int[][] mine;
    boolean[][] mineMark;
    boolean[][] mineFlag;

    void init(int num) {
        this.num = num;
        this.mineNum = 0;
        this.emptyNum = num * num;
        mine = new int[num][num];
        mineMark = new boolean[num][num];
        mineFlag = new boolean[num][num];

        for (int[] row : mine) {
            Arrays.fill(row, 0);
        }
        for (boolean[] row : mineMark) {
            Arrays.fill(row, false);
        }
        for (boolean[] row : mineFlag) {
            Arrays.fill(row, false);
        }

        int m = switch (num) {
            case 9 -> 10;
            case 16 -> 40;
            case 22 -> 100;
            default -> 0;
        };

        while (mineNum < m) {
            int a = (int) (Math.random() * num);
            int b = (int) (Math.random() * num);
        }
    }
}
