import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PyramidBuilder {
    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(1, 6, 7, 4, 2, 3);
        int size = A.size();
//Проверка: можно ли из элементов предложенного листа сделать пирамиду
        int columns = 1;
        int rows = 1;
        int quantity = 0;
        while (quantity < size) {
            quantity = quantity + rows;
            rows++;
            columns = columns + 2;
        }
//Количество строк и столюцов, которое будет в пирамиде
        rows = rows - 1;
        columns = columns - 2;
        if (quantity == size) {
            constraction(A, rows, columns);
        } else System.out.println("The Pyramid cannot be built");
    }

    public static void constraction(List<Integer> A, int rows, int columns) {
        //Сортируем элементы списка по возрастанию
        List<Integer> sortedA = A.stream().sorted().collect(Collectors.toList());
        //Создаем матрицу, в которой мы будем строить пирамиду, и заполняем её нулями
        int[][] pyramid = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                pyramid[i][j] = 0;
            }
        }
        //Находим место, откуда начнется заполнение пирамиды
        int center = (columns / 2);
        //Задаем начальное количество элементов в первой строке
        int count = 1;
        //Задаем начальный сдвиг от центра
        int offset = 0;
//Задаем индекс первого элемента списка
        int listIndex = 0;
        for (int i = 0; i < rows; i++) {
            int start = center - offset;
            for (int j = 0; j < count * 2; j += 2) {
                pyramid[i][start + j] = sortedA.get(listIndex);
                listIndex++;
            }
            offset++;
            count++;
        }
        //Вывод пирамиды
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(pyramid[i][j]);
            }
            System.out.println("");
        }
    }

}
