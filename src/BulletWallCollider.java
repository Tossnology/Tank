public class BulletWallCollider implements Collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof BaseBullet && o2 instanceof Wall) {
            BaseBullet b = (BaseBullet) o1;
            Wall w = (Wall) o2;

            if (b.getRect().intersects(w.rect)) {
                b.die();
            }
        } else if (o1 instanceof Wall && o2 instanceof BaseBullet) {
            return collide(o2, o1);
        }
        return true;
    }
}
