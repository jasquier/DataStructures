package squier.john.dataStructures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author John A. Squier
 */
public class MyLinkedListTest {

    MyLinkedList<Integer> myLinkedList;

    @Before
    public void setup() {
        myLinkedList = new MyLinkedList<>();
    }

    @Test
    public void addElementToTheListTest() {
        int expectedSizeBefore = 0;
        int expectedSizeAfter = 1;
        Integer expected = 1;

        int actualSizeBefore = myLinkedList.size();
        myLinkedList.add(1);
        int actualSizeAfter = myLinkedList.size();
        Integer actual = myLinkedList.get(0);

        Assert.assertEquals("I expect the initial size of the linked list to be zero.",
                expectedSizeBefore, actualSizeBefore);
        Assert.assertEquals("I expect the final size of the the linked list to be one.",
                expectedSizeAfter, actualSizeAfter);
        Assert.assertEquals("I expect the element at index 0 to be the Integer 1.",
                expected, actual);
    }

    @Test
    public void addFiveElementsToTheListTest() {
        int expectedSizeBefore = 0;
        int expectedSizeAfter = 5;
        Integer[] expected = {1, 2, 3, 4, 5};

        int actualSizeBefore = myLinkedList.size();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);
        int actualSizeAfter = myLinkedList.size();
        Integer[] actual = new Integer[5];
        for ( int i = 0; i < 5; i++ ) {
            actual[i] =  myLinkedList.get(i);
        }

        Assert.assertEquals("I expect the initial size of the linked list to be zero.",
                expectedSizeBefore, actualSizeBefore);
        Assert.assertEquals("I expect the final size of the linked list to be five.",
                expectedSizeAfter, actualSizeAfter);
        Assert.assertArrayEquals("I expect the five elements in the list to be the Integers 1, 2, 3, 4, and 5.",
                expected, actual);
    }

    @Test
    public void listDoesContainElementTest() {
        myLinkedList.add(100);
        boolean expected = true;

        boolean actual = myLinkedList.contains(100);

        Assert.assertEquals("I expect myLinkedList.contains(100) to return true.",
                expected, actual);
    }

    @Test
    public void nonEmptyListDoesNotContainElementTest() {
        myLinkedList.add(1);
        boolean expected = false;

        boolean actual = myLinkedList.contains(100);

        Assert.assertEquals("I expect myLinkedList.contains(100) to return false.",
                expected, actual);
    }

    @Test
    public void emptyListDoesNotContainElementTest() {
        boolean expected = false;

        boolean actual = myLinkedList.contains(100);

        Assert.assertEquals("I expect myListList.contains(100) to return false.",
                expected, actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getNegativeIndexFromEmptyListTest() {
        myLinkedList.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getPositiveFromEmptyListTest() {
        myLinkedList.get(1000);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getNegativeIndexFromNonEmptyListTest() {
        myLinkedList.add(1);
        myLinkedList.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getPositiveIndexFromNonEmptyListTest() {
        myLinkedList.add(1);
        myLinkedList.get(1000);
    }

    @Test
    public void getSizeOfEmptyListTest() {
        int expected = 0;

        int actual = myLinkedList.size();

        Assert.assertEquals("I expect an empty linked list to have size 0.",
                expected, actual);
    }

    @Test
    public void getSizeOfListWithFiveElementsInIt() {
        int expected = 5;
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);

        int actual = myLinkedList.size();

        Assert.assertEquals("I expect a list with five elements in it to be of size 5.",
                expected, actual);
    }

    @Test
    public void emptyListToStringTest() {
        String expected = "no elements in the list";

        String actual = myLinkedList.toString();

        Assert.assertEquals("I expect an empty list's toString() to return \"no elements in the list\".",
                expected, actual);
    }

    @Test
    public void listWithThreeElementsToStringTest() {
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        String expected = "value: 1\nvalue: 2\nvalue: 3\n";

        String actual = myLinkedList.toString();

        Assert.assertEquals("I expect the list to return \"value: 1\nvalue: 2\nvalue: 3\n\".",
                expected, actual);
    }

    @Test
    public void findElementInListTest() {
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        int expected = 1;

        int actual = myLinkedList.find(2);

        Assert.assertEquals("I expect the index of the element with value 2 to be 1.",
                expected, actual);
    }

    @Test
    public void findElementThatIsNotInTheListTest() {
        int expected = -1;

        int actual = myLinkedList.find(100);

        Assert.assertEquals("I expect the index of an element that doesn't exist to be -1.",
                expected, actual);
    }

    @Test
    public void removeFirstElementFromList() {
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        Integer expected = 1;
        int expectedSizeBefore = 3;
        int expectedSizeAfter = 2;

        int actualSizeBefore = myLinkedList.size();
        Integer actual = myLinkedList.remove(0);
        int actualSizeAfter = myLinkedList.size();

        Assert.assertEquals("I expect the zeroth index to be the Integer 1.",
                expected, actual);
        Assert.assertEquals("I expect the list to be of size 3 before the remove() call.",
                expectedSizeBefore, actualSizeBefore);
        Assert.assertEquals("I expect the list to be of size 2 after the remove() call.",
                expectedSizeAfter, actualSizeAfter);
    }

    @Test
    public void removeMiddleElementFromList() {
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        Integer expected = 2;
        int expectedSizeBefore = 3;
        int expectedSizeAfter = 2;

        int actualSizeBefore = myLinkedList.size();
        Integer actual = myLinkedList.remove(1);
        int actualSizeAfter = myLinkedList.size();

        Assert.assertEquals("I expect the first index to be the Integer 2.",
                expected, actual);
        Assert.assertEquals("I expect the list to be of size 3 before the remove() call.",
                expectedSizeBefore, actualSizeBefore);
        Assert.assertEquals("I expect the list to be of size 2 after the remove() call.",
                expectedSizeAfter, actualSizeAfter);
    }

    @Test
    public void removeLastElementFromList() {
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        Integer expected = 3;
        int expectedSizeBefore = 3;
        int expectedSizeAfter = 2;

        int actualSizeBefore = myLinkedList.size();
        Integer actual = myLinkedList.remove(2);
        int actualSizeAfter = myLinkedList.size();

        Assert.assertEquals("I expect the second index to be the Integer 3.",
                expected, actual);
        Assert.assertEquals("I expect the list to be of size 3 before the remove() call.",
                expectedSizeBefore, actualSizeBefore);
        Assert.assertEquals("I expect the list to be of size 2 after the remove() call.",
                expectedSizeAfter, actualSizeAfter);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeElementThatDoesNotExistFromEmptyList() {
        myLinkedList.remove(100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeElementThatDoesNotExistFromNonEmptyList() {
        myLinkedList.add(1);
        myLinkedList.remove(10);
    }
}