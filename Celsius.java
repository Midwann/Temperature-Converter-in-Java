
public class Celsius extends TemperatureScale implements TempConverter {
	
	public Celsius() {
		super("C");
	}

	/**
	 *
	 * Convert a Celsius Temperature Value to Fahrenheit
	 * @param value
	 * @return
	 */
	@Override
	public double convert(double value) {
		return ((value * 1.8) + 32);
	}
	
}
