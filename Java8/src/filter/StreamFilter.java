package filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Product {
    int id;
    String name;
    Double price;

    public Product(int id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class StreamFilter {

    public static void main(String[] args) {

        List<String> listStr = Arrays.asList("anna", "rajivgandhi", "siva", "kathir", "ravi", "dinesh");

        //listStr.stream().filter(str -> str.length() > 4).forEach(System.out::println);

        // filter null value from the collections.
        List<String> listStr2 = Arrays.asList("anna", "rajivgandhi", "siva", "kathir", "ravi", "dinesh", null, null);
        List<String> result = listStr2.stream().filter(str -> str != null).collect(Collectors.toList());
       // System.out.println(result);

        // calculating the product details
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1,"HP",25000.0));
        productList.add(new Product(2,"HP1",25009.0));

        productList.stream().filter(p-> p.price>25000)
                        .forEach(pr-> System.out.println(pr.price));

    }
}
