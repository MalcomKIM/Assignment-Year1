numeral(0).
numeral(succ(X)):-numeral(X).

greater(succ(_),0).
greater(succ(X),succ(Y)):-greater(X,Y).

add(0,Y,Y).
add(succ(X),Y,succ(Z)):-add(X,Y,Z).