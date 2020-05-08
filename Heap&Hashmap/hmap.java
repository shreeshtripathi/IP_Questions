import java.util.*;
class hashmap {

    private class Node {
        String key;
        int value;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size = 0;

    private LinkedList<Node>[] bucket = null;

    public hashmap() {
        bucket = new LinkedList[4];
        for(int i = 0; i < 4; i++) {
            bucket[i] = new LinkedList<>();
        }
    }

    private int hashfun(String key) {
        int hc = key.hashCode();
        int bi = hc % bucket.length;
        return bi;
    }

    private int searchInBucket(int bi, String key) {
        int di = -1;
        LinkedList<Node> list = bucket[bi];
        
        int i = 0;
        for(Node n : list) {
            String str = n.key;
            if(str == key) {
                di = i;
                break;
            }
            i++;
        }
        return di;
    }

    private double lambda = 0.0;
    private int nsize = 0;

    private void rehash() {
        LinkedList<Node>[] ob = bucket;
        bucket = new LinkedList[2 * bucket.length];
        for(LinkedList<Node> list : bucket) {
            for(Node n : list) {
                put(n.key, n.value);
            }
        }
    }

    public void put(String key, int value) {
        int bi = hashfun(key);
        int di = searchInBucket(bi, key);

        if(di == -1) {
            nsize++;
            bucket[bi].addLast(new Node(key, value));
        } else {
            nsize++;
            bucket[bi].get(di).value = value;
        }
        lambda = nsize / bucket.length;
        if(lambda > 2) {
            rehash();
        }
    }

    public int size() {
        return this.size;
    }

    public int get(String key) {
        int bi = hashfun(key);
        int di = searchInBucket(bi, key);

        if(di == -1) {
            return -1;
        } else {
            return bucket[bi].get(di).value;
        }
    }

    public int remove(String key) {
        int bi = hashfun(key);
        int di = searchInBucket(bi, key);

        if(di == -1) {
            return -1;
        } else {
            Node rem = bucket[bi].remove(di);
            nsize--;
            return rem.value;
        }
    }

    public ArrayList<String> keySet() {
        ArrayList<String> kset = new ArrayList<>();
        for(LinkedList<Node> list : bucket) {
            for(Node n : list) {
                kset.add(n.key);
            }
        }
        return kset;
    }

    public boolean containsKey(String key) {
        int bi = hashfun(key);
        int di = searchInBucket(bi, key);

        if(di == -1) {
            return false;
        } else {
            return true;
        }
    }
}


public class hmap {
    public static void main(String[] args) {
        hashmap map = new hashmap();
        map.put("India", 100);
        map.put("WB", 120);
        map.put("Pakistan", 200);
        map.put("England", 105);
        map.put("America", 150);
        System.out.println(map.get("India"));

        map.put("India", 400);

        System.out.println(map.get("India"));
        System.out.println(map.get("Afgan"));
        System.out.println(map.keySet());
    }
}