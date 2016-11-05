/**
 * Created by shyslav on 9/25/16.
 */
public class LicensedUser {
    private int id;
    private String computerName;
    private String userName;
    private String system;
    private long diskTotalSpace;
    private String dateLicenceStart;
    private String dateLicenceEnd;
    private String md5License;
    public LicensedUser() {
    }

    public LicensedUser(int id, String computerName, String userName, String system, long diskTotalSpace, String dateLicenceStart, String dateLicenceEnd, String md5License) {
        this.id = id;
        this.computerName = computerName;
        this.userName = userName;
        this.system = system;
        this.diskTotalSpace = diskTotalSpace;
        this.dateLicenceStart = dateLicenceStart;
        this.dateLicenceEnd = dateLicenceEnd;
        this.md5License = md5License;
    }

    public LicensedUser(String computerName, String userName, String osName, long totalSpace) {
        this.computerName = computerName;
        this.userName = userName;
        this.system = osName;
        this.diskTotalSpace = totalSpace;
    }

    public LicensedUser(String computerName, String userName, String system, long diskTotalSpace, String dateLicenceStart, String dateLicenceEnd) {
        this.computerName = computerName;
        this.userName = userName;
        this.system = system;
        this.diskTotalSpace = diskTotalSpace;
        this.dateLicenceStart = dateLicenceStart;
        this.dateLicenceEnd = dateLicenceEnd;
    }

    public String getComputerName() {
        return computerName;
    }

    public String getUserName() {
        return userName;
    }

    public String getSystem() {
        return system;
    }

    public long getDiskTotalSpace() {
        return diskTotalSpace;
    }


    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public void setDiskTotalSpace(long diskTotalSpace) {
        this.diskTotalSpace = diskTotalSpace;
    }

    public String getDateLicenceStart() {
        return dateLicenceStart;
    }

    public void setDateLicenceStart(String dateLicenceStart) {
        this.dateLicenceStart = dateLicenceStart;
    }

    public String getDateLicenceEnd() {
        return dateLicenceEnd;
    }

    public void setDateLicenceEnd(String dateLicenceEnd) {
        this.dateLicenceEnd = dateLicenceEnd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMd5License() {
        return md5License;
    }

    public void setMd5License(String md5License) {
        this.md5License = md5License;
    }
}
