public abstract class Animal {

    protected static int totalAnimalCount = 0;  // общий счётчик животных
    protected static int catCount = 0;          // счётчик котов
    protected static int dogCount = 0;          // счётчик собак

    protected String name;  // имя животного


    public Animal(String name) {
        this.name = name;
        totalAnimalCount++;
    }


    public abstract void run(int distance);
    public abstract void swim(int distance);


    public static int getTotalAnimalCount() {
        return totalAnimalCount;
    }

    public static int getCatCount() {
        return catCount;
    }

    public static int getDogCount() {
        return dogCount;
    }


    public String getName() {
        return name;
    }

    public static class Dog extends Animal {

        private final int MAX_RUN_DISTANCE = 500;
        private final int MAX_SWIM_DISTANCE = 10;


        public Dog(String name) {
            super(name);
            dogCount++;
        }


        @Override
        public void run(int distance) {
            if (distance <= MAX_RUN_DISTANCE) {
                System.out.println(name + " пробежал " + distance + " м.");
            } else {
                System.out.println(name + " не может пробежать " + distance + " м. Максимум: " + MAX_RUN_DISTANCE + " м.");
            }
        }


        @Override
        public void swim(int distance) {
            if (distance <= MAX_SWIM_DISTANCE) {
                System.out.println(name + " проплыл " + distance + " м.");
            } else {
                System.out.println(name + " не может проплыть " + distance + " м. Максимум: " + MAX_SWIM_DISTANCE + " м.");
            }
        }
    }

    public static class Bowl {
        private int foodAmount;


        public Bowl(int initialFood) {
            if (initialFood < 0) {
                this.foodAmount = 0;
            } else {
                this.foodAmount = initialFood;
            }
        }


        public void addFood(int amount) {
            if (amount > 0) {
                foodAmount += amount;
                System.out.println("Добавлено " + amount + " еды в миску. Теперь в миске: " + foodAmount + " еды.");
            }
        }


        public boolean decreaseFood(int amount) {
            if (amount > foodAmount) {
                System.out.println("В миске недостаточно еды! Нужно: " + amount + ", есть: " + foodAmount);
                return false;
            }

            foodAmount -= amount;
            System.out.println("Из миски съедено " + amount + " еды. Осталось: " + foodAmount);
            return true;
        }


        public int getFoodAmount() {
            return foodAmount;
        }
    }

    public static class Cat extends Animal {

        private final int MAX_RUN_DISTANCE = 200;
        private final int MAX_SWIM_DISTANCE = 0;  // коты не умеют плавать


        private boolean isFull;


        public Cat(String name) {
            super(name);
            this.isFull = false;  // при создании кот голоден
            catCount++;
        }


        @Override
        public void run(int distance) {
            if (distance <= MAX_RUN_DISTANCE) {
                System.out.println(name + " пробежал " + distance + " м.");
            } else {
                System.out.println(name + " не может пробежать " + distance + " м. Максимум: " + MAX_RUN_DISTANCE + " м.");
            }
        }


        @Override
        public void swim(int distance) {
            System.out.println(name + " не умеет плавать!");
        }


        public void eat(Bowl bowl, int foodAmount) {
            if (isFull) {
                System.out.println(name + " уже сыт!");
                return;
            }

            boolean ateSuccessfully = bowl.decreaseFood(foodAmount);
            if (ateSuccessfully) {
                isFull = true;
                System.out.println(name + " покушал и теперь сыт!");
            } else {
                System.out.println(name + " остался голодным...");
            }
        }


        public void eat(Bowl bowl) {
            eat(bowl, 10);  // по умолчанию кот ест 10 единиц еды
        }


        public boolean isFull() {
            return isFull;
        }


        public void setFull(boolean full) {
            isFull = full;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Часть 1: Создание животных и проверка их возможностей ===\n");


        Dog dog1 = new Dog("Бобик");
        Dog dog2 = new Dog("Рекс");
        Cat cat1 = new Cat("Мурзик");
        Cat cat2 = new Cat("Барсик");
        Cat cat3 = new Cat("Васька");


        System.out.println("--- Проверка бега ---");
        dog1.run(400);
        dog1.run(600);
        cat1.run(150);
        cat1.run(250);

        System.out.println("\n--- Проверка плавания ---");
        dog2.swim(5);
        dog2.swim(15);
        cat2.swim(5);

        System.out.println("\n--- Статистика животных ---");
        System.out.println("Всего животных: " + Animal.getTotalAnimalCount());
        System.out.println("Собак: " + Animal.getDogCount());
        System.out.println("Котов: " + Animal.getCatCount());

        System.out.println("\n=== Часть 2: Кормление котов ===\n");


        Bowl bowl = new Bowl(25);
        System.out.println("Создана миска с " + bowl.getFoodAmount() + " единицами еды");


        Cat[] cats = {cat1, cat2, cat3};


        System.out.println("\n--- Кормим всех котов по очереди ---");
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(bowl);
        }


        System.out.println("\n--- Проверка сытости котов ---");
        for (Cat cat : cats) {
            System.out.println(cat.getName() + " сыт: " + cat.isFull());
        }


        System.out.println("\n--- Добавляем еды в миску ---");
        bowl.addFood(15);


        System.out.println("\n--- Кормим голодных котов снова ---");
        for (Cat cat : cats) {
            if (!cat.isFull()) {
                cat.eat(bowl);
            }
        }


        System.out.println("\n--- Создаём нового кота и кормим его ---");
        Cat cat4 = new Cat("Пушок");
        cat4.eat(bowl, 5);

        System.out.println("\n--- Финальная статистика ---");
        System.out.println("Всего животных: " + Animal.getTotalAnimalCount());
        System.out.println("Собак: " + Animal.getDogCount());
        System.out.println("Котов: " + Animal.getCatCount());
        System.out.println("Еды в миске осталось: " + bowl.getFoodAmount());
    }
}


