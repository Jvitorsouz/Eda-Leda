import java.util.ArrayList;
import java.util.Scanner;

class predecessor{
    

    public static void main(String[] args){
        BST bst = new BST();

        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int x = sc.nextInt();
      

        for(String ent: entrada){
            bst.add(Integer.parseInt(ent));
        }

    
        System.out.println(bst.predecesor(x));
        
    }

}

class BST{

    Node root;

    boolean isEmpty(){
        return this.root == null;
    }
    void add(int v){

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
            }else{
                add(current.left, v);
            }
        }else{
            if(current.right == null){
                Node newNode = new Node(v);
                current.right = newNode;
                newNode.parent = current;
            }else{
                add(current.right, v);
            }
        }
    }


    Node search(int v){
        return search(this.root, v);
    }

    Node search(Node current, int v){
        if(current == null) return null;
        if(v == current.value) return current;
        if(v < current.value) return search(current.left, v);
        else return search(current.right, v);
    }

    ArrayList<Integer> max(Node current, ArrayList<Integer> dados){
        if(current.right == null) {
            dados.add(current.value);
            return dados;
        }
        else{
            dados.add(current.value);
            return max(current.right, dados);
        }
    }

    ArrayList<Integer> predecesor(int v){
        Node node = search(v);
        ArrayList<Integer> saida = new ArrayList<>();

        if(node == null) return saida;
        saida.add(v);
        if(node.left != null) return max(node.left, saida);
        else{
            Node aux = node.parent;
            if(aux.value < node.value)
                saida.add(aux.value);

            while(aux != null && aux.value > node.value){
                saida.add(aux.value);
                aux = aux.parent;

            }

            return saida;
        }
    }

   

}

class Node{

    int value;
    Node left, right, parent;

    Node(int value){
        this.value = value;
    }

}