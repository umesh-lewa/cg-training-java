package labbook1;

public class Q25 {

}

protected class base {
String Method() {
return "Wow";
}
}
class dervied {
public void useD() {
base z = new base();
System.out.println("base says, " + z.Method());
}
}
