package entity.npcs;

import entity.Mob;
import entity.Player;
import javafx.scene.image.Image;
import model.GameContext;
import util.Direction;
import util.GridLocation;

/**
 * NPC - Non Player Character - will be used for representing monsters and potentially other types of NPC
 * Uses strategy pattern for deciding its actions.
 *
 * Created by Mark on 19/09/17.
 */
public class NPC extends Mob {

	private Actions actions;

	public NPC(GameContext context, GridLocation spawnPos, Image sprite, int startingHealth, Direction direction){
		super(context, spawnPos, sprite, startingHealth, direction);
	}

	public void ping() { actions.ping(); }

	@Override
	public void interact(GameContext context) { actions.interact(this); }

	interface Actions {
		void ping();
		void interact(NPC npc);
		boolean isPenetrable();
	}

	@Override
	public String toString() {
		return null;
	}

	@Override
	public boolean isPenetrable(){
		return actions.isPenetrable();
	}
}
