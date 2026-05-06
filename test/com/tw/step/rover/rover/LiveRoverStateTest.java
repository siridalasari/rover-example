package com.tw.step.rover.rover;

import com.tw.step.rover.boundary.Plateau;
import com.tw.step.rover.position.Coordinate;
import com.tw.step.rover.position.Direction;
import com.tw.step.rover.position.Navigator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertSame;

class LiveRoverStateTest {

    static Plateau boundary;
    @BeforeAll
    static void beforeAll() {
        boundary = new Plateau(new Coordinate(0,0), new Coordinate(2,2));
    }

    @Test
    void shouldTurnAndStayLive() {
        Rover rover = new Rover(new Coordinate(1, 1), Direction.N);
        LiveRoverState state = new LiveRoverState(rover);

        RoverState nextState = state.turnLeft(Navigator.create(), boundary);

        assertSame(state, nextState);
        assertEquals("1 1 W", rover.toString());
    }

    @Test
    void shouldMoveAndStayLiveWithinBoundary() {
        Rover rover = new Rover(new Coordinate(1, 1), Direction.N);
        LiveRoverState state = new LiveRoverState(rover);

        RoverState nextState = state.move(Navigator.create(), boundary);

        assertSame(state, nextState);
        assertEquals("1 2 N", rover.toString());
    }

    @Test
    void shouldBecomeDeadWhenRoverStartsOutsideBoundary() {
        Rover rover = new Rover(new Coordinate(5, 5), Direction.N);
        LiveRoverState state = new LiveRoverState(rover);

        RoverState nextState = state.move(Navigator.create(), new Plateau(new Coordinate(0, 0), new Coordinate(2, 2)));

        assertInstanceOf(DeadRoverState.class, nextState);
        assertEquals("5 5 N", rover.toString());
    }
}
