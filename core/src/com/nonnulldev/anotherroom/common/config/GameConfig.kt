package com.nonnulldev.anotherroom.common.config

class GameConfig private constructor(){

    companion object {
        val WIDTH = 800 // pixels
        val HEIGHT = 480 // pixels

        val WORLD_WIDTH = 21f // world units
        val WORLD_HEIGHT = 21f // world units

        val WORLD_CENTER_X = WORLD_WIDTH / 2f // world units
        val WORLD_CENTER_Y = WORLD_HEIGHT / 2f // world units

        val ROOM_CREATION_ATTEMPTS = 1000
        val REGION_MERGING_ATTEMPTS = 1000

        val WALL_SIZE = 1f
        val PATH_SIZE = 1f

        val ROOM_TO_EDGE_OF_MAP_BUFFER = (WALL_SIZE ) + PATH_SIZE

        val DOOR_SIZE = 1f
        val PLAYER_SIZE = 0.3f
        val PLAYER_ZOOM = 0.3f
        val PLAYER_SPEED = 50f
        val MAX_VELOCITY = 10f

        val DEFAULT_REFRESH_RATE = 60f
        val DEFAULT_LINEAR_DAMPENING = 8f

        val TILE_SIZE = 1f
        val PLAYER_DENSITY = 50f
    }
}
