package entity;

import javafx.scene.image.Image;
import util.GridLocation;

/**
 * Created by Mark on 19/09/2017.
 */
public class Door extends Obstacle {

	enum STATE { LOCKED, UNLOCKED }

	private final int KEY;
	private STATE state;

	public Door(GridLocation startingPos, Image sprite, int key){
		super(startingPos, sprite);
		KEY = key;
		state = STATE.LOCKED;
	}


}
