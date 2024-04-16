public class BST{

    private Node root;

    public boolean isEmpty(){
        return this.root == null;
    }

    public void add(int element){
        if(isEmpty()){
            this.root = new Node(element);
        }else{
            //Recursivo
            //addRecursivo(this.root, element);
            //Iterativo
            addIterativo(this.root, element);

        }
    }

    private void addRecursivo(Node current, int element){
        if(element < current.value){
            if(current.left == null){
                Node newNode = new Node(element);
                current.left = newNode;
                newNode.patern = current;
                return;
            }
            addRecursivo(current.left, element);
        }else{
            if(current.right == null){
                Node newNode = new Node(element);
                current.right = newNode;
                newNode.patern = current;
                return;
            }
            addRecursivo(current.right, element);
        }
    }

    private void addIterativo(Node current, int element){
        while(current != null){
            if(element < current.value){
                if(current.left == null){
                    Node newNode = new Node(element);
                    current.left = newNode;
                    newNode.patern = current;
                    return;
                }
                current = current.left;
            }else{
                if(current.right == null){
                    Node newNode = new Node(element);
                    current.right = newNode;
                    newNode.patern = current;
                    return;
                }
                current = current.right;
            }
        }
    }

    public Node search(int element){
        //return searchRecursivo(this.root, element);
        return searchIterativo(this.root, element);
    }

    private Node searchRecursivo(Node current, int element){
        if(current == null) return null;
        if(current.value == element) return current;
        if(element < current.value) return searchRecursivo(current.left, element);
        else return searchRecursivo(current.right, element);
    }

    private Node searchIterativo(Node current, int element){
        while(current != null){
            if(element == current.value) return current;
            if(element < current.value) current = current.left;
            else current = current.right;
        }

        return null;
    }


}

class Node{

    int value;
    Node left;
    Node right;
    Node patern;

    Node(int element){
        this.value = element;
    }
}