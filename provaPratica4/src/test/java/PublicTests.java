import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;


public class PublicTests {
    
    @Test
    public void testSomaIrmaos() {

        BST bst = new BST();
        assertEquals(0, bst.somaIrmaos());
        bst.add(50);
        assertEquals(0, bst.somaIrmaos());
        bst.add(20);
        assertEquals(0, bst.somaIrmaos());
        bst.add(70);
        assertEquals(90, bst.somaIrmaos());
        bst.add(95);
        assertEquals(90, bst.somaIrmaos());
        bst.add(10);
        assertEquals(90, bst.somaIrmaos());
        bst.add(60);
        assertEquals(245, bst.somaIrmaos());
        bst.add(25);
        assertEquals(280, bst.somaIrmaos());
        
        bst.add(1);
        assertEquals(280, bst.somaIrmaos());
        bst.add(27);
        assertEquals(280, bst.somaIrmaos());
        bst.add(65);
        assertEquals(280, bst.somaIrmaos());
        bst.add(93);
        assertEquals(280, bst.somaIrmaos());
        bst.add(92);
        assertEquals(280, bst.somaIrmaos());
        bst.add(26);
        assertEquals(280, bst.somaIrmaos());
        
        bst.add(11);
        assertEquals(292, bst.somaIrmaos());

        bst.add(29);
        assertEquals(347, bst.somaIrmaos());        
        
        // testes do exemplo 1
        bst = new BST();
        bst.add(92);
        bst.add(75);
        bst.add(96);
        bst.add(24);
        bst.add(85);
        bst.add(97);
        bst.add(21);
        bst.add(43);
        bst.add(83);
        bst.add(14);
        assertEquals(344, bst.somaIrmaos());        

        
        // testes do exemplo 2
        bst = new BST();
        bst.add(41);
        bst.add(20);
        bst.add(65);
        bst.add(11);
        bst.add(29);
        bst.add(50);
        bst.add(91);
        bst.add(32);
        bst.add(72);
        bst.add(99);
        assertEquals(437, bst.somaIrmaos());
    }
    
    @Test
    public void testRemove() { 
        BST bst = new BST();
        bst.add(85);
        bst.add(49);
        bst.add(97);
        bst.add(7);
        bst.add(53);
        bst.add(93);
        bst.add(51);
        bst.add(81);
        bst.add(65);
        bst.add(55);
        
        ArrayList<Integer> expectedBFS = new ArrayList<Integer>();
        expectedBFS.add(85);
        expectedBFS.add(49);
        expectedBFS.add(97);
        expectedBFS.add(7);
        expectedBFS.add(53);
        expectedBFS.add(93);
        expectedBFS.add(51);
        expectedBFS.add(81);
        expectedBFS.add(65);
        expectedBFS.add(55);
        
        assertEquals(expectedBFS, bst.bfs());
        
        bst.remove(85);
        expectedBFS = new ArrayList<Integer>();
        expectedBFS.add(93);
        expectedBFS.add(49);
        expectedBFS.add(97);
        expectedBFS.add(7);
        expectedBFS.add(53);
        expectedBFS.add(51);
        expectedBFS.add(81);
        expectedBFS.add(65);
        expectedBFS.add(55);
        assertEquals(expectedBFS, bst.bfs());
        
        bst.remove(93);
        expectedBFS = new ArrayList<Integer>();
        expectedBFS.add(97);
        expectedBFS.add(49);
        expectedBFS.add(7);
        expectedBFS.add(53);
        expectedBFS.add(51);
        expectedBFS.add(81);
        expectedBFS.add(65);
        expectedBFS.add(55);
        assertEquals(expectedBFS, bst.bfs());
        
        bst.remove(7);
        expectedBFS = new ArrayList<Integer>();
        expectedBFS.add(97);
        expectedBFS.add(49);
        expectedBFS.add(53);
        expectedBFS.add(51);
        expectedBFS.add(81);
        expectedBFS.add(65);
        expectedBFS.add(55);
        assertEquals(expectedBFS, bst.bfs());
        
        bst.remove(97);
        expectedBFS = new ArrayList<Integer>();
        expectedBFS.add(49);
        expectedBFS.add(53);
        expectedBFS.add(51);
        expectedBFS.add(81);
        expectedBFS.add(65);
        expectedBFS.add(55);
        assertEquals(expectedBFS, bst.bfs());
        
        bst.remove(53);
        expectedBFS = new ArrayList<Integer>();
        expectedBFS.add(49);
        expectedBFS.add(55);
        expectedBFS.add(51);
        expectedBFS.add(81);
        expectedBFS.add(65);
        assertEquals(expectedBFS, bst.bfs());
        assertEquals(5, bst.size());

        bst.remove(81);
        expectedBFS = new ArrayList<Integer>();
        expectedBFS.add(49);
        expectedBFS.add(55);
        expectedBFS.add(51);
        expectedBFS.add(65);
        assertEquals(expectedBFS, bst.bfs());
        
        bst.remove(51);
        expectedBFS = new ArrayList<Integer>();
        expectedBFS.add(49);
        expectedBFS.add(55);
        expectedBFS.add(65);
        assertEquals(expectedBFS, bst.bfs());
        
        bst.remove(55);
        expectedBFS = new ArrayList<Integer>();
        expectedBFS.add(49);
        expectedBFS.add(65);
        assertEquals(expectedBFS, bst.bfs());
        
        bst.remove(49);
        expectedBFS = new ArrayList<Integer>();
        expectedBFS.add(65);
        assertEquals(expectedBFS, bst.bfs());
        
        bst.remove(65);
        expectedBFS = new ArrayList<Integer>();
        assertEquals(expectedBFS, bst.bfs());
        
        bst.add(65);
        expectedBFS = new ArrayList<Integer>();
        expectedBFS.add(65);
        assertEquals(expectedBFS, bst.bfs());
        assertEquals(bst.size(), 1);
    }

    @Test
    public void testBuildHeap() {
        int[] expected = new int[]{82, 65, 62, 45, 56, 52, 43, 30, 33, 38,
                0, 0, 0, 0, 0};

        Heap heap = new Heap(15);
        for (int i = 0; i <= 9; i++)
            heap.add(expected[i]);
        assertEquals(Arrays.toString(expected), heap.toString());
        
        assertEquals(82, heap.remove());
        expected = new int[]{65, 56, 62, 45, 38, 52, 43, 30, 33, 38, 0, 0, 0, 0, 0};
        assertEquals(Arrays.toString(expected), heap.toString());
        
        assertEquals(65, heap.remove());
        expected = new int[]{62, 56, 52, 45, 38, 33, 43, 30, 33, 38, 0, 0, 0, 0, 0};
        assertEquals(Arrays.toString(expected), heap.toString());
        
        assertEquals(62, heap.remove());
        expected = new int[]{56, 45, 52, 30, 38, 33, 43, 30, 33, 38, 0, 0, 0, 0, 0};
        assertEquals(Arrays.toString(expected), heap.toString());
        
        assertEquals(56, heap.remove());
        expected = new int[]{52, 45, 43, 30, 38, 33, 43, 30, 33, 38, 0, 0, 0, 0, 0};
        assertEquals(Arrays.toString(expected), heap.toString());
        
        assertEquals(52, heap.remove());
        expected = new int[]{45, 38, 43, 30, 33, 33, 43, 30, 33, 38, 0, 0, 0, 0, 0};
        assertEquals(Arrays.toString(expected), heap.toString());
        
        assertEquals(45, heap.remove());
        expected = new int[]{43, 38, 33, 30, 33, 33, 43, 30, 33, 38, 0, 0, 0, 0, 0};
        assertEquals(Arrays.toString(expected), heap.toString());
        
        assertEquals(43, heap.remove());
        expected = new int[]{38, 30, 33, 30, 33, 33, 43, 30, 33, 38, 0, 0, 0, 0, 0};
        assertEquals(Arrays.toString(expected), heap.toString());
        
        assertEquals(38, heap.remove());
        expected = new int[]{33, 30, 33, 30, 33, 33, 43, 30, 33, 38, 0, 0, 0, 0, 0};
        assertEquals(Arrays.toString(expected), heap.toString());
        
        assertEquals(33, heap.remove());
        expected = new int[]{30, 30, 33, 30, 33, 33, 43, 30, 33, 38, 0, 0, 0, 0, 0};
        assertEquals(Arrays.toString(expected), heap.toString());
        
        assertEquals(30, heap.remove());
        expected = new int[]{30, 30, 33, 30, 33, 33, 43, 30, 33, 38, 0, 0, 0, 0, 0};
        assertEquals(Arrays.toString(expected), heap.toString());
        
    }
}




