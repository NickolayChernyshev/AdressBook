/**
 * Created by Николай on 22.10.2014.
 */
import java.util.Scanner;

public class AddrBookManager {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        while (true) {
            System.out.println("Доступные операции:");
            System.out.println("1. Добавление записи");
            System.out.println("2. Поиск записи по имени человека");
            System.out.println("3. Вывод всех записей на экран");
            System.out.println("4. Удаление записи по индексу");
            System.out.println("5. Изменение записи");
            System.out.println("6. Выход");
            System.out.println("Введите номер пункта меню: ");
            Scanner sc = new Scanner(System.in);
            String menu = sc.nextLine();
            int command = Integer.parseInt (menu);
            switch (command) {
                case 1: {
                    System.out.println("Введите имя:");
                    String name = sc.nextLine();
                    System.out.println("Введите телефон:");
                    String phone = sc.nextLine();
                    System.out.println("Введите email:");
                    String email = sc.nextLine();
                    AddressBook.add(addressBook, name, phone, email);
                    System.out.println("Запись была успешно добавлена");
                    break;
                }
                case 2: {
                    System.out.println("Введите имя:");
                    String name = sc.nextLine();
                    int [] poisk = AddressBook.find(addressBook, name);
                    if (poisk.length == 0) {
                        System.out.println("Результаты не найдены");
                    } else {
                        for (int i = 0; i < poisk.length; i++) {
                            AddressBook.vvod (addressBook, poisk[i]);
                        }
                    }
                    break;
                }
                case 3:
                    AddressBook.print(addressBook);
                    break;
                case 4: {
                    System.out.println("Введите индекс для удаления записи");
                    String a = sc.nextLine();
                    int index = Integer.parseInt (a);
                    if (index < AddressBook.getCount(addressBook)) {
                        AddressBook.delete(addressBook, index);
                        System.out.println("Запись была успешно удалена");
                    } else {
                        System.out.println("Неправильный индекс");
                    }
                    break;
                }
                case 5:
                    System.out.println("Введите индекс для изменения записи");
                    String a = sc.nextLine();
                    int index = Integer.parseInt (a);
                    if (index < AddressBook.getCount(addressBook)) {
                        System.out.println("Введите имя");
                        String name = sc.nextLine();
                        System.out.println("Введите телефон");
                        String phone = sc.nextLine();
                        System.out.println("Введите email");
                        String email = sc.nextLine();
                        AddressBook.edit(addressBook, index, name, phone, email);
                        System.out.println("Запись была успешно изменена");
                    } else {
                        System.out.println("Неправильный индекс");
                    }
                    break;
                case 6:
                    System.out.println("Спасибо за использование!");
                    return;
                default:
            }

        }
    }
}
