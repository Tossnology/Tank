import java.awt.*;
import java.util.Collection;
import java.util.Random;

public class RectTank extends BaseTank{
    private Dir dir = Dir.DOWN;
    private boolean moving  = true;
    public static final int WIDTH = ResourceMgr.getInstance().tankD.getWidth();
    public static final int HEIGHT = ResourceMgr.getInstance().tankD.getHeight();
    private boolean living = true;
    private Random random = new Random();
    private Group group = Group.BAD;
    private int step = 0;

    private Rectangle rect = new Rectangle();

    public RectTank(int x, int y, Dir dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
    }

    public void paint(Graphics g) {
        if (!living) {
            GameModel.getInstance().remove(this);
            return;
        }

        Color c = g.getColor();
        g.setColor(group == Group.BAD ? Color.BLUE : Color.RED);
        g.fillRect(x, y, WIDTH, HEIGHT);
        g.setColor(c);

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
        if (!moving) return;
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

        if (group == Group.BAD && random.nextInt(100) > 95) this.fire(NormalFireStrategy.getInstance());
        if (group == Group.BAD && random.nextInt(100) > 95) randomDir();

        boundsCheck();

        rect.x = this.x;
        rect.y = this.y;
    }

    private void boundsCheck() {
        if (x < 0) x = 0;
        if (y < 20) y = 20;
        if (x > GameModel.GAME_WIDTH - Tank.WIDTH) x = GameModel.GAME_WIDTH - Tank.WIDTH;
        if (y > GameModel.GAME_HEIGHT - Tank.HEIGHT) y = GameModel.GAME_HEIGHT - Tank.HEIGHT;
    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }

    public void setMainTankDir(boolean bL, boolean bU, boolean bR, boolean bD) {
        if (bL) dir = Dir.LEFT;
        if (bU) dir = Dir.UP;
        if (bR) dir = Dir.RIGHT;
        if (bD) dir = Dir.DOWN;

        if (!bL && !bU && !bR && !bD) {
            moving = false;
        } else {
            moving = true;
        }
    }

    public void fire(FireStrategy strategy) {
        strategy.fire(this);
    }


    @Override
    public void stop() {
        this.moving = false;
    }

    @Override
    public void backward() {

    }

    @Override
    public void handleFireKey() {

    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void die() {
        this.living = false;
        int eX = x + WIDTH/2 - Explode.WIDTH/2;
        int eY = y + HEIGHT/2 - Explode.HEIGHT/2;
        GameModel.getInstance().add(GameModel.getInstance().gf.createExplode(eX, eY));
    }

    public Group getGroup() {
        return group;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Dir getDir() {
        return dir;
    }

    public Rectangle getRect() {
        return rect;
    }

}
