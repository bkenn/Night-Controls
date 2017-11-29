package us.nightware.controls

import javafx.event.EventTarget
import javafx.scene.layout.VBox
import tornadofx.*
import us.nightware.controls.card.Card
import us.nightware.controls.card.CardHolder

fun EventTarget.cardholder(op: (VBox.() -> Unit)? = null) : CardHolder {
    val cardHolder = CardHolder()
    val vb = vbox {
        paddingBottom = 100
        paddingHorizontal = 25
        paddingTop = 25
    }
    op?.invoke(vb)
    cardHolder.add(vb)
    return opcr(this,cardHolder)
}

fun EventTarget.card(op: (Card.() -> Unit)? = null) : Card {
    val card = Card()
    return opcr(this, card ,op)
}
