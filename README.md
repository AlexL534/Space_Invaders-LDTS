## LDTS_14_08 - Space Invaders

In this 2D fixed shooter game, the player controls a spaceship that shoots lasers!
The objective of the player is to fire at the aliens and survive. The game will be infinite giving a score in the end of the game.

This project was made and developed by Pedro Borges (up202207552@fe.up.pt), Alexandre Lopes (up202207015@fe.up.pt) and Tomás Linhares (up202207236@fe.up.pt) for LP01 2023/2024.

## IMPLEMENTED FEATURES 

### Model

Although it's not definitive most of the model is done (we still want to make changes to the menu and maybe to the bullet and power-ups for further implementations).
Our game consists on the user controlling a spaceship which fires against a horde of aliens and tries to destroy them, depending on each power-up the shooting of the spaceship will be different.
- SpaceShip: user will control it, and it will only move sideways.
- PowerUpShip: which will drop a random PowerUp upon its death.
- Alien
- Bullet: bullet class which will be instantiated on SpaceShip and Alien.
- Element: base class for all of the above.
- PowerUps: TripleShot, FasterFireRate, SlowerFireRate and ExtraLife.
- Space: the "arena" of the game.
- SpaceBuilder: class for building our space.
- LoaderSpaceBuilder: class for loading our space.
- Position: class for getting the position ( x and y coordinates ) of the elements on the space.


## PLANNED FEATURES 

Things like the movement of the aliens (and the drawing), drop of a power-up after killing a PowerUpShip, score showing on the screen, lives showing on the screen, collisions(shots from the aliens hit the player, shots from the player hit the aliens, shots from the player hit the PowerUpShip and drops a power-up),better menu,
create a font for the game (to help draw the elements without them being only a character) etc... 
It will look something like this...

![example.gif](..%2FUsers%2FUtilizador%2FDownloads%2Fexample.gif)


## DESIGN

Our UML for this project looks like this.




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
