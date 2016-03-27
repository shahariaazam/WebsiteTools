package WebsiteTools;

import UtilLibraries.MxRecords;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.InitialDirContext;
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
            MxRecords MxRecordset;
            MxRecordset = new MxRecords();
            FinalResult = "=================== \n" +
                    "IP Address " + WebsiteURL.getText() + ": " + address + "\n \n" +
                    "======================== \n"+
                    "MX Records: "+ MxRecordset.getMx(WebsiteURL.getText());

        } catch (UnknownHostException e) {
            FinalResult = "Something wrong! Please try again later.";
        }

        ResultOutput.setText(FinalResult);
    }
}