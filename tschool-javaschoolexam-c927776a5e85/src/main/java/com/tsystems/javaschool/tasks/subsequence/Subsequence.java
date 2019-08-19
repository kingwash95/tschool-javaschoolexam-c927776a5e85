import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Subsequence {
    public static void main(String[] args) {
        List<Object> X = Arrays.asList("A", "B", "C", "D");
        List<Object> Y = Arrays.asList("BD", "A", "ABC", "B", "M", "D", "M", "C", "DC", "D");
        System.out.println(comparison(X, Y));
    }


    public static boolean comparison(List<Object> X, List<Object> Y) {
        int XIdx = 0;
        int YIdx = 0;
        while (XIdx < X.size()) {
            Object XElem = X.get(XIdx);
            Object YElem = Y.get(YIdx);
            while (!XElem.equals(YElem)) {
                if (++YIdx > Y.size() - 1) {
                    return false;
                }
                YElem = Y.get(YIdx);
            }
            XIdx++;
        }
        return true;
    }
}
