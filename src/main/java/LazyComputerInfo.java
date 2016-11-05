import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 * Created by shyslav on 9/25/16.
 */
public class LazyComputerInfo {
    private static final FileSystemView fsv = FileSystemView.getFileSystemView();

    /**
     * Get user name of computer
     *
     * @return current user name
     */
    public static String getUserName() {
        return System.getProperty("user.name");
    }

    /**
     * Get computer name
     *
     * @return computer name
     */
    public static String getComputerName() {
        try {
            return String.valueOf(InetAddress.getLocalHost());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Get OS name
     *
     * @return os name
     */
    public static String getOSName() {
        return System.getProperty("os.name");
    }

    /**
     * Get application dir path
     *
     * @return path
     */
    public static String getCurrentDir() {
        return System.getProperty("user.dir");
    }

    /**
     * Get screen dimensions
     *
     * @return screen dimensions
     */
    public static Dimension getScreenSize() {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }

    /**
     * Get disk folders array
     *
     * @return root folders
     */
    public static File[] getRootsFolder() {
        return fsv.getRoots();
    }

    /**
     * Get roots list
     *
     * @return roots array
     */
    public static File[] getRootsList() {
        return File.listRoots();
    }

    /**
     * Get driver info list
     *
     * @return driver info list
     */
    public static ArrayList<DriverInfo> getDriverInfo() {
        ArrayList<DriverInfo> list = new ArrayList();
        File[] f = getRootsList();
        for (int i = 0; i < f.length; i++) {
            DriverInfo driverInfo = new DriverInfo(
                    f[i].toString(),
                    fsv.getSystemDisplayName(f[i]),
                    fsv.isDrive(f[i]),
                    fsv.isFloppyDrive(f[i]),
                    f[i].canRead(),
                    f[i].canWrite(),
                    f[i].getTotalSpace(),
                    f[i].getUsableSpace()
            );
            list.add(driverInfo);
        }
        return list;
    }

    /**
     * Get linux mouse devices
     *
     * @return mouse device array
     */
    public static ArrayList<String> getLinuxMouseDevice() {
        ArrayList<String> mouseDevice = new ArrayList();
        if (LazyComputerInfo.getOSName().equalsIgnoreCase("linux")) {
            File roots = new File("/dev/input");
            for (File root : roots.listFiles()) {
                if (root.getName().contains("mouse")) {
                    mouseDevice.add(root.getName());
                }
            }
        }
        return mouseDevice;
    }
}
