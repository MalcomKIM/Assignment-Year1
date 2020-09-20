/* Family Tree */

parent(pete,ian).     % Pete is a parent of Ian
parent(ian,peter).
parent(ian,lucy).
parent(lou,pete).
parent(lou,pauline).
parent(cathy,ian).

female(cathy).        % Cathy is female.
female(lucy).
female(pauline).
female(lou).

male(ian).            % Ian is male.
male(pete).
male(peter).

predecessor(X,Z):-parent(X,Z).
predecessor(X,Z):-parent(X,Y), predecessor(Y,Z).

child(pete,ian). % Ian is child of Pete 
child(ian,peter).
child(ian,lucy).
child(lou,pete).
child(lou,pauline).
child(cathy,ian).

successor(X,Z):-child(X,Z).
successor(X,Z):-child(X,Y), successor(Y,Z).

silly(X):-silly(X).

