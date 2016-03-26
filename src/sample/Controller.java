package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Controller {
    @FXML
    private Button AnalyzeBtn;
    @FXML
    private TextField WebsiteURL;
    @FXML
    private TextArea ResultOutput;

    String FinalResult;

    @FXML
    protected void startA(ActionEvent event) {
        try {
            String address = InetAddress.getByName(WebsiteURL.getText()).getHostAddress();
            FinalResult = "IP Address " + WebsiteURL.getText() + ": " + address;
        } catch (UnknownHostException e) {
            FinalResult = "Something wrong! Please try again later.";
        }

        ResultOutput.setText(FinalResult);
    }
}