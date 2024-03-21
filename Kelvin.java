
public class Kelvin extends TemperatureScale implements TempConverter {
    
    public Kelvin() {
        super("K");
    }

    /**
     * 
     * Convert a Kelvin Temperature Value to Celsius
     * @param value
     * @return
     */
    @Override
    public double convert(double value) {
        return value - 273.15;
    }
    
}
