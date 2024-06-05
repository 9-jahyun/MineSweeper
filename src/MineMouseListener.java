import java.awt.event.*;
import javax.swing.*;

public class MineMouseListener implements MouseListener {
    int i, j;
    JButton[][] button;
    JButton difButton;
    Mine mine;
    Frame frame;
    Timer timer;
    int mode;

    public MineMouseListener(int i, int j, Mine mine, JButton[][] button, Frame frame, Timer timer) {
        this.i = i;
        this.j = j;
        this.mine = mine;
        this.button = button;
        this.frame = frame;
        this.timer = timer;
        this.mode = 0;
    }

    public MineMouseListener(JButton difButton, Mine mine, Frame frame, int mode, Timer timer) {
        this.difButton = difButton;
        this.mine = mine;
        this.frame = frame;
        this.mode = mode;
        this.timer = timer;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (mode == 0) {
            if (e.getButton() == MouseEvent.BUTTON1)
                mine.open(i, j, button, frame, timer);
            else if (e.getButton() == MouseEvent.BUTTON3)
                mine.flag(i, j, button, frame);
        } else {
            timer.off();
            if (mode == 1) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (mine.size == 9) {
                        mine.init(9);
                        frame.easy();
                    } else if (mine.size == 16) {
                        mine.init(16);
                        frame.normal();
                    } else {
                        mine.init(22);
                        frame.hard();
                    }
                }
            } //else if (mode == 2)
            // TODO : replay 구현
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}