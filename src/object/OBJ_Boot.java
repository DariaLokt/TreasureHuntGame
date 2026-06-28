package object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Boot extends SuperObject {
    public OBJ_Boot() {
        this.setName("Boot");

        try {
            this.setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/boot.png"))), this.state);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
