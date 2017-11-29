package us.nightware.controls.card

import javafx.geometry.Pos
import tornadofx.*
import us.nightware.controls.DepthManager

class CardStyles: Stylesheet() {

    companion object {
        val card                by cssclass()
        val cardHolder          by cssclass()
        val defaultBgColor      = c("#f9f9f9")
        val defaultBorderColor  = c("#c9c4c4")
    }

    init {
        card {
            alignment = Pos.CENTER
            backgroundColor += defaultBgColor
            borderColor = multi(box(defaultBorderColor))
            fillWidth = true
            effect = DepthManager.depth[1]
            and(hover) {
                effect = DepthManager.depth[3]
            }
        }
        cardHolder {
            fitToHeight = true
            fitToWidth = true
            scrollBar {
                and(vertical) {
                    unitIncrement = 20.px
                    blockIncrement = 20.px
                }
            }
        }
    }
}