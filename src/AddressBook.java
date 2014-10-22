/**
 * Created by Николай on 22.10.2014.
 */
public class AddressBook {
    private Address[] list = new Address[100];
    private int count = 0;
    public static void add(AddressBook book, String name, String phone, String email) {
        Address newAddress = new Address(name, phone, email);
        book.list[book.count] = newAddress;
        book.count++;
    }
    public static int[] find(AddressBook book, String name) {
        int count = 0;
        for (int i = 0; i < book.count; i++) {
            if (!(book.list[i].name == null)) {
                Address a = book.list[i];
                if (a.name.equals(name)) {
                    count++;
                }
            }
        }
        int[] poisk = new int[count];
        count = 0;
        for (int i = 0; i < book.count; i++) {
            if (!(book.list[i].name == null)) {
                Address a = book.list[i];
                if (a.name.equals(name)) {
                    poisk[count] = i;
                    count++;
                }
            }
        }
        return poisk;
    }
    public static void print (AddressBook book) {
        System.out.println(" Имя  /   телефон  /  email");
        for (int i=0; i<book.count; i++) {
            Address address = book.list[i];
            System.out.println(i + "." + address.name + " / " + address.phone + " / " + address.email);
        }
    }
    public static void vvod (AddressBook book) {
        int i=0;
        Address address = book.list[i];
        System.out.println(i + "." + address.name + " / " + address.phone + " / " + address.email);

    }
    public static void delete(AddressBook book, int index) {
        book.list[index].name = null;
        book.list[index].phone = null;
        book.list[index].email = null;
        for (int i = index; i < book.count - 1; i++) {
            book.list[i].name = book.list[i + 1].name;
            book.list[i].phone = book.list[i + 1].phone;
            book.list[i].email = book.list[i + 1].email;
        }
        book.count --;
    }
    public static void edit (AddressBook book, int index, String name, String phone, String email){
        book.list [index].name=name;
        book.list [index].phone=phone;
        book.list [index].email=email;
    }
    public static int getCount(AddressBook book){
        return book.count;
    }
}