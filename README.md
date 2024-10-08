<<<<<<< HEAD
## LDTS_14_08 - Space Invaders

In this 2D fixed shooter game, the player controls a spaceship that shoots lasers!
The objective of the player is to fire at the aliens and survive. The game will have a couple of levels (that go up in difficulty).

This project was made and developed by Pedro Borges (up202207552@fe.up.pt), Alexandre Lopes (up202207015@fe.up.pt) and Tomás Linhares (up202207236@fe.up.pt) for LP01 2023/2024.

## IMPLEMENTED FEATURES 

We still only have done the movement and the drawing of the spaceship and tried to implement the shooting.

## PLANNED FEATURES 

Things like the movement of the aliens (and the drawing), spawn of power-ups after a certain amount of kills, score showing on the screen, lifes showing on the screen, collisions, menu,
levels, create a font for the game (to help draw the elements without them being only a character) etc... 
It will look something like this..

![image_of_space_invaders](docs%2Fimage.png)

(We need GUI Mock-Ups to show this planned features)

## DESIGN

Our UML for this project looks like this.

![initial-uml.png](docs%2Finitial-space.png)

#### THE SHOOT ACTION SHOULD BE DIFFERENT DEPENDING ON WHICH/NONE POWER-UP

We were thinking of using a lot of conditional logic when deciding how would the spaceship behave while shooting, since shooting should be different based on which power-up (triple-shot, bomb, shield, half fire-rate shooting...). 

Instead, we will apply the State pattern. Making it possible to distinguish different states based on what power-ups the player has...

The use of the State Pattern in the current design allows the following benefits:

- The several states that represent the spaceship shooting will be easier to control and to understand, instead of relying on a series of flags.
- We don’t need to have a long set of conditional if or switch statements associated with the various states; instead, polimorphism is used to activate the right behavior.
- There are now more classes and instances to manage.


#### MVC Pattern

We noticed the code looked a bit messy and it would be hard for other people to read it and understand it.

So we decided that we will use this pattern to separate the game logic from the display code, this makes the code more readable and easier to fix.


The use of the MVC Pattern in the current design allows the following benefits:

- Its easier to add features and to fix bugs.
- The code will be more organised, so its easier to read and to write.


#### Singleton Pattern


...

#### KNOWN CODE SMELLS 

Our code, since it's not refined, it's not well organised, so it's a bit confusing and not clean. 

### TESTING

Screenshot of the tests..
Link to mutation testing report..

### SELF-EVALUATION

....
=======
# LDTS_14_08 - Space Invaders

## Game Description
In this 2D fixed shooter game, the player controls a spaceship that shoots lasers!
The objective of the player is to fire at the aliens and survive. The game will be infinite giving a score in the end of the game.

This project was developed by Pedro Borges, Alexandre Lopes, Tomás Linhares.

For a more detailed version check the README inside the docs' folder.

## Screenshots
### Game
![invaders.gif](docs%2Finvaders.gif)

### Main Menu
![Mainmenu.png](docs%2FMainmenu.png)

### Instructions
![instructions.png](docs%2Finstructions.png)
### Leaderboard 
![leaderboard.png](docs%2Fleaderboard.png)
### Game Over Screen
![gameover.png](docs%2Fgameover.png)
>>>>>>> 4f06f33b1ab10fb6901ee4044b250ab34a12b343
