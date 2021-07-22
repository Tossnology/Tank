import java.awt.*;

public class Bullet extends BaseBullet{
    private static final int SPEED = 10;
    public static int WIDTH = ResourceMgr.getInstance().bulletD.getWidth();
    public static int HEIGHT = ResourceMgr.getInstance().bulletD.getHeight();
    private Group group = Group.BAD;

    private Rectangle rect = new Rectangle();

    private Dir dir;

    private boolean living = true;

    public Bullet(int x, int y, Dir dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        GameModel.getInstance().add(this);
    }

    public void paint(Graphics g) {
        if (!living) {
            GameModel.getInstance().remove(this);
        }

        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.getInstance().bulletL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.getInstance().bulletU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.getInstance().bulletR, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.getInstance().bulletD, x, y, null);
                break;
        }

        move();
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

    private void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }

        rect.x = this.x;
        rect.y = this.y;

        if (x < 0 || y < 0 || x > GameModel.GAME_WIDTH || y > GameModel.GAME_HEIGHT) living =false;
    }

//    public void collideWith(BaseTank tank) {
//        if (tank.getGroup() == this.group) return;
//        if (rect.intersects(tank.getRect())) {
//            tank.die();
//            this.die();
//        }
//    }

    @Override
    public Group getGroup() {
        return group;
    }

    @Override
    public Rectangle getRect() {
        return rect;
    }

    public void die() {
        this.living = false;
    }
}
