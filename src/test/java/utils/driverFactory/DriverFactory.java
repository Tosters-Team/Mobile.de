package utils.driverFactory;

import utils.driverFactory.enums.DriverType;

public class DriverFactory {

    public static DriverManager getManager(DriverType type) {

        DriverManager driverManager;

        switch (type.toString()) {//СПРОСИТЬ ЕСЛИ ЗБС
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
