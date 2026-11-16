public class Main {
    static int[] slots = new int[30];
    static int next = 0;
    static MySemaphore mutex = new MySemaphore(1);
    static int sum=0;
    static int empty=0;

    public static void main(String[] args) throws InterruptedException  {
        Drawer[] Draw = new Drawer[5];
        for (int i=0;i<5;i++){
            Draw[i]= new Drawer(i+1);
            Draw[i].start();
        }
        for (int i = 0; i < 4; i++) {
            Draw[i].join();
        }
        for(int i = 0; i < 30; i++) {
            if (slots[i] == 0) {
                empty++;
            } else {
                sum += slots[i];
            }
        }
        System.out.println("Slots filled: " + next);
        System.out.println("Sum of all values: " + sum);
        System.out.println("Empty slots: " + empty);
    }
}


