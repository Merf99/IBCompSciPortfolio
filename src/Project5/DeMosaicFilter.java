package Project5;

public class DeMosaicFilter implements Filter{

    @Override
    public void filter(PixelImage theImage) {
        Pixel[][] data = theImage.getData();

        for (int row = 1; row < theImage.getHeight()-1; row++) {
            for (int col = 1; col < theImage.getWidth()-1 ; col++) {
                //isolate pixels
                //red = channel 1
                //green = channel 2
                //blue = channel 3
                if (data[row][col].color == 3){
                    //average green pixels
                    int above = data[row-1][col].green;
                    int below = data[row+1][col].green;
                    int left = data[row][col-1].green;
                    int right = data[row][col+1].green;
                    data[row][col].green = (above+below+left+right)/4;
                    //average red pixels
                    int tl = data[row-1][col-1].red;
                    int br = data[row+1][col+1].red;
                    int bl = data[row+1][col-1].red;
                    int tr = data[row-1][col+1].red;
                    data[row][col].red = (tl+br+bl+tr)/4;
                }
                if (data[row][col].color == 2){
                    //average red pixels
                    int above = data[row-1][col].red;
                    int below = data[row+1][col].red;
                    data[row][col].red = (above+below)/2;

                    //average blue pixels
                    int left = data[row][col-1].blue;
                    int right = data[row][col+1].blue;
                    data[row][col].blue = (left+right)/2;

                }
                if (data[row][col].color == 1){
                    //average green pixels
                    int above = data[row-1][col].green;
                    int below = data[row+1][col].green;
                    int left = data[row][col-1].green;
                    int right = data[row][col+1].green;
                    data[row][col].green = (above+below+left+right)/4;
                    //average blue pixels
                    int tl = data[row-1][col-1].blue;
                    int br = data[row+1][col+1].blue;
                    int bl = data[row+1][col-1].blue;
                    int tr = data[row-1][col+1].blue;
                    data[row][col].blue = (tl+br+bl+tr)/4;
                }
            }
        }
        theImage.setData(data);
    }
}
