package us.nightware.controls.card

import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleDoubleProperty
import javafx.geometry.Insets
import javafx.scene.layout.VBox
import javafx.util.Duration
import tornadofx.*
import us.nightware.controls.DepthManager

class Card: VBox() {

    companion object {
        /**
         * Global animation values for scaling when card is hovered.
         */
        val originProperty = SimpleDoubleProperty(1.0)
        var origin by originProperty

        val scaleOneProperty = SimpleDoubleProperty(1.001)
        var scaleOne by scaleOneProperty

        val scaleTwoProperty = SimpleDoubleProperty(1.001)
        var scaleTwo by scaleTwoProperty

        /**
         * Global flag for animation on cards
         */
        val globalAnimationProperty = SimpleBooleanProperty(true)
        var globalAnimation by globalAnimationProperty

    }

    /**
     * Flag for animation on an instance of a card
     */
    val animationProperty = SimpleBooleanProperty(true)
    var animation by animationProperty


    /**************************************************
     *              Initialization
     *************************************************/

    init {
        initGraphics()
        registerListeners()
    }

    private fun initGraphics() {
        styleClass.add("card")
        VBox.setMargin(this, Insets(20.0, 50.0, 0.0, 50.0))
        DepthManager.setDepth(this, 1)
    }

    private fun registerListeners() {
        hoverProperty().onChange { hovering ->
            if(globalAnimation && animation && hovering) {
                sequentialTransition {
                    timeline {
                        keyframe(Duration.ZERO) {
                            keyvalue(scaleXProperty(), origin)
                            keyvalue(scaleYProperty(), origin)
                        }
                    }
                    timeline {
                        keyframe(Duration(70.0)) {
                            keyvalue(scaleXProperty(), scaleOne)
                            keyvalue(scaleYProperty(), scaleTwo)
                        }
                    }
                }
            } else {
                sequentialTransition {
                    timeline {
                        keyframe(Duration.ZERO) {
                            keyvalue(scaleXProperty(), scaleOne)
                            keyvalue(scaleYProperty(), scaleTwo)

                        }
                        keyframe(Duration(70.0)) {
                            keyvalue(scaleXProperty(), origin)
                            keyvalue(scaleYProperty(), origin)
                        }
                    }
                }
            }
        }
    }

    override fun getUserAgentStylesheet(): String = CardStyles().base64URL.toExternalForm()

}
