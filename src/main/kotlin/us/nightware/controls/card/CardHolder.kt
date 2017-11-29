package us.nightware.controls.card

import javafx.scene.Node
import javafx.scene.control.ScrollPane
import tornadofx.*

class CardHolder: ScrollPane() {

    /**************************************************
     *              Initialization
     *************************************************/

    init {
        initGraphics()
        registerListeners()
    }

    private fun initGraphics() {
        styleClass.add("card-holder")
    }

    private fun registerListeners() {
        setOnScroll { evt ->
            val deltaY  = evt.deltaY * 100
            val width   = content.boundsInLocal.height
            val vv      = vvalue
            vvalue      = (vv + - deltaY / width)
        }
    }

    /**************************************************
     *              Public Functions
     *************************************************/

    /**
     * The holder should only contain one child. Which is a VBox.
     * Use this in order to add new children programmatically.
     * @param node Node
     * @return Unit
     */
    operator fun plus(node: Node) = children[0].add(node)

    /**
     * The holder should only contain one child. Which is a VBox.
     * Use this in order to add new children programmatically.
     * @param node Node
     * @return Unit
     */
    fun add(node: Node) = plus(node)

    override fun getUserAgentStylesheet(): String = CardStyles().base64URL.toExternalForm()
}
