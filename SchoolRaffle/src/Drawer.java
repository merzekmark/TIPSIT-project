class Drawer extends Thread {
    int id;
    int value=0;

    Drawer(int id) {
        this.id = id;
    }

    public void run() {
        for (int j = 1; j <= 6; j++) {
            value=id*100+j;
            Main.mutex.acquire();
            try {
                Main.slots[Main.next]=value;
                Thread.sleep(1);
            }catch (InterruptedException e) {
            }
            Main.next++;
        }
        Main.mutex.release();
    }
}
