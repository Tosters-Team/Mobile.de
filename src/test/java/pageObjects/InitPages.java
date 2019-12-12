package pageObjects;

import static stepDefinitions.Hooks.driver;

public class InitPages {

    public static CarListPage carListPage = new CarListPage(driver);
    public static CarParkPage carParkPage = new CarParkPage(driver);
    public static ComparisonPage comparisonPage = new ComparisonPage(driver);
    public static DetailedCarSearchPage detailedCarSearchPage = new DetailedCarSearchPage(driver);
    public static EditAccountPage editAccountPage = new EditAccountPage(driver);
    public static HeaderGeneral headerGeneral = new HeaderGeneral(driver);
    public static HomePageQuickSearch homePageQuickSearch = new HomePageQuickSearch(driver);
    public static LoginPage loginPage = new LoginPage(driver);
    public static MySearchesPage mySearchesPage = new MySearchesPage(driver);
    public static QuickTruckSearch quickTruckSearch = new QuickTruckSearch(driver);
    public static SellPage sellPage = new SellPage(driver);
    public static SidePanelSearchPage sidePanelSearchPage = new SidePanelSearchPage(driver);


}
