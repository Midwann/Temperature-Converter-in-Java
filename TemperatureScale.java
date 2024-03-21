public abstract class TemperatureScale {
	private double value;
	private final String scale;

	public TemperatureScale(String scale) {
		this.scale = scale;
	}

	public double getValue() {
		return this.value;
	}

	public String getScale() {
		return this.scale;
	}

	public void setValue(double value) {
		this.value = value;
	}
}