import java.awt.*;
import javax.swing.*;

public class Frame {
    JFrame frame = new JFrame("Mine Sweeper");
    JPanel panel = new JPanel();
    Mine easy_mine;
    Mine normal_mine;
    Mine hard_mine;
    JButton easy_button = new JButton("EASY");
    JButton normal_button = new JButton("NORMAL");
    JButton hard_button = new JButton("HARD");

    Frame(Mine easy_mine, Mine normal_mine, Mine hard_mine) {
        this.easy_mine = easy_mine;
        this.normal_mine = normal_mine;
        this.hard_mine = hard_mine;
        panel.setLayout(new FlowLayout());
        panel.add(easy_button);
        panel.add(normal_button);
        panel.add(hard_button);
        frame.setLocation(500,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    void start() {
        easy();
    }
    void easy() {

    }

    void normal() {

    }

    void hard() {

    }
}

