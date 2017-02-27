package squier.john.dataStructures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @author John A. Squier
 */
public class MyLinkedListTest {

    private MyLinkedList<Integer> myLinkedList;

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
    public void addElementToIndexZeroInEmptyList() {
        int expectedSizeBefore = 0;
        int expectedSizeAfter = 1;
        Integer expected = 10;

        int actualSizeBefore = myLinkedList.size();
        myLinkedList.add(0, 10);
        int actualSizeAfter = myLinkedList.size();
        Integer actual = myLinkedList.get(0);

        Assert.assertEquals("I expect the initial size of the linked list to be zero.",
                expectedSizeBefore, actualSizeBefore);
        Assert.assertEquals("I expect the final size of the linked list to be one.",
                expectedSizeAfter, actualSizeAfter);
        Assert.assertEquals("I expect the zeroth element to be the Integer 10.",
                expected, actual);
    }

    @Test
    public void addElementToIndexZeroInNonEmptyList() {
        myLinkedList.add(1);
        int expectedSizeBefore = 1;
        int expectedSizeAfter = 2;
        Integer[] expected = {0, 1};

        int actualSizeBefore = myLinkedList.size();
        myLinkedList.add(0, 0);
        int actualSizeAfter = myLinkedList.size();
        Integer[] actual = new Integer[2];
        actual[0] = myLinkedList.get(0);
        actual[1] = myLinkedList.get(1);

        Assert.assertEquals("I expect the initial size of the linked list to be one.",
                expectedSizeBefore, actualSizeBefore);
        Assert.assertEquals("I expect the final size of the linked list to be two.",
                expectedSizeAfter, actualSizeAfter);
        Assert.assertArrayEquals("I expect the two elements in the list to be the Integers 0 and 1.",
                expected, actual);
    }

    @Test
    public void addElementToTheEndOfAList() {
        myLinkedList.add(0);
        int expectedSizeBefore = 1;
        int expectedSizeAfter = 2;
        Integer[] expected = {0, 1};

        int actualSizeBefore = myLinkedList.size();
        myLinkedList.add(1, 1);
        int actualSizeAfter = myLinkedList.size();
        Integer[] actual = new Integer[2];
        actual[0] = myLinkedList.get(0);
        actual[1] = myLinkedList.get(1);

        Assert.assertEquals("I expect the initial size of the linked list to be one.",
                expectedSizeBefore, actualSizeBefore);
        Assert.assertEquals("I expect the final size of the linked list to be two.",
                expectedSizeAfter, actualSizeAfter);
        Assert.assertArrayEquals("I expect the two elements in the list to be the Integers 0 and 1.",
                expected, actual);
    }

    @Test
    public void addElementToIndexTwoInList() {
        myLinkedList.add(0);
        myLinkedList.add(1);
        myLinkedList.add(3);
        Integer[] expected = {0, 1, 2, 3};
        int expectedSizeBefore = 3;
        int expectedSizeAfter = 4;

        int actualSizeBefore = myLinkedList.size();
        myLinkedList.add(2, 2);
        int actualSizeAfter = myLinkedList.size();
        Integer[] actual = new Integer[4];
        for ( int i = 0; i < 4; i++ ) {
            actual[i] = myLinkedList.get(i);
        }

        Assert.assertEquals("I expect the initial size of the linked list to be three",
                expectedSizeBefore, actualSizeBefore);
        Assert.assertEquals("I expect the final size of the linked list to be three.",
                expectedSizeAfter, actualSizeAfter);
        Assert.assertArrayEquals("I expect the final list to contain the elements 0, 1, 2, and 3.",
                expected, actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addElementToIndexOutOfBounds() {
        myLinkedList.add(100, 100);
    }

    @Test
    public void addAllEmptyCollectionEmptyListTest() {
        Collection c = Collections.EMPTY_LIST;
        int expectedSizeBefore = 0;
        int expectedSizeAfter = 0;

        int actualSizeBefore = myLinkedList.size();
        myLinkedList.addAll(c);
        int actualSizeAfter = myLinkedList.size();

        Assert.assertEquals("I expect the initial size of the linked list to be zero.",
                expectedSizeBefore, actualSizeBefore);
        Assert.assertEquals("I expect the final size of the linked list to be zero.",
                expectedSizeAfter, actualSizeAfter);
    }

    @Test
    public void addAllNonEmptyCollectionToEmptyListTest() {
        Collection<Integer> c = new ArrayList<>();
        c.add(0);
        c.add(1);
        c.add(2);
        int expectedSizeBefore = 0;
        int expectedSizeAfter = 3;
        Integer[] expected = {0, 1, 2};

        int actualSizeBefore = myLinkedList.size();
        myLinkedList.addAll(c);
        int actualSizeAfter = myLinkedList.size();
        Integer[] actual = new Integer[3];
        for ( int i = 0; i < myLinkedList.size(); i++ ) {
            actual[i] = myLinkedList.get(i);
        }

        Assert.assertEquals("I expect the initial size of the linked list to be zero.",
                expectedSizeBefore, actualSizeBefore);
        Assert.assertEquals("I expect the final size of the linked list to be three.",
                expectedSizeAfter, actualSizeAfter);
        Assert.assertArrayEquals("I expect the final linked list to contain the Integers 0, 1, and 2.",
                expected, actual);
    }

    @Test
    public void addAllEmptyCollectionNonEmptyList() {
        Collection c = Collections.EMPTY_LIST;
        myLinkedList.add(0);
        myLinkedList.add(1);
        myLinkedList.add(2);
        int expectedSizeBefore = 3;
        int expectedSizeAfter = 3;
        Integer[] expected = {0 ,1 ,2};

        int actualSizeBefore = myLinkedList.size();
        myLinkedList.addAll(c);
        int actualSizeAfter = myLinkedList.size();
        Integer[] actual = new Integer[3];
        for ( int i = 0; i < myLinkedList.size(); i++ ) {
            actual[i] = myLinkedList.get(i);
        }

        Assert.assertEquals("I expect the initial size of the linked list to be three.",
                expectedSizeBefore, actualSizeBefore);
        Assert.assertEquals("I expect the final size of the linked list to be three.",
                expectedSizeAfter, actualSizeAfter);
        Assert.assertArrayEquals("I expect the final linked list to contain the Integers 0, 1, and 2.",
                expected, actual);
    }

    @Test
    public void addAllNonEmptyCollectionNonEmptyList() {
        Collection<Integer> c = new ArrayList<>();
        c.add(0);
        c.add(1);
        c.add(2);
        myLinkedList.add(0);
        myLinkedList.add(1);
        myLinkedList.add(2);
        int expectedSizeBefore = 3;
        int expectedSizeAfter = 6;
        Integer[] expected = {0, 1, 2, 0, 1, 2};

        int actualSizeBefore = myLinkedList.size();
        myLinkedList.addAll(c);
        int actualSizeAfter = myLinkedList.size();
        Integer[] actual = new Integer[6];
        for ( int i = 0; i < myLinkedList.size(); i++ ) {
            actual[i] = myLinkedList.get(i);
        }

        Assert.assertEquals("I expect the initial size of the linked list to be three.",
                expectedSizeBefore, actualSizeBefore);
        Assert.assertEquals("I expect the final size of the linked list to be six.",
                expectedSizeAfter, actualSizeAfter);
        Assert.assertArrayEquals("I expect the final linked list to contain the Integers 0, 1, 2, 0, 1, and 2.",
                expected, actual);
    }

    @Test
    public void addAllAtIndexZero() {
        Collection<Integer> c = new ArrayList<>();
        c.add(0);
        c.add(1);
        c.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);
        int expectedSizeBefore = 3;
        int expectedSizeAfter = 6;
        Integer[] expected = {0, 1, 2, 3, 4, 5};

        int actualSizeBefore = myLinkedList.size();
        myLinkedList.addAll(0, c);
        int actualSizeAfter = myLinkedList.size();
        Integer[] actual = new Integer[6];
        for ( int i = 0; i < myLinkedList.size(); i++ ) {
            actual[i] = myLinkedList.get(i);
        }

        Assert.assertEquals("I expect the initial size of the linked list to be three.",
                expectedSizeBefore, actualSizeBefore);
        Assert.assertEquals("I expect the final size of the linked list to be six.",
                expectedSizeAfter, actualSizeAfter);
        Assert.assertArrayEquals("I expect the final linked list to contain the Integers 0, 1, 2, 3, 4, and 5.",
                expected, actual);
    }

    @Test
    public void addAllAtIndexInTheMiddleOfTheList() {
        Collection<Integer> c = new ArrayList<>();
        c.add(0);
        c.add(1);
        c.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);
        int expectedSizeBefore = 3;
        int expectedSizeAfter = 6;
        Integer[] expected = {3, 0, 1, 2, 4, 5};

        int actualSizeBefore = myLinkedList.size();
        myLinkedList.addAll(1, c);
        int actualSizeAfter = myLinkedList.size();
        Integer[] actual = new Integer[6];
        for ( int i = 0; i < myLinkedList.size(); i++ ) {
            actual[i] = myLinkedList.get(i);
        }

        Assert.assertEquals("I expect the initial size of the linked list to be three.",
                expectedSizeBefore, actualSizeBefore);
        Assert.assertEquals("I expect the final size of the linked list to be six.",
                expectedSizeAfter, actualSizeAfter);
        Assert.assertArrayEquals("I expect the final linked list to contain the Integers 3, 0, 1, 2, 4, 5.",
                expected, actual);
    }

    @Test
    public void addAllAtLastIndex() {
        Collection<Integer> c = new ArrayList<>();
        c.add(0);
        c.add(1);
        c.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);
        int expectedSizeBefore = 3;
        int expectedSizeAfter = 6;
        Integer[] expected = {3, 4, 5, 0, 1, 2};

        int actualSizeBefore = myLinkedList.size();
        myLinkedList.addAll(3, c);
        int actualSizeAfter = myLinkedList.size();
        Integer[] actual = new Integer[6];
        for ( int i = 0; i < myLinkedList.size(); i++ ) {
            actual[i] = myLinkedList.get(i);
        }

        Assert.assertEquals("I expect the initial size of the linked list to be three.",
                expectedSizeBefore, actualSizeBefore);
        Assert.assertEquals("I expect the final size of the linked list to be six.",
                expectedSizeAfter, actualSizeAfter);
        Assert.assertArrayEquals("I expect the final linked list to contain the Integers 3, 4, 5, 0, 1, 2.",
                expected, actual);
    }

    @Test
    public void clearListTest() {
        myLinkedList.add(0);
        myLinkedList.add(1);
        myLinkedList.add(2);
        int expectedSizeBefore = 3;
        int expectedSizeAfter = 0;

        int actualSizeBefore = myLinkedList.size();
        myLinkedList.clear();
        int actualSizeAfter = myLinkedList.size();

        Assert.assertEquals("I expect the initial size of the linked list to be three.",
                expectedSizeBefore, actualSizeBefore);
        Assert.assertEquals("I expected the final size of the linked list to be zero.",
                expectedSizeAfter, actualSizeAfter);
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

    @Test
    public void listDoesContainAllTest() {
        Collection<Integer> c = new ArrayList<>();
        c.add(0);
        c.add(1);
        c.add(2);
        myLinkedList.add(0);
        myLinkedList.add(1);
        myLinkedList.add(2);
        boolean expected = true;

        boolean actual = myLinkedList.containsAll(c);

        Assert.assertEquals("I expect the linked list to contain all of collection c (0, 1, 2).",
                expected, actual);
    }

    @Test
    public void listDoesNotContainAllTest() {
        Collection<Integer> c = new ArrayList<>();
        c.add(0);
        c.add(1);
        c.add(2);
        myLinkedList.add(0);
        myLinkedList.add(1);
        boolean expected = false;

        boolean actual = myLinkedList.containsAll(c);

        Assert.assertEquals("I do not expect the linked list to contain all of collection c (0, 1, 2).",
                expected, actual);
    }

    @Test
    public void listAreEqualTest() {

    }

    @Test
    public void listsAreNotEqualTest() {

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getNegativeIndexFromEmptyListTest() {
        myLinkedList.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getPositiveIndexFromEmptyListTest() {
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
        String expected = "head--->value: 1\nvalue: 2\ntail--->value: 3\n";

        String actual = myLinkedList.toString();

        Assert.assertEquals("I expect the list to return \"head--->value: 1\nvalue: 2\ntail--->value: 3\n\".",
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

    @Test
    public void copyListTest() {
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);
        Integer[] expected = {1, 2, 3, 4, 5};

        MyLinkedList<Integer> copiedList = myLinkedList.copy();
        Integer[] actual = new Integer[copiedList.size()];
        for ( int i = 0; i < copiedList.size(); i++ ) {
            actual[i] = copiedList.get(i);
        }

        Assert.assertArrayEquals("I expect the copied list to contain the Integers 1, 2, 3, 4, and 5.",
                expected, actual);
    }

    @Test
    public void reverseListTest() {
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);
        Integer[] expected = {5, 4, 3, 2, 1};

        myLinkedList.reverse();

        Integer[] actual = new Integer[myLinkedList.size()];
        for ( int i = 0; i < myLinkedList.size(); i++ ) {
            actual[i] = myLinkedList.get(i);
        }

        //Assert.assertArrayEquals("I expect the reversed list to contain the Integers 5, 4, 3, 2, and 1.",
        //        expected, actual);
    }
}