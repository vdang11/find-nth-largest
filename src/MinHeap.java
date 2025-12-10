public class MinHeap {
	private int [] minHeap;
	private int size;
	
	public MinHeap (int capacity) {
		this.minHeap= new int [capacity];
		this.size=0;
	}
	//nếu node con có giá trị nhỏ hơn cha thì đẩy node con lên vị trí cha  
	public void heapifyUp(int index) {
		while(index>0)
		{
			int parent=(index-1)/2;
			if(minHeap[index]<minHeap[parent]) {
				swap(index,parent);
				index=parent;
			} else {
				break;
			}
		}
	}
	
	public void insert (int value) {
		minHeap[size]=value;
		heapifyUp(size);
		size++;
	}
	
	public void swap(int a, int b) {
		int temp=minHeap[a];
		minHeap[a]=minHeap[b];
		minHeap[b]=temp;
	}
	
	public int removeMin() { //xóa root và gán root bằng node cuối 
        int minValue = minHeap[0];

        minHeap[0] = minHeap[size - 1];
        size--;

        heapifyDown(0);
        return minValue;
    }

    public int getMin() {
        return minHeap[0];
    }


     private void heapifyDown(int index) { // root có giá trị lớn hơn các node con thì đẩy giá trị root  
         while (index < size) {
             int left = 2 * index + 1;
             int right = 2 * index + 2;

             int smallest = index;

             if (left < size && minHeap[left] < minHeap[smallest]) {
                 smallest = left;
             }
             if (right < size && minHeap[right] < minHeap[smallest]) {
                 smallest = right;
             }

             if (smallest != index) {
                 swap(index, smallest);
                 index = smallest;
             } else {
                 break;
             }
         }
     }
     
     public static int findNthLargest(int[] arr, int n) {
         MinHeap heap = new MinHeap(n);

         for (int x : arr) {

             if (heap.size < n) {
                 heap.insert(x);
             } else {
                 if (x > heap.getMin()) {
                     heap.removeMin();
                     heap.insert(x);
                 }
             }
         }

         return heap.getMin(); 
     }

     
     public static void main(String[] args) {
         int[] arr = {4, 7, 2, 3, 9, 8, 1};

         System.out.println(findNthLargest(arr, 1));
         System.out.println(findNthLargest(arr, 2)); 
         System.out.println(findNthLargest(arr, 3)); 
         System.out.println(findNthLargest(arr, 7)); 
     }
}


