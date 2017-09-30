package com.swen.herebethetitle.parsertests;
import org.junit.Test;
import static org.junit.Assert.fail;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.swen.herebethetitle.model.Tile;
import com.swen.herebethetitle.parser.TerrainParser;



/** 
 * This class will handle all white-box tests for the Terrain Parser and ensure it functions as far as I can tell.
 * @author - Jordan
 * */
public class TerrainParserTests {
	
	File testTerrain = new File("res/test_terrain_file.txt");
	/** 
	 * Testing the first method for initializing properly
	 * */
	@Test
	public void init_scanner_load() throws IOException{
		System.out.println("Testing scanner initialization for the txt file");
		TerrainParser tp = new TerrainParser();
		try{
			tp.init_scanner(testTerrain);
		}
		catch(IOException e){
			fail("IOException during the Terrain Parser Initialization");
		}			
	}
	/** 
	 * Checking if the string stored in character matches that of the terrain map provided.
	 * 
	 * @author - Jordan
	 * */
	@Test
	public void string_parser_test(){
		TerrainParser tp = new TerrainParser();
		try{
			System.out.println("Testing String Parser to see Tile matches the txt file");
			tp.init_scanner(testTerrain);
			tp.parseStringArray();
			Tile[][] rA = tp.getRA();
			ArrayList<String[]> sA = tp.getStringArray();
			for(int i = 0; i < sA.size(); i++){
				for(int j = 0; j < sA.get(i).length; j++){
					//System.out.println(rA[i][j].getCharacter() + " " + sA.get(i)[j]);
					if(!(rA[i][j].getCharacter().equals(sA.get(i)[j]))){
						
						fail("character pulled from regionArray does not match stringArray");
					}
				}
			}
			
		}
		catch(IOException e){
			fail("IOException during the Terrain Parser string parser test");
		}
		catch(IndexOutOfBoundsException e){
			fail("Index fell out of bounds during the parsing process or in examining the classes themselves.");
		}
		finally{
			
		}
	}
	/** 
	 * This test is for ensuring the tiles which are added together have no IndexOutOfBoundsExceptions and are only neighbours with each other.
	 * It also prints the number of neighbours it knows.
	 * 
	 * @Author - Jordan
	 * */
	@Test
	public void connecting_nodes_test(){
		TerrainParser tp = new TerrainParser();
		try{
			System.out.println("Testing String Parser to see if it connects the right number of nodes");
			tp.init_scanner(testTerrain);
			tp.parseStringArray();
			Tile[][] rA = tp.getRA();
			tp.connectNetworks(rA);
			for(int i = 0; i < rA.length; i++){
				for(int j = 0; j < rA[i].length; j++){
					System.out.print(rA[i][j].getNeighbours().size());
				}
				System.out.println("");
			}
		}
		catch(IOException e){
			fail("IOException during the Terrain Parser connecting nodes test");
		}
		catch(IndexOutOfBoundsException e){
			fail("Index fell out of bounds during the parsing process or in examining the classes themselves.");
		}
	}
}