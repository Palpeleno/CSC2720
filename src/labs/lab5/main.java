package labs.lab5;

public class main {
    {
        HashTable<String, Integer> hash = new HashTable<>();
        hash.put("this", 1);
        hash.put("coder", 2);
        hash.put("this", 4);
        hash.put("hi", 5);
        System.out.println(hash.size());
        System.out.println(hash.remove("this"));
        System.out.println(hash.remove("this"));
        System.out.println(hash.size());
        System.out.println(hash.isEmpty());
    }




        
}
