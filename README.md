Universe -   a project to simulate an alternative, finite universe.

Current version wcontains stars, planets, two different types of comets and black holes.
When comets bounce of the edges of the universe they rebound and change depending on the type
of comet. If a comet 5 hits an edge the colour changes. If a comet 6 hits the edge its size 
changes. While moving, comet 5 randomly changes direction. While moving, comet 6 decreases its
life time. Stars, planets and black holes cannot move and do not touch the edges of the universe.
Collisions follow the following rules;
- Comet --> Star = Comet destroyed and sun gains life time equal to comet's area
- Comet --> Plant = Comet destroyed and planet gains the comets area
- Comet --> Black hole proximity = Comet goes straight towards black hole, behaviours ignored
- Comet --> Black hole centre = Comet destroyed
- Cometn --> Cometn = Bounce of each other with directions reversed
- Cometm --> Cometm = Bounce of each other with directions reversed
- Large cometn --> Small cometm = Large continues on same path, small is destroyed
- Fast cometn --> Slow cometm = Fast continues on same path, slow is destroyed

This version does net yet include a User Interface.

UP769535

-------------------------------------------------------------------------------------------------------------

This project is the starting point for the INTPROG Java coursework in academic year 2015/2016.

You will need to modify and add code as detailed in the coursework specification on Moodle

Currently the universe has 3 objects in it which are travelling in different directions. These
objects, of class Space_Object, have some of the behaviour of comets ( as described in the coursework brief).
Space_Objects can detect when they have reached the "bottom" of the Universe and bounce off
the bottom when they hit it. In this version they cannot detect the other edges of
the Universe. These features are illustrated by the green object. Space_Objects are
not aware of each other and, in the current version, should they collide they will just
pass through each other as illustrated by the red and blue objects.

You need to study the code for the Universe and Space_Object classes and make sure you
fully understand how they work. You do not need to look at the Canvas class source
code but you do need to know how to use it so you might want to use the documentation
view for Canvas.

N.B. You are simulating an imaginary, alternative Universe which obeys different rules
to the real Universe! You aren't expected to produce a program which fully obeys
the rules of physics!

