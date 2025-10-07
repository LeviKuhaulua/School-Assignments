package paths;


public class ComputePaths {
    
    // Thread to divide up FloydWarshall alg
    public class Worker implements Runnable {
        private long start;
        private long end;
        private int graph_size;

        Worker(long start, long end, int graph_size) {
            this.start = start;
            this.end = end;
            this.graph_size = graph_size;
        }

        @Override
        public void run() {
            for (long i = start; i < end; i++) {
                new FloydWarshall(graph_size, i).floydWarshall();
            }
        }
    }


    public void compute(int graph_size, int num_threads) {
        long work = 2520;

        if (num_threads > 1) {
            work = 2520 / num_threads;
        }

        // Determines indices for each thread
        long start, end;
        start = end = 0;
        
        Thread threads[] = new Thread[num_threads];
        // Start work for graphs
        for (int i = 0; i < threads.length; i++) {
            start = i * work;
            end = (work + start);
            threads[i] = new Thread(new Worker(start, end, graph_size));
            threads[i].start();
        }
        
        // Terminate threads when done
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {}
        }


    }

    public static void main(String[] args) {

        if (args.length != 2) {
            System.err.println("Usage: java ComputePaths <graph size> <# threads>");
            System.exit(1);
        }

        int graph_size = 0;
        int num_threads = 0;
        try {
            graph_size = Integer.parseInt(args[0]);
            num_threads = Integer.parseInt(args[1]);
            if ((graph_size <= 0) || (num_threads < 1)) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.err.println("Invalid command-line arguments");
            System.exit(1);
        }

        double now = System.currentTimeMillis();

        new ComputePaths().compute(graph_size, num_threads);

        System.out.println("All graphs computed in " + (System.currentTimeMillis() - now) / 1000 + " seconds");

    }

}