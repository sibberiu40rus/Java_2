import java.util.ArrayList;

public class BMI {
    public static void main(String[] args) {
        //объвляем переменную индекса массы тела
        double bmi;

        String arrays = (
                        "118 2.05\n" +
                        "106 1.77\n" +
                        "87 1.83\n" +
                        "45 1.12\n" +
                        "70 1.87\n" +
                        "54 1.57\n" +
                        "105 1.76\n" +
                        "50 1.96\n" +
                        "114 1.76\n" +
                        "72 2.45\n" +
                        "53 2.10\n" +
                        "66 2.25\n" +
                        "54 1.50\n" +
                        "95 1.62\n" +
                        "86 1.72\n" +
                        "62 1.57\n" +
                        "65 2.24\n" +
                        "72 1.43\n" +
                        "93 2.01\n" +
                        "109 3.01\n" +
                        "106 2.97\n" +
                        "77 1.69\n" +
                        "114 2.09\n" +
                        "98 1.72\n" +
                        "85 2.46\n" +
                        "113 1.94\n" +
                        "53 1.77\n" +
                        "106 2.30");

        //разбиваем строку на массив строк

        String[] s = arrays.split(" |\n");

        //Создаем два списочных массива
        ArrayList<Double> weight_1 = new ArrayList<>();
        ArrayList<Double> growth_1 = new ArrayList<>();


        //разбиваем массив имеющихся значений на два списочных массива (вес и рост)
        for (int i = 0; i < s.length; i++) {
            double weight;
            double growth;
            if (i % 2 == 0) {
                weight = Double.parseDouble(s[i]);
                weight_1.add(weight);
            } else {
                growth = Double.parseDouble(s[i]);
                growth_1.add(growth);
            }

        }

        //вычисляем индекс массы тела и выводим информацию в консоль
        for (int i = 0; i < weight_1.size(); i++) {
            bmi = weight_1.get(i) / (growth_1.get(i) * growth_1.get(i));
            if (bmi < CategoryOfBmi.Underweight.getIndex()) {
                System.out.println("weight equals " + weight_1.get(i) + "; growth equals " + growth_1.get(i) + "; BMI equals " +
                        Math.floor(bmi) + " is " + CategoryOfBmi.Underweight.getCategory() + "; " + "(" + CategoryOfBmi.Underweight.getName() + ")");
            }
            if (bmi >= CategoryOfBmi.Underweight.getIndex() && bmi < CategoryOfBmi.NormalWeight.getIndex()) {
                System.out.println("weight equals " + weight_1.get(i) + "; growth equals " + growth_1.get(i) + "; BMI equals " +
                        Math.floor(bmi) + " is " + CategoryOfBmi.NormalWeight.getCategory() + "; " + "(" + CategoryOfBmi.NormalWeight.getName() + ")");
            }
            if (bmi >= CategoryOfBmi.NormalWeight.getIndex() && bmi < CategoryOfBmi.Overweight.getIndex()) {
                System.out.println("weight equals " + weight_1.get(i) + "; growth equals " + growth_1.get(i) + "; BMI equals " +
                        Math.floor(bmi) + " is " + CategoryOfBmi.Overweight.getCategory() + "; " + "(" + CategoryOfBmi.Overweight.getName() + ")");
            }
            if (bmi >= CategoryOfBmi.Overweight.getIndex()) {
                System.out.println("weight equals " + weight_1.get(i) + "; growth equals " + growth_1.get(i) + "; BMI equals " +
                        Math.floor(bmi) + " is " + CategoryOfBmi.Obesity.getCategory() + "; " + "(" + CategoryOfBmi.Obesity.getName() + ")");
            }
        }

    }
}
