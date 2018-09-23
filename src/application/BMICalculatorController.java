package application;

import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class BMICalculatorController {

    @FXML
    private JFXTextField weightInput;

    @FXML
    private JFXTextField heightInput;

    @FXML
    private JFXTextField bmiOutput;

    @FXML
    private JFXTextField healthStatus;

    @FXML
    private Button buttonCalculate;

    @FXML
    private Text close;
    
    @FXML
    private ImageView imageInput;

    @FXML
    void calculate(ActionEvent event) {
    	this.bmiOutput.clear();
    	this.healthStatus.clear();
    	if(!this.weightInput.getText().isEmpty() && !this.heightInput.getText().isEmpty()) {
    	Double weightValue= Double.parseDouble(this.weightInput.getText());
    	Double heightValue=Double.parseDouble(this.heightInput.getText());
    	Double heightInMetres=heightValue/100;
    	Double bmiValue= weightValue/(heightInMetres*heightInMetres);
    	this.weightInput.clear();
    	this.heightInput.clear();
    	setResult(bmiValue);
    	}

    }

    private void setResult(Double bmiValue) {
    	
    	this.bmiOutput.setText(bmiValue.toString());
    	if(bmiValue<=18.5) {
    		Image image=new Image("file:G:\\J2EEProjects\\FXML\\img\\underweight.jpg",500,300,true,true);
    		this.healthStatus.setText("UNDERWEIGHT");
    		this.imageInput.setImage(image);
    		centerImage();
    	}else if(bmiValue>25) {
    		this.healthStatus.setText("OVERWEIGHT");
       		Image image=new Image("file:G:\\J2EEProjects\\FXML\\img\\overweight.jpg",500,300,true,true);
       		this.imageInput.setImage(image);
       		
    	}else {
    		this.healthStatus.setText("NORMAL");
    		Image image=new Image("file:G:\\J2EEProjects\\FXML\\img\\normal.jpg",500,300,true,true);
    		this.imageInput.setImage(image);
    		
    	}

		
	}
    
    public void centerImage() {
        Image img = imageInput.getImage();
        if (img != null) {
            double w = 0;
            double h = 0;

            double ratioX = imageInput.getFitWidth() / img.getWidth();
            double ratioY = imageInput.getFitHeight() / img.getHeight();

            double reducCoeff = 0;
            if(ratioX >= ratioY) {
                reducCoeff = ratioY;
            } else {
                reducCoeff = ratioX;
            }

            w = img.getWidth() * reducCoeff;
            h = img.getHeight() * reducCoeff;

            imageInput.setX((imageInput.getFitWidth() - w) / 2);
            imageInput.setY((imageInput.getFitHeight() - h) / 2);

        }
    }

	@FXML
    void close(MouseEvent event) {
		System.exit(0);
    }

}
