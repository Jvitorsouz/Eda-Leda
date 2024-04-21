import java.util.ArrayList;
import java.util.Scanner;

class ValorMaisProximo{
    private Node root;
    private int size;

    public boolean isEmpty(){
        return this.root == null;
    }

    public void add(int element){
        this.size++;
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

    public ArrayList<Integer> preOrder(){
        ArrayList<Integer> saida = new ArrayList<>();
        return preOrder(this.root, saida);

    }

    private ArrayList<Integer> preOrder(Node current, ArrayList<Integer> saida){
        if(current != null){
            saida.add(current.value);
            preOrder(current.left, saida);
            preOrder(current.right, saida);
        }
        return saida;
    }

    public int valorMaisProximo(int v){

        Node aux = this.root;
        int maisProximo = aux.value;

        while(aux != null){
            if(Math.abs(aux.value - v) < Math.abs(maisProximo - v)){
                maisProximo = aux.value;
            }

            if(aux.value == v) return aux.value;
            if(v < aux.value) aux = aux.left;
            else aux = aux.right;

        }
        return maisProximo;

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ValorMaisProximo bst = new ValorMaisProximo();

        String[] entrada = sc.nextLine().split(" ");
        int n = sc.nextInt();


        for(String ent: entrada){
            int i = Integer.parseInt(ent);
            bst.add(i);
        }

        ArrayList<Integer> saida = bst.preOrder();
        System.out.println(saida.toString());
        System.out.println(bst.valorMaisProximo(n));
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