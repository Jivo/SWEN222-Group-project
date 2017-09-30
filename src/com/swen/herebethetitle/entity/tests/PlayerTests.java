package com.swen.herebethetitle.entity.tests;

import com.swen.herebethetitle.entity.items.Item;
import org.junit.Test;
import static org.junit.Assert.*;
import com.swen.herebethetitle.entity.*;
import com.swen.herebethetitle.entity.items.*;
import com.swen.herebethetitle.model.GameContext;
import com.swen.herebethetitle.util.Direction;

import java.util.*;


/**
 * Created by Mark on 19/09/2017.
 */
public class PlayerTests {
	@Test
	public void test_add(){
		Player p = new Player(null, Direction.Down);
		p.add(new Item(null), new Item(null));
		assertEquals(2, p.inventory().getItems().size());
	}

	@Test
	public void test_posseses(){
		Player p = new Player(null, Direction.Down);
		Item i = new Item(null);
		p.add(i);
		assertTrue(p.possesses(i));
	}

	@Test
	public void test_damage_noArmour_1(){
		Player p = new Player(null, Direction.Down);
		p.damage(20);
		assertEquals(Mob.FULL_HEALTH-20, p.getHealth(), 0);
	}

	@Test
	public void test_damage_armour_1(){
		Player p = new Player(null, Direction.Down);
		Armour a = new Armour(null, Armour.TYPE.HELMET, 3.5);
		p.add(a);
		p.damage(20);
		assertTrue(p.getHealth()>Mob.FULL_HEALTH-20);
		assertTrue(p.getHealth()<Mob.FULL_HEALTH);
	}

	@Test
	public void test_damage_armour_2(){
		Player p = new Player(null, Direction.Down);
		Armour a = new Armour(null, Armour.TYPE.HELMET, 3.5);
		Armour b = new Armour(null, Armour.TYPE.TORSO, 6);
		Armour c = new Armour(null, Armour.TYPE.BOOTS, 1.75);
		p.add(a, b, c);
		p.damage(20);
		assertTrue(p.getHealth()>Mob.FULL_HEALTH-20);
		assertTrue(p.getHealth()<Mob.FULL_HEALTH);
	}

	@Test
	public void test_isPenetrable(){
		Player p = new Player(null, Direction.Down);
		assertFalse(p.isPenetrable());
	}

	@Test
	public void test_toString(){
		Player p = new Player(null, Direction.Down);
		assertNotNull(p.toString());
	}
}
