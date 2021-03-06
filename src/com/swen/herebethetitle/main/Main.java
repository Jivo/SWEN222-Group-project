package com.swen.herebethetitle.main;

import com.swen.herebethetitle.control.Controller;
import com.swen.herebethetitle.logic.GameListener;
import com.swen.herebethetitle.logic.GameLogic;
import com.swen.herebethetitle.model.GameContext;

/**
 * Main class for the 2D RPG.
 * @author J Woods
 *
 */
public class Main{
	
	public static void main(String[] args) throws Exception {
//		GameContext game = new GameContext();
//		GameLogic gameLogic = new GameLogic(game);
//		/*
//		 * the game and logic are both static in the GUI class.
//		 *this lets the application launch a new instance properly.
//		 */
//		GUI.setGame(game);
//		GUI.setLogic(gameLogic);
//		GUI.launch(GUI.class);
//		gameLogic.addGameListener(GUI.getWorldGraphics());
		
		/*launch new controller - it will set up everything*/
		Controller.launch(Controller.class);
	}
}
