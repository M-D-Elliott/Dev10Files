package algo;

public class Holder {
    private int count;
    private Character value;

    public Holder(Character value, int count) {
        this.count = count;
        this.value = value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Character getValue() {
        return value;
    }

    public void setValue(Character value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Holder{" + "count=" + count + ", value=" + value + '}';
    }
    
    
}
