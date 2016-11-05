/**
 * Created by shyslav on 9/25/16.
 */
public class DriverInfo {
    private String drive;
    private String displayName;
    private boolean isDrive;
    private boolean isFloppy;
    private boolean readable;
    private boolean writable;
    private long totalSpace;
    private long usableSpace;

    public DriverInfo(String drive, String displayName, boolean isDrive, boolean isFloppy, boolean readable, boolean writable, long totalSpace, long usableSpace) {
        this.drive = drive;
        this.displayName = displayName;
        this.isDrive = isDrive;
        this.isFloppy = isFloppy;
        this.readable = readable;
        this.writable = writable;
        this.totalSpace = totalSpace;
        this.usableSpace = usableSpace;
    }

    public String getDrive() {
        return drive;
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean isDrive() {
        return isDrive;
    }

    public boolean isFloppy() {
        return isFloppy;
    }

    public boolean isReadable() {
        return readable;
    }

    public boolean isWritable() {
        return writable;
    }

    public long getTotalSpace() {
        return totalSpace;
    }

    public long getUsableSpace() {
        return usableSpace;
    }
}
