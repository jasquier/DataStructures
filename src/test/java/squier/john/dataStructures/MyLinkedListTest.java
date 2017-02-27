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

    @Test(expected = ListHasNoElementsException.class)
    public void getNegativeIndexFromEmptyListTest() {
        myLinkedList.get(-1);
    }

    @Test(expected = ListHasNoElementsException.class)
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
}
