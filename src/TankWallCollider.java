public class TankWallCollider implements Collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof BaseTank && o2 instanceof Wall) {
            BaseTank t = (BaseTank) o1;
            Wall w = (Wall) o2;
            if (t.getRect().intersects(w.rect)) {
                //System.out.println(1);
                t.backward();
            }
        } else if (o1 instanceof Wall && o2 instanceof BaseTank) {
            return collide(o2, o1);
        }
        return true;
    }
}
