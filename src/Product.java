// Задание_1\Задание_2
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Product {

    private String name;
    private LocalDate productionDate;
    private String manufacturer;
    private String countryOfOrigin;
    private double prise;
    private boolean booking;


    private Product(String name, LocalDate productionDate, String manufacturer, String countryOfOrigin,
                    double prise, boolean booking) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.prise = prise;
        this.booking = booking;
    }


    private Product(String name, String productionDateStr, String manufacturer, String countryOfOrigin,
                    double prise, boolean booking) {
        this.name = name;
        this.productionDate = parseDate(productionDateStr);
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.prise = prise;
        this.booking = booking;
    }


    public void printInfo() {
        System.out.println("Название: " + name);
        System.out.println("Дата производтсва: " + productionDate);
        System.out.println("Бренд: " + manufacturer);
        System.out.println("Страна происхождения: " + countryOfOrigin);
        System.out.println("Цена: " + prise);
        System.out.println("Состояние бронирование покупателем: " + (booking ? "Забронирован" : "Свободжен"));
        System.out.println("==================================\n");
    }


    private String formatDate(LocalDate date) {
        if (date == null) {
            return "Не указано";
        } DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return date.format(formatter);
    }

    private LocalDate parseDate(String dateString) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            return LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e){
            System.err.println("Ошибка парсинга даты: " + dateString + ". Используется текущая дата.");
            return LocalDate.now();
        }
    }


    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }


    public LocalDate getProductionDate(){
        return productionDate;
    }
    public void setProductionDate(LocalDate productionDate){
        this.productionDate = productionDate;
    }


    public String getManufacturer(){
        return manufacturer;
    }
    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }


    public String getCountryOfOrigin(){
        return countryOfOrigin;
    }
    public void setCountryOfOrigin(String countryOfOrigin){
        this.countryOfOrigin = countryOfOrigin;
    }


    public double getPrise(){
        return prise;
    }
    public void setPrise(double prise){
        this.prise = prise;
    }


    public boolean getBooking(){
        return booking;
    }
    public void setBooking(boolean booking){
        this.booking = booking;
    }


    public static void main (String[] args){
        Product[] productsArray = new Product[5];

        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025",
                "Samsung Corp.", "Korea", 5599.0, true);

        productsArray[1] = new Product("iPhone 16 Pro Max", "15.03.2025",
                "Apple Inc.", "China", 6999.0, false);

        productsArray[2] = new Product("Xiaomi 14T", "10.04.2025",
                "Xiaomi Corp.", "China", 3499.0, true);

        productsArray[3] = new Product("Sony WH-1000XM6", "20.05.2025",
                "Sony Corp.", "Japan", 299.0, false);

        productsArray[4] = new Product("Dell XPS 15", "05.06.2025",
                "Dell Technologies", "USA", 1999.0, true);


        for (Product product : productsArray) {
            product.printInfo();
        }
    }

















}
