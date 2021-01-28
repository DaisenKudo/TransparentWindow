package me.qlain.infrastructure

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage
import javafx.stage.StageStyle

/**
 * ウィンドウ内のコンポーネントに変更を加えて表示させます。
 */
class MainApp : Application() {
    private var xOffset = 0.0
    private var yOffset = 0.0
    private var isWindowMovable = true

    override fun start(primaryStage: Stage) {
        val root: Parent = FXMLLoader.load(javaClass.getResource("scene.fxml"))

        primaryStage.apply {
            this.scene = Scene(root).apply {
                stylesheets.add(MainApp::class.java.getResource("styles.css").toExternalForm())
                fill = null
            }

            initStyle(StageStyle.TRANSPARENT)
            show()
        }

        root.apply {
            setOnMousePressed { event ->
                when (event.button.name) {
                    "PRIMARY" -> {
                        xOffset = event.sceneX
                        yOffset = event.sceneY
                    }
                    "SECONDARY" -> {
                        isWindowMovable = !isWindowMovable
                    }
                }
            }
            setOnMouseDragged { event ->
                if (isWindowMovable) {
                    primaryStage.x = event.screenX - xOffset
                    primaryStage.y = event.screenY - yOffset
                }
            }
        }
    }
}