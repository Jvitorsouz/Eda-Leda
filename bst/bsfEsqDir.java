import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.*;

class bsfEsqDir{

    public static void main(String[] args){

        BST bst = new BST();
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");

        for(String en: entrada)
            bst.add(Integer.parseInt(en));

        System.out.println(bst.printBST());
    }
}





class BST{

    Node root;
    int size;

    boolean isEmpty(){
        return this.root == null;
    }

    void add(int v){
        this.size += 1;

        if(isEmpty()){
            this.root = new Node(v);
        }else{
            add(this.root, v);
        }

    }

    void add(Node current, int v){
        if(v < current.value){
            if(current.left == null){
                Node newNode = new Node(v);
                current.left = newNode;
                newNode.parent = current;
                return;
            }else add(current.left, v);
        }else{
            if(current.right == null){
                Node newNode = new Node(v);
                current.right = newNode;
                newNode.parent = current;
                return;
            }else add(current.right, v);
        }

    }


    Node search(int v){
        return search(this.root, v);
    }

    Node search(Node current, int v){
        if(current == null) return null;
        if(current.value == v) return current;
        if(v < current.value) return search(current.left, v);
        else return search(current.right, v);
    }

    Node max(){
        if(isEmpty()) return null;
        return max(this.root);
    }

    Node max(Node current){
        //if(current == null) return null;
        if(current.right == null) return current;
        else return max(current.right);
    }

    Node min(){
        if(isEmpty()) return null;
        return min(this.root);
    }

    Node min(Node current){
        //if(current == null) return null;
        if(current.left == null) return current;
        else return min(current.left);
    }

    int height(){
        return height(this.root);
    }

    int height(Node current){
        if(current == null) return -1;
        else return 1 + Math.max(height(current.left), height(current.right));
    }

    Boolean equals(BST outra){
        return equals(this.root, outra.root);
    }

    boolean equals(Node node1, Node node2){
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;
        if(node1.value != node2.value) return false;
        else return equals(node1.left, node2.left) && equals(node1.right, node2.right);
    }

    void preOrder(){
        preOrder(this.root);
    }

    void preOrder(Node current){
        if(current != null){
            System.out.println(current.value);
            preOrder(current.left);
            preOrder(current.right);
        }
    }

    void inOrder(){
        inOrder(this.root);
    }

    void inOrder(Node current){
        if(current != null){
            inOrder(current.left);
            System.out.println(current.value);
            inOrder(current.right);
        }
    }

    void posOrder(){
        posOrder(this.root);
    }

    void posOrder(Node current){
        if(current != null){
            posOrder(current.left);
            posOrder(current.right);
            System.out.println(current.value);            
        }
    }

    String printBST(){
        Deque<Node> queue = new LinkedList<Node>();
        String saida = "";

        if(!isEmpty()){
            queue.addLast(this.root);

            while(!queue.isEmpty()){
                Node current = queue.removeFirst();
                saida += current.value + " ";

                if(current.right != null){
                    queue.addLast(current.right);
                }
                if(current.left != null){
                    queue.addLast(current.left);
                }
            }
        }
        return saida.trim();
    }

    Node sucessor(int v){

        Node node = search(v);
        if(node == null) return null;

        if(node.right != null) return min(node.right);
        else{
            Node aux = node.parent;

            while(aux != null && aux.value < node.value){
                aux = aux.parent;
            }

            return aux;
        }
        
    }

    Node predecessor(int v){
        Node node = search(v);

        if(node == null) return null;

        if(node.left != null) return max(node.left);
        else{
            Node aux = node.parent;

            while(aux != null && aux.value > node.value){
                aux = aux.parent;
            }

            return aux;
        }

    }

    void remove(int v){

        Node node = search(v);
        if(node != null){
            remove(node);
            this.size -= 1;
        }
    
    }

    void remove(Node toRemove){

        if(toRemove.isLeaf()){
            if(toRemove == this.root){
                this.root = null;
            }else{
                if(toRemove.value < toRemove.parent.value){
                    toRemove.parent.left = null;
                }else{
                    toRemove.parent.right = null;
                }
            }
        }else if(toRemove.hasOnlyLeftChild()){
            if(toRemove == this.root){
                this.root = toRemove.left;
                this.root.parent = null;
            }else{
                //Ligação do neto com o avô
                toRemove.left.parent = toRemove.parent;
                if(toRemove.value < toRemove.parent.value){
                    toRemove.parent.left = toRemove.left;
                }else{
                    toRemove.parent.right = toRemove.left;
                }
            }
        }else if(toRemove.hasOnlyRightChild()){
            if(toRemove == this.root){
                this.root = toRemove.right;
                this.root.parent = null;
            }else{
                //Ligação do neto com o avô
                toRemove.right.parent = toRemove.parent;
                if(toRemove.value < toRemove.parent.value){
                    toRemove.parent.left = toRemove.right;
                }else{
                    toRemove.parent.right = toRemove.right;
                }
            }
        }else{
            Node sucessor = sucessor(toRemove.value);
            toRemove.value = sucessor.value;
            remove(sucessor);
        }
    }

    int size(){
        return this.size;
    }

    ArrayList<Integer> bfs() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Deque<Node> queue = new LinkedList<Node>();
        
        if (!isEmpty()) {
            queue.addLast(this.root);
            while (!queue.isEmpty()) {
                Node current = queue.removeFirst();
                
                list.add(current.value);
                
                if(current.left != null) 
                    queue.addLast(current.left);
                if(current.right != null) 
                    queue.addLast(current.right);   
            }
        }
        return list;
    }

}

class Node{

    int value;
    Node left, right, parent;

    Node(int element){
        this.value = element;
    }

    boolean isLeaf(){
        return left == null && right == null;
    }

    boolean hasOnlyLeftChild(){
        return left != null && right == null;
    }

    boolean hasOnlyRightChild(){
        return left == null && right != null;
    }

    boolean isNotLeaf(){
        return left != null && right != null;
    }
}
