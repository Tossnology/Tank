public class BulletTankCollider implements Collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof BaseBullet && o2 instanceof BaseTank) {
            BaseBullet b = (BaseBullet) o1;
            BaseTank t = (BaseTank) o2;
            if (t.getGroup() == b.getGroup()) return true;
            if (b.getRect().intersects(t.getRect())) {
                t.die();
                b.die();
                return false;
            }
        } else if (o1 instanceof BaseTank && o2 instanceof BaseBullet) {
            return collide(o2, o1);
        }
        return true;
    }
}
