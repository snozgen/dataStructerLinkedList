class Node<T extends Comparable<T>> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList<T extends Comparable<T>> {
    Node<T> head;

    // Başa ekleme
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }

    // Sona ekleme
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // İstenilen yere ekleme
    public void addAtPosition(T data, int position) {
        if (position == 0) {
            addFirst(data);
            return;
        }

        Node<T> newNode = new Node<>(data);
        Node<T> current = head;
        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current != null) {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Baştan silme
    public void deleteFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    // Sondan silme
    public void deleteLast() {
        if (head == null) return;

        if (head.next == null) {
            head = null;
            return;
        }

        Node<T> current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    // İstenilen yerden silme
    public void deleteAtPosition(int position) {
        if (position == 0) {
            deleteFirst();
            return;
        }

        Node<T> current = head;
        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current != null && current.next != null) {
            current.next = current.next.next;
        }
    }

    // Listeyi yazdırma
    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Küçükten büyüğe sıralama
    public void sortAscending() {
        if (head == null || head.next == null) return;

        Node<T> current = head;
        while (current != null) {
            Node<T> index = current.next;
            while (index != null) {
                if (current.data.compareTo(index.data) > 0) {
                    T temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }

    // Büyükten küçüğe sıralama
    public void sortDescending() {
        if (head == null || head.next == null) return;

        Node<T> current = head;
        while (current != null) {
            Node<T> index = current.next;
            while (index != null) {
                if (current.data.compareTo(index.data) < 0) {
                    T temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }
}

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> intList = new LinkedList<>();
        intList.addLast(3);
        intList.addLast(1);
        intList.addLast(2);
        intList.printList(); // 3 1 2

        intList.sortAscending();
        intList.printList(); // 1 2 3

        intList.sortDescending();
        intList.printList(); // 3 2 1

        intList.addFirst(0);
        intList.printList(); // 0 3 2 1

        intList.addAtPosition(4, 2);
        intList.printList(); // 0 3 4 2 1

        intList.deleteFirst();
        intList.printList(); // 3 4 2 1

        intList.deleteLast();
        intList.printList(); // 3 4 2

        intList.deleteAtPosition(1);
        intList.printList(); // 3 2

        LinkedList<String> strList = new LinkedList<>();
        strList.addLast("c");
        strList.addLast("a");
        strList.addLast("b");
        strList.printList(); // c a b

        strList.sortAscending();
        strList.printList(); // a b c

        strList.sortDescending();
        strList.printList(); // c b a

        strList.addFirst("z");
        strList.printList(); // z c b a

        strList.addAtPosition("d", 2);
        strList.printList(); // z c d b a

        strList.deleteFirst();
        strList.printList(); // c d b a

        strList.deleteLast();
        strList.printList(); // c d b

        strList.deleteAtPosition(1);
        strList.printList(); // c b
    }
}