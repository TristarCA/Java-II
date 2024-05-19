package Assignment1.CodingQuestions;

public class WeightConverter {
    public double poundsToKilos(double pounds) {
        assert (pounds > 0) : "pounds must be non-negative";
        return pounds * 0.45359237;
    }

    public double kilosToPounds(double kilos) {
        assert (kilos > 0) : "kilos must be non-negative";
        return kilos * 2.20462262;
    }

    public static void main(String[] args) {
        WeightConverter converter = new WeightConverter();
        System.out.println("Converting 2 pounds to kilograms: " + converter.poundsToKilos(2));
        System.out.println("Converting 4 kilograms to pounds: " + converter.kilosToPounds(4));
        System.out.println("Converting -1 kilogram to pounds: " + converter.kilosToPounds(-1));
        System.out.println("Converting -2 kilograms to pounds: " + converter.poundsToKilos(-2));
    }
}
