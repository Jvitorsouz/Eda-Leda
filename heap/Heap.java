public class Heap {
    
    private int[] heap;
    private int tail;

    public Heap(int capacidade){
        this.heap = new int[capacidade];
        this.tail = -1;
    }

    public Heap(int[] heap){
        this.heap = heap;
        this.tail = this.heap.length-1;
        this.buildHeap();
    }

    private void buildHeap(){
        for(int i = parent(tail); i >= 0; i--){
            heapify(i);
        }
    }

    public boolean isEmpty(){
        return this.tail == -1;
    }

    public int left(int index){
        return 2 * index + 1;
    }

    public int right(int index){
        return 2 * (index + 1);
    }

    public int parent(int index){
        return Math.floorDiv(index-1, 2);
    }

    public void add(int x){
        if(tail >= this.heap.length-1){
            resize();
        }

        this.tail += 1;
        this.heap[tail] = x;

        int i = 0;
        while(i > 0 && this.heap[parent(i)] < this.heap[i]){
            int aux = this.heap[i];
            this.heap[i] = this.heap[parent(i)];
            this.heap[parent(i)] = aux;
            i = parent(i);
        }
    }

    public int remove(){
        if(isEmpty()) throw new RuntimeException("EMPTY");

        int element = this.heap[0];
        this.heap[0] = this.heap[tail];
        this.tail -= 1;

        heapify(0);

        return element;
    }

    private void heapify(int index){
        if(isLeaf(index) || !isValidIndex(index)) return;

        int index_max = max_index(index, left(index), right(index));

        if(index_max != index){
            swap(index, index_max);
            heapify(index_max);
        }
    }

    private void swap(int i, int j){
        int aux = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = aux;
    }
    private int max_index(int index, int left, int right){
        if(this.heap[index] > this.heap[left]){
            if(isValidIndex(right)){
                if(this.heap[index] < this.heap[right]){
                    return right;
                }
            }
            return index;
        }else{
            if(isValidIndex(right)){
                if(this.heap[left] < this.heap[right]){
                    return right;
                }
            }
            return left;
        }

    }

    private boolean isValidIndex(int index){
        return index >= 0 && index <+ tail;
    }
    private boolean isLeaf(int index){
        return index > parent(tail) && index <= tail;
    }

    private void resize(){
        int[] novoHeap = new int[this.heap.length * 2];

        for(int i = 0; i <= tail; i++){
            novoHeap[i] = this.heap[i];
        }

        this.heap = novoHeap;
    }


}
