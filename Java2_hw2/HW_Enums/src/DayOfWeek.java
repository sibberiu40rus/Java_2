public enum DayOfWeek {
    //понимаю, что можно было им вообще значения не присваивать, но так показалось слишком просто.
    MONDAY("Понедельник", 0), TUESDAY("Вторник", 8), WEDNESDAY("Среда", 16), THURSDAY("Четверг", 24),
    FRIDAY("Пятница", 32), SATURDAY("Суббота", 40), SUNDAY("Воскресенье", 40), HoursInWeek("Количество часов", 40);

    private final int hoursInDay;
    private final String name;

    DayOfWeek(String name, int hoursInDay) {
        this.name = name;
        this.hoursInDay = hoursInDay;
    }

    public int getHoursInDay() {
        return hoursInDay;
    }

    public String getName() {
        return name;
    }
}
