package Project5;

    /**
     * Defines a filter method to modify images
     *
     * @author Richard Dunn
     * @version March 2, 2002
     *
     * DO NOT MODIFY THIS INTERFACE
     */

    /** interface filter. All the filters implement this interface */
    public interface Filter {
        /**
         * Modify the image according to your algorithm
         *
         * @param  theImage The image to modify
         */
        void filter(PixelImage theImage);
    }

