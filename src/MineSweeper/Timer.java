package MineSweeper;

public class Timer extends Thread {
    Frame frame;
    boolean on_off = false;

    Timer(Frame frame) {
        this.frame = frame;
    }

    public void on() {
        on_off = true;
    }

    public void off() {
        on_off = false;
    }

    public void reset() {
        off();
        // TODO : 프레임 MineSweeper.Timer reset 구현
    }

    public void run() {
        while (true) {
            try {
                // TODO : 프레임 MineSweeper.Timer 구현
                if (on_off) {
                    Thread.sleep(1000);
                } else
                    while (!on_off) {
                        if (on_off)
                            break;
                        reset();
                    }
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    String makeTimer(int time) {
        int min = time / 60;
        int sec = time % 60;
        return String.format("%02d : %02d", min, sec);
    }
}