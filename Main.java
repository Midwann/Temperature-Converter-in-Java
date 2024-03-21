public class Main {
	public static void main(String[] args) {
		TempConverterView temperatureView = new TempConverterView();
		TemperatureScaleModel temperatureModel = new TemperatureScaleModel();

		TempConverterController employeeController = new TempConverterController(temperatureView, temperatureModel);
	}
}