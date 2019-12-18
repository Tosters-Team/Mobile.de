package utils.driverFactory;

public class DriverFactory {

    public static DriverManager getManager(String type) {

        DriverManager driverManager;

        switch (type) {
            case "CHROME":
                driverManager = new Chrome();
                break;
            case "EXPLORER":
                driverManager = new Explorer();
                break;
            default:
                driverManager = null;
                break;
        }
        return driverManager;

    }
}
