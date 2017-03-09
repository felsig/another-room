package com.nonnulldev.anotherroom.component

import com.badlogic.ashley.core.Component
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.utils.Pool


class BoundsComponent : Component, Pool.Poolable {

    val rectangle = Rectangle(0f, 0f, 1f, 1f)

    override fun reset() {
        rectangle.setPosition(0f, 0f)
        rectangle.setSize(1f, 1f)
    }
}

