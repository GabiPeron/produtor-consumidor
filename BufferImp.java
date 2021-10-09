import java.util.Queue;
import java.util.PriorityQueue;

public class BufferImp {
    private int tamanho;
    private Queue<Integer> q;

    public BufferImp(int tamanho) {
        this.tamanho = tamanho;
        this.q = new PriorityQueue<Integer>();
    }

    public boolean isFull() {
        return this.q.size() <= tamanho;
    }

    public boolean isEmpty() {
        return this.q.size() == 0;
    }

    public synchronized void add(int valor) {
        if (this.isFull()) {
            this.q.add(valor);
        }
    }

    public synchronized int remove() {
        if (!this.isEmpty()) {
            return this.q.remove();
        }

        return 0;
    }
}
