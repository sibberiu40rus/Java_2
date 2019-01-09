

public class ArrayListMagnet {
    public static void main(String[] args) {

        //проверяем возможные варианты
        String[][] myArray = {
                {"18", "25", "32", "42"},
                {"53", "23", "71", "83"},
                {"93", "16", "11", "22"},
                {"12", "56", "22", "87"}};

        String[][] myArray_1 = {
                {"18", "25", "32", "42"},
                {"53", "23", "7a", "83"},
                {"93", "16", "11", "22"},
                {"12", "56", "22", "87"}};

        String[][] myArray_2 = {
                {"18", "25", "32", "42"},
                {"53", "22", "71", "83"},
                {"53", "22", "71", "83"},
                {"93", "16", "11", "22"},
                {"12", "56", "22", "87"}};



        try {
            System.out.println(summArrays(myArray));
        }catch (MyArraySizeException e){
            System.out.println(e.getMessage());
        }catch (MyArrayDataException e) {
            System.out.print(e.getMessage());
            System.out.println("{" + e.getSymbol() + "}" + " в ячейке: [" + e.getRow() + " " + e.getColumn() + "]");
        }

        try {
            System.out.println(summArrays(myArray_1));
        }catch (MyArraySizeException e){
            System.out.println(e.getMessage());
        }catch (MyArrayDataException e) {
            System.out.print(e.getMessage());
            System.out.println("{" + e.getSymbol() + "}" + " в ячейке: [" + e.getRow() + " " + e.getColumn() + "]");
        }

        try {
            System.out.println(summArrays(myArray_2));
        }catch (MyArraySizeException e){
            System.out.println(e.getMessage());
        }catch (MyArrayDataException e) {
            System.out.print(e.getMessage());
            System.out.println("{" + e.getSymbol() + "}" + " в ячейке: [" + e.getRow() + " " + e.getColumn() + "]");
        }



    }

    public static int summArrays(String[][] arr) throws MyArraySizeException, MyArrayDataException  {

        int summ = 0;
        boolean checkSymbol = true;

        //проверяем на границы массива

        if (arr.length > 4 || arr.length < 4)
            throw new MyArraySizeException("the size of the array doesn't match the set value");

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {

                //неуверен, что это самый правильный вариант, но лучше не придумал.
                //проверяем символ на возможность преобразование в число.

                if (arr[i][j] == null || arr[i][j].isEmpty()) checkSymbol = false;
                for (int e = 0; e < arr[i][j].length(); e++) {
                    if (!Character.isDigit(arr[i][j].charAt(e))) checkSymbol = false;
                }
                if (checkSymbol == false) throw new MyArrayDataException("Неверно введен символ: ", arr[i][j], i , j);


                int sum = Integer.parseInt(arr[i][j]);
                summ += sum;
            }
        }
        return summ;
    }


}

/**
 * Создаем исключение MyArraySizeException
 */
class MyArraySizeException extends Exception {
    public MyArraySizeException (String message) {
        super(message);
    }
}

/**
 * Создаем исключение MyArrayDataException
 */
class MyArrayDataException  extends NumberFormatException {
    private String symbol;
    private  int row;
    private  int column;

    public String getSymbol() {
        return symbol;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public MyArrayDataException (String message, String symbol, int row, int column) {
        super(message);
        this.symbol = symbol;
        this.row = row;
        this.column = column;
    }
}


