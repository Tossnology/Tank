import java.awt.*;

public abstract class BaseBullet extends GameObject{
    //public abstract void collideWith(BaseTank tank);
    public abstract Group getGroup();
    public abstract Rectangle getRect();

    public abstract void die();
}
