public class LinkedListTester {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        for (int i = 0; i < 10; i++) {
            list.addLast(i);
        }
        System.out.println(list);
        list.printDebug();
        //list.printReverseDebug();
    }
}