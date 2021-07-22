public class FireEvent {
    private BaseTank tank;

    public FireEvent(BaseTank tank) {
        this.tank = tank;
    }

    public BaseTank getSource() {
        return tank;
    }
}
