package Project5;


    /**
     * Represents a pixel, which is a red, green, and blue value
     *
     * @author Richard Dunn, modified by Parag
     * @version Feb 25, 2003
     *
     * DO NOT MODIFY THIS CLASS
     */
    public class Pixel {
        //the following static variables are used to refer to various colors (RGB)
        public static int AllColors = 0; //this represents the int value corresponding to the
        // case when a pixel stores the true value of all the colors
        public static int Red = 1;
        public static int Green = 2;
        public static int Blue = 3;

        // RGB color values for this pixel (0-255)
        public int red;
        public int green;
        public int blue;
        public int color; //the color value to which this pixel corresponds - could be red,green,blue
        // or allcolors (which means that all the color values are stored properly)

        /**
         * constructor for objects of class pixel
         * initializes the pixel values;
         */
        public Pixel(int red, int green, int blue) {
            this.color = AllColors;
            this.red = red;
            this.green = green;
            this.blue = blue;
        }

        /**
         * constructor for objects of class pixel
         * initializes the pixel values; this constructs the
         * pixel with non-zero intensity for one of the colors
         * and zero for others.
         */
        public Pixel(int intensity,int color) {
            this.color = color;
            this.red = 0;
            this.green = 0;
            this.blue = 0;
            if(color == Red) {
                this.red = intensity;
            }
            if(color == Green) {
                this.green = intensity;
            }
            if(color == Blue) {
                this.blue = intensity;
            }
        }

        /** Return a String representation of this Pixel */
        public String toString() {
            return "Pixel(red=" + red + ", green=" + green + ", blue=" + blue + ")";
        }

    }

