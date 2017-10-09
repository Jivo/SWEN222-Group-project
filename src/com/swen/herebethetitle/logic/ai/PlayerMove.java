package com.swen.herebethetitle.logic.ai;

import java.util.Optional;

import com.swen.herebethetitle.entity.Player;
import com.swen.herebethetitle.logic.Notifier;
import com.swen.herebethetitle.model.Region;
import com.swen.herebethetitle.model.Tile;
import com.swen.herebethetitle.pathfinding.Graph;
import com.swen.herebethetitle.pathfinding.Path;


/**
 * Interaction to move the player.
 * @author J Woods
 *
 */
public class PlayerMove implements Interaction {
    private Player player;
    private Tile dest;

    @Override
    public void tick(Region region, Notifier notifier) throws InteractionOver {
        /* find optimal path */
        Graph graph = new Graph(region, region.getPlayerTile(), dest);
        Optional<Path> optimalPath = graph.findPath();

        if(!optimalPath.isPresent()) {
            // no optimal path exists, do nothing
            throw new InteractionOver();
        }

        // Move the player
        if(region.getPlayerTile() == dest) { //don't move if we're already there
            throw new InteractionOver();
        }

        region.move(player, optimalPath.get().next());
    }

    @Override
    public boolean isSameAs(Interaction interaction) {
        return interaction instanceof PlayerMove;
    }
}
