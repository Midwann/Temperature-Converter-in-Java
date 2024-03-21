
public class Fahrenheit extends TemperatureScale implements TempConverter {
	
	public Fahrenheit() {
		super("F");
	}

	/**
	 *
	 * Convert a Fahrenheit Temperature Value to Celsius
	 * @param value
	 * @return
	 */
	@Override
	public double convert(double value) {
		return ((value-32)/1.8);
	}
	
}
