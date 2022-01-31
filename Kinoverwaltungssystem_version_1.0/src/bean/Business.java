package bean;

public class Business extends User {
    private String shopName;
    private String addresse;

    public Business() {}
    public Business(String loginName, String userName, String passWord, char sex, String phone, double money, String shopName, String addresse) {
        super(loginName, userName, passWord, sex, phone, money);
        this.shopName = shopName;
        this.addresse = addresse;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }
}
