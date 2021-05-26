class Problem {
    public static void main(String[] args) {

        String param1 = args[0];
        String param2 = args[1];
        String param3 = args[2];
        String param4 = args[3];

        if (param1.equals("mode")){
            System.out.println(param2);
        } else if (param3.equals("mode")) {
            System.out.println(param4);
        } else {
            System.out.println("default");
        }

    }
}