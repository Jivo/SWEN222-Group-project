package pathfinding.tests;

import org.junit.Test;

import entity.Obstacle;
import model.Tile;
import util.GridLocation;

public class ComplexTests extends Base {
    /**
     * Looks like this
     * 
     * ---------
     * |aI
     * | I
     * | I
     * | I
     * |     b
     * ---------
     * 
     * The path from a->b should scale the wall vertically until it hits the bottom, and then travels
     * horizontally until it hits b. In this sense it forms an 'L' shape.
     */
    @Test
    public void canRouteAroundObnoxiousWall() {
        TestGrid grid = new TestGrid(5, 5);
        Tile source = grid.get(0, 0);
        Tile dest = grid.get(4, 4);
        
        // Fill in a vertical wall right close to the left with only one empty space at the bottom.
        for (int y=0; y<grid.height - 1; y++) {
            Tile tile = grid.get(1, y);
            tile.setMapEntity(new Obstacle(tile.getLocation(), null));
        }
        
        verifyPath(grid, source, dest,
                new GridLocation(0, 0), new GridLocation(0, 1), new GridLocation(0, 2),
                new GridLocation(0, 3), new GridLocation(1, 4), new GridLocation(2, 4),
                new GridLocation(3, 4), new GridLocation(4, 4));
    }
    
    /**
     * Looks like this
     * -----------
     * |A w B    |
     * |  w w w  |
     * |  w w w  |
     * |  w w w  |
     * |         |
     * -----------
     * 
     * On order to get from A to B, we must follow the entire left wall, follow the entire
     * bottom wall, follow the entire right wall, then traverse left until we get to B.
     */
    @Test
    public void canRouteAroundGridBoundaryWhenForced() {
        TestGrid grid = new TestGrid(5, 5);
        Tile source = grid.get(0, 0);
        Tile dest = grid.get(2, 0);
        
        // Fill in every cell except the outermost ring on the boundary.
        for (int x=1; x<grid.width - 1; x++) {
            for (int y=1; y<grid.height - 1; y++) {
                Tile tile = grid.get(x, y);
                tile.setMapEntity(new Obstacle(tile.getLocation(), null));
            }
        }
        // Set the obstacle that forces us to track over the whole boundary.
        Tile tile = grid.get(1, 0);
        tile.setMapEntity(new Obstacle(tile.getLocation(), null));

        
        verifyPath(grid, source, dest,
                new GridLocation(0, 0), new GridLocation(0, 1), new GridLocation(0, 2),
                new GridLocation(0, 3), new GridLocation(0, 4), new GridLocation(1, 4),
                new GridLocation(2, 4), new GridLocation(3, 4), new GridLocation(4, 3),
                new GridLocation(4, 2), new GridLocation(4, 1), new GridLocation(3, 0),
                new GridLocation(2, 0));
        
    }
}
