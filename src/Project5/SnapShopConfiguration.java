package Project5;

/**
 * A class to configure the SnapShop application
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SnapShopConfiguration {
    /**
     * Method to configure the SnapShop.  Call methods like addFilter
     * and setDefaultFilename here.
     * @param theShop A pointer to the application
     */
    public static void configure(SnapShop theShop) {
        //replace the following path in the following line by the directory path you want your
        //file loader to open
        theShop.setDefaultFilename("D:\\downloads\\billg.jpg");

        theShop.addFilter(new FlipHorizontalFilter(), "Flip Horizontal");
        theShop.addFilter(new DeMosaicFilter(), "DeMosaic");
    }

    /** Main method */
    public static void main(String args[]) {
        SnapShop theShop = new SnapShop();
    }
}
