import info.gridworld.actor.*;
import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.UnboundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.grid.*; 
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Game of Life starter code. Demonstrates how to create and populate the game using the GridWorld framework.
 * Also demonstrates how to provide accessor methods to make the class testable by unit tests.
 * 
 * @author @gcschmit
 * @version 18 July 2014
 */
public class GameOfLife
{
    // the world comprised of the grid that displays the graphics for the game
    private ActorWorld world;
    
    // the game board will have 5 rows and 5 columns
    private final int ROWS = 20;
    private final int COLS = 20;
    
    // constants for the location of the seven cells initially alive
    private final int Y1 = 0, X1 = 1;
    private final int Y2 = 1, X2 = 3;
    private final int Y3 = 2, X3 = 0;
    private final int Y4 = 2, X4 = 1;
    private final int Y5 = 2, X5 = 4;
    private final int Y6 = 2, X6 = 5;
    private final int Y7 = 2, X7 = 6;

    /**
     * Default constructor for objects of class GameOfLife
     * 
     * @post    the game will be initialized and populated with the initial state of cells
     * 
     */
    public GameOfLife()
    {
        // create the grid, of the specified size, that contains Actors
        BoundedGrid<Actor> grid = new BoundedGrid<Actor>(ROWS, COLS);
        
        // create a world based on the grid
        world = new ActorWorld(grid);
        
        // populate the game
        populateGame();
        
        // display the newly constructed and populated world
        world.show();
        
    }
    
    /**
     * Creates the actors and inserts them into their initial starting positions in the grid
     *
     * @pre     the grid has been created
     * @post    all actors that comprise the initial state of the game have been added to the grid
     * 
     */
    private void populateGame()
    {
        // the grid of Actors that maintains the state of the game
        //  (alive cells contains actors; dead cells do not)
        Grid<Actor> grid = world.getGrid();
        
        //lets the user choose the intial start pattern
        Scanner in = new Scanner(System.in);
        System.out.println("Choose an intial start pattern:  Acorn or Random? ");
        String intial = in.next();
        if (intial.toLowerCase().compareTo("random") == 0)
        {
            drawRandom(grid);
        }
        
        if (intial.toLowerCase().compareTo("acorn") == 0)
        {
            drawAcorn(grid);
        }
        
    }

    /**
     * Generates the next generation based on the rules of the Game of Life and updates the grid
     * associated with the world
     *
     * @pre     the game has been initialized
     * @post    the world has been populated with a new grid containing the next generation
     * 
     */
    public void createNextGeneration()
    {
        /** You will need to read the documentation for the World, Grid, and Location classes
         *      in order to implement the Game of Life algorithm and leverage the GridWorld framework.
         */
        
        // create the grid, of the specified size, that contains Actors
        Grid<Actor> grid = world.getGrid();
        
        // insert magic here...
        ArrayList<Location> liveCells = grid.getOccupiedLocations();
        ArrayList<Location> deadCells = new ArrayList<Location>();
        ArrayList<Location> cellsToRemove = new ArrayList<Location>();
        ArrayList<Location> cellsToBeBorn = new ArrayList<Location>();
        for (Location alive: liveCells)
        {
            ArrayList<Location> neighbors = grid.getOccupiedAdjacentLocations(alive);
            ArrayList<Location> emptyCells = grid.getEmptyAdjacentLocations(alive);
            for (Location empty: emptyCells)
            {
               deadCells.add(empty);
            }
            
            if (!(neighbors.size() == 2 || neighbors.size() == 3))
            {
                cellsToRemove.add(alive);
            }
        }
           
        for (Location dead: deadCells)
        {
            ArrayList<Location> neighbors = world.getGrid().getOccupiedAdjacentLocations(dead);
            if (neighbors.size() == 3)
            {
                cellsToBeBorn.add(dead);
            }
        }
        for (Location birth: cellsToBeBorn)
        {
            Flower flower = new Flower();
            int row = birth.getRow();
            int col = birth.getCol();
            
            /*
             * This section of code makes any live cell that reaches the ends of the grid bounce off of the walls (just for kicks)
             * 
             * if (birth.getRow() == 0)
            {
                Location x = new Location((birth.getRow() + 1), col); 
                grid.put(x, flower);
            }
            
            if (birth.getRow() == (ROWS -1))
            {
                Location x = new Location((birth.getRow() - 1), col); 
                grid.put(x, flower);
            }
            
            if (birth.getCol() == 0)
            {
                Location x = new Location(row, (birth.getCol() + 1));  
                grid.put(x, flower);
            }
            
            if (birth.getCol() == (COLS - 1))
            {
                Location x = new Location(row, (birth.getCol() - 1));  
                grid.put(x, flower);
            }
             */
            
 
            grid.put(birth, flower);
        }
        for (Location death: cellsToRemove)
        {
            grid.remove(death);
        }
        world.setGrid(grid);
     
         /*
          * Alternate way to check for live cells
          * 
        for(int row = 0; row < ROWS; row++)
        {
            for(int col = 0; col < COLS; col++)
            {
                Location locCell = new Location(row, col);
                
                if (grid.get(locCell) != null)
                {
                    System.out.println("Yes");
                }        
                else
                {
                 System.out.println("No");   
                }
            }
        }
        
          */
        
    }
    
    /**
     * Returns the actor at the specified row and column. Intended to be used for unit testing.
     *
     * @param   row the row (zero-based index) of the actor to return
     * @param   col the column (zero-based index) of the actor to return
     * @pre     the grid has been created
     * @return  the actor at the specified row and column
     */
    public Actor getActor(int row, int col)
    {
        Location loc = new Location(row, col);
        Actor actor = world.getGrid().get(loc);
        return actor;
    }

    /**
     * Returns the number of rows in the game board
     *
     * @return    the number of rows in the game board
     */
    public int getNumRows()
    {
        return ROWS;
    }
    
    /**
     * Returns the number of columns in the game board
     *
     * @return    the number of columns in the game board
     */
    public int getNumCols()
    {
        return COLS;
    }
    
    
    /**
     * Intitializes the grid with a Random pattern
     * 
     * @param  grid  The grid that the pattern is to be intialized in
     */
 
    public void drawRandom(Grid<Actor> grid)
    {
        int amount = (int)(Math.random() * ROWS * COLS);
        Flower flower = new Flower();
        for (int i = 0; i < amount; i++)
        {
            int row = (int)(Math.random() * ROWS);
            int col = (int)(Math.random() * COLS);
            Location x = new Location (row, col);
            grid.put(x, flower);
        }
    }
    
    
    /**
     * Intitializes the grid with an Acorn pattern
     * 
     * @param  grid  The grid that the pattern is to be intialized in
     */
    public void drawAcorn(Grid<Actor> grid)
    {
        Flower flower1 = new Flower();
        Location loc1 = new Location(Y1, X1);
        grid.put(loc1, flower1);
        
        Flower flower2 = new Flower();
        Location loc2 = new Location(Y2, X2);
        grid.put(loc2, flower2);
        
        Flower flower3 = new Flower();
        Location loc3 = new Location(Y3, X3);
        grid.put(loc3, flower3);
        
        Flower flower4 = new Flower();
        Location loc4 = new Location(Y4, X4);
        grid.put(loc4, flower4);
        
        Flower flower5 = new Flower();
        Location loc5 = new Location(Y5, X5);
        grid.put(loc5, flower5);
        
        Flower flower6 = new Flower();
        Location loc6 = new Location(Y6, X6);
        grid.put(loc6, flower6);
        
        Flower flower7 = new Flower();
        Location loc7 = new Location(Y7, X7);
        grid.put(loc7, flower7);
    }

    public static void main(String[] args)
        throws InterruptedException
    {
        GameOfLife game = new GameOfLife();
        int run = 0;
        while (run != 1)
        {
            Thread.sleep(100);
            game.createNextGeneration();
        }
    }
}