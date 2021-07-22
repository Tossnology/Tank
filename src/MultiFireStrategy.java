public class MultiFireStrategy implements FireStrategy{
    private MultiFireStrategy() {};

    private static final MultiFireStrategy INSTANCE = new MultiFireStrategy();

    public static MultiFireStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public void fire(BaseTank tank) {
        int bX = tank.getX() + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = tank.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        GameModel.getInstance().gf.createBullet(bX, bY, Dir.LEFT, tank.getGroup());
        GameModel.getInstance().gf.createBullet(bX, bY, Dir.UP, tank.getGroup());
        GameModel.getInstance().gf.createBullet(bX, bY, Dir.RIGHT, tank.getGroup());
        GameModel.getInstance().gf.createBullet(bX, bY, Dir.DOWN, tank.getGroup());
        new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();
    }
}
