

## Collection

1. **Array vs ArrayList?**

    - **Array**: Arrays are fixed in size, meaning their length cannot be changed once they are created. They provide direct access to elements via indexing and are more memory-efficient than ArrayLists. However, they require manual management of resizing and do not provide built-in methods for adding, removing, or resizing elements.

    - **ArrayList**: ArrayLists are dynamic in size, meaning they can grow or shrink as needed. They are implemented using arrays internally but provide dynamic resizing and a variety of methods for adding, removing, and accessing elements. ArrayLists are part of the Java Collections Framework, offering more flexibility and functionality compared to arrays.

2. **ArrayList vs LinkedList? When to use which collection?**

    - **ArrayList**: ArrayLists are implemented using arrays internally and provide fast random access to elements. They are more suitable for scenarios where frequent access or iteration over elements is required but less suitable for frequent insertions or deletions in the middle of the list.

    - **LinkedList**: LinkedLists are implemented using a doubly-linked list internally and provide fast insertion and deletion operations, especially in the middle of the list. They are more suitable for scenarios where frequent insertions or deletions are expected but less suitable for random access or iteration.

3. **Fail Safe vs Fail Fast Iterators?**

    - **Fail-Safe Iterators**: Fail-safe iterators operate on a copy of the underlying collection and hence do not throw ConcurrentModificationException if the collection is modified during iteration. They provide a consistent view of the collection but may not reflect the latest changes.

    - **Fail-Fast Iterators**: Fail-fast iterators operate directly on the underlying collection and throw ConcurrentModificationException if the collection is modified structurally (i.e., not through the iterator) during iteration. They detect concurrent modifications and ensure that the iterator remains in a consistent state.

4. **What is a concurrent modification exception?**

   A ConcurrentModificationException is thrown when an attempt is made to modify a collection (such as adding or removing elements) while it is being iterated over by a fail-fast iterator. This exception indicates that the collection has been structurally modified during iteration, which violates the fail-fast behavior of the iterator.

5. **Internal working of HashMap?**

   HashMap in Java is implemented using an array of buckets, where each bucket is a linked list of key-value pairs (entries). When an element is added to the HashMap, its key's hash code is used to determine the bucket where it should be stored. If multiple keys have the same hash code (hash collision), they are stored in the same bucket as a linked list. To retrieve an element, the key's hash code is used to locate the appropriate bucket, and then a linear search is performed within the linked list for the key.

6. **Java 8 changes to HashMap?**

   In Java 8, HashMap introduced improvements such as:
    - Hash collision resolution using balanced trees (red-black trees) instead of linked lists for better worst-case performance.
    - The introduction of `compute()`, `computeIfAbsent()`, and `computeIfPresent()` methods for conditional updates based on existing key-value pairs.
    - The introduction of `forEach()` method for iterating over key-value pairs.

7. **Why does HashMap contain a null key?**

   HashMap in Java allows `null` as a key because the hash code of `null` is defined to be `0`, and there can be only one `null` key in a HashMap. Therefore, `null` is treated as a special case and can be used as a key in HashMap.

8. **Is it Mandatory to have the key immutable in HashMap?**

   While it is not strictly mandatory to have immutable keys in HashMap, it is highly recommended. This is because the behavior of HashMap depends on the hash code and equality of its keys. If a key is mutable and its hash code or equality changes after being inserted into the HashMap, it can lead to unexpected behavior, such as not being able to retrieve the corresponding value or storing duplicate keys.

9. **Why override `equals()` and `hashCode()` method?**

   In Java, when you override the `equals()` method, you should also override the `hashCode()` method to maintain the contract between these two methods. This is because objects that are equal according to the `equals()` method must have the same hash code according to the `hashCode()` method. Failing to do so can lead to incorrect behavior when using objects as keys in hash-based collections like HashMap or HashSet.

10. **HashSet vs LinkedHashSet vs TreeSet?**

    - **HashSet**: HashSet is an unordered collection that uses hashing to store elements. It does not maintain any order of elements. It provides constant-time performance for basic operations like add, remove, and contains.

    - **LinkedHashSet**: LinkedHashSet is an ordered version of HashSet that maintains the insertion order of elements. It internally uses a linked list to maintain the order of elements.

    - **TreeSet**: TreeSet is a sorted collection that uses a Red-Black tree internally to store elements in sorted order. It maintains the elements in ascending order (natural order) or according to a specified comparator.

11. **What is the Internal Datastructure in TreeMap? How are the elements sorted?**

    TreeMap in Java is implemented using a Red-Black tree data structure. Each entry (key-value pair) in the TreeMap is represented as a node in the tree. The elements are sorted based on their keys, either in natural order (if the keys implement the Comparable interface) or according to a specified comparator. The Red-Black tree maintains the elements in sorted order by balancing the tree to ensure that the height of the tree is logarithmic with respect to the number of elements.

12. **HashMap vs ConcurrentHashMap?**

    - **HashMap**: HashMap is not thread-safe and should not be used in concurrent environments without external synchronization. It provides better performance in single-threaded scenarios but can lead to data corruption or inconsistent behavior in multi-threaded scenarios.

    - **ConcurrentHashMap**: ConcurrentHashMap is a thread-safe version of HashMap designed for concurrent use by multiple threads. It achieves thread-safety through partitioning the map into segments, allowing multiple threads to operate on different segments concurrently. It provides better performance in multi-threaded scenarios but may have slightly lower performance in single-threaded scenarios due to synchronization overhead.

13. **Comparable vs Comparator?**

    - **Comparable**: Comparable is an interface in Java that defines a single method `compareTo()` used to compare the current object with another object of the same type. Classes that implement Comparable can be sorted based on their natural ordering.

    - **Comparator**: Comparator is a functional interface in Java that defines a method `compare()` used to compare two objects of a specified type. It allows custom sorting logic to be defined separately from the objects being sorted. Comparator objects can be used to sort objects in custom orders or based on multiple criteria.

14. **What is a blocking Queue?**

    A blocking queue is a type of queue in Java that supports operations that wait for the queue to become non-empty when retrieving an element (`take()`) or become non-full when adding an element (`put()`). Blocking queues are designed for producer-consumer scenarios where producers produce data to be consumed by consumers. Blocking queues provide thread-safe and efficient communication between producers and consumers.

15. **What is Vector? When to use it?**

    Vector is a legacy class in Java that implements a dynamic array. It is similar to ArrayList but provides synchronization, making it thread-safe. However, this synchronization comes at a cost in terms of performance. Vectors are rarely used in modern Java applications due to their performance overhead. They were used in early versions of Java before the introduction of the Collections Framework.