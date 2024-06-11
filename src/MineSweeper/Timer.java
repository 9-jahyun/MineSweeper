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
        frame.time = 0;
        frame.timerLabel.setText("00:00");
    }

    public void run() {
        while (true) {
            try {
                frame.timerDisplay = makeTimer(frame.time);
                frame.timerLabel.setText(frame.timerDisplay);
                frame.time++;
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