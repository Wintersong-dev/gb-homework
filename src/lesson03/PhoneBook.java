package lesson03;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PhoneBook {
    Map<String, String> map = new TreeMap<>();

    public void add(String name, String phoneNo) {
        map.put(phoneNo, name);
        System.out.println("Номер " + phoneNo + " (" + name + ") внесен в книгу.");
    }

    public void get(String name) {
        String elem;
        String res = "";
        int iter = 1;

        // Даже не начинаем шерстить всю мапу, если его там и нет
        if (map.containsValue(name)) {
            Set<String> set = map.keySet();

            for (String key : set) {
                elem = map.get(key);
                if (key != null && name.equals(elem)) {
                        System.out.println(iter + ". " + name + ": " + key);
                        iter++;
                }
            }
        } else {
            System.out.println(name + ": записи не найдены.");
        }


    }
}
