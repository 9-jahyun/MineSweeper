package MineSweeper;

import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.util.Arrays;

// TODO : ImageIcon 이미지 설정 필요

public class Mine {

    private static final int MINE = 9;
    int size;
    int mineNum;
    int emptyNum;
    int[][] mineBoard;
    boolean[][] mineMark;
    boolean[][] mineFlag;

    void init(int size) {
        this.size = size;
        this.mineNum = 0;
        this.emptyNum = size * size;
        mineBoard = new int[size][size];
        mineMark = new boolean[size][size];
        mineFlag = new boolean[size][size];

        for (int[] row : mineBoard) {
            Arrays.fill(row, 0);
        }
        for (boolean[] row : mineMark) {
            Arrays.fill(row, false);
        }
        for (boolean[] row : mineFlag) {
            Arrays.fill(row, false);
        }

        int m = switch (size) {
            case 9 -> 10;
            case 16 -> 40;
            case 22 -> 100;
            default -> 0;
        };

        while (mineNum < m) {
            int a = (int) (Math.random() * size);
            int b = (int) (Math.random() * size);
            insertMine(a, b);
        }
    }

    void insertMine(int a, int b) {
        if (mineBoard[a][b] != MINE) {
            mineBoard[a][b] = MINE;
            mineNum++;
            emptyNum--;
            updateNumbersAround(a, b);
        }
    }

    private void updateNumbersAround(int a, int b) {
        for (int x = Math.max(a - 1, 0); x <= Math.min(a + 1, size - 1); x++) {
            for (int y = Math.max(b - 1, 0); y <= Math.min(b + 1, size - 1); y++) {
                if (mineBoard[x][y] != MINE) {
                    mineBoard[x][y]++;
                }
            }
        }
    }

    void open(int a, int b, JButton[][] button, Frame frame, Timer timer) {
        if (mineMark[a][b])
            return;
        if (mineFlag[a][b])
            return;
        mineMark[a][b] = true;
        if (mineBoard[a][b] == 0) {
            emptyNum--;
            button[a][b].setIcon(new ImageIcon());
            if (a != 0 && b != 0)
                open(a - 1, b - 1, button, frame, timer);
            if (a != 0)
                open(a - 1, b, button, frame, timer);
            if (a != 0 && b != size - 1)
                open(a - 1, b + 1, button, frame, timer);
            if (b != 0)
                open(a, b - 1, button, frame, timer);
            if (b != size - 1)
                open(a, b + 1, button, frame, timer);
            if (a != size - 1 && b != 0)
                open(a + 1, b - 1, button, frame, timer);
            if (a != size - 1)
                open(a + 1, b, button, frame, timer);
            if (a != size - 1 && b != size - 1)
                open(a + 1, b + 1, button, frame, timer);
        } else if (mineBoard[a][b] == 9) {
            for (int i = 0; i < size; i++)
                for (int j = 0; j < size; j++) {
                    if (mineBoard[i][j] == 9)
                        button[i][j].setIcon(new ImageIcon());
                }
            timer.off();
            JOptionPane.showMessageDialog(null, "LOSE", null, JOptionPane.WARNING_MESSAGE);
            // TODO : 리플레이 함수 구현
        } else {
            switch (mineBoard[a][b]) {
                case 1:
                    button[a][b].setIcon(new ImageIcon());
                    break;
                case 2:
                    button[a][b].setIcon(new ImageIcon());
                    break;
                case 3:
                    button[a][b].setIcon(new ImageIcon());
                    break;
                case 4:
                    button[a][b].setIcon(new ImageIcon());
                    break;
                case 5:
                    button[a][b].setIcon(new ImageIcon());
                    break;
                case 6:
                    button[a][b].setIcon(new ImageIcon());
                    break;
                case 7:
                    button[a][b].setIcon(new ImageIcon());
                    break;
                case 8:
                    button[a][b].setIcon(new ImageIcon());
                    break;
            }
            emptyNum--;
        }
        if (emptyNum == 0) {
            for (int i = 0; i < size; i++)
                for (int j = 0; j < size; j++) {
                    if (mineBoard[i][j] == 9)
                        button[i][j].setIcon(new ImageIcon());
                }
            timer.off();
            // TODO : 타이머 프레임, 리플레이 함수 구현
        }
    }

    void flag(int a, int b, JButton[][] button, Frame frame) {
        if (mineMark[a][b])
            return;
        if (mineFlag[a][b]) {
            mineFlag[a][b] = false;
            button[a][b].setIcon(new ImageIcon());
            mineNum++;
            // TODO : 지뢰개수 프레임 구현
        } else {
            mineFlag[a][b] = true;
            button[a][b].setIcon(new ImageIcon());
            mineNum--;
            // TODO : 지뢰개수 프레임 구현
        }
    }
}