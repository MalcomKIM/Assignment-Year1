moves(X,Y,Xs):- moves([state(X,Y)],Xs).


moves([state(X0,Y0)|T], [state(2,Y1),state(X0,Y0)|T])
    	:- move(state(X0,Y0),state(2,Y1)),
	reverse([state(2,Y1),state(X0,Y0)|T], Reversed),
	write('\nThe answer is:'),
	print(Reversed),
	!.

moves([state(X0,Y0)|T],Xs) :-
    move(state(X0,Y0),state(X1,Y1)), 
    not(member(state(X1,Y1),[state(X0,Y0)|T])),
    moves([state(X1,Y1),state(X0,Y0)|T],Xs).

print([state(X,Y)|[]]):-
	write('(',X,',',Y,')').
print([state(X,Y)|T]) :- 
	write('(',X,',',Y,')'),
	print(T).

move(state(X,Y),state(Z,3)) :- Z is X - (3 - Y), Z >= 0.
move(state(X,Y),state(Z,0)) :- Z is X + Y, Z =< 4.
move(state(X,Y),state(4,Z)) :- Z is Y - (4 - X), Z >=0.
move(state(X,Y),state(0,Z)) :- Z is X + Y, Z =< 3.

move(state(0,Y),state(4,Y)).
move(state(X,0),state(X,3)).
move(state(X,Y),state(X,0)) :- Y > 0.
move(state(X,Y),state(0,Y)) :- X > 0.

