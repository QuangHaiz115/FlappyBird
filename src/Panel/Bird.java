package Panel;

import Menu.Objects;
import Menu.SoundPlayer;

import java.awt.*;
import java.io.File;

public class Bird extends Objects {
    private float vt = 0;

    private boolean isFlying = false;

    private Rectangle rect;

    private boolean isLive = true;

    public SoundPlayer flapSound, collideSound, pointSound, soundTrack;

    public Bird(int x, int y, int w, int h) {
        super(x, y, w, h);
        rect = new Rectangle(x, y, w, h);
        flapSound = new SoundPlayer(new File("Stock/fap.wav"));
        collideSound = new SoundPlayer(new File("Stock/fall.wav"));
        pointSound = new SoundPlayer(new File("Stock/getpoint.wav"));
        soundTrack = new SoundPlayer(new File("Stock/game0.wav"));
    }

    public Bird() {

    }

    public void setVt(float vt) {
        this.vt = vt;
    }

    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

    public float getVt() {
        return vt;
    }

    public boolean getIsFlying() {
        return isFlying;
    }

    public void setFlying(boolean isFlying) {
        this.isFlying = isFlying;
    }

    public void update(long deltaTime) {
        vt += Handle.g;
        this.setPosY(this.getPosY() + vt);
        if (this.getPosY() < 0) {
            this.setPosY(0);
            vt = 0;
        }

        this.rect.setLocation((int) this.getPosX(), (int) this.getPosY());
        if (vt < 0)
            isFlying = true;
        else
            isFlying = false;
    }

    public void fly() {
        vt = -4;
        if (!Handle.turnonMusic)
            flapSound.play();

    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean isLive) {
        this.isLive = isLive;
    }

}
