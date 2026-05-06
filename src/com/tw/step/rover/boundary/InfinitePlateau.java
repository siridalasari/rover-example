package com.tw.step.rover.boundary;

import com.tw.step.rover.position.Coordinate;

public class InfinitePlateau implements Boundary {


    @Override
    public boolean isWithin(Coordinate coord) {
        return true;
    }
}
