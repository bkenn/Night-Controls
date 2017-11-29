package us.nightware.controls

import javafx.event.EventTarget
import javafx.scene.Node
import javafx.scene.layout.VBox
import tornadofx.*
import us.nightware.controls.card.Card
import us.nightware.controls.card.CardHolder
import kotlin.reflect.KClass

fun EventTarget.cardholder(op: (VBox.() -> Unit) = {}) : CardHolder {
    val cardHolder = CardHolder()
    val vb = vbox {
        paddingBottom = 100
        paddingHorizontal = 25
        paddingTop = 25
    }
    op.invoke(vb)
    cardHolder.add(vb)
    return opcr(this,cardHolder)
}

fun EventTarget.card(op: (Card.() -> Unit) = {}) : Card {
    val card = Card()
    return opcr(this, card ,op)
}

fun <T: UIComponent> EventTarget.card(uiComponent: T, op: (Card.() -> Unit) = {}): Card {
    val card = Card()
    card.add(uiComponent.root)
    return opcr(this, card ,op)
}

fun EventTarget.card(uiComponent: KClass<out UIComponent>, op: (Card.() -> Unit) = {}) = card(find(uiComponent), op)