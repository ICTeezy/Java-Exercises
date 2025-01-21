public class Exercise_6_9 {

    public static double footToMeter(double foot) {
        return 0.305 * foot;
    }

    public static double meterToFoot(double meter) {
        return 3.279 * meter;
    }

    public static void main( String[] args ) {

        System.out.println("Feet -> Meters");
        for (int i = 1; i <= 10; i++) {
            System.out.println((double) i + " - " + footToMeter(i));
        }

        System.out.println();

        System.out.println("Meters -> Feet");
        for (int i = 20; i <= 65; i += 5) {
            System.out.println((double) i + " - " + meterToFoot(i));
        }

    }

}