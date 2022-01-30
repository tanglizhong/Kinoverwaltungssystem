package run;

import bean.Business;
import bean.Customer;
import bean.Film;
import bean.User;

import java.util.*;

public class Main {
    //定义系统的数据容器
    //1.存储很多用户
    public static final List<Customer> user = new ArrayList<>(); //list for customer
    public static final List<Business> bus = new ArrayList<>();  //list for business
    public static final ArrayList<Film> film = new ArrayList<>();
    //存储系统全部商家及排片信息
    //public static Map<Business, List<Film>> ALL_FILMS = new HashMap<>();
    static{
        Customer c = new Customer();
        c.setLoginName("tang");
        c.setPassWord("123");
        c.setUserName("Long");
        c.setSex('m');
        c.setMoney(1000);
        c.setPhone("18236464621");
        user.add(c);

        Customer c2 = new Customer();
        c2.setLoginName("tt");
        c2.setPassWord("123");
        c2.setUserName("Ling");
        c2.setSex('m');
        c2.setMoney(1000);
        c2.setPhone("186546351546");
        user.add(c2);


        Business b = new Business();
        b.setLoginName("tangtang");
        b.setPassWord("123");
        b.setUserName("tangbuku");
        b.setSex('m');
        b.setMoney(2000);
        b.setPhone("017546546742");
        b.setShopName("Kino");
        b.setAddresse("Berburger Str.xx");
        bus.add(b);
        //List<Film> film1 = new ArrayList<>();
        //ALL_FILMS.put(b,film1);

        Business b2 = new Business();
        b2.setLoginName("tang1");
        b2.setPassWord("123");
        b2.setUserName("tangbuku");
        b2.setSex('m');
        b2.setMoney(2000);
        b2.setPhone("01785147212");
        b2.setShopName("Kino");
        b2.setAddresse("xxxxxxxxx Str.xx");
        bus.add(b2);
        //List<Film> film2 = new ArrayList<>();
        //ALL_FILMS.put(b2,film2);

        film.add(new Film("夏洛特烦恼"));
        film.add(new Film("长津湖"));
        film.add(new Film("开端"));



    }      // initialization
    public static final Scanner eingabe = new Scanner(System.in);     //Scanner for generally
    public static final Scanner eingabeName = new Scanner(System.in); //Scanner for name
    public static void main(String[] args){
        hauptseite();
    }
    private static void hauptseite(){
        boolean schleife = true;
        while(schleife){
            System.out.println();
            System.out.println("********************************************");
            System.out.println("*    Herzlichen Willkommen zum KINOWELT    *");
            System.out.println("********************************************");
            System.out.println("*              1 --- Login                 *" + "\n*              2 --- Exit                  *");
            System.out.println("********************************************");
            System.out.print("Geben Sie Ihre Option ein: ");
            int option = eingabe.nextInt();
            switch (option){
                case 1:
                    login();
                    break;
                case 2:
                    schleife = false;
                    break;
                default:
                    System.out.println("ungueltige Eingabe!!");
            }
        }
    }       //main
    private static void login() {
        while (true){
            try{
                System.out.println("********************************************");
                System.out.println("Sind Sie Customer oder Business?\n1 --- business\n2 --- customer\n3 --- Registieren als Customer");
                System.out.println("********************************************");
                System.out.print("Geben Sie Ihre Wahl ein: ");
                int wahl = eingabe.nextInt();
                if (wahl == 1) {
                    businessLogin();
                    break;
                } else if (wahl == 2) {
                    customerLogin();
                    break;
                } else if(wahl == 3){
                    registieren();
                }
                else {
                    System.out.println("ungueltige Eingabe!!");
                }
            }catch (Exception error){
                System.out.println("Bitte geben Sie Zahlen ein!!!");
            }
        }
    }           //login choose
    private static void businessLogin(){
        System.out.print("Geben Sie Ihren Name ein: ");
        String name = eingabe.next();
        for (int i = 0; i < bus.size(); i++) {
            if(name.equals(bus.get(i).getLoginName())){
                System.out.print("Geben Sie Ihr Passwort ein: ");
                String password = eingabe.next();
                if(password.equals(bus.get(i).getPassWord())){
                    System.out.println("********************************************");
                    System.out.println("*             LOGIN ERFOLGREICH            *");
                    System.out.println("********************************************");
                    System.out.println("   Hallo '"+name+"' Herzlichen Willkommen");
                    System.out.println("********************************************");
                    business(i);
                    break;
                }
            }
            else {
                System.out.println("Password oder Loginname ist falsch!");
                break;
            }
        }
    }    //business verify
    private static void customerLogin(){
        boolean noUser = true;
        System.out.print("Geben Sie Ihren Name ein: ");
        String name = eingabe.next();
        for (int i = 0; i < user.size(); i++) {
            if(name.equals(user.get(i).getLoginName())){
                System.out.print("Geben Sie Ihr Passwort ein: ");
                String password = eingabe.next();
                if(password.equals(user.get(i).getPassWord())){
                    noUser = false;
                    System.out.println("********************************************");
                    System.out.println("*             LOGIN ERFOLGREICH            *");
                    System.out.println("********************************************");
                    System.out.println("   Hallo '"+name+ "' Herzlichen Willkommen");
                    System.out.println("********************************************");
                    customer(i);
                    break;
                }
            }

        }
        if(noUser){
            System.out.println("Password oder Loginname ist falsch!");
        }
    }    //customer verify
    private static void business(int i){
        boolean schleife = true;
        while(schleife){
            System.out.println();
            System.out.println("********************************************");
            System.out.println("1 --- Info\n2 --- Filme hinzufügen\n3 --- Filme löschen\n4 --- Zurück auf die Hauptseite");
            System.out.println("********************************************");
            System.out.print("Geben Sie Ihre Option ein: ");
            int option = eingabe.nextInt();
            switch (option){
                case 1:
                    System.out.println("*********************************************************");
                    System.out.println("Geschäftsinfo: ");
                    System.out.println("*********************************************************");
                    System.out.println("Name  Adresse           Sex    Telefon       Guthaben");
                    System.out.println(bus.get(i).getShopName()+"  "+bus.get(i).getAddresse()+"   "+bus.get(i).getSex()+"     "+bus.get(i).getPhone()+"   "+bus.get(i).getMoney()+" Euro");
                    System.out.println("*********************************************************");
                    info();
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    remove();
                    break;
                case 4:
                    schleife = false;
                    break;
                default:
                    System.out.println("ungueltoge Eingabe!!");
            }
        }

    }    //business function
    private static void customer(int i){
        boolean schleife = true;
        while (schleife){
            System.out.println("********************************************");
            System.out.println("1 --- Info\n2 --- Filme waehlen\n0 --- Zurück auf die Hauptseite");
            System.out.println("********************************************");
            System.out.print("Geben Sie Ihre Option ein: ");
            int option = eingabe.nextInt();
            switch (option){
                case 1:
                    System.out.println("*********************************************************");
                    System.out.println("Kundeninfo: ");
                    System.out.println("*********************************************************");
                    System.out.println("Username      Sex       Telefon      Guthaben");
                    System.out.println(user.get(i).getUserName()+"           "+user.get(i).getSex()+"        "+user.get(i).getPhone()+"  "+user.get(i).getMoney() + " Euro");
                    System.out.println("*********************************************************");
                    break;
                case 2:
                    info();
                    filmWahl(i);
                    break;
                case 0:
                    schleife = false;
                    break;
                default:
                    System.out.println("ungueltoge Eingabe!!");
            }
        }
    }    //customer function
    private static void info(){
        if(film.size() != 0){
            System.out.println("Filmeinfo: ");
            System.out.println("*********************************************************");
            for (int i = 0; i < film.size(); i++) {
                System.out.println((i+1)+". "+film.get(i).getName());
            }
            System.out.println("*********************************************************");

        }
        else {
            System.out.print("Filminfo: ");
            System.out.println("Zur Zeit sind keine Filme vorhanden!");
            System.out.println("********************************************");
        }
    }             //information show
    private static void add(){
        System.out.print("Name des neuen Films: ");
        String name = eingabeName.nextLine();
        Film f = new Film();
        f.setName(name);
        film.add(f);
        System.out.println("Der Film ist schon hinzugefügt");
    }              //movie add
    private static void remove(){
        if(film.size() != 0){
            while (true){
                try{
                    System.out.println("Filmeinfo: ");
                    System.out.println("*********************************************************");
                    for (int i = 0; i < film.size(); i++) {
                        System.out.println((i+1)+". "+film.get(i).getName());
                    }
                    System.out.println("*********************************************************");
                    System.out.println("Welcher Film möchten Sie löschen?");
                    int removeFilm = eingabe.nextInt();
                    System.out.println("Film '"+film.get(removeFilm-1)+"' ist schon gelöscht");
                    film.remove(removeFilm-1);
                    break;
                }
                catch (Exception error){
                    System.out.println("ungültig");
                }
            }
        }
        else {
            System.out.println("Zur Zeit sind keine Filme vorhanden!");}
    }           //movie remove
    private static void filmWahl(int i){
        boolean schleife = true;
        int ticket = 8;
        while(schleife) {
            try{
                System.out.print("Geben Sie Ihre Option ein: ");
                int filmName = eingabe.nextInt();
                System.out.println("Sie haben den Film '"+ film.get(filmName-1).getName() +"' gewählt.");
                System.out.println("Es kostet 8 Euro.\nMöchten Sie es bezahlen?\n1 --- ja\n2 --- nein");
                System.out.print("Geben Sie Ihre Option ein: ");
                int zahlen = eingabe.nextInt();
                switch (zahlen){
                    case 1:
                        user.get(i).setMoney(user.get(i).getMoney()-ticket);
                        System.out.println("8 Euro werden von Ihrem Konto abgebucht. Vielen Dank!!");
                        System.out.println("Ihr neuer Kontostand lautet "+ user.get(i).getMoney()+" Euro");
                        break;
                    case 2:
                        break;
                    default:
                        System.out.println("");
                }
                schleife = false;
            }
            catch (Exception error){
                System.out.println("ungültige Eingabe");
            }
        }

    }    //movie choose
    private static void registieren(){
        while(true){
            try{
                System.out.print("Loginname: ");
                String loginname = eingabeName.nextLine();
                System.out.print("Vorname Nachname: ");
                String username = eingabeName.nextLine();
                System.out.print("Passwort: ");
                String passwort = eingabe.next();
                System.out.print("Geschlecht: ");
                char sex = eingabe.next().charAt(0);
                System.out.print("TEL: " );
                String phone = eingabe.next();
                System.out.print("Guthaben: ");
                double money = eingabe.nextDouble();
                Customer neuCustomer = new Customer(loginname,username,passwort,sex,phone,money);
                user.add(neuCustomer);
                System.out.println("Sie haben erfolgreich registiert");
                break;
            }
            catch (Exception error){
                System.out.println("ungültige Eingabe!!");
            }
        }
    }      //sign up


}