
public class ArrayStack {

    private int[] dispenser;

    public ArrayStack() {

        this.dispenser = new int[7];
    }

    public boolean isEmpty() {

        if (this.dispenser[0] == 1) {

            return false;
        }

        return true;
    }

    public boolean isFull() {

        if (this.dispenser[6] == 0) {

            return false;
        }

        return true;
    }

    public void push() {

        if (!this.isFull()) {
            this.dispenser[this.getCount()] = 1;
        } else {
            System.err.print("Stack full.");
        }
    }

    public void pop() {

        if (!this.isEmpty()) {
            this.dispenser[this.getCount() - 1] = 0;
        } else {
            System.err.print("Stack empty.");
        }
    }

    public int getCount() {
        int count = 0;

        for (int i = 0; i < this.dispenser.length; i++) {
            if (this.dispenser[i] == 1) {
                count += 1;
            }
        }

        return count;
    }
}
