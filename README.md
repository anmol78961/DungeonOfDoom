# DungeonOfDoom
## Java OOP's game

- GameLogic is the main class
- After you extract the files from the zip folder do change their location in the code

## Instructions

- Before entering using your own map in the game just add borders of '#' around it.

- The game will first ask you to read this file if you haven't read it;
- It will then give you options to select your map;
#### Enter (in any case):
-	'map 1' : To select the first map
-	'map 2' : To select the second map
- 	'map 3' : To select the third map
- 	'choose': To choose your own map

- If you are choosing your own map then enter the map name without the extension;
- Then it will give you instructions to enter then play the game

#### To play the game do th following:
##### 	Enter (in any case):
- 		'move n' : To move up.
- 		'move s' : To move down.
- 		'move e' : To move right.
- 		'move w' : To move left.
- 		'look'   : To look at the 5x5 map around the player.
- 		'quit'   : To quit.
- 		'pick up': To pick up gold.
- 		'hello'  : To see how much gold is required to win.
- 		'gold'   : To see how much gold you have owned.

- To quit you must be the 'E'.
- To pick up the gold you have to be at 'G'.

- The map will print out fail in the following cases:
- 		If you enter 'move n', 'move s', 'move e', or 'move w':
- 			If you are infront of a wall.
- 		If you enter 'pick up':
- 			If you try to pick up the gold when its not there.
- 		If you enter 'quit':
- 			If you try to exit the level when 'E' is not there
