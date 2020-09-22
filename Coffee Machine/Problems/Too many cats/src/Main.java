class Cat {
    String name;
    int age;
    static int counter;


    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        counter++;
        if (Cat.getNumberOfCats() > 5) {
            System.out.println("You have too many cats");
        }
    }

    public static int getNumberOfCats() {
        return counter;
    }
}