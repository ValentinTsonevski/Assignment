package Encapsulation;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String peopleInfo = scanner.nextLine();
        String[] peopleData = peopleInfo.split(";");

        Set<Person> people = new HashSet<>();

        for (String infoPerson : peopleData) {
        String[] personInfo = infoPerson.split("=");
        String personName = personInfo[0];
        int money = Integer.parseInt(personInfo[1]);

        Person person = new Person(personName,money,new ArrayList<>());
        people.add(person);
        }

        String productsInfo = scanner.nextLine();
        String[] productsData = productsInfo.split(";");

        Set<Product> products = new HashSet<>();


        for (String infoProduct : productsData) {
            String[] productInfo = infoProduct.split("=");
            String name = productInfo[0];
            int cost = Integer.parseInt(productInfo[1]);

            Product product = new Product(name,cost);
            products.add(product);
        }

        StringBuilder sb = new StringBuilder();

        String purchases = scanner.nextLine();

        while (!purchases.equals("END")) {
            String[] purchaseInfo = purchases.split("\\s+");
            String personName = purchaseInfo[0];
            String productName = purchaseInfo[1];

            Optional<Person> person = people.stream().filter(p -> p.getName().equals(personName)).findFirst();
            Optional<Product> product = products.stream().filter(p -> p.getName().equals(productName)).findFirst();

            if(person.isPresent() && product.isPresent()){
                int personMoney = person.get().getMoney();
                int productCost = product.get().getCost();

                person.get().buyProduct(product.get());
            }

            purchases = scanner.nextLine();
        }
        for (Person person : people) {
            System.out.println(person.toString());
        }
    }


}
