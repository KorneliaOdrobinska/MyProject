package pl.odrobinska.projekt;

import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest {
    private final static String DEFAULT_AUTHOR = "Anonymous";
    private final static Type DEFAULT_KITCHEN_TYPE = Type.SMALL;

    @Test
    public void test_prepareData_bedroomObject(){
        // given
        Bedroom bedroom = new Bedroom(1,"Bed", "http://","Blue","Kornelia");
        var SUT = new Service(bedroom); // SUT - System Under Test

        // when
        var result = SUT.prepareData();
        //then
        assertTrue(result instanceof Bedroom);
        assertFalse(result instanceof Kitchen);
        assertFalse(result instanceof Hall);

    }

    @Test
    public void test_prepareData_bedroomData(){
        // given
        Bedroom bedroom = new Bedroom(1,"Bed", "http://","Blue","Kornelia");
        var SUT = new Service(bedroom); // SUT - System Under Test

        // when
        var result = SUT.prepareData();
        //then
        assertEquals(bedroom.getId(),result.getId());
        assertEquals(bedroom.getElement(),result.getElement());
        assertEquals(bedroom.getLink(),result.getLink());
        assertEquals(bedroom.getDescription(),result.getDescription());
        assertEquals(bedroom.getAuthor(),result.getAuthor());
    }

    @Test
    public void test_prepareData_bedroomData_defaultAuthor(){
        // given
        Bedroom bedroom = new Bedroom(1,"Bed", "http://","Blue",null);
        var SUT = new Service(bedroom); // SUT - System Under Test

        // when
        var result = SUT.prepareData();
        //then
        assertEquals(bedroom.getId(),result.getId());
        assertEquals(bedroom.getElement(),result.getElement());
        assertEquals(bedroom.getLink(),result.getLink());
        assertEquals(bedroom.getDescription(),result.getDescription());
        assertEquals(DEFAULT_AUTHOR,result.getAuthor());
    }

    @Test
    public void test_prepareData_kitchenObject(){
        // given
        Kitchen kitchen = new Kitchen(1,"Table", "http://","Blue","Kornelia", Type.DARK);
        var SUT = new Service(kitchen); // SUT - System Under Test

        // when
        var result = SUT.prepareData();
        //then
        assertTrue(result instanceof Kitchen);
        assertFalse(result instanceof Bedroom);
        assertFalse(result instanceof Hall);

    }

    @Test
    public void test_prepareData_kitchenData(){
        // given
        Kitchen kitchen = new Kitchen(1,"Table", "http://","Blue","Kornelia", Type.DARK);
        var SUT = new Service(kitchen); // SUT - System Under Test

        // when
        var result = SUT.prepareData();
        //then
        assertEquals(kitchen.getId(),result.getId());
        assertEquals(kitchen.getElement(),result.getElement());
        assertEquals(kitchen.getLink(),result.getLink());
        assertEquals(kitchen.getDescription(),result.getDescription());
        assertEquals(kitchen.getAuthor(),result.getAuthor());
        assertEquals(kitchen.getType(),((Kitchen) result).getType());
    }

    @Test
    public void test_prepareData_kitchenData_defaultAuthor(){
        // given
        Kitchen kitchen = new Kitchen(1,"Table", "http://","Blue",null, null);
        var SUT = new Service(kitchen); // SUT - System Under Test

        // when
        var result = SUT.prepareData();
        //then
        assertEquals(kitchen.getId(),result.getId());
        assertEquals(kitchen.getElement(),result.getElement());
        assertEquals(kitchen.getLink(),result.getLink());
        assertEquals(kitchen.getDescription(),result.getDescription());
        assertEquals(DEFAULT_AUTHOR,result.getAuthor());
        assertEquals(DEFAULT_KITCHEN_TYPE,((Kitchen) result).getType());
    }

    @Test
    public void test_prepareData_hallObject(){
        // given
        Hall hall = new Hall(1,"Wall", "http://","Blue","Kornelia", false);
        var SUT = new Service(hall); // SUT - System Under Test

        // when
        var result = SUT.prepareData();
        //then
        assertTrue(result instanceof Hall);
        assertFalse(result instanceof Bedroom);
        assertFalse(result instanceof Kitchen);

    }

    @Test
    public void test_prepareData_hallData(){
        // given
        Hall hall = new Hall(1,"Wall", "http://","Blue","Kornelia", false);
        var SUT = new Service(hall); // SUT - System Under Test

        // when
        var result = SUT.prepareData();
        //then
        assertEquals(hall.getId(),result.getId());
        assertEquals(hall.getElement(),result.getElement());
        assertEquals(hall.getLink(),result.getLink());
        assertEquals(hall.getDescription(),result.getDescription());
        assertEquals(hall.getAuthor(),result.getAuthor());
        assertEquals(hall.getStairs(),((Hall) result).getStairs());
    }

    @Test
    public void test_prepareData_hallData_defaultAuthor(){
        // given
        Hall hall = new Hall(1,"Wall", "http://","Blue",null, false);
        var SUT = new Service(hall); // SUT - System Under Test

        // when
        var result = SUT.prepareData();
        //then
        assertEquals(hall.getId(),result.getId());
        assertEquals(hall.getElement(),result.getElement());
        assertEquals(hall.getLink(),result.getLink());
        assertEquals(hall.getDescription(),result.getDescription());
        assertEquals(DEFAULT_AUTHOR,result.getAuthor());
        assertEquals(hall.getStairs(),false);
    }
}
