import javax.swing.*;

public class Main extends JFrame {
    public Main()
    {
        setSize(1280,720);
        setResizable(false);
        setDefaultCloseOperation(3);
        Draw d = new Draw();
        add(d);
        setVisible(true);
    }
    public static void main(String[] args)
    {
        setLaF();
        new Main();
    }
    static void setLaF()
    {

        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName()
            );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }
}
