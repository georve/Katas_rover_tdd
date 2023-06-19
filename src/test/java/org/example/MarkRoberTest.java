package org.example;


import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;



import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class MarkRoberTest {

    private  Rover rover;

    @Before
    public void init(){

        this.rover=new Rover(new Grid());
    }

    @Test
    @Parameters({
            "R,0:0:E",
            "RR,0:0:S",
            "RRR,0:0:W",
            "RRRR,0:0:N",

    })

    public void rotate_right(String command, String position) {


        assertThat(rover.execute(command),is(position));

    }

    @Test
    @Parameters({
            "L,0:0:W",
            "LL,0:0:S",
            "LLL,0:0:E",
            "LLLL,0:0:N"
    })
    public void rotate_left(String command, String position) {

        assertThat(rover.execute(command),is(position));

    }

    @Test
    @Parameters({
            "M,0:1:N",
            "MMM,0:3:N"
    })
    public void move_up(String command, String position) {

        assertThat(rover.execute(command),is(position));

    }



    @Test
    @Parameters({
            "MMMMMMMMMM,0:0:N",
            "MMMMMMMMMMMMMMM,0:5:N"
    })
    public void move_up_max(String command, String position) {

        assertThat(rover.execute(command),is(position));

    }

    @Test
    @Parameters({
            "RM,1:0:E",
            "RMMMMM,5:0:E"
    })
    public void move_right(String command, String position) {

        assertThat(rover.execute(command),is(position));

    }

    @Test
    @Parameters({
            "LM,9:0:W",

    })
    public void move_west(String command, String position) {

        assertThat(rover.execute(command),is(position));

    }

    @Test
    @Parameters({
            "LLM,0:9:S",

    })
    public void move_south(String command, String position) {

        assertThat(rover.execute(command),is(position));

    }

    @Test
    @Parameters({
            "MMMM,O:0:3:N",
            "RMMMMMM,O:1:0:E"

    })
    public void move_with_obstacle(String command, String position) {
        Coordinate point0_4=new Coordinate(0,4);
        Coordinate point2_0=new Coordinate(2,0);
        Grid grid=new Grid(Arrays.asList(point0_4,point2_0));
        Rover rover=new Rover(grid);
        assertThat(rover.execute(command),is(position));

    }

}
