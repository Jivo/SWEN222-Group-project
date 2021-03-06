package com.swen.herebethetitle.entity;

import com.swen.herebethetitle.model.GameContext;

/**
 * Used for interacting with doors
 *
 * Created by Mark on 27/09/17.
 *
 * @author Mark Metcalfe
 */
public final class Key extends Item {

    private final int KEY;

	/**
	 * @param name The name of the key
	 * @param spritePath What it looks like
	 * @param key The ID of the key that matches a door
	 */
	public Key(String name, String spritePath, int key){
    	super(name, spritePath);
        this.KEY = key;
    }

	/**
	 * Check whether a given key ID is the same as this one
	 */
	protected boolean equals(int key) {
		return this.KEY == key;
	}

	/**
	 * Picking up key doesn't do anything, handled by DoorStrategy instead
	 */
	@Override
	protected void use(GameContext context) {
	}

	@Override
	public String toString() { return super.toString()+" "+KEY; }
}
