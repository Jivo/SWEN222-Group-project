package com.swen.herebethetitle.pathfinding.test;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.swen.herebethetitle.entity.Entity;
import com.swen.herebethetitle.entity.Terrain;

/**
 * Tests invariants that must be true for pathfinding to work correctly.
 * @author dylan
 */
public class Invariants {
    @Test
    public void obstacleEntityIsImpenetrable() {
        Entity terrain = new Terrain(null);
        assertFalse(terrain.isPenetrable());
    }
}
