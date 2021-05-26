import java.util.*;

class SetUtils {

    public static Set<Integer> getSetFromString(String str) {
        Set<Integer> list = new HashSet<>();
        String [] parts = str.split(" ");
        for(int i = 0; i < parts.length; i++ ) {
            list.add(Integer.valueOf(parts[i]));
        }

        return list;
    }

    public static void removeAllNumbersGreaterThan10(Set<Integer> set) {
      set.removeIf(s -> s > 10);
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        Set<Integer> set = SetUtils.getSetFromString(numbers);
        SetUtils.removeAllNumbersGreaterThan10(set);
        set.forEach(e -> System.out.print(e + " "));
    }
}