package com.swen.herebethetitle.graphics;

import java.awt.Canvas;
import java.awt.Point;

import com.swen.herebethetitle.util.GridLocation;

/**A grid object is a representation of an area of evenly spaced cells over a given area.
 It will have static methods for turning its own grid coordinates into real world pixel coordinates
 among other things.
 * Created by weirjosh on 19/09/17.
 */
public class GridManager extends Canvas{

    private int cellSize;

    //The horizontal and vertical gaps of this grid
    private int vGap;
    private int hGap;

    private int x;
    private int y;

    private static final int defaultCellSize = 64;

    /**The Grid manager that will be used to render the game world.
     *
     * @return
     * @author weirjosh
     */
    public static GridManager createDefaultManager(){
        return new GridManager(0,0,defaultCellSize, 2,2);
    }

    /**
     * Create a new grid manager
     * @param cellSize size (width & height) of each cell in the grid
     * @param vGap vertical gap between each cell in the grid.
     * @param hGap horizontal gap between each cell in the grid.
     * @author weirjosh
     */
    public GridManager(int x, int y, int cellSize, int vGap, int hGap){
        this.cellSize = cellSize;
        this.vGap = vGap;
        this.hGap = hGap;
        this.x = x;
        this.y = y;
    }

    /**
     * Takes a GridLocation and returns real world coordinates
     * @param location The grid location
     * @return A pixel coordinate
     * @author weirjosh
     */
    public Point getRealCoordinates(GridLocation location){
        int x = this.x +(location.x * cellSize) + location.x*hGap;
        int y = this.y +(location.y * cellSize) + location.y*vGap;

        return new Point(x,y);
    }

    //FIXME Probbly don't need this method
    /**
     * Takes a grid location, and calculates a real world coordinate offset by another grid location
     * @param location The grid location.
     * @param offset The offset from the given location.
     * @return A pixel coordinate
     * @author weirjosh
     */
/*    public Point getRealCoordinates(GridLocation location, GridLocation offset){
//        int x = location.x + offset.x * cellSize;
//        int y = location.y + offset.y * cellSize;
       return getRealCoordinates(new GridLocation(
                location.x+offset.x - (cellSize/2),
               location.y+offset.y - (cellSize/2)));

        //return new Point(x,y);
    }*/

    /**
     * Takes a grid location, and calculates a real world coordinate offset by an arbitrary amount of pixels
     * @param location The grid location.
     * @param offset The offset (pixel vector) from the given location.
     * @return A pixel coordinate
     * @author weirjosh
     */
    public Point getRealCoordinates(GridLocation location, Point offset){
        Point p = new Point(getRealCoordinates(location));
        p.x += offset.x - (cellSize/2);
        p.y += offset.y - (cellSize/2);
        return p;
    }

    /**
     * Takes a real coordinate, and returns a GridLocation based on the offset.
     * @param p The real world coordinate.
     * @param offset The current Player location.
     * @return
     * @author weirjosh
     */
    public GridLocation getGridLocation(Point p, Point offset){
        int col = ((p.x - (offset.x-(cellSize/2)) - this.x) /(cellSize+hGap)) ;
        int row = ((p.y - (offset.y-(cellSize/2)) - this.y) /(cellSize+vGap));

        return new GridLocation(col, row);
    }


    /**
     * @return Get the vertical gap of this GridManager.
     * @author weirjosh
     */
    public int getvGap(){ return vGap; }

    /**
     * @return Get the horizontal gap of this GridManager.
     * @author weirjosh
     */
    public int gethGap(){return hGap;}

    /**
     * set the vertical gap
     * @author weirjosh
     */
    public void setvGap(int newVGap){vGap = newVGap;}

    /**
     * set the horizontal gap
     * @author weirjosh
     */
    public void sethGap(int newHGap){hGap = newHGap;}

    /**
     * @return get the cell size of this GridManager
     * @author weirjosh
     */
    public int getCellSize(){return cellSize;}

    /**
     * @param size The new cell size of this grid manager.
     * @author weirjosh
     */
    public void setCellSize(int size){cellSize = size;}

    /**
     * @param x x coordinate of this GridManager
     * @param y y coordinate of this GridManager
     * @author weirjosh
     */
    public void setOrigin(int x, int y){
        this.x=x;
        this.y=y;
    }

    /**@return The origin of the GridManager
     * @author weirjosh
     */
    public Point getOrigin(){
        return new Point(this.x, this.y);
    }


}
