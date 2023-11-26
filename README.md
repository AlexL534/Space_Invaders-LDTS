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

![space_invaders.gif](docs%2Fspace_invaders.gif)


## DESIGN

Our UML for this project looks like this.



![uml-image.png](docs%2Fuml-image.png)




#### The Shoot Action should be different depending on each power-up / no power-up

##### Problem in Context
We were thinking of using a lot of conditional logic when deciding how would the spaceship behave while shooting, since shooting should be different based on which power-up (triple-shot, bomb, shield, half fire-rate shooting...). 
##### The Pattern
Instead, we will apply the State pattern. Making it possible to distinguish different states based on what power-ups the player has...
#### Implementation
Can be seen in the image of our UML 
#### Consequences
The use of the State Pattern in the current design allows the following benefits:

- The several states that represent the spaceship shooting will be easier to control and to understand, instead of relying on a series of flags.
- We don’t need to have a long set of conditional if or switch statements associated with the various states; instead, polymorphism is used to activate the right behavior.
- There are now more classes and instances to manage.
#### MVC Pattern
##### Problem in Context
We noticed the code looked a bit messy, and it would be hard for other people to read it and understand it.
##### The Pattern
So we decided that we will use this pattern to separate the game logic from the display code, this makes the code more readable and easier to fix.
##### Implementation
Can be seen in the image of our UML
##### Consequences
The use of the MVC Pattern in the current design allows the following benefits:

- Its easier to add features and to fix bugs.
- The code will be more organised, so it's easier to read and to write.

#### Observer Pattern
##### Problem in Context 
We noticed that there were objects that will be interested in the actions of another one, so we decided to implement the Observer Pattern on reading keystrokes (user inputs), since some classes will need to be notified when a certain input is made, we determined it would be best to
use this pattern.
##### Implementation
Can be seen in the image of our UML
##### The Pattern/Consequences
The use of the Observer Pattern in the current design allows the following benefits:
- Enables objects to have relations between them in runtime without changing the main class.


#### Factory Pattern
##### Problem in Context

We noticed the entities of our game had some similarities, but it wouldn't do us any better having a common interface because it wouldn't be reusable, classes that implement such interface have different atributes and types, so instead of having them separated
and when needed to change a common attribute having to change all the classes, we decided it was best to use this Pattern.

##### The Pattern
This Factory pattern defines an interface for creating objects, but lets subclasses decide which classes to instantiate.

##### Implementation
Can be seen in the image of our UML
##### Consequences 
The use of the Factory Pattern in the current design allows the following benefits:
- Factory methods eliminate the need to bind application-specific classes into your code.
- The code only needs to deal with the Product interface; therefore it can work with any user-defined ConcreteProduct classes. 
#### KNOWN CODE SMELLS 

We didn't notice any  code smells.

### TESTING

Screenshot of the tests..
Link to mutation testing report..

### SELF-EVALUATION

Pedro Borges - 33.3%

Alexandre Lopes - 33.3%

Tomás Linhares - 33.3%