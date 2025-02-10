package constans;

public interface IConstans {
    String LOGIN_PAGE_URL = "https://www.saucedemo.com";
    String CART_PAGE_URL = LOGIN_PAGE_URL + "/cart.html";
    String PRODUCT_PAGE_URL = LOGIN_PAGE_URL + "/inventory.html";
    String PAGE_URL_NON_EXISTENT_PRODUCT = LOGIN_PAGE_URL + "/inventory-item.html?id=999";
}