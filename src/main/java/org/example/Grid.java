package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Grid {

    public static final int MAX_HEIGHT = 10;
    public static final int MAX_WEIGHT=10;

    List<Coordinate> obstacles;

    public Grid(){
        this.obstacles= Collections.emptyList();
    }

    public  Grid(List<Coordinate> list) {
        this.obstacles=list;
    }

    public Optional<Coordinate> move_forward(Coordinate coordinate,Direction direction) {
        int y= coordinate.getY();
        int x= coordinate.getX();
        if(direction==Direction.NORTH){
            y=(y+1)% MAX_WEIGHT;
        }

        if(direction==Direction.EAST){
            x=(x+1)%MAX_HEIGHT;
        }

        if(direction==Direction.WEST){
            x=(x>0)?(x-1):MAX_HEIGHT-1;
        }

        if(direction==Direction.SOUTH){
            y=(y>0)?(y-1):MAX_WEIGHT-1;
        }

        Coordinate newCoordinates=new Coordinate(x,y);

       return this.obstacles.contains(newCoordinates)? Optional.empty() :Optional.of(newCoordinates);


    }
}
