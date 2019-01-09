public class DayOfWeekMain {
    public static void main(final String[] args) {
        getWorkingHours(DayOfWeek.SATURDAY);
    }

    //наверно это слишком простой вариант решения

    public static void getWorkingHours (DayOfWeek dayOfWeek) {
        switch (dayOfWeek) {
            case MONDAY:
                System.out.print(DayOfWeek.MONDAY.getName() + ", осталось работать: ");
                System.out.print(DayOfWeek.HoursInWeek.getHoursInDay() - DayOfWeek.MONDAY.getHoursInDay() + " часов");
                break;
            case TUESDAY:
                System.out.print(DayOfWeek.TUESDAY.getName() + ", осталось работать: ");
                System.out.print(DayOfWeek.HoursInWeek.getHoursInDay() - DayOfWeek.TUESDAY.getHoursInDay() + " часа");
                break;
            case WEDNESDAY:
                System.out.print(DayOfWeek.WEDNESDAY.getName() + ", осталось работать: ");
                System.out.print(DayOfWeek.HoursInWeek.getHoursInDay() - DayOfWeek.WEDNESDAY.getHoursInDay() + " часа");
                break;
            case THURSDAY:
                System.out.print(DayOfWeek.THURSDAY.getName() + ", осталось работать: ");
                System.out.print(DayOfWeek.HoursInWeek.getHoursInDay() - DayOfWeek.THURSDAY.getHoursInDay() + " часов");
                break;
            case FRIDAY:
                System.out.print(DayOfWeek.FRIDAY.getName() + ", осталось работать, всего: ");
                System.out.print(DayOfWeek.HoursInWeek.getHoursInDay() - DayOfWeek.FRIDAY.getHoursInDay() + " часов");
                break;
            case SATURDAY:
                System.out.print(DayOfWeek.SATURDAY.getName() + ", сегодня выходной!");
                break;
            case SUNDAY:
                System.out.print(DayOfWeek.SUNDAY.getName() + ", сегоня выходной, но завтра на работу");
                break;
        }
    }
}
