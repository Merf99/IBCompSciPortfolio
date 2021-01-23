package Project5;

    import java.awt.image.*;

    /**
     * Provides an interface to a picture as an array of Pixels
     *
     * @author Richard Dunn, modified by Donald Chinn, modified by Parag
     * @version Feb 25, 2003
     *
     * DO NOT MODIFY THIS CLASS
     */
    public class PixelImage {
        private BufferedImage myImage; //image corresponding to this pixel image
        private int width;             // width of the image
        private int height;            // height of the image
        private Pixel pixels[][];      // the pixels

        /**
         * Map this PixelImage to a real image
         * @param bi The image
         */
        public PixelImage(BufferedImage bi) {
            // initialise instance variables
            this.myImage = bi;
            this.width = bi.getWidth();
            this.height = bi.getHeight();
            pixels = new Pixel[height][width];
            intializePixels();
        }

        /**
         * Return the width of the image
         */
        public int getWidth() {
            return this.width;
        }

        /**
         * Return the height of the image
         */
        public int getHeight() {
            return this.height;
        }

        /**
         * IGNORE THIS METHOD
         */
        public BufferedImage getImage() {
            return this.myImage;
        }

        /** intialize the pixels*/
        private void intializePixels() {

            Raster r = this.myImage.getRaster();
            int[] samples = new int[3];

            for (int row = 0; row < r.getHeight(); row++) {
                for (int col = 0; col < r.getWidth(); col++) {
                    samples = r.getPixel(col, row, samples);
                    Pixel newPixel = new Pixel(samples[0], samples[1], samples[2]);
                    pixels[row][col] = newPixel;
                }
            }
        }


        /**
         * Return the image's pixel data as an array of Pixels.  The
         * first coordinate is the x-coordinate, so the size of the
         * array is [width][height], where width and height are the
         * dimensions of the array
         * @return The array of pixels
         */
        public Pixel[][] getData() {
            return pixels;
        }

        /**
         * Set the image's pixel data from an array.  This array matches
         * that returned by getData().  It is an error to pass in an
         * array that does not match the image's dimensions or that
         * has pixels with invalid values (not 0-255)
         * @param data -- a 2-dimensional array of Pixels
         */
        public void setData(Pixel[][] data) throws IllegalArgumentException {
            pixels=data;
            int[] pixelValues = new int[3];     // a temporary array to hold r,g,b values
            WritableRaster wr = this.myImage.getRaster();

            if (data.length != wr.getHeight()) {
                throw new IllegalArgumentException("Array size does not match");
            } else {
                if (data[0].length != wr.getWidth()) {
                    throw new IllegalArgumentException("Array size does not match");
                }
            }
            for (int row = 0; row < wr.getHeight(); row++) {
                for (int col = 0; col < wr.getWidth(); col++) {
                    pixelValues[0] = data[row][col].red;
                    pixelValues[1] = data[row][col].green;
                    pixelValues[2] = data[row][col].blue;
                    wr.setPixel(col, row, pixelValues);
                }
            }
        }
    }

