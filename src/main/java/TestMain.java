import java.util.ArrayList;
import java.util.List;

public class TestMain {

    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        String stringList = new String();
        stringList = String.join(",",integerList.toString());
        System.out.println(stringList);
    }


}
