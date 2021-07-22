public class TankTankCollider implements Collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof BaseTank && o2 instanceof BaseTank) {
            BaseTank t1 = (BaseTank) o1;
            BaseTank t2 = (BaseTank) o2;
            if (t1.getRect().intersects(t2.getRect())) {
                //System.out.println(1);
                t1.backward();
                t2.backward();
            }
        }
        return true;
    }
}
