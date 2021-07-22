public abstract class GameFactory {
    public abstract BaseTank createTank(int x, int y, Dir dir, Group group);
    public abstract BaseExplode createExplode(int x, int y);
    public abstract BaseBullet createBullet(int x, int y, Dir dir, Group group);
}
