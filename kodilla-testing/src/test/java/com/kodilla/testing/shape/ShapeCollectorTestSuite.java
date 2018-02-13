package com.kodilla.testing.shape;

import org.junit.*;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("Starting tests ...");
    }

    @AfterClass
    public static void afterAllTessts() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        System.out.println("Starting test #" + ++testCounter);
    }

    @Test
    public void testAddFigure() {
        // Given
        ShapeCollector shapeCollector = new ShapeCollector();
        // When
        shapeCollector.addFigure(new Circle(5.5));
        // Then
        Assert.assertEquals(1, shapeCollector.getFiguresQuantity());
    }

    @Test
    public void testGetFigure() {
        // Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape figure = new Square(10);
        shapeCollector.addFigure(figure);
        // When
        Shape retrievedFigure = shapeCollector.getFigure(0);
        // Then
        Assert.assertEquals(figure, retrievedFigure);
        Assert.assertEquals("square", retrievedFigure.getShapeName());
        Assert.assertEquals(new Double(10.0*10.0), (Double) retrievedFigure.getField());
    }

    @Test
    public void testRemoveFigureNotExisting() {
        // Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Triangle triangle = new Triangle(6, 12);
        // When
        boolean result = shapeCollector.removeFigure(triangle);
        // Then
        Assert.assertFalse(result);
    }

    @Test
    public void testRemoveFigure() {
        // Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Square square = new Square(4);
        shapeCollector.addFigure(square);
        // When
        boolean result = shapeCollector.removeFigure(square);
        // Then
        Assert.assertTrue(result);
        Assert.assertEquals(0, shapeCollector.getFiguresQuantity());
    }
}
