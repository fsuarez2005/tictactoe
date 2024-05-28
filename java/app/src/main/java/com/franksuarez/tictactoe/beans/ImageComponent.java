/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.franksuarez.tictactoe.beans;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author franksuarez
 */
public class ImageComponent extends Component {

    private boolean ready = false;
    private int offsetX = 0;
    private int offsetY = 0;
    private String filePath = "";
    private boolean paintBackground = true;
    private boolean imageCentered = false;
    private boolean resizeToPreferredSize = true;
    private BufferedImage bufImg; // TODO: BufferedImage does not store alpha

    public ImageComponent() {
        addPropertyChangeListener((PropertyChangeEvent pce) -> {
            String propertyName = pce.getPropertyName();

            switch (propertyName) {
                case "filePath" -> {

                    this.bufImg = null;

                    ImageComponent.this.loadImage();


                }
                case "offsetX" -> {
                    ImageComponent.this.repaint();
                }
                case "offsetY" -> {
                    ImageComponent.this.repaint();
                }
                case "background" -> {
                    ImageComponent.this.repaint();
                }

                case "imageCentered" -> {
                    ImageComponent.this.repaint();

                }

                default -> {
                }
            }
        });

    }

    public boolean isImageCentered() {
        return imageCentered;
    }

    public void setImageCentered(boolean imageCentered) {
        boolean oldImageCentered = this.imageCentered;
        this.imageCentered = imageCentered;
        firePropertyChange("imageCentered", oldImageCentered, imageCentered);
    }

    public int getCenterOffsetX() {
        if (this.bufImg != null) {
            return (this.getWidth() / 2 - this.bufImg.getWidth() / 2);
        } else {
            return 0;
        }
    }

    public int getCenterOffsetY() {
        if (this.bufImg != null) {
            return (this.getHeight() / 2 - this.bufImg.getHeight() / 2);
        } else {
            return 0;
        }
    }

    public boolean isResizeToPreferredSize() {
        return resizeToPreferredSize;
    }

    // TODO: fire property change event
    public void setResizeToPreferredSize(boolean resizeToPreferredSize) {
        this.resizeToPreferredSize = resizeToPreferredSize;
    }

    public boolean isPaintBackground() {
        return paintBackground;
    }

    // TODO: fire property change event
    public void setPaintBackground(boolean paintBackground) {
        this.paintBackground = paintBackground;
    }

    public int getImageWidth() {
        int output = 0;
        if (this.bufImg != null) {
            output = this.bufImg.getWidth();
        }
        return output;
    }

    public int getImageHeight() {
        int output = 0;
        if (this.bufImg != null) {
            output = this.bufImg.getHeight();
        }
        return output;
    }

    public int getOffsetX() {
        return offsetX;
    }

    public void setOffsetX(int offsetX) {
        int oldOffsetx = this.offsetX;
        this.offsetX = offsetX;
        firePropertyChange("offsetX", oldOffsetx, offsetX);

    }

    public int getOffsetY() {
        return offsetY;
    }

    public void setOffsetY(int offsetY) {
        int oldOffsetY = this.offsetY;
        this.offsetY = offsetY;
        firePropertyChange("offsetY", oldOffsetY, offsetY);
    }

    public boolean isReady() {
        return this.ready;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        String oldFilePath = this.filePath;
        this.filePath = filePath;
        firePropertyChange("filePath", oldFilePath, filePath);

    }

    @Override
    public void setBackground(Color c) {
        Color oldBackground = this.getBackground();
        firePropertyChange("background", oldBackground, c);
        super.setBackground(c); // sets this.background but does listen for property changes
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int localOffsetX = this.getOffsetX();
        int localOffsetY = this.getOffsetY();

        if (this.isImageCentered()) {
            localOffsetX = this.getCenterOffsetX();
            localOffsetY = this.getCenterOffsetY();
        }

        Rectangle bounds = this.getBounds();

        Graphics2D g2d = (Graphics2D) g;

        if (this.isPaintBackground()) {
            Color background = this.getBackground();
            if (background != null) {
                g2d.setBackground(this.getBackground());
                g2d.clearRect(bounds.x, bounds.y, bounds.width, bounds.height);
            }
        }

        if (this.ready) {
            g2d.drawImage(this.bufImg, null, 0 + localOffsetX, 0 + localOffsetY);
        }
    }

    private void loadImage() {
        if (filePath == null) {
            return;
        }

        URL resource = getClass().getClassLoader().getResource(filePath);
        if (resource == null) {
            this.ready = false;
            return;
        }

        try {
            this.bufImg = ImageIO.read(resource);
        } catch (IOException ex) {

            this.ready = false;
            Logger.getLogger(ImageComponent.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.ready = true;

    }

    public void clear() {
        Rectangle bounds = this.getBounds();
        Graphics g = this.getGraphics();
        g.clearRect(0, 0, bounds.width, bounds.height);
    }

}
