import java.awt.*;

public class RectExplode extends BaseExplode{
    public static int WIDTH = ResourceMgr.getInstance().explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.getInstance().explodes[0].getHeight();
    private boolean living = true;
    private int step = 0;



    public RectExplode(int x, int y) {
        this.x = x;
        this.y = y;

        new Thread(() -> new Audio("audio/explode.wav").play()).start();
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(x, y, 10 * step, 10 * step);
        if (step == 5) GameModel.getInstance().remove(this);
        step++;
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }
}
