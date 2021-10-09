public class Fibonacci extends Thread {
    private int ciclos;
    private BufferImp buff;
    private int prioridade;
    
    public Fibonacci(int ciclos, BufferImp buff, int prioridade) {
        this.ciclos = ciclos;
        this.buff = buff;
        this.prioridade = prioridade;
    }

    private int fibo(int ciclos) {
        if (ciclos < 1) {
            return 0;
        }
        
        if (ciclos == 1 || ciclos == 2) {
            return 1;
        }

        return (fibo(ciclos - 1) + fibo(ciclos - 2));
    }

    @Override
    public void run() {
        setPriority(this.prioridade);
        
        do {
            buff.add(this.fibo(this.ciclos));
        } while (true);
    }
}