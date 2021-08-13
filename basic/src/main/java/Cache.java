import java.util.HashMap;

public class Cache {

    private HashMap<String, LinkedNode> hashmap;

    private LinkedNode head;

    private LinkedNode tail;

    private Integer capacity = 1024;

    public Cache() {
        head = new LinkedNode();
        tail = new LinkedNode();
        hashmap = new HashMap<>();
        head.prefix = null;
        head.next = tail;
        tail.prefix = head;
        tail.next = null;
    }

    public Cache(Integer capacity) {
        this();
        this.capacity = capacity;
    }



    private void put(String key, LinkedNode node) {
        Integer size = hashmap.size();
        //非链表内元素
        LinkedNode linkedNode = hashmap.get(key);
        if(null == linkedNode) {
            //超过最大设定，删除最尾部
            if(size.equals(capacity)) {
                hashmap.remove(tail.prefix.key);
                //删除尾部元素
                tail.prefix.prefix.next = tail;
                tail.prefix = tail.prefix.prefix;
            }
        }

        hashmap.put(key, node);
        //非链表内元素
        if(null != linkedNode) {
            node.prefix = linkedNode.prefix;
            node.next = linkedNode.next;
            linkedNode.prefix.next = node;
            linkedNode.next.prefix = node;
        }
        //放入链表头部
        node.prefix = head;
        node.next = head.next;
        head.next.prefix = node;
        head.next = node;
    }


    public static void main(String[] args) {
        LinkedNode node = new LinkedNode("key1", 1);
        LinkedNode node1 = new LinkedNode("key2", 2);
        LinkedNode node2 = new LinkedNode("key3", 3);
        LinkedNode node3 = new LinkedNode("key4", 4);
        LinkedNode node4 = new LinkedNode("key5", 5);

        Cache cache = new Cache(4);
        cache.put("key1", node);
        cache.put("key2", node1);
        cache.put("key3", node2);
        cache.put("key4", node3);
        cache.put("key5", node4);


    }

}