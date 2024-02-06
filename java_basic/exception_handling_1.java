class fff
{
    public static void main(String[] args) {
        try {
            if (args.length < 3) 
            {
                throw new IllegalArgumentException("Insufficient arguments. Usage: java ExpressionCalculator A B C");
            }
            double A = Double.parseDouble(args[0]);
            double B = Double.parseDouble(args[1]);
            double C = Double.parseDouble(args[2]);
            int sizeOfArg = args.length;
            double F = (A + B) - C / sizeOfArg;
            System.out.println("The result of the expression F = (A + B) - C / (size of the array arg) is: " + F);
        } catch (Exception e) 
        {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
