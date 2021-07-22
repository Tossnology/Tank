import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {
    private static final GameModel INSTANCE = new GameModel();
//    List<BaseTank> tanks = new ArrayList<>();
//    List<BaseBullet> bullets = new ArrayList<>();
//    List<BaseExplode> explodes = new ArrayList<>();
    ColliderChain chain = new ColliderChain();

    List<GameObject> objects = new ArrayList<>();

    GameFactory gf = new DefaultFactory();

    BaseTank myTank = gf.createTank(200, 400, Dir.DOWN, Group.GOOD);

    public static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;
    private GameModel() {
        myTank.SPEED = 5;

        int initTankCount = PropertyMgr.getInt("initTankCount");

        //初始化敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            add(gf.createTank(50 + i * 80, 200, Dir.DOWN, Group.BAD));
        }

        add(new Wall(150, 150, 200, 50));
        add(new Wall(550, 150, 200, 50));
        add(new Wall(300, 300, 50, 200));
        add(new Wall(550, 300, 50, 200));
    }

    public static GameModel getInstance() {
        return INSTANCE;
    }

    public void add(GameObject go) {
        objects.add(go);
    }

    public void remove(GameObject go) {
        objects.remove(go);
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
//        g.drawString("子弹的数量：" + gm.bullets.size(), 10, 60);
//        g.drawString("敌人的数量：" + gm.tanks.size(), 10, 80);
        g.setColor(c);

        myTank.paint(g);

        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(g);
        }

        //处理子弹与坦克碰撞
        for (int i = 0; i < objects.size(); i++) {
            for (int j = i + 1; j < objects.size(); j++) {
                GameObject o1 = objects.get(i);
                GameObject o2 = objects.get(j);
                chain.collide(o1, o2);
            }
        }


//        for (int i = 0; i < gm.bullets.size(); i++) {
//            for (int j = 0; j < gm.tanks.size(); j++) {
//                gm.bullets.get(i).collideWith(gm.tanks.get(j));
//            }
//        }
    }

    public BaseTank getMainTank() {
        return myTank;
    }
}
