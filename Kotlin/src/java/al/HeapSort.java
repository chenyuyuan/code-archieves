package al;

import java.util.ArrayList;

public class HeapSort {
    private ArrayList<Integer> A;

    private int heapSize;

    public ArrayList<Integer> getA() {
        return A;
    }

    public void setA(ArrayList<Integer> a) {
        A = a;
    }

    public int getHeapSize() {
        return heapSize;
    }

    public void setHeapSize(int heapSize) {
        this.heapSize = heapSize;
    }

    // 左节点下标
    public int left(int i) {
        return i * 2 + 1;
    }

    // 右节点下标
    public int right(int i) {
        return i * 2 + 2;
    }

    // 父节点下标
    public int parent(int i) {
        return (i - 1) / 2;
    }
}
