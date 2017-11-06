import java.util.Random;

/**
 * BTVTester
 * @author Gahwon Lee
 */
public class BTVTester {
    public static void main(String[] args) {
        //fractionTest();
        viewerTest();
    }
    
    // private static void fractionTest() {
    //     BinaryTreeViewer.Fraction f1 = new BinaryTreeViewer.Fraction(717, 1);
    //     BinaryTreeViewer.Fraction f2 = new BinaryTreeViewer.Fraction(718, 1);
    //     System.out.println(f1 + " - " + f2 + " = " + f1.subtract(f2));
    // }
    
    private static void viewerTest() {
        BSTNode<Character> node = new BSTNode<>(new BSTNode<>(new BSTNode<>('A'), 'H', new BSTNode<>('N')), 'T', new BSTNode<>(new BSTNode<>('S'), 'K', new BSTNode<>('!')));
        new BinaryTreeViewer("data", "left", "right").display(node);
        
        BSTNode<Short> bst = null;
        Random random = new Random();
        for (int REPEATS = 0; REPEATS < 400; REPEATS++) {
            bst = add(bst, (short) random.nextInt());
        }
        new BinaryTreeViewer().setDataMethod("getData").setLeftChildMethod("getLeft()").display(bst, 1920, 900);
    }
    
    private static <T extends Comparable<? super T>> BSTNode<T> add(BSTNode<T> root, T value) {
        if (root == null)
            return new BSTNode<>(value);
        
        int compare = root.data.compareTo(value);
        if (compare > 0)
            root.left = add(root.left, value);
        else if (compare < 0)
            root.right = add(root.right, value);
        return root;
    }
    
    private static class BSTNode<E extends Comparable<? super E>> {
        private E data;
        private BSTNode<E> left;
        private BSTNode<E> right;
        
        public BSTNode() {
            this(null);
        }
        
        public BSTNode(E initValue) {
            this(null, initValue, null);
        }
        
        public BSTNode(BSTNode<E> initLeft,
                       E initValue,
                       BSTNode<E> initRight) {
            data = initValue;
            left = initLeft;
            right = initRight;
        }
        
        public E getData() {
            return data;
        }
        
        public BSTNode<E> getLeft() {
            return left;
        }
        
        public BSTNode<E> getRight() {
            return right;
        }
        
        public void setData(E theNewValue) {
            data = theNewValue;
        }
        
        public void setLeft(BSTNode<E> theNewLeft) {
            left = theNewLeft;
        }
        
        public void setRight(BSTNode<E> theNewRight) {
            right = theNewRight;
        }
    }
}
