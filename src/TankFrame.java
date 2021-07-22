import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
//    Collider btCollider = new BulletTankCollider();
//    Collider ttCollider = new TankTankCollider()
    private int l;

    public TankFrame() throws HeadlessException {
        setSize(GameModel.GAME_WIDTH, GameModel.GAME_HEIGHT);
        setResizable(false);
        setTitle("坦克大战");
        setVisible(true);

        addKeyListener(new MyKeyListener());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    //双缓冲
    Image offScreenImage = null;
    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GameModel.GAME_WIDTH, GameModel.GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GameModel.GAME_WIDTH, GameModel.GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    @Override
    public void paint(Graphics g) {
        GameModel.getInstance().paint(g);
    }


        class MyKeyListener extends KeyAdapter {
            boolean bL = false;
            boolean bU = false;
            boolean bR = false;
            boolean bD = false;

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                switch (key) {
                    case KeyEvent.VK_LEFT:
                        bL = true;
                        break;
                    case KeyEvent.VK_UP:
                        bU = true;
                        break;
                    case KeyEvent.VK_RIGHT:
                        bR = true;
                        break;
                    case KeyEvent.VK_DOWN:
                        bD = true;
                        break;
                    default:
                        break;
                }
                GameModel.getInstance().getMainTank().setMainTankDir(bL, bU, bR, bD);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int key = e.getKeyCode();
                switch (key) {
                    case KeyEvent.VK_LEFT:
                        bL = false;
                        break;
                    case KeyEvent.VK_UP:
                        bU = false;
                        break;
                    case KeyEvent.VK_RIGHT:
                        bR = false;
                        break;
                    case KeyEvent.VK_DOWN:
                        bD = false;
                        break;
                    case KeyEvent.VK_Z:
                        GameModel.getInstance().getMainTank().handleFireKey();
                        break;
                    case KeyEvent.VK_X:
                        GameModel.getInstance().getMainTank().fire(MultiFireStrategy.getInstance());
                        break;
                    default:
                        break;
                }
                GameModel.getInstance().getMainTank().setMainTankDir(bL, bU, bR, bD);
            }
        }
    }
