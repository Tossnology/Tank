public class NormalFireStrategy implements FireStrategy{
    private NormalFireStrategy() {};

    private static final NormalFireStrategy INSTANCE = new NormalFireStrategy();

    public static NormalFireStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public void fire(BaseTank tank) {
        int bX = tank.getX() + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = tank.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        GameModel.getInstance().gf.createBullet(bX, bY, tank.getDir(), tank.getGroup());
        new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();
    }
}
