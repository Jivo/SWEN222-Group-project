package entity;

import javafx.scene.image.ImageView;
import util.GridLocation;

/**
 * Created by Mark on 19/09/2017.
 */
public class Weapon extends Item {

	private final double STRENGTH;

	private Actions actions;

	public Weapon(Player player, GridLocation spawnPos, ImageView sprite, double strength){
		super(player, spawnPos, sprite);
		this.STRENGTH = strength;
	}

	public double getStrength(){
		return STRENGTH;
	}

	public void attack(){
		actions.attack(this);
	}

	interface Actions extends Item.Actions {
		void attack(Weapon weapon);
	}

	public void setActions(Actions newActions){
		this.actions=newActions;
	}
}
