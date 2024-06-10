package MineSweeper;

public class Main {
    public static void main(String[] args) {
        Mine easy_mine = new Mine();
        easy_mine.init(9);
        Mine normal_mine = new Mine();
        normal_mine.init(16);
        Mine hard_mine = new Mine();
        hard_mine.init(22);
        Frame f = new Frame(easy_mine, normal_mine, hard_mine);
        f.start();
    }
}