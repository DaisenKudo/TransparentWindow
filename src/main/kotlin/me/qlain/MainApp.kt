package me.qlain

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.paint.Paint
import javafx.stage.Stage
import javafx.stage.StageStyle

class MainApp : Application() {
    private var xOffset = 0.0
    private var yOffset = 0.0

    override fun start(primaryStage: Stage) {
        val root: Parent = FXMLLoader.load(javaClass.getResource("scene.fxml"))

        val scene = Scene(root)
        primaryStage.apply {
            this.scene = scene
            initStyle(StageStyle.TRANSPARENT)
            scene.stylesheets.add(MainApp::class.java.getResource("styles.css").toExternalForm())
            scene.fill = null
            show()
        }

        root.apply {
            setOnMousePressed { event ->
                xOffset = event.sceneX
                yOffset = event.sceneY
            }
            setOnMouseDragged { event ->
                primaryStage.x = event.screenX - xOffset
                primaryStage.y = event.screenY - yOffset
            }
        }
    }
}