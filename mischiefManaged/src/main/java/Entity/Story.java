package Entity;

import com.example.javagame2d.GamePanel;

import java.awt.image.BufferedImage;

public class Story extends Entity{

    public Story(GamePanel gp) {
        super(gp);
    }

    public void speak() {

        if (gp.player.stage == 0) dialogueIndex = 0;
        dialogue = false;
        gp.player.stage = 1;
        gp.ui.currentDialogue = dialogues[dialogueIndex];
        gp.ui.dialogueImage = gp.ui.dialogueImages.get(2);
        gp.aSetter.setTempoNPC();
    }

    public void setDialogue()
    {
        dialogues[0] = "";
        dialogues[1] = "Who is he?";
        dialogues[2] = "You should tell Feluda";
        dialogues[3] = "Why don't you check it out yourself?";
    }
}
