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
    //存储系统全部商家及排片信息  // 1 business - many movies
    public static Map<Business, List<Film>> film = new HashMap<>(); //key-value like dictionary in python ---  //键值对 --- // Schlüssel - Wert wie Wörterbusch in Python
    static{
        Customer c = new Customer();
        c.setLoginName("tang");
        c.setPassWord("123");
        c.setUserName("Long");
        c.setSex('m');
        c.setMoney(30);
        c.setPhone("18236464621");
        user.add(c);

        Customer c2 = new Customer();
        c2.setLoginName("tt");
        c2.setPassWord("123");
        c2.setUserName("Ling");
        c2.setSex('m');
        c2.setMoney(50);
        c2.setPhone("186546351546");
        user.add(c2);


        Business b = new Business();
        b.setLoginName("tangtang");
        b.setPassWord("123");
        b.setUserName("tangbuku");
        b.setSex('m');
        b.setMoney(2000);
        b.setPhone("017546546742");
        b.setShopName("Kino1");
        b.setAddresse("Berburger Str.xx");
        bus.add(b);
        List<Film> film1 = new ArrayList<>();
        film1.add(new Film("夏洛特烦恼"));
        film1.add(new Film("长津湖"));
        film.put(b,film1);

        Business b2 = new Business();
        b2.setLoginName("tang");
        b2.setPassWord("123");
        b2.setUserName("tangbuku");
        b2.setSex('m');
        b2.setMoney(2000);
        b2.setPhone("01785147212");
        b2.setShopName("Kino2");
        b2.setAddresse("xxxxxxxxx Str.xx");
        bus.add(b2);
        List<Film> film2 = new ArrayList<>();
        film2.add(new Film("开端"));
        film.put(b2,film2);

    }      // initialization
    public static final Scanner eingabe = new Scanner(System.in);     //Scanner for generally
    public static final Scanner eingabeName = new Scanner(System.in); //Scanner for name
    public static void main(String[] args){
        hauptseite();
    }
    private static void hauptseite(){
        boolean schleife = true;
        while(schleife){
            try{
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
            }catch (Exception error){
                System.out.println("Geben Sie nur Zahlen bitte ein!!!");
                eingabe.next();//clear scanner wrong input -- leeren Scanner falsche Eingabe
            }
        }
    }            //main
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
                eingabe.next();//clear scanner wrong input -- leeren Scanner falsche Eingabe
            }
        }
    }                //login choose
    private static void businessLogin(){
        boolean noUser = true;
        System.out.print("Geben Sie Ihren Name ein: ");
        String name = eingabeName.nextLine();
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
                    noUser = false;
                    break;
                }
            }

        }
        if(noUser){
            System.out.println("Password oder Loginname ist falsch!");
        }
    }         //business verify
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
    }         //customer verify
    private static void business(int i){
        boolean schleife = true;
        while(schleife){
            try{
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
                        infoBusiness(i);
                        break;
                    case 2:
                        add(i);
                        break;
                    case 3:
                        remove(i);
                        break;
                    case 4:
                        schleife = false;
                        break;
                    default:
                        System.out.println("ungueltoge Eingabe!!");
                }
            }catch (Exception error){
                System.out.println("Bitte Geben Sie nur Zahlen ein!!!");
                eingabe.next();//clear scanner wrong input -- leeren Scanner falsche Eingabe
            }
        }

    }         //business function
    private static void customer(int i){
        boolean schleife = true;
        while (schleife){
            try{
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
                        infoCustomer();
                        filmWahl(i);
                        break;
                    case 0:
                        schleife = false;
                        break;
                    default:
                        System.out.println("ungueltoge Eingabe!!");
                }
            }
            catch (Exception error){
                System.out.println("Bitte geben Sie nur zahlen ein!!!");
                eingabe.next();//clear scanner wrong input -- leeren Scanner falsche Eingabe
            }
        }
    }         //customer function
    private static void infoBusiness(int i){
        if(film.size() != 0){
            System.out.println("Filmeinfo: ");
            System.out.println("*********************************************************");
            for (int j = 0; j < film.get(bus.get(i)).size(); j++) {
                System.out.println((j+1)+". "+film.get(bus.get(i)).get(j).getName());
            }
            System.out.println("*********************************************************");

        }
        else {
            System.out.print("Filminfo: ");
            System.out.println("Zur Zeit sind keine Filme vorhanden!");
            System.out.println("********************************************");
        }
    }     //information show
    private static void infoCustomer(){
        if(film.size() != 0){
            System.out.println("*********************************************************");
            for (int i = 0; i < film.size(); i++) {
                System.out.println("Kinoinfo: ");
                System.out.println("Name: "+(i+1)+". "+ bus.get(i).getShopName());
                System.out.println("Adresse: "+bus.get(i).getAddresse());
                System.out.println("Filmeinfo: ");
                for (int j = 0; j < film.get(bus.get(i)).size(); j++) {
                    System.out.println((j+1)+". "+film.get(bus.get(i)).get(j).getName());
                }
                System.out.println("*********************************************************");
            }
        }

        else {
            System.out.print("Filminfo: ");
            System.out.println("Zur Zeit sind keine Filme vorhanden!");
            System.out.println("********************************************");
        }
    }          //information show
    private static void add(int i){
        System.out.print("Name des neuen Films: ");
        String name = eingabeName.nextLine();
        Film f = new Film();
        f.setName(name);
        film.get(bus.get(i)).add(f);
        System.out.println("Der Film ist schon hinzugefügt");
    }              //movie add
    private static void remove(int i){
        if(film.size() != 0){
            while (true){
                try{
                    System.out.println("Filmeinfo: ");
                    System.out.println("*********************************************************");
                    for (int j = 0; j < film.size(); j++) {
                        System.out.println((j+1)+". "+film.get(bus.get(i)).get(j).getName());
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
                    eingabe.next();//clear scanner wrong input -- leeren Scanner falsche Eingabe
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
                System.out.print("Geben Sie Ihre Option eines Kinos ein: ");
                int kinoName = eingabeName.nextInt();
                System.out.print("Geben Sie Ihre Option eines Films ein: ");
                int filmName = eingabe.nextInt();
                for (int j = 0; j < film.size(); j++) {
                    if(bus.get(j).getShopName().equals(bus.get(kinoName-1).getShopName())){   //判断选择的商家是哪一个 --- Geschäft bestimmen---Business confirm
                        System.out.println("Sie haben das Kino '"+bus.get(j).getShopName()+"' den Film '"+ film.get(bus.get(j)).get(filmName-1).getName() +"' gewählt.");
                        break;
                    }
                }
                System.out.println("Es kostet 8 Euro.\nMöchten Sie es bezahlen?\n1 --- ja\n2 --- nein");
                System.out.print("Geben Sie Ihre Option ein: ");
                int zahlen = eingabe.nextInt();
                switch (zahlen){
                    case 1:
                        if(user.get(i).getMoney() >= ticket){
                            user.get(i).setMoney(user.get(i).getMoney()-ticket);  //用户余额减去电影票钱 --- //Guthaben - ticket --- //money - ticket
                            bus.get(kinoName-1).setMoney(bus.get(kinoName-1).getMoney()+ticket);  //商家增加一张电影票的收入 --- //Guthaben + ticket --- //money +ticket
                            System.out.println("8 Euro werden von Ihrem Konto abgebucht. Vielen Dank!!");
                            System.out.println("Ihr neuer Kontostand lautet "+ user.get(i).getMoney()+" Euro");   //money show ---//aktuelles Guthaben zeigen --- //显示余额
                            break;
                        }
                        else {
                            System.out.println("Ihr Konto hat kein genug Geld dafür!!\nMöchten Sie nun es aufladen?\n1 --- ja\n2 --- nein");
                            System.out.print("Geben Sie Ihre Option ein: ");
                            int wahl = eingabe.nextInt();
                            switch (wahl){
                                case 1:
                                    rechargeCustomer(i);
                                    break;
                                case 2:
                                    break;
                                default:
                                    System.out.println("ungültige Eingabe!!!");
                            }
                            break;
                        }
                    case 2:
                        break;
                    default:
                        System.out.println("");
                        eingabe.next();//clear scanner wrong input -- leeren Scanner falsche Eingabe
                }
                schleife = false;
            }
            catch (Exception error){
                System.out.println("ungültige Eingabe");
            }
        }

    }         //movie choose
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
                eingabe.next();//clear scanner wrong input -- leeren Scanner falsche Eingabe
            }
        }
    }           //sign up
    private static void rechargeCustomer(int i){
        System.out.println("Wie viel möchten Sie es aufladen?");
        System.out.print("Geben Sie Ihre Antwort ein: ");
        double money = eingabe.nextDouble();
        user.get(i).setMoney(user.get(i).getMoney()+money);
    }

}