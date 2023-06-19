package org.example;

import java.util.Optional;

public class Rover {



    Direction direction=Direction.NORTH;
    
    Coordinate coordinate=new Coordinate(0,0);
    private Grid grid;

    public Rover(Grid grid) {
        this.grid = grid;
    }

    public String execute(String r) {
        Optional<Coordinate> nextCoordinate=Optional.empty();
        String obstacle="";
        for(char o:r.toCharArray()){
            if(o=='R'){
                direction=direction.right();

            }else if(o=='L'){
                direction=direction.left();
            }else if(o=='M'){
                nextCoordinate=grid.move_forward(coordinate,direction);
                nextCoordinate.ifPresent(nc->coordinate=nc);
                obstacle=nextCoordinate.isPresent()?"":"O:";

            }
        }

        return obstacle + this.coordinate.getX()+":"+ this.coordinate.getY()+":"+direction.getValue();
    }




}
