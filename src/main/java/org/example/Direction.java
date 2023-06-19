package org.example;

enum Direction{
    NORTH("N","W","E"),
    EAST("E","N","S"),
    SOUTH("S","E","W"),
    WEST("W","S","N");


    private String value;
    private String left;
    private String right;
    Direction(String value, String left, String right) {
        this.value=value;
        this.left=left;
        this.right=right;
    }

    public String getValue(){
        return this.value;
    }

    public Direction right(){
        return setDirectionTo(right);
    }

    public Direction left(){
        return setDirectionTo(left);
    }

    private Direction setDirectionTo(String dir) {
        for (Direction direction:values()){
            if(direction.value==dir){
                return direction;
            }
        }
        return null;
    }
}