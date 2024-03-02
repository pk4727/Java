// HashMap in Java stores the data in (Key, Value) pairs.
// you can access them by an index of another type (e.g. an Integer)
// One object is used as a key (index) to another object (value).
// If you try to insert the duplicate key in HashMap, 
// it will replace the element of the corresponding key.

// collision handling of any index in hashing :-

// 1.function for hashing : channing :- ( create linked list at that index )
// a. division -----------> [ h(k) = k % m ] , (m = arr.size or prime)
// b. multiplication -----> [ h(k) = { (a*k) % 2^w} >> (w-r) ] , a = random number / w = no of bits in k / m = 2^r
// c. universal hashing --> [ h(k) = { ((a*k) + b) % p } % m ] , a & b = random number E (0 to p-1) / p = large prime number

// 2.function for hashing : open addressing :- h(x,0) / h(x,1) / h(x,2)/ ... try
// a. linear probing ---> [ h(k,i) = (h(k)+i) % m ] ---> (search next available index)
// b. double hashing ---> [ h(k,i) = ( h1(k) + i*h2(k) ) % m ]
// c. uniform hashing --> [ cost of next operation(insert or delete) <= (1 / (1-α)) , α = alpha = n/m = empty/size ] (m! possible permutation)

import java.util.*;

public class hashMap_hashTable {
    public static void main(String[] args) {
        String s = "pk"; // change to unique number
        int shv = s.hashCode();
        System.out.println(shv);
        Integer i = 3579; // not changed ( already unique )
        int ihv = i.hashCode();
        System.out.println(ihv);
        
        System.out.println("\n======= HashMap =========");
        HashMap<Integer, String> hm = new HashMap<>(); // not thread safe or not synchronized
        hm.put(87, "pk");
        hm.put(85, "sk");
        hm.put(86, "ak");
        hm.put(84, "Sk");
        hm.put(89, "Ak");
        System.out.println(hm);
        System.out.println(hm.get(84));
        System.out.println(hm.getOrDefault(81, "dk"));
        System.out.println(hm.getOrDefault(87, "dk"));
        System.out.println(hm.containsKey(87));
        System.out.println(hm.containsValue("pk"));
        
        System.out.println("\n======= Hashtable =========");
        Hashtable<Integer, String> ht = new Hashtable<>(); // thread safe or synchronized
        ht.put(87, "pk");
        ht.put(85, "sk");
        ht.put(86, "ak");
        ht.put(84, "Sk");
        ht.put(89, "Ak");
        System.out.println(ht);
        System.out.println(ht.get(84));
        System.out.println(ht.getOrDefault(81, "dk"));
        System.out.println(ht.getOrDefault(87, "dk"));
        System.out.println(ht.containsKey(87));
        System.out.println(ht.containsValue("pk"));
        
        System.out.println("\n======= HashSet =========");
        HashSet<Integer> hs = new HashSet<>();
        hs.add(87);
        hs.add(85);
        hs.add(86);
        hs.add(87);
        hs.add(89);
        System.out.println(hs);
        
        System.out.println("\n======= TreeMap =========");
        TreeMap<Integer, String> tm = new TreeMap<>();
        tm.put(87, "pk");
        tm.put(85, "sk");
        tm.put(86, "ak");
        tm.put(84, "Sk");
        tm.put(89, "Ak");
        System.out.println("original are : " + tm);
        System.out.println("reversed are : " + tm.descendingMap());
        System.out.println(tm.get(84));
        System.out.println(tm.getOrDefault(81, "dk"));
        System.out.println(tm.getOrDefault(87, "dk"));
        System.out.println(tm.containsKey(87));
        System.out.println(tm.containsValue("pk"));

        System.out.println("\n======= CustomHeap =========");
        hashmap chm = new hashmap();
        chm.put("pk", "giridih");
        chm.put("ak", "kolkata");
        chm.put("vk", "Palamu");
        chm.put("gk", "Dhanbad");
        System.out.println(chm.get("pk"));
        System.out.println(chm.remove("gk"));

        System.out.println("\n======= CustomHeapWithGeneric =========");
        hashmapFinal<String, String> hmf = new hashmapFinal<>();
        hmf.put("pk", "giridih");
        hmf.put("ak", "kolkata");
        hmf.put("vk", "Palamu");
        hmf.put("gk", "Dhanbad");
        System.out.println(hmf.get("pk"));
        System.out.println(hmf.remove("gk"));
        System.out.println(hmf.containKey("gk"));
        System.out.println(hmf);
    }

    public static class hashmapFinal<K, V> {
        ArrayList<LinkedList<Entity>> list;
        private int size = 0;
        // if half list is full and want to insert in list then double the size of list
        // is called load factor
        private final float lf = 0.5f; // load factor

        hashmapFinal() {
            list = new ArrayList<>(); // initially 10 empty list is added
            for (int i = 0; i < 10; i++) {
                list.add(new LinkedList<>());
            }
        }

        private class Entity {
            K key;
            V value;

            public Entity(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        public void put(K key, V value) {
            int hashIndex = Math.abs(key.hashCode() % list.size());
            LinkedList<Entity> entities = list.get(hashIndex); // index of that key
            for (Entity e : entities) { // key is present then rename it with new value
                if (e.key.equals(key)) {
                    e.value = value;
                    return;
                }
            }
            if ((float) (size) / list.size() > lf) { // if half is full then double the list
                reHash();
            }
            entities.add(new Entity(key, value)); // add new Entity in that index
            size++;
        }

        private void reHash() {
            ArrayList<LinkedList<Entity>> old = list; // old list
            list = new ArrayList<>(); // creating new list
            size = 0;
            for (int i = 0; i < old.size() * 2; i++) { // adding empty Entity inside list with double size
                list.add(new LinkedList<>());
            }
            for (LinkedList<Entity> e : old) { // copying all Entity in new list of old list
                for (Entity ee : e) {
                    put(ee.key, ee.value);
                }
            }
        }

        public V get(K key) {
            int hashIndex = Math.abs(key.hashCode() % list.size());
            LinkedList<Entity> entities = list.get(hashIndex); // find index
            for (Entity e : entities) { // search Entity in that index
                if (e.key.equals(key)) {
                    return e.value;
                }
            }
            return null;
        }

        public V remove(K key) {
            int hashIndex = Math.abs(key.hashCode() % list.size());
            LinkedList<Entity> entities = list.get(hashIndex); // find index
            Entity removed = null;
            for (Entity e : entities) { // search Entity in that index
                if (e.key.equals(key)) {
                    removed = e;
                    break;
                }
            }
            entities.remove(removed);
            size--;
            return removed.value;
        }

        public boolean containKey(K key) {
            return get(key) != null;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            for (LinkedList<Entity> e : list) {
                for (Entity item : e) {
                    sb.append(item.key);
                    sb.append(" = ");
                    sb.append(item.value);
                    sb.append(" , ");
                }
            }
            sb.append("}");
            return sb.toString();
        }
    }

    public static class hashmap {
        private final Entity[] entities;

        hashmap() {
            entities = new Entity[100];
        }

        private static class Entity {
            String key;
            String value;

            public Entity(String key, String value) {
                this.key = key;
                this.value = value;
            }
        }

        public void put(String key, String value) {
            int hashIndex = Math.abs(key.hashCode() % entities.length);
            entities[hashIndex] = new Entity(key, value);
        }

        public String get(String key) {
            int hashIndex = Math.abs(key.hashCode() % entities.length);
            if (entities[hashIndex] != null && entities[hashIndex].key.equals(key)) {
                return entities[hashIndex].value;
            }
            return null;
        }

        public String remove(String key) {
            int hashIndex = Math.abs(key.hashCode() % entities.length);
            String removed = "";
            if (entities[hashIndex] != null && entities[hashIndex].key.equals(key)) {
                removed = entities[hashIndex].value;
                entities[hashIndex].value = null;
            }
            return removed;
        }
    }
}