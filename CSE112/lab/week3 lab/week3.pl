eats(fred,oranges).       /* "Fred eats oranges" */ 
eats(fred,t_bone_steaks). /* "Fred eats T-bone steaks" */
eats(tony,apples).        /* "Tony eats apples" */ 
eats(john,apples).        /* "John eats apples" */ 
eats(john,grapefruit).    /* "John eats grapefruit" */ 

likes(john,mary). 
likes(john,trains). 
likes(peter,fast_cars).  
likes(Person1,Person2):-  hobby(Person1,Hobby),  hobby(Person2,Hobby).  
hobby(john,trainspotting).  
hobby(tim,sailing).  
hobby(helen,trainspotting).  
hobby(simon,sailing). 