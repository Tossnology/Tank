public class NormalFireHandler implements TankObserver{
    @Override
    public void actionOnFireKey(FireEvent fe) {
        fe.getSource().fire(NormalFireStrategy.getInstance());
    }
}
