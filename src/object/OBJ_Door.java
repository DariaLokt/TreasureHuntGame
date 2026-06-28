package object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Door extends SuperObject {
    public OBJ_Door() {
        this.setName("Door");

        try {
            this.setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/door.png"))), this.state);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.setCollision(true);
    }
}
