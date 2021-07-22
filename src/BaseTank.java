import java.awt.*;

public abstract class BaseTank extends GameObject{
    public int SPEED = 1;
    int lastX;
    int lastY;

    public abstract int getX();
    public abstract int getY();
    public abstract Group getGroup();
    public abstract Rectangle getRect();
    public abstract void die();
    public abstract Dir getDir();
    public abstract void setMainTankDir(boolean bL, boolean bU, boolean bR, boolean bD);
    public abstract void fire(FireStrategy strategy);


    public abstract void stop();

    public abstract void backward();

    public abstract void handleFireKey();
}
