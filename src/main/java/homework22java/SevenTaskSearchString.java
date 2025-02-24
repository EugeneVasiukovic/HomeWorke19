package homework22java;

import java.util.List;

public class SevenTaskSearchString {

    public static  boolean containsString(List<String> list, String searchString){
        for (String string : list){
            if(string.equals(searchString)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        List<String> productList = List.of("banana","cherry","apple","pineapple");
        String searchProduct = "apple";

        boolean result = containsString(productList, searchProduct);
        System.out.println("The product is found: " + result);
    }
}
