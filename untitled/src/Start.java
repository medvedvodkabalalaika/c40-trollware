import javax.swing.*;

public class Start {
    public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                TransparentImageApp app = new TransparentImageApp();
                app.setVisible(true);
                new rhbm().main2();

            });
        try {
            ua.main(args); } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            ark.main(args); } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}








