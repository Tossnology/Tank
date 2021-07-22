public class DefaultFactory extends GameFactory{
    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group) {
        return new Tank(x, y, dir, group);
    }

    @Override
    public BaseExplode createExplode(int x, int y) {
        return new Explode(x, y);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group) {
        return new Bullet(x, y, dir, group);
    }
}
