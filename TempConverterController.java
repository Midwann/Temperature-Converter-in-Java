
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TempConverterController {
	private final TempConverterView tempConverterView;
	private final TemperatureScaleModel temperatureScaleModel;

	public TempConverterController(TempConverterView tempConverterView, TemperatureScaleModel temperatureScaleModel) {
		this.tempConverterView = tempConverterView;
		this.temperatureScaleModel = temperatureScaleModel;


		this.tempConverterView.setConvertBtnActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String scale = (String)tempConverterView.fromComboBox.getSelectedItem();
				double value = tempConverterView.getValueToconvert();
				double result = temperatureScaleModel.convertTemperature(scale, value);
				tempConverterView.setConvertedValue(result);
			}
		});
	}


}