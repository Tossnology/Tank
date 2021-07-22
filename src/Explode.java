import java.awt.*;

public class Explode extends BaseExplode{
    public static int WIDTH = ResourceMgr.getInstance().explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.getInstance().explodes[0].getHeight();
    private boolean living = true;
    private int step = 0;



    public Explode(int x, int y) {
        this.x = x;
        this.y = y;

        new Thread(() -> new Audio("audio/explode.wav").play()).start();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.getInstance().explodes[step++], x, y, null);
        if (step == 16) GameModel.getInstance().remove(this);
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
