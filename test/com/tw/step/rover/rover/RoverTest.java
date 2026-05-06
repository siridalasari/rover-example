package com.tw.step.rover.rover;

import com.tw.step.rover.boundary.Plateau;
import com.tw.step.rover.position.Coordinate;
import com.tw.step.rover.position.Direction;
import com.tw.step.rover.position.Navigator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoverTest {

    static Plateau boundary;
    @BeforeAll
    static void beforeAll() {
        boundary = new Plateau(new Coordinate(0,0), new Coordinate(2,2));
    }

    @Test
    void shouldTurnAndMove() {
        Rover rover = new Rover(new Coordinate(0, 0), Direction.N);
        Navigator navigator = Navigator.create();

        rover.turnRight(navigator, boundary);
        rover.move(navigator, boundary);

        assertEquals("1 0 E", rover.toString());
    }


}
