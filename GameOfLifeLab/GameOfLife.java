import info.gridworld.actor.*;
import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import static org.junit.Assert.*;
import info.gridworld.grid.*; 

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
        
        // create and add rocks (a type of Actor) to the three intial locations
        Actor rock1 = new Actor();
        Location loc1 = new Location(Y1, X1);
        grid.put(loc1, rock1);
        
        Bug rock2 = new Bug();
        Location loc2 = new Location(Y2, X2);
        grid.put(loc2, rock2);
        
        Critter rock3 = new Critter();
        Location loc3 = new Location(Y3, X3);
        grid.put(loc3, rock3);
        
        Flower rock4 = new Flower();
        Location loc4 = new Location(Y4, X4);
        grid.put(loc4, rock4);
        
        Rock rock5 = new Rock();
        Location loc5 = new Location(Y5, X5);
        grid.put(loc5, rock5);
        
        Rock rock6 = new Rock();
        Location loc6 = new Location(Y6, X6);
        grid.put(loc6, rock6);
        
        Rock rock7 = new Rock();
        Location loc7 = new Location(Y7, X7);
        grid.put(loc7, rock7);
    }

    /**
     * Generates the next generation based on the rules of the Game of Life and updates the grid
     * associated with the world
     *
     * @pre     the game has been initialized
     * @post    the world has been populated with a new grid containing the next generation
     * 
     */
    private void createNextGeneration()
    {
        /** You will need to read the documentation for the World, Grid, and Location classes
         *      in order to implement the Game of Life algorithm and leverage the GridWorld framework.
         */
        
        // create the grid, of the specified size, that contains Actors
        Grid<Actor> grid = world.getGrid();
        
        // insert magic here...
        for(int row = 0; row < ROWS; row++)
        {
            for(int col = 0; col < COLS; col++)
            {
                Location locCell = new Location(ROWS, COLS);
                assertNotNull(locCell);
                
            }
        }
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
     * Creates an instance of this class. Provides convenient execution.
     *
     */
    public static void main(String[] args)
    {
        GameOfLife game = new GameOfLife();
    }

}
