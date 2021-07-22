public class NuclearFireStrategy implements FireStrategy{
    @Override
    public void fire(BaseTank tank) {
        int bX = tank.getX() + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = tank.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        new Bullet(bX, bY, tank.getDir(), tank.getGroup());
        new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();
    }
}
