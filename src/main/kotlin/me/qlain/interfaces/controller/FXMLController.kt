package me.qlain.interfaces.controller

import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.text.Text
import me.qlain.infrastructure.repositoryimpl.RuntimeRepositoryImpl
import java.net.URL
import java.util.*

class FXMLController: Initializable {

    @FXML
    private lateinit var text: Text

    /**
     * ウィンドウ内のテキストを非同期で取得・更新します。
     * settings.jsonから設定を変更できます。
     */
    override fun initialize(location: URL?, resources: ResourceBundle?) {
        RuntimeRepositoryImpl().let {
            text.textProperty().bind(it.valueProperty())
            Thread(it).start()
        }
    }
}