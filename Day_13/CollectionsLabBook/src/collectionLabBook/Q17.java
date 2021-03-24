package collectionLabBook;


import java.util.*;
class Q17 {
public static void main(String[] args) {
Map<ToDos, String> m = new HashMap<ToDos, String>();
ToDos t1 = new ToDos("Monday");
ToDos t2 = new ToDos("Monday");
ToDos t3 = new ToDos("Tuesday");
m.put(t1, "doLaundry");
m.put(t2, "payBills");
m.put(t3, "cleanAttic");
System.out.println(m.size());
}}

class ToDos1{
String day;
ToDos1(String d) { day = d; }
public boolean equals(Object o) {
return ((ToDos)o).day == this.day;
}
// public int hashCode() { return 9; }
}