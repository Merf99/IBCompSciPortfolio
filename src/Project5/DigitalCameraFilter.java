package Project5;

    /**
     * Filter that stores filters the intensity for one of the RGB values for each
     * row. The alternating patterns of R,G and G,B rows are stored. Green appears
     * more because human eye is sensitive to it and needs more accuracy.
     * @author Parag
     * @version February 25, 2003
     *
     * DO NOT MODIFY THIS CLASS
     * This class does the transformation from an image to the mosaic pattern first
     * recorded by a digital camera.
     */
    public class DigitalCameraFilter implements Filter {

        /** filter this image - as done by a digital camera */
        public void filter(PixelImage pi) {
            Pixel[][] data = pi.getData();
            int pixelColor;

            for (int row = 0; row < pi.getHeight(); row++) {
                for (int col = 0; col < pi.getWidth(); col++) {

                    //get the color for this pixel - we want a pattern of the form R,G,R,G
                    //alternating with rows of the form G,B,G,B...

                    if(row%2 == 0 && col%2 == 0) {
                        pixelColor = Pixel.Red;
                    } else {
                        if (row%2 != 0 && col%2 != 0) {
                            pixelColor = Pixel.Blue;
                        } else {
                            pixelColor = Pixel.Green;
                        }
                    }
                    Pixel pixel = data[row][col];
                    data[row][col] = getSingleColor(pixel,pixelColor);
                }
            }
            pi.setData(data);
        }

        /** extract the intensity for the specifed color and copy this value
         * for other colors as well. For example, if we want to retain the Green
         * Value, we extract the green intensity from the pixel and copy this
         * value for all the 3 colors intensities */
        private Pixel getSingleColor(Pixel originalPixel,int color) {
            int intensity;
            if(color == Pixel.Red) {
                intensity = originalPixel.red;
            } else {
                if(color == Pixel.Green) {
                    intensity = originalPixel.green;
                } else {
                    intensity = originalPixel.blue;
                }
            }
            return new Pixel(intensity,color);
        }
    }

