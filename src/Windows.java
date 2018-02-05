import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Windows extends JFrame{

    public Windows(String name) {
        new JFrame();
        this.setTitle(name);
        this.setSize(410, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setTextAltitude(String altitude){
        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g){

                g.drawString("Altitude altuelle : "+altitude, 10, 20);

            }
        };
        this.setContentPane(panel);
        this.setVisible(true);
    }

    public void setImageHorizon(){
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image horizon = null;
                try {
                    horizon = ImageIO.read(new File("src/ressources/horizon.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                g.drawImage(horizon, 0, 0, this);
            }
        };
        this.setContentPane(panel);
        this.setVisible(true);
    }
    public void repaintHorizon(int angleDrone){
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    final BufferedImage bi;

                    bi = ImageIO.read(new File("src/ressources/horizon.jpg"));
                    Graphics2D g2 = (Graphics2D) g;
                    g2.rotate(Math.toRadians(angleDrone), bi.getWidth() / 2, bi.getHeight() / 2);
                    g2.drawImage(bi, 0, 0, null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        this.setContentPane(panel);
        this.repaint();
    }
}
