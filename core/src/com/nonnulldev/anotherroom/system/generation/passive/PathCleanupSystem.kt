package com.nonnulldev.anotherroom.system.generation.passive

import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.EntitySystem
import com.nonnulldev.anotherroom.config.GameConfig
import com.nonnulldev.anotherroom.data.*
import com.nonnulldev.anotherroom.enum.DungeonTileTypes
import com.nonnulldev.anotherroom.types.loop

class PathCleanupSystem(private val dungeon: Dungeon) : EntitySystem() {

    override fun checkProcessing(): Boolean {
        return false
    }

    override fun addedToEngine(engine: Engine?) {
        dungeon.grid.loop{ coordinates ->
            val tile = dungeon.grid.get(coordinates)
            if (tile.type == DungeonTileTypes.Path && isDeadEnd(coordinates)) {
                removePath(coordinates)
            }
        }
    }

    private fun isDeadEnd(coordinates: Coordinates): Boolean {
        return sequenceOf(coordinates.north(), coordinates.south(), coordinates.east(), coordinates.west())
                .map { dungeon.grid.get(it) }
                .count { it.type == DungeonTileTypes.Path || it.type == DungeonTileTypes.Door } <= 1
    }

    private fun removePath(coordinates: Coordinates) {

        if (coordinates.x < GameConfig.WALL_SIZE || coordinates.x >= GameConfig.WORLD_WIDTH - GameConfig.WALL_SIZE)
            return

        if (coordinates.y < GameConfig.WALL_SIZE || coordinates.y >= GameConfig.WORLD_HEIGHT - GameConfig.WALL_SIZE)
            return

        val dungeonTile = dungeon.grid.get(coordinates)

        if (dungeonTile.type != DungeonTileTypes.Path || !isDeadEnd(coordinates)) {
            return
        }

        dungeonTile.regionId = 0
        dungeonTile.type = DungeonTileTypes.Earth

        sequenceOf(coordinates.north(), coordinates.south(), coordinates.east(), coordinates.west())
                .forEach { removePath(it) }
    }
}