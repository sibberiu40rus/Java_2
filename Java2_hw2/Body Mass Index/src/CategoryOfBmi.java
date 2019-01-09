public enum CategoryOfBmi {
    Underweight("недостаточная масса", 18.5, "under"), NormalWeight("норма", 25.0 , "normal"),
    Overweight("избыточная масса", 30.0, "over"), Obesity("ожирение", "obese");


    private String name;
    private double index;
    private String category;


    CategoryOfBmi (String name, double index, String category) {
        this.name = name;
        this.index = index;
        this.category = category;

    }
    CategoryOfBmi(String name, String category) {
        this.name = name;
        this.category = category;

    }

    public String getName() {
        return name;
    }

    public double getIndex() {
        return index;
    }

    public String getCategory() {
        return category;
    }
}