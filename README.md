# Java-Zombie-Platform-Game
First year Java project

Java 2D platformer game developed using a variation of the Box2D game engine, and using Netbeans.

Aim of the game is to surive each level by avoiding enemies, by jumping over them or jumping onto ledges.

My game features: a main menu, level design and powerups.

The main menu is build using Netbeans' GUI builder. 
I have implemented buttons for pausing the game as well as skipping or restarting a particular level.

There are three levels. The first level features a basic zombie enemy that just walks across towards the player.
The second level then features a bat enemy in addition to the zombie enemy; the bat enemy bounces around the platform.
The final level then features a ghost enemt in addition to the zombie and ghost enemy; the ghost enemies drop vertically onto the platforms
and have implement a basic finite state machine in which they move towards the player if the player is close, or they stay idle if not.

The two powerups are implemented to simply activate on collision. There is a speed power up that allows the player to more quickly move
across the platforms, and an invincibility powerup that makes the player invincible for a short period of time. The two powerups also sounds
which are played on pickup. The pickup are also randomly generated for every level so that the player doesn't always know the exact location
and has to adapt their strategy slightly with every playthough.

In addition to these features the ledges use a timer to dissapear after so many seconds in order to make it more difficult for the player.
