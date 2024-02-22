package uvg.edu.gt;

public class DataStructureFactory {

    public static <E> Stack<E> createStack(String type, String listType) {
        if ("ArrayList".equalsIgnoreCase(type)) {
            return new ArrayListStack<>();
        } else if ("Vector".equalsIgnoreCase(type)) {
            return new VectorStack<>();
        } else if ("lista".equalsIgnoreCase(type)) {
            return createListBasedStack(listType);
        }
        throw new IllegalArgumentException("Unknown Stack type: " + type);
    }

    private static <E> Stack<E> createListBasedStack(String listType) {
        if ("SinglyLinkedList".equalsIgnoreCase(listType)) {
            // Supongamos que SinglyLinkedListStack es tu implementación de Stack que usa SinglyLinkedList
            return new SinglyLinkedListStack<>();
        } else if ("DoublyLinkedList".equalsIgnoreCase(listType)) {
            // Supongamos que DoublyLinkedListStack es tu implementación de Stack que usa DoublyLinkedList
            return new DoublyLinkedListStack<>();
        }
        throw new IllegalArgumentException("Unknown List type for Stack: " + listType);
    }

    public static <E> List<E> createList(String type) {
        if ("SinglyLinkedList".equalsIgnoreCase(type)) {
            return new SinglyLinkedList<>();
        } else if ("DoublyLinkedList".equalsIgnoreCase(type)) {
            return new DoublyLinkedList<>();
        }
        throw new IllegalArgumentException("Unknown List type: " + type);
    }
}

