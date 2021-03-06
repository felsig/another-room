package com.nonnulldev.anotherroom.common.extension

import com.nonnulldev.anotherroom.common.config.GameConfig
import com.nonnulldev.anotherroom.common.data.Coordinates

fun Coordinates.areWithinWorldBounds(): Boolean {
    return (this.x > 0 && this.x <= GameConfig.WORLD_WIDTH - 2f) &&
            (this.y > 0 && this.y <= GameConfig.WORLD_HEIGHT -2f)
}