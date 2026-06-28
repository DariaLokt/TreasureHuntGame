package object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Chest extends SuperObject {
    public OBJ_Chest() {
        this.setName("Chest");

        try {
            this.setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/chest.png"))), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            this.setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/open_chest.png"))), 1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.setCollision(true);
    }
}
