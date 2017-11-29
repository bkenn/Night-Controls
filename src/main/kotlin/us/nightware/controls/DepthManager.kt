package us.nightware.controls

import javafx.scene.Node
import javafx.scene.effect.BlurType
import javafx.scene.effect.DropShadow
import javafx.scene.paint.Color

/**
 * Taken from Jfoenix package com.jfoenix.effects
 */
object DepthManager {

    val depth = listOf(
            DropShadow(BlurType.GAUSSIAN, Color.rgb(0, 0, 0, 0.0), 0.0, 0.0, 0.0, 0.0),
            DropShadow(BlurType.GAUSSIAN, Color.rgb(0, 0, 0, 0.26), 10.0, 0.12, -1.0, 2.0),
            DropShadow(BlurType.GAUSSIAN, Color.rgb(0, 0, 0, 0.26), 15.0, 0.16, 0.0, 4.0),
            DropShadow(BlurType.GAUSSIAN, Color.rgb(0, 0, 0, 0.26), 20.0, 0.19, 0.0, 6.0),
            DropShadow(BlurType.GAUSSIAN, Color.rgb(0, 0, 0, 0.26), 25.0, 0.25, 0.0, 8.0),
            DropShadow(BlurType.GAUSSIAN, Color.rgb(0, 0, 0, 0.26), 30.0, 0.30, 0.0, 10.0))

    /**
     * this method will generate a new container node that prevent
     * control transformation to be applied to the shadow effect
     * (which makes it looks as a real shadow)
     */

    fun setDepth(control: Node, lvl: Int) {
        var level = lvl
        level = if (level < 0) 0 else level
        level = if (level > 5) 5 else level
        control.effect = DropShadow(BlurType.GAUSSIAN,
                depth[level].color,
                depth[level].radius,
                depth[level].spread,
                depth[level].offsetX,
                depth[level].offsetY)
    }

    fun pop(control: Node) {
        control.effect = DropShadow(BlurType.GAUSSIAN, Color.rgb(0, 0, 0, 0.26), 5.0, 0.05, 0.0, 1.0)
    }

}