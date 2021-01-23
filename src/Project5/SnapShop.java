package Project5;


import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.io.*;
import javax.swing.JFileChooser;

    /**
     * A PhotoShop like application for filtering images
     *
     * @author Richard Dunn, modified by Parag and Tammy
     * @version Feb 25, 2003
     *
     * DO NOT MODIFY THIS CLASS
     * 142 Students: You do not need to understand the code in this class
     */
    public class SnapShop extends JFrame {
        FileLoader fl;
        FilterButtons fb;
        ImagePanel ip;
        RenderingDialog rd;
        BufferedImage originalImage;
        Filter digicam;
        PixelImage pixelImage;  //pixel image corresponding to this image

        /**
         * Constructor for objects of class SnapShop
         */
        public SnapShop() {
            super("CSE 142 - SnapShop");

            this.addWindowListener(new WindowAdapter () {
                public void windowClosing(WindowEvent e) { System.exit(0); }
            });

            ip = new ImagePanel(this);
            this.getContentPane().add(ip, BorderLayout.CENTER);

            fl = new FileLoader(this);
            this.getContentPane().add(fl, BorderLayout.NORTH);

            fb = new FilterButtons(this);
            this.getContentPane().add(fb, BorderLayout.WEST);

            rd = new RenderingDialog(this);

            SnapShopConfiguration.configure(this);

            //add the digital camera filter
            digicam=new DigitalCameraFilter();
            addFilter(digicam, "Digital Camera Filter");

            this.pack();
            this.show();
        }

        /** Class used to load image files */
        private class FileLoader extends JPanel implements ActionListener {
            private String filePath="";
            private ImagePanel ip;
            private SnapShop s;

            /** Construct a new FileLoader object given SnapShot as a parameter */
            public FileLoader(SnapShop s) {
                super(new FlowLayout());

                this.s = s;
                this.ip = s.getImagePanel();

                //add(new JLabel("File Directory: "+filePath));

                JButton loadButton = new JButton("      Load New File      ");
                loadButton.addActionListener(this);
                add(loadButton);
            }

            /** get action performed by user in choosing file to open */
            public void actionPerformed(ActionEvent e) {

                JFileChooser chooser = new JFileChooser(filePath);
                int resultOfShow = chooser.showDialog(null,
                        "Choose a text file");
                try{
                    if (resultOfShow == JFileChooser.APPROVE_OPTION) {
                        String fileName = chooser.getSelectedFile().getAbsolutePath();
                        ip.loadImage(fileName);
                    }
                    else {
                        //user must have canceled
                        throw new IOException("");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(s,
                            "Could not load a file",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }

            /** sets default file name given the filePath */
            public void setDefaultFilename(String filePath) {
                this.filePath = filePath;
            }
        }

        /** Class that represents the buttons that are tied to the filter operations */
        private class FilterButtons extends JPanel {
            private SnapShop s;
            private ImagePanel ip;

            /** create a new set of FilterButtons given the SnapShot */
            public FilterButtons(SnapShop s) {
                setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
                this.s = s;
                this.ip = s.getImagePanel();;
            }

            /* add a filter to this set */
            // called by SnapShotConfituration configure method
            public void addFilter(Filter f, String description) {
                JButton filterButton = new JButton(description);
                filterButton.addActionListener(new FilterButtonListener(this, f));
                add(filterButton);
                s.pack();
            }

            /** run the filter method associated with the button */
            public void applyFilter(Filter f) {
                try {
                    ip.applyFilter(f);
                } catch (Exception e) {
                    e.printStackTrace(System.out);
                }
            }

            /** Class representing the act of listening for button presses */
            private class FilterButtonListener implements ActionListener {
                private FilterButtons fb;
                private Filter f;

                /** create a new FilterButtonListener given the set of filter buttons and
                 * the Filter object (algorithm performed when button is pressed) */
                public FilterButtonListener(FilterButtons fb, Filter f) {
                    this.fb = fb;
                    this.f = f;
                }

                /** apply filter when button is pressed */
                public void actionPerformed(ActionEvent e) {
                    fb.applyFilter(f);
                }
            }
        }

        /** Class representing the ImagePanel */
        private class ImagePanel extends JPanel {
            private BufferedImage bi;
            private SnapShop s;
            private int margin;
            /** create a new ImagePanel given the SnapShot */
            public ImagePanel(SnapShop s) {
                margin = 10;
                bi = null;
                this.s = s;
            }

            /** perform the action of loading an image given the filename of the image */
            public void loadImage(String filename) {
                Image img = Toolkit.getDefaultToolkit().getImage(filename);
                try {
                    MediaTracker tracker = new MediaTracker(this);
                    tracker.addImage(img, 0);
                    tracker.waitForID(0);
                } catch (Exception e) {}
                int width = img.getWidth(this);
                int height = img.getHeight(this);
                bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                Graphics2D biContext = bi.createGraphics();
                biContext.drawImage(img, 0, 0, null);
                setPreferredSize(new Dimension(2*bi.getWidth()+ margin, bi.getHeight()));
                revalidate();
                s.pack();
                s.repaint();

                //set the original image to this image       -> added by Parag on 2/24/2003
                // and add the digital camera filter
                originalImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                Graphics2D g = originalImage.createGraphics();
                g.drawImage(img, 0, 0, null);
                pixelImage = new PixelImage(bi);
                fb.applyFilter(digicam);
            }

            /** render image in window */
            public void paint(Graphics g) {
                super.paint(g);
                if (bi != null) {
                    g.drawImage(bi, 0, 0, this);
                    g.drawImage(originalImage, bi.getWidth()+ margin, 0 , this);
                }
            }

            /** apply filter and redraw image according to new pixel data */
            public void applyFilter(Filter f) {
                if (bi == null) {
                    return;
                }
                //now we do not create a new image each time we apply a filter
                // therefore, the following line is commented.
                //PixelImage newImage = new PixelImage(bi);

                s.showWaitDialog();
                f.filter(pixelImage);
                s.hideWaitDialog();
                bi = pixelImage.getImage();
                repaint();
            }
        }

        /** Class representing dialog box that gets displayed while action is being performed */
        private class RenderingDialog extends JFrame {
            public RenderingDialog(JFrame parent) {
                super("Please Wait");
                Point p = parent.getLocation();
                setLocation((int)p.getX() + 100, (int)p.getY() + 100);
                this.getContentPane().add(new JLabel("Applying filter, please wait..."), BorderLayout.CENTER);
            }
        }

        /**
         * Add a filter to the SnapShop interface.  Creates a button and
         * links it to the filter.
         * @param f The filter to apply
         * @param description English description of the filter
         */
        public void addFilter(Filter f, String description) {
            fb.addFilter(f, description);
        }

        /**
         * IGNORE THIS METHOD
         */
        protected void showWaitDialog() {
            rd.pack();
            rd.show();
        }

        /**
         * IGNORE THIS METHOD
         */
        protected void hideWaitDialog() {
            rd.hide();
        }

        /**
         * IGNORE THIS METHOD
         */
        protected ImagePanel getImagePanel() {
            return ip;
        }

        /**
         * Set the default filename to appear in the box
         * @param filename The filename
         */
        public void setDefaultFilename(String filename) {
            fl.setDefaultFilename(filename);
        }

        /**
         * Open a SnapShop
         */
        public static void test() {
            SnapShop s = new SnapShop();
        }
    }

