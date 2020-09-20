state(2,_).

state(0,0):-write('Fill the 3-galloon jug:(0,0) --> (0,3)\n'),state(0,3).

state(0,3):-write('Pour water from 3-Gallon jug to 4-gallon:(0,3) --> (3,0)\n'),state(3,0).

state(3,0):-write('Fill the 3-galloon jug:(3,0) --> (3,3)\n'),state(3,3).

state(3,3):-write('Pour water from 3-Gallon jug to 4-gallon:(3,3) --> (4,2)\n'),state(4,2).

state(4,2):-write('Empty the 4-Gallon jug:(4,2) --> (0,2)\n'),state(0,2).

state(0,2):-write('Pour water from 3-Gallon jug to 4-gallon:(0,2) --> (2,0)\n'),state(2,0).

state(4,0):-write('Empty the 4-Gallon jug:(4,0) --> (0,0)\n'),state(0,0).

state(4,3):-write('Empty the 3-Gallon jug:(4,3) --> (4,0)\n'),state(4,0).