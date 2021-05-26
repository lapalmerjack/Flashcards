class Problem {
    public static void main(String[] args) {


        int a = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        String result;

        result = args[0].equals("+") ? String.valueOf(a + b) :
                args[0].equals("-") ? String.valueOf(a - b) :
                        args[0].equals("*") ? String.valueOf(a * b) :
                                "Unknown operator";

        System.out.println(result);
    }
}