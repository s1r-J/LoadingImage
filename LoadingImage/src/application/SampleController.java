package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SampleController {

	@FXML
	private ImageView image;

	@FXML
	public void onClickButton(ActionEvent event) {

		// set loading image
		this.image.setImage(new Image(getClass().getResourceAsStream("/images/loader.gif")));

		Thread t = new Thread(() -> {
			try {
				// wait 3 seconds
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			Platform.runLater(() -> {
				// after finishing some processes
				// set result image
				this.image.setImage(new Image(getClass().getResourceAsStream("/images/maru.png")));
			});
		});

		t.setDaemon(true);
		t.start();
	}
}
