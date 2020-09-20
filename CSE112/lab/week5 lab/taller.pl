taller(bob,mike).
taller(mike,jim).
taller(jim,george).

istaller(X,Z):-taller(X,Z).
istaller(X,Z):-taller(X,Y), istaller(Y,Z).