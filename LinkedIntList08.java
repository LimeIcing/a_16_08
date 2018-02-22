// Class LinkedIntList can be used to store a list of integers.

public class LinkedIntList08 {

    /*
    Write a method called switchPairs that switches the order of values in the list in a pairwise fashion. Your method
    should switch the order of the first two values, then switch the order of the next two, switch the order of the next
    two, and so on. If the list contains an odd number of values, the final element is not moved. For example, if the
    list initially stores [10, 25, 31, 47, 52, 68, 77] , your method should switch the first pair ( 10 and 25 ), the
    second pair ( 31 and 47 ), and the third pair ( 52 and 68 ) to yield [25, 10, 47, 31, 68, 52, 77] .
     */

    public void switchPairs() {
        int[] aux = new int[this.size()];
        int counter = 0;
        ListNode08 current = front;

        while (current != null) {
            aux[counter] = current.data;
            current = current.next;
            counter++;
        }

        front = new ListNode08(aux[1]);

        for (int i = 1; i < aux.length; i++) {
            if (i % 2 == 0 && i + 1 < aux.length) {
                this.add(aux[i + 1]);
            } else if (i % 2 != 0) {
                this.add(aux[i - 1]);
            }
        }

        if (aux.length % 2 != 0) {
            this.add(aux[aux.length - 1]);
        }
    }

    // Everything below is copied from the book

    private ListNode08 front; // first value in the list

    // post: constructs an empty list
    public LinkedIntList08() {
        front = null;
    }

    // post: returns the current number of elements in the list
    public int size() {
        int count = 0;
        ListNode08 current = front;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    // pre : 0 <= index < size()
    // post: returns the integer at the given index in the list
    public int get(int index) {
        return nodeAt(index).data;
    }

    // post: returns comma-separated, bracketed version of list
    public String toString() {
        if (front == null) {
            return "[]";
        } else {
            String result = "[" + front.data;
            ListNode08 current = front.next;
            while (current != null) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }

    // post: returns the position of the first occurrence of the
    // given value (-1 if not found)
    public int indexOf(int value) {
        int index = 0;
        ListNode08 current = front;
        while (current != null) {
            if (current.data == value) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    // post: appends the given value to the end of the list
    public void add(int value) {
        if (front == null) {
            front = new ListNode08(value);
        } else {
            ListNode08 current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode08(value);
        }
    }

    // pre: 0 <= index <= size()
    // post: inserts the given value at the given index
    public void add(int index, int value) {
        if (index == 0) {
            front = new ListNode08(value, front);
        } else {
            ListNode08 current = nodeAt(index - 1);
            current.next = new ListNode08(value, current.next);
        }
    }

    // pre : 0 <= index < size()
    // post: removes value at the given index
    public void remove(int index) {
        if (index == 0) {
            front = front.next;
        } else {
            ListNode08 current = nodeAt(index - 1);
            current.next = current.next.next;
        }
    }

    // pre : 0 <= i < size()
    // post: returns a reference to the node at the given index
    private ListNode08 nodeAt(int index) {
        ListNode08 current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

}