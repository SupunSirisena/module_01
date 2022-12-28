import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.util.Observable;

public class LoginFromController {
    public TextField txtUsername;
    public PasswordField txtPassword;
    public CheckBox cbRemember;
    public RadioButton rbUser;
    public RadioButton rbAdmin;
    public ComboBox<String> cmbLanguage;
    public TextField txtLanguage;
    public void initialize(){
        ObservableList<String> obList = FXCollections.observableArrayList();
        obList.addAll("Java","Php","Ruby");
        cmbLanguage.setItems(obList);
    }

    public void btnLoginOnAction(ActionEvent actionEvent) {
        System.out.println(txtUsername.getText());
        System.out.println(txtPassword.getText());
        System.out.println(cbRemember.isSelected()?"Remember me":"not Remember me");
        System.out.println(rbUser.isSelected()?"User selected":"Admin selected");
        //cmbLanguage.getItems().add(txtLanguage.getText());

        if (!isExits(txtLanguage.getText())){
            cmbLanguage.getItems().add(txtLanguage.getText());
        }
        else {
            new Alert(Alert.AlertType.WARNING,"Already Exits!").show();
        }

        txtLanguage.clear();
    }

    private boolean isExits(String Language){
        for (String temp:cmbLanguage.getItems()
             ) {
                    if (temp.equals(Language)) return true;
        }
        return false;
    }
}

