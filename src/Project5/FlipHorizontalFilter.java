package Project5;

/**
 * Filter that flips the image horizontally.
 * @author Parag
 * @version February 25, 2003
 *
 * DO NOT MODIFY THIS CLASS
 */
public class FlipHorizontalFilter implements Filter {
    // no instance variables -- no state of objects

    /** this filter takes a pixel image and flips it horizontally */
    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();

        for (int row = 0; row < pi.getHeight(); row++) {
            for (int col = 0; col < pi.getWidth() / 2; col++) {
                Pixel temp = data[row][col];
                data[row][col] = data[row][pi.getWidth() - col - 1];
                data[row][pi.getWidth() - col - 1] = temp;
            }
        }
        pi.setData(data);
    }
}