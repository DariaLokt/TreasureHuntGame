package object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Key extends SuperObject {
    public OBJ_Key() {
        this.setName("Key");

        try {
            this.setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/key.png"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
