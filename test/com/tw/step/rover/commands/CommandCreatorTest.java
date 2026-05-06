package com.tw.step.rover.commands;

import com.tw.step.rover.position.Navigator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNull;

class CommandCreatorTest {
    @Test
    void shouldCreateCommandsForKnownInstructions() {
        CommandCreator commandCreator = new CommandCreator();
        Navigator navigator = Navigator.create();
        InfinitePlateau boundary = new InfinitePlateau();

        assertInstanceOf(TurnLeftCommand.class, commandCreator.create('L', navigator, boundary));
        assertInstanceOf(TurnRightCommand.class, commandCreator.create('R', navigator, boundary));
        assertInstanceOf(MoveCommand.class, commandCreator.create('F', navigator, boundary));
    }

    @Test
    void shouldReturnNullForUnknownInstruction() {
        assertNull(new CommandCreator().create('X', Navigator.create(), new InfinitePlateau()));
    }
}
