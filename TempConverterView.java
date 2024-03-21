import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

public class TempConverterView {
	private final TemperatureScaleModel model;
	private final JFrame mainFrame;
	private final JLabel toLbl;
	private final JTextField valueTf;
	private final JTextField conversionTf;
	private final JButton convertBtn;
	private final JTextArea messageTextArea;
	final JComboBox fromComboBox;
	private final String scale[]={"Celsius","Fahrenheit","Kelvin"};

	public TempConverterView() {
		this.mainFrame = new JFrame("Temp Converter GUI");
        this.model = new TemperatureScaleModel(); 

		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.mainFrame.setSize(250, 400);

		this.fromComboBox = new JComboBox(this.scale);
		this.toLbl = new JLabel("Fahrenheit ");

		this.messageTextArea = new JTextArea(" ");
		this.messageTextArea.setPreferredSize(new Dimension(220, 170));
		this.messageTextArea.setEditable(false);

		this.valueTf = new JTextField();
		this.valueTf.setColumns(10);
		this.conversionTf = new JTextField();
		this.conversionTf.setColumns(10);
		//this.conversionTf.setEnabled(false);

		/*
			Listen to changes in combobox and adapt accordingly
		*/
		this.fromComboBox.addActionListener(new FromComboBoxListener(fromComboBox, toLbl, conversionTf));

		this.convertBtn = new JButton("Convert");
		this.convertBtn.setPreferredSize(new Dimension(220, 30));

		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.add(this.fromComboBox);
		panel.add(this.valueTf);
		panel.setPreferredSize(new Dimension(220, 30));
		this.mainFrame.add(panel);

		panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.add(this.toLbl);
		panel.add(this.conversionTf);
		panel.setPreferredSize(new Dimension(220, 30));
		this.mainFrame.add(panel);

		this.mainFrame.add(convertBtn);
		this.mainFrame.add(messageTextArea);

		this.mainFrame.setVisible(true);

	}

	public void setMessageText(String text) {
		this.messageTextArea.setText(text);
	}

    public void setConvertBtnActionListener(ActionListener actionListener) {
        this.convertBtn.addActionListener(new ActionListener() {
         
            public void actionPerformed(ActionEvent e) {
                try {
                    double value = getValueToconvert();
                    String scale = (String) fromComboBox.getSelectedItem();
                    double convertedValue = model.convertTemperature(scale, value); 
                    setConvertedValue(convertedValue);

                    setMessageText("");
                } catch (NumberFormatException ex) {
                    setMessageText("Wrong number format. Please enter the number correctly!");
                } catch (IllegalArgumentException ex) {
                    setMessageText("This temperature scale is not supported.");
                }
            }
        });
    }

    public double getValueToconvert() throws NumberFormatException {
        try {
            double value = Double.parseDouble(this.valueTf.getText());
            return value;
        } catch (NumberFormatException e) {
            throw e;
        }
    }

	public void setConvertedValue(double value) {
		this.conversionTf.setText(String.format("%.2f",value));
	}
	/*
	*****************************************************
		Implement the ActionListener as an Inner Class
	*****************************************************
	*/
	private class FromComboBoxListener implements ActionListener {
		private final JComboBox cb;
		private final JLabel label;
		private final JTextField result;

		public FromComboBoxListener(JComboBox cb, JLabel label, JTextField result ) {
			this.cb = cb;
			this.label = label;
			this.result = result;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
            String scale = (String)cb.getSelectedItem();
            if (scale.equals("Celsius")) {
                label.setText("Fahrenheit");

            } else if (scale.equals("Fahrenheit")) {
                label.setText("Celsius");

            } else if (scale.equals("Kelvin")){
                label.setText("Celsius");
            }
            result.setText("");
        }
	}


}