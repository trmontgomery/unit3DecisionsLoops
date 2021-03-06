Introduction

The goal of this lab is to apply your understanding of decision and loop
    structures to implement a complex algorithm within the context of an
    unfamiliar and significant software framework (GridWorld). In addition,
    you will implement a unit test for your program using the JUnit framework
    and create documentation for your program using JavaDoc.


Requirements

Write a program that plays Conway’s Game of Life. Conway’s Game of Life is a
    cellular automaton. From Wikipedia:

The universe of the Game of Life is an infinite two-dimensional orthogonal
    grid of square cells, each of which is in one of two possible states,
    alive or dead. Every cell interacts with its eight neighbours, which are
    the cells that are horizontally, vertically, or diagonally adjacent. At
    each step in time, the following transitions occur:

* Any live cell with fewer than two live neighbours dies, as if caused by
    underpopulation.
* Any live cell with two or three live neighbours lives on to the next generation.
* Any live cell with more than three live neighbours dies, as if by overcrowding.
* Any dead cell with exactly three live neighbours becomes a live cell, as if
    by reproduction.
* The initial pattern constitutes the seed of the system. The first
    generation is created by applying the above rules simultaneously to every
    cell in the seed—births and deaths occur simultaneously, and the discrete
    moment at which this happens is sometimes called a tick (in other words,
    each generation is a pure function of the preceding one). The rules
    continue to be applied repeatedly to create further generations.


Nonfunctional Requirements:

* the program must be implemented in Java and utilize the GridWorld platform
* I recommend not use GridWorld’s execution engine to produce subsequent
    generations. It will be easier to implement the unit test if you directly
    produce and display subsequent generations.


Artifacts to Produce:

* Requirements Document: Many functional and nonfunctional requirements needs
    to be defined. You must define additional requirements that are
    reasonable and document them in a requirements document. I must review
    your requirements document before you start the design document or test
    plan. You may change the requirements document throughout development.
    
    My requirements:  
    grid is 20x20
    
    live cells look like: flower 
    
    dead cells look like: empty cell
    
    intitial pattern: 
     0 1 2 3 4 5 6
    0 - A - - - - -
    1 - - - A - - -
    2 A A - - A A A
    3 - - - - - - -
    4 - - - - - - -
    5 - - - - - - -
    6 - - - - - - -
    
    how long does the game run?:  infinitely 
    
    time interval between generations: one millisecond
    
    The cells are contained in a bounded grid
    
            
    
    
* Design Document: You must do some design activity before starting
    implementation. This may consist of a flow cart, pseudocode, or other
    design artifact. I must review your design document before you start
    implementing code. You may change your design document throughout
    development.
    
    
    PseudoCode:
      createNextGeneration()
        1)iterate through all of the live cells and keep track of its neighbors and 
          the amount of empty cells around it
          1a)add all of the empty cells to an ArrayList (intialized outside of 
             the for loop)
          1b)if the amount of neighbors near the current cell is not equal to 2 
             or 3 then add them  it to an ArrayList of cells to remove (initialized 
             outside of the for loop)
        2)iterate through all of the deadcells collected in the last for loop
          2a)if the amount of neighbors the current cell has is equal to 3 then add 
          it to an ArrayList of cells to be born (initialized outside of the loop)
        3)iterate through all of the cells to be born and then add them to the grid
        4)iterate through all of the cells to be removed and then remove them from 
          the grid.  (All of these steps need to be in this exact order or all of 
          the cells get removed)
    
    
* Test Plan: You must create a test plan with specific test cases (at least
    two) before starting implementation. I must review your test plan before
    you start implementing your test class. You may change your test plan
    throughout development. The provided code in GitHub is an example of
    implementing an initial test case.
* GameOfLifeTest Test Class: JUnit-compatible test class that implements the
    test plan.
* GameOfLife class: You must produce a working class the meets the
    requirements and is verified and validated by your test plan.
* Reflection Document: This is a significant and challenging lab. Please
    reflect on this experience and share your feedback with me. What did you
    like or dislike and why? What was surprising or unexpected? What did you
    learn? What questions do you still have? What advice would you offer next
    year's students?
    
    
        When I began to write the createNextGeneration() method I originally tried 
  to test whether or not a cell was alive by iterating through every cell in the 
  grid and then checking to see if the current cell’s location was null and then 
  printing out yes if it was alive and no if it was dead in order to test my logic 
  (see alternative code commented out within the method). When I ran this, my 
  terminal window showed that there were no cells alive and I was quite frustrated 
  until you showed me that I just needed to enable unlimited buffering in the 
  terminal window.  However, I still wanted to have something done so I read ahead 
  in Chapter 7 and used ArrayLists to implement the pseudocode above.  Things I am 
  still interested in doing are adding new actors, making the live cells appear on 
  the opposite side of the screen if they hit a wall of the grid, and making the 
  Step button work, because you made it sound like it was difficult, and I like to 
  challenge myself.



Submission:

* Ensure the following artifacts have been committed to GitHub in addition to your code:
    * requirements document
    * design document (pseudocode, flow charts, etc.)
    * test plan (with specific test cases)
    * HTML documentation generated by JavaDoc
    * reflection document
* Submit a pull request in GitHub and submit a link to the request with this assignment.
