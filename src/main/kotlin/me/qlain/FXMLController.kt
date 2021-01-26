package me.qlain

import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.text.Text
import java.net.URL
import java.util.*

class FXMLController: Initializable {

    @FXML
    private lateinit var text: Text

    /**
     * テキストの取得
     */
    override fun initialize(location: URL?, resources: ResourceBundle?) {
        val task = RefreshTask()

        text.textProperty().bind(task.valueProperty())
        Thread(task).start()
    }
}