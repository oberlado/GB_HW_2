package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.DataOutputStream;
import java.io.IOException;

public class PersonalController {
	@FXML
	TextArea textArea;

	@FXML
	Button btn;

	public void btnClick() {
		if (!((MiniStage) btn.getScene().getWindow()).parentList.contains(textArea)) {
			((MiniStage) btn.getScene().getWindow()).parentList.add(textArea);
			System.out.println("1");
		}
		DataOutputStream out = ((MiniStage) btn.getScene().getWindow()).out;
		String nickTo = ((MiniStage) btn.getScene().getWindow()).nickTo;
		try {
			out.writeUTF("@" + nickTo + " " + textArea.getText());
		} catch (IOException e) {
			e.printStackTrace();
		}


		// get a handle to the stage
		Stage stage = (Stage) btn.getScene().getWindow();
		// do what you have to do
		stage.close();
	}
}