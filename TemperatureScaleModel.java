public class TemperatureScaleModel {
    private final Celsius celsius;
    private final Fahrenheit fahrenheit;
    private final Kelvin kelvin;

    public TemperatureScaleModel() {
        this.celsius = new Celsius();
        this.fahrenheit = new Fahrenheit();
        this.kelvin = new Kelvin();
    }

    public double convertTemperature(String scale, double value) {
        double result = 0.0;
        try {
            if (scale.equals("Celsius")) {
                result = celsius.convert(value);

            } else if (scale.equals("Fahrenheit")) {
                result = fahrenheit.convert(value);

            } else if (scale.equals("Kelvin")) {
                result = kelvin.convert(value);

            } else {
                throw new IllegalArgumentException("Unsupported scale: " + scale);
            }
            
        } catch (NumberFormatException e) {
            System.err.println("Invalid input: " + e.getMessage());
        } finally {
            return result;
        }
    }
}
