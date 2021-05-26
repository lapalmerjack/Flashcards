class Problem {
    public static void main(String[] args) {

        int number = -1;



        for(int i = 0; i < args.length; i++) {
            if(args[i].equals("test")) {
                number = i;
                break;
            }


        }



        System.out.println(number);
    }
}