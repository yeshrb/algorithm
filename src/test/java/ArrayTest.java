

import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by ljj on 2018/1/10.
 */
public class ArrayTest {
    Array arr;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {
        arr = initTestArray(20);
    }

    @Test
    public void testCreate() {
        Array arr = new Array();
        assertNotNull(arr);
        Array arr1 = new Array(20);
        assertNotNull(arr1);
    }

    @Test
    public void testGetSize() {
        Array arr = new Array(20);
        assertEquals(0, arr.getSize());
        arr = initTestArray(20);
        assertEquals(10, arr.getSize());

    }

    @Test
    public void testAddLast() {
        Array arr = initTestArray(10);
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, arr.data);
    }

    @Test
    public void testAdd() {
        Array arr = initTestArray(20);
        arr.add(3, 100);
        assertArrayEquals(new int[]{0, 1, 2, 100, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0}, arr.data);

    }

    @Test
    public void testGetCapacity() {
        Array arr = initTestArray(10);
        assertEquals(10, arr.getCapacity());
        assertEquals(10, arr.getSize());
        Array arr1 = initTestArray(20);
        assertEquals(20, arr1.getCapacity());
        assertEquals(10, arr1.getSize());
    }

    @Test
    public void testAddFirst() {
        Array arr = new Array();
        arr.addFirst(100);
        assertEquals(100, arr.data[0]);
        arr.addFirst(200);
        assertEquals(200, arr.data[0]);

    }

    @Test
    public void testIsEmpty() {
        Array arr = new Array();
        assertTrue(arr.isEmpty());
        arr.addLast(1);
        assertFalse(arr.isEmpty());

    }

    @Test
    public void testToString() {
        Array arr = initTestArray(20);
        String expected = "Arrat: size = 10, capacity = 20\n"
                + "[0,1,2,3,4,5,6,7,8,9]";
        assertEquals(expected, arr.toString());

    }

    @Test
    public void testGet() {
        assertEquals(0, arr.get(0));
        thrown.expect(IllegalArgumentException.class);
        arr.get(arr.getSize());
    }

    @Test
    public void testSet() {
        Array arr = initTestArray(20);
        arr.set(0, 101);
        assertEquals(101, arr.get(0));
        thrown.expect(IllegalArgumentException.class);
        arr.set(arr.getSize(), 101);
        thrown.expect(IllegalArgumentException.class);
        arr.set(-1, 101);
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    @Test
    public void find_should_return_index_of_element_or_neg_1_if_not_exist() {
        Array arr = initTestArray(20);
        assertEquals(3, arr.find(3));
    }


    @Test
    public void remove_should_delete_element_of_index_and_return_element_deleted() {
        Array arr = initTestArray(20);
        assertEquals(1, arr.remove(1));
        assertEquals(9, arr.getSize());
        assertEquals(2, arr.get(1));

    }

    // 从数组中删除第一个元素, 返回删除的元素
    @Test
    public void removeFirst_should_remove_the_first_element_and_return_it() {
        Array arr = initTestArray(20);
        assertEquals(0, arr.removeFirst());
        assertEquals(1, arr.removeFirst());
        assertEquals(2, arr.removeFirst());

    }

    // 从数组中删除最后一个元素, 返回删除的元素
    @Test
    public void removeLast_should_remove_the_last_element_and_return_it() {
        Array arr = initTestArray(20);
        assertEquals(9, arr.removeLast());
        assertEquals(8, arr.removeLast());
        assertEquals(7, arr.removeLast());

    }

    // 从数组中删除元素e
    @Test
    public void removeElement_should_remove_the_element(){
        Array arr = initTestArray(20);
        arr.removeElement(1);
        assertEquals(-1,arr.find(1));
        arr.removeElement(2);
        assertEquals(-1,arr.find(2));
    }

    private Array initTestArray(int capacity) {
        Array arr = new Array(capacity);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        return arr;
    }
}