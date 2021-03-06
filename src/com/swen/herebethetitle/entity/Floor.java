package com.swen.herebethetitle.entity;

import com.swen.herebethetitle.logic.Notifier;
import com.swen.herebethetitle.model.GameContext;

/**
 * Represents the Floor of each tile, the ground that other entities sit on top of
 *
 * Created by Mark on 27/09/17.
 *
 * @author Mark Metcalfe
 */
public class Floor extends Static {

    public Floor(String name, String spritePath){ super(name, spritePath); }

	public Floor(String spritePath){ this("Floor", spritePath); }

	/**
	 * Deliberately Blank, Floor can't be interacted with by design
	 */
	@Override
    public void interact(GameContext context, Notifier notifier){}

	/**
	 * The floor is designed to be underneath other entities, so other entities
	 * need to be able to sit on top of it
	 */
	@Override
    public boolean isPenetrable() { return true; }

    @Override
    public String toString() { return super.toString(); }
}
