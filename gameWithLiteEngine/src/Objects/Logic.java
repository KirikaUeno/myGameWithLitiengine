package Objects;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.entities.Spawnpoint;
import de.gurkenlabs.litiengine.graphics.Camera;
import de.gurkenlabs.litiengine.graphics.PositionLockCamera;

public class Logic {
    private Logic(){
    }

    public static void init() {
        // we'll use a camera in our game that is locked to the location of the player
        Camera camera = new PositionLockCamera(Player.instance());
        camera.setClampToMap(true);
        camera.setZoom(0.8f,0);
        Game.world().setCamera(camera);

        // set a basic gravity for all levels.
        Game.world().setGravity(0);

        // add default game logic for when a level was loaded
        Game.world().onLoaded(e -> {
            // spawn the player instance on the spawn point with the name "enter"
            Spawnpoint enter = e.getSpawnpoint("spawn");
            if (enter != null) {
                enter.spawn(Player.instance());
            }
        });
    }
}
