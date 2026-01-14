import java.util.ArrayList;
import java.util.List;


public class Park {
    private String name;
    private List<Attraction> attractions;


    // Конструктор
    public Park(String name) {
        this.name = name;
        this.attractions = new ArrayList<>();
    }

    // Внутренний класс Attraction
    public class Attraction {
        private String attractionName;
        private String workingHours;
        private double cost;

        // Конструктор внутреннего класса
        public Attraction(String attractionName, String workingHours, double cost) {
            this.attractionName = attractionName;
            this.workingHours = workingHours;
            this.cost = cost;
        }

        // Геттеры (при необходимости можно добавить сеттеры)
        public String getAttractionName() {
            return attractionName;
        }

        public String getWorkingHours() {
            return workingHours;
        }

        public double getCost() {
            return cost;
        }

        // Метод для вывода информации об аттракционе
        public void printInfo() {
            System.out.println("Название аттракциона: " + attractionName);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Стоимость: " + cost + " руб.");
            System.out.println("====================\n");
        }
    }

    // Метод для добавления аттракциона в парк
    public void addAttraction(String name, String hours, double cost) {
        Attraction attraction = new Attraction(name, hours, cost);
        attractions.add(attraction);
    }

    // Метод для вывода всех аттракционов парка
    public void printAllAttractions() {
        System.out.println("Парк: " + name);
        System.out.println("Список аттракционов:");
        System.out.println("====================\n");
        for (Attraction attraction : attractions) {
            attraction.printInfo();
        }
    }

    // Дополнительный метод: получить аттракцион по названию
    public Attraction findAttraction(String name) {
        for (Attraction attraction : attractions) {
            if (attraction.getAttractionName().equalsIgnoreCase(name)) {
                return attraction;
            }
        }
        return null; // не найден
    }

    // Геттер для названия парка
    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        // Создаём парк
        Park park = new Park("Солнечный парк");

        // Добавляем аттракционы
        park.addAttraction("Американские горки", "10:00–20:00", 500.0);
        park.addAttraction("Колесо обозрения", "11:00–19:00", 300.0);
        park.addAttraction("Карусель", "12:00–18:00", 200.0);

        // Выводим всю информацию
        park.printAllAttractions();

        // Ищем конкретный аттракцион
        Park.Attraction attraction = park.findAttraction("Американские горки");
        if (attraction != null) {
            System.out.println("Найден аттракцион: " + attraction.getAttractionName());
        } else {
            System.out.println("Аттракцион не найден.");
        }
    }
}