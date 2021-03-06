
// optimzied arraylist for primitive int
public class vector_copy {

    private int[] data;
    private int size;

    public vector_copy() {
        data = new int[2];
        size = 0;
    }

    public void add(int s) {
        if (data.length == size) {
            int[] aux = new int[2 * size];
            System.arraycopy(data, 0, aux, 0, size);
            data = aux;
        }
        data[size++] = s;
    }

    public void add(int p, int s) {
        if (data.length == size) {
            int[] aux = new int[2 * size];
            System.arraycopy(data, 0, aux, 0, p);
            data[size++] = s;
            System.arraycopy(data, p, aux, p+1, size-p-1);
            data = aux;
        } else {
            System.arraycopy(data, p, data, p+1, size-p);
            data[p] = s;
        }
        
    }
    
    public int[] get_vect() {
        return data;
    }
    
    public int get_at(int idx) {
        return data[idx];
    }

    public int get_size() {
        return size;
    }

    public boolean find(short s) {
        int l_ptr = 0;
        int r_ptr = size;
        while (l_ptr < r_ptr) {
            int mid = l_ptr + r_ptr >> 1;
            if (data[mid] == s) {
                return true;
            } else if (data[mid] > s) {
                l_ptr = mid;
            } else {
                r_ptr = mid;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size - 1; ++i) {
            sb.append(data[i]);
            sb.append(',');
            sb.append(' ');
        }
        sb.append(data[size - 1]);
        sb.append(']');
        return sb.toString();
    }
}
