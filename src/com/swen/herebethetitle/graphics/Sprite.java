package com.swen.herebethetitle.graphics;

import com.swen.herebethetitle.util.GridLocation;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

import java.awt.*;

/**
 * A Sprite is an javafx.scene.image.Image, along with a GridLocation.
 * Provides support for drawing to a Canvas using a GridLocation.
 * @author weirjosh
 */
public class Sprite {

    private GridLocation loc;
    private Image img;

    /**
     * Create a new Sprite.
     * @param i The image this sprite will represent
     * @param l The location of this sprite on the canvas.
     * @author weirjosh
     */
    public Sprite(Image i, GridLocation l){
        loc = l;
        img = i;
    }

    /**
     * Draw this sprite to the given canvas. Offset by a given point.
     * @param gc the GraphicsContext used to render the image
     * @param g The gridManager for positioning
     * @param offset The offset from the origin.
     * @author weirjosh
     */
    public void draw(GraphicsContext gc, GridManager g, Point offset){
        Point pos = g.getRealCoordinates(loc, offset);
        gc.drawImage(img, pos.x, pos.y, g.getCellSize(), g.getCellSize());
    }

    /**
     * Draw this sprite to the given canvas.
     * @param gc the GraphicsContext used to render the image
     * @param g The gridManager for positioning
     * @author weirjosh
     */
    public void draw(GraphicsContext gc, GridManager g){
        Point pos = g.getRealCoordinates(loc);
        gc.drawImage(img, pos.x, pos.y, g.getCellSize(), g.getCellSize());
    }

    /**
     * @return The image of this sprite
     * @author weirjosh
     */
    public Image getImage(){
        return img;
    }

    /**
     * @return The location of this sprite
     * @author weirjosh
     */
    public GridLocation getLocation() {
        return loc;
    }
}