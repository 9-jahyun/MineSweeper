package MineSweeper;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Frame {
    JFrame frame = new JFrame("Mine Sweeper");
    Container contentPane = frame.getContentPane();
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel minePanel = new JPanel();
    JPanel timerPanel = new JPanel();
    Mine easyMine;
    Mine normalMine;
    Mine hardMine;
    JButton easyButton = new JButton("EASY");
    JButton normalButton = new JButton("NORMAL");
    JButton hardButton = new JButton("HARD");
    JButton replayButton = new JButton("REPLAY");
    JLabel minePic = new JLabel(new ImageIcon("pic/mine.png"));
    JLabel mineNum;
    JLabel timerPic = new JLabel(new ImageIcon("pic/timer.png"));
    JLabel timerLabel = new JLabel("0");
    String mineDisplay;
    String timerDisplay;
    int time = 0;
    Timer timer = new Timer(this);

    Frame(Mine easy_mine, Mine normal_mine, Mine hard_mine) {
        this.easyMine = easy_mine;
        this.normalMine = normal_mine;
        this.hardMine = hard_mine;
        panel2.setLayout(new FlowLayout());
        panel2.add(easyButton);
        panel2.add(normalButton);
        panel2.add(hardButton);
        frame.setLocation(500, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MineMouseListener easy_listener = new MineMouseListener(easyButton, easy_mine, this, 1, timer);
        easyButton.addMouseListener(easy_listener);
        MineMouseListener normal_listener = new MineMouseListener(normalButton, normal_mine, this, 1, timer);
        normalButton.addMouseListener(normal_listener);
        MineMouseListener hard_listener = new MineMouseListener(hardButton, hard_mine, this, 1, timer);
        hardButton.addMouseListener(hard_listener);
        timer.start();
    }

    void start() {
        easy();
    }

    void replay(Mine mineBoard) {
        if (mineBoard.size == 9) {
            mineBoard.init(9);
            easy();
        } else if (mineBoard.size == 16) {
            mineBoard.init(16);
            normal();
        } else {
            mineBoard.init(22);
            hard();
        }
    }

    void easy() {
        contentPane.removeAll();
        panel.removeAll();
        panel3.removeAll();
        minePanel.removeAll();
        timerPanel.removeAll();
        panel.setLayout(new GridLayout(9, 9));
        time = 0;
        mineDisplay = easyMine.mineNum + "개";
        JButton[][] button = new JButton[9][9];
        MineMouseListener[][] listener = new MineMouseListener[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                button[i][j] = new JButton();
                button[i][j].setIcon(new ImageIcon("pic/false.png"));
                listener[i][j] = new MineMouseListener(i, j, easyMine, button, this, timer);
                button[i][j].addMouseListener(listener[i][j]);
                panel.add(button[i][j]);
            }
        }
        MineMouseListener replay_listener = new MineMouseListener(replayButton, easyMine, this, 2, timer);
        replayButton.addMouseListener(replay_listener);
        panel3.setLayout(new FlowLayout());
        minePanel.add(minePic);
        mineNum = new JLabel(mineDisplay);
        minePanel.add(mineNum);
        timerPanel.add(timerPic);
        timerLabel = new JLabel(timerDisplay);
        timerPanel.add(timerLabel);
        panel3.add(minePanel);
        panel3.add(replayButton);
        panel3.add(timerPanel);
        contentPane.add(panel, BorderLayout.CENTER);
        contentPane.add(panel2, BorderLayout.SOUTH);
        contentPane.add(panel3, BorderLayout.NORTH);
        frame.setSize(270, 370);
        timer.on();
        frame.setVisible(true);
    }

    void normal() {
        contentPane.removeAll();
        panel.removeAll();
        panel3.removeAll();
        minePanel.removeAll();
        timerPanel.removeAll();
        panel.setLayout(new GridLayout(16, 16));
        time = 0;
        mineDisplay = normalMine.mineNum + "개";
        JButton[][] button = new JButton[16][16];
        MineMouseListener[][] listener = new MineMouseListener[16][16];
        MineMouseListener easy_listener = new MineMouseListener(easyButton, easyMine, this, 1, timer);
        easyButton.addMouseListener(easy_listener);
        MineMouseListener normal_listener = new MineMouseListener(normalButton, normalMine, this, 1, timer);
        normalButton.addMouseListener(normal_listener);
        MineMouseListener hard_listener = new MineMouseListener(hardButton, hardMine, this, 1, timer);
        hardButton.addMouseListener(hard_listener);
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                button[i][j] = new JButton();
                button[i][j].setIcon(new ImageIcon("pic/false.png"));
                listener[i][j] = new MineMouseListener(i, j, normalMine, button, this, timer);
                button[i][j].addMouseListener(listener[i][j]);
                panel.add(button[i][j]);
            }
        }
        MineMouseListener replay_listener = new MineMouseListener(replayButton, normalMine, this, 2, timer);
        replayButton.addMouseListener(replay_listener);
        panel3.setLayout(new FlowLayout());
        minePanel.add(minePic);
        mineNum = new JLabel(mineDisplay);
        minePanel.add(mineNum);
        timerPanel.add(timerPic);
        timerLabel = new JLabel(timerDisplay);
        timerPanel.add(timerLabel);
        panel3.add(minePanel);
        panel3.add(replayButton);
        panel3.add(timerPanel);
        contentPane.add(panel, BorderLayout.CENTER);
        contentPane.add(panel2, BorderLayout.SOUTH);
        contentPane.add(panel3, BorderLayout.NORTH);
        frame.setSize(480, 580);
        timer.on();
        frame.setVisible(true);
    }

    void hard() {
        contentPane.removeAll();
        panel.removeAll();
        panel3.removeAll();
        minePanel.removeAll();
        timerPanel.removeAll();
        panel.setLayout(new GridLayout(22, 22));
        time = 0;
        mineDisplay = hardMine.mineNum + "개";
        JButton[][] button = new JButton[22][22];
        MineMouseListener[][] listener = new MineMouseListener[22][22];
        MineMouseListener easy_listener = new MineMouseListener(easyButton, easyMine, this, 1, timer);
        easyButton.addMouseListener(easy_listener);
        MineMouseListener normal_listener = new MineMouseListener(normalButton, normalMine, this, 1, timer);
        normalButton.addMouseListener(normal_listener);
        MineMouseListener hard_listener = new MineMouseListener(hardButton, hardMine, this, 1, timer);
        hardButton.addMouseListener(hard_listener);
        for (int i = 0; i < 22; i++) {
            for (int j = 0; j < 22; j++) {
                button[i][j] = new JButton();
                button[i][j].setIcon(new ImageIcon("pic/false.png"));
                listener[i][j] = new MineMouseListener(i, j, hardMine, button, this, timer);
                button[i][j].addMouseListener(listener[i][j]);
                panel.add(button[i][j]);
            }
        }
        MineMouseListener replay_listener = new MineMouseListener(replayButton, hardMine, this, 2, timer);
        replayButton.addMouseListener(replay_listener);
        panel3.setLayout(new FlowLayout());
        minePanel.add(minePic);
        mineNum = new JLabel(mineDisplay);
        minePanel.add(mineNum);
        timerPanel.add(timerPic);
        timerLabel = new JLabel(timerDisplay);
        timerPanel.add(timerLabel);
        panel3.add(minePanel);
        panel3.add(replayButton);
        panel3.add(timerPanel);
        contentPane.add(panel, BorderLayout.CENTER);
        contentPane.add(panel2, BorderLayout.SOUTH);
        contentPane.add(panel3, BorderLayout.NORTH);
        frame.setSize(550, 660);
        timer.on();
        frame.setVisible(true);
    }
}