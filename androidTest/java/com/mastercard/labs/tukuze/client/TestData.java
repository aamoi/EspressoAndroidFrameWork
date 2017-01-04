package com.mastercard.labs.tukuze.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Created by amoi on 21/07/2016.
 */
public class TestData {
    //Clean  data from your postgres 2kuze db by running this query before running these tests
    String sqlCleanScript = "truncate farmer cascade; truncate buyer cascade; truncate buy_order cascade;";

    /**
     * Pre-populated farmers.
     *
     * @return List of farmers to be registered.
     */
    public static String[][] registerFarmers() {

        String[][] farmers = {
                //surname, otherNames, mobile number, id
                {"Kihara", "Anneh", "+254728067003", "10009", "Nairobi-L"},
                {"Kuria", "Ashford", "+254728067003", "10004", "Nairobi-E"},
                {"Akummu", "Aynsola", "+254728067003", "10003", "Nairobi-D"},

                {"Munyiri", "Benard", "+254728067003", "10000", "Nairobi-A"},
                {"Karungo", "Bismark", "+254728067003", "10012", "Nairobi-O"},

                {"Mwisuji", "Daniel", "+254728067003", "10005", "Nairobi-F"},
                {"Olubebdi", "Daureen", "+254728067003", "10015", "Nairobi-R"},
                {"Tole", "David", "+254728067003", "10007", "Nairobi-H"},
                {"Gikunda", "Denis", "+254728067003", "10006", "Nairobi-G"},

                {"Montet", "Francis", "+254728067003", "10002", "Nairobi-C"},

                {"Kiplagat", "Isaac", "+254728067003", "10013", "Nairobi-P"},

                {"Reeves", "June", "+254728067003", "10014", "Nairobi-Q"},

                {"Salim", "Khalila", "+254728067003", "10007", "Nairobi-J"},

                {"Mwikali", "Laureen", "+254728067003", "10010", "Nairobi-M"},

                {"Kibwage", "Michael", "+254728067003", "10001", "Nairobi-B"},

                {"Kwamboka", "Serah", "+254728067003", "10011", "Nairobi-N"},

                {"Temi", "Tope", "+254728067003", "10006", "Nairobi-I"},

                {"Maranga", "Yvonneh", "+254728067003", "10008", "Nairobi-K"}

        };

        return farmers;

    }

    /**
     * Pre-populated farmers.
     *
     * @return List of farmers to be registered.
     */
    public static String[][] getNMBFarmers() {

        String[][] farmers = {
                //surname, otherNames, mobile number, id
                {"Kihara", "Annieh", "+254728067003", "10009", "Nairobi-L"},
                {"Kuria", "Ashford", "+254728067003", "10004", "Nairobi-E"},
                {"Akummu", "Aynsola", "+254728067003", "10003", "Nairobi-D"},

                {"Munyiri", "Benard", "+254728067003", "10000", "Nairobi-A"},
                {"Karungo", "Bismark", "+254728067003", "10012", "Nairobi-O"},

                {"Mwisuji", "Daniel", "+254728067003", "10005", "Nairobi-F"},
                {"Olubebdi", "Daureen", "+254728067003", "10015", "Nairobi-R"},
                {"Tole", "David", "+254728067003", "10007", "Nairobi-H"},
                {"Gikunda", "Denis", "+254728067003", "10006", "Nairobi-G"},

                {"Montet", "Francis", "+254728067003", "10002", "Nairobi-C"},

                {"Kiplagat", "Isaac", "+254728067003", "10013", "Nairobi-P"},

                {"Reeves", "June", "+254728067003", "10014", "Nairobi-Q"},

                {"Salim", "Khalila", "+254728067003", "10007", "Nairobi-J"},

                {"Mwikali", "Laureen", "+254728067003", "10010", "Nairobi-M"},

                {"Kibwage", "Michael", "+254728067003", "10001", "Nairobi-B"},

                {"Kwamboka", "Serah", "+254728067003", "10011", "Nairobi-N"},

                {"Temi", "Tope", "+254728067003", "10006", "Nairobi-I"},

                {"Maranga", "Yvonneh", "+254728067003", "10008", "Nairobi-K"}

        };

        return farmers;
    }

    /**
     * get information for updating farmer.
     *
     * @return array of farmer info.
     */
    public static String[] getUpdateFarmer() {

        String[] farmer = {"Kiharia", "Annieh", "+254700585827", "112200", "Nairobi-W"};

        return farmer;

    }

    /**
     * buyer orders to be posted
     *
     * @return list of buyer orders to be posted
     */
    public static String[][] buyerOrders() {
        //produce, quantity,buyer
        String[][] buyerOrders = {
                {"tea", "1", "Benard"}, {"tea", "4", "Silas"}, {"honey", "1", "Benard"},
                {"honey", "4", "Silas"}, {"coffee", "1", "Benard"}, {"coffee", "4", "Silas"}
        };
        return buyerOrders;
    }

    /**
     * List of buyers in the backend
     *
     * @return
     */
    public static String[] buyers() {
        String[] buyers = {"Alex", "Benard", "Charles", "Daniel", "Francis", "Gilbert", "Hillary",
                "Michael", "Sola"};
        return buyers;
    }

    /**
     * List of produce in the backend
     *
     * @return
     */
    public static String[] produce() {
        String[] produce = {
                "apple", "avocado", "bananas", "beans", "chicken", "coffee", "cotton", "eggs", "fish",
                "honey", "maize", "mango", "millet", "nuts", "onions", "orange", "pineapple", "potatos",
                "pumpkin", "sorghum", "soya", "strawberry", "sunflower", "tomatos", "watermelon", "wheat"};
        return produce;
    }

    /**
     * NMB produce list
     */

    public static String[][] getNMBProduceList() {
        //produce name, unit of measure, price
        String[][] produce = {
                {"meru-apple", "KGs", "10.00"},
                {"meru-avocado", "pieces", "15.11"},
                {"meru-banana", "KGs", "20.00"},
                {"meru-beans", "KGs", "25.00"},
                {"meru-coffee", "KGs", "30.00"},

                {"meru-chicken", "KGs", "7001.34"},

                {"meru-cotton", "KGs", "35.00"},
                {"meru-eggs", "KGs", "40.00"},
                {"meru-fish", "KGs", "45.00"},
                {"meru-honey", "KGs", "50.00"},
                {"meru-maize", "KGs", "55.00"},

                {"meru-mango", "KGs", "60.00"},
                {"meru-millet", "KGs", "65.00"},
                {"meru-onions", "KGs", "70.00"},
                {"meru-orangle", "KGs", "75.00"},
                {"meru-pineapple", "KGs", "80.00"},

                {"meru-potatos", "KGs", "81.00"},
                {"meru-pumpkin", "KGs", "82.00"},
                {"meru-sorghum", "KGs", "83.00"},
                {"meru-soya", "KGs", "84.00"},
                {"meru-sunflower", "KGs", "85.00"},

                {"meru-strawberry", "KGs", "86.00"},
                {"meru-tomatos", "KGs", "87.00"},
                {"meru-watermelon", "KGs", "88.00"},
                {"meru-wheat", "KGs", "89.00"},
        };
        return produce;
    }

    /**
     * Buyers list
     */
    public static String[][] buyersList() {

        String[][] buyers = {
                {"Alex", "Amoi", "+254728067001", "Nairobi-S"},
                {"Benard", "Munyiri", "+254700585857", "Nairobi-S"},
                {"Charles", "Otieno", "+254700585827", "Nairobi-E"},
                {"Daniel", "Mwisuji", "+254728067001", "Nairobi-C"},
                {"Edga", "Omondi", "+254728067001", "Nairobi-C"},
                {"Francis", "Montet", "+254700585870", "Nairobi-N"},
                {"Gilbert", "Misoi", "+254700585827", "Nairobi-C"},
                {"Hillary", "Mfoyongo", "+254728067008", "Nairobi-W"},
                {"Ian", "Mlima", "+254728067008", "Nairobi-W"},
                {"Jackson", "Motto", "+254728067008", "Nairobi-W"},
                {"Kelvin", "Motto", "+254728067008", "Nairobi-W"},
                {"Laban", "Obot", "+254728067008", "Nairobi-W"},
                {"Michael", "Kibwage", "+254700585805", "Nairobi-S"},
                {"Nelson", "Sechere", "+254700585806", "Nairobi-S"},
                {"Olive", "Musera", "+254700585802", "Nairobi-S"},
                {"Peter", "Masero", "+254700585803", "Nairobi-S"},
                {"Quenteen", "Shalo", "+254700585809", "Nairobi-S"},
                {"Rose", "Amunga", "+254700585807", "Nairobi-S"},
                {"Sola", "Akumu", "+254700585822", "Nairobi-E"},
                {"Titus", "Okumu", "+254700585816", "Nairobi-S"},
                {"Uncle", "Tom", "+254700585876", "Nairobi-S"},
                {"Vivian", "Oketch", "+254700585876", "Nairobi-S"},
                {"Wilson", "Kalo", "+254700585876", "Nairobi-S"},
                {"Xaton", "Cheti", "+254700585878", "Nairobi-S"},
                {"Yusuf", "Hussein", "+254700585879", "Nairobi-S"},
                {"Zablon", "Munyama", "+25470058559", "Nairobi-S"},
        };

        return buyers;
    }

    /**
     * Prices for buy orders
     * Please ensure this returns exact  price set matching your buyer orders
     */
    public static int[] buyOrderPrices(int ordersCount) {

        int size = ordersCount;

        int[] prices = new int[size];

        int minimumPrice = 200;
        int increment = 40;

        for (int count = 0; count < size; ++count) {
            prices[count] = minimumPrice + increment * (count + 1);
        }
        return prices;
    }

    /**
     * collection prices for collections without weighing
     * Please ensure this returns exact  price set mstching your collections without weighing
     */
    public static int[] collectionWithOutPrices(int collections) {

        int size = collections;
        int[] prices = new int[size];
        int minimumPrice = 100;
        int increment = 20;

        for (int count = 0; count < size; ++count) {
            prices[count] = minimumPrice + increment * (count + 1);
        }
        return prices;
    }

    /**
     * test database update  interactions
     *
     * @return
     */
    public static int query() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("cant find postgres sql driver library. error: " + e);
            System.exit(0);
        }
        String stm = "update farmer set tin='1111'";
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://192.168.43.5:5432/tukuze?", "postgres", "r00t");
            PreparedStatement pst = connection.prepareStatement(stm);
            return pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}