package com.example.javagame2d;

import Entity.*;
import objects.OBJ_Boots;
import objects.OBJ_Chest;
import objects.OBJ_Door;
import objects.OBJ_Key;

public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp)
    {
        this.gp = gp;
    }

    public void setObject()
    {
        gp.obj[1][0] = new OBJ_Key(gp);
        gp.obj[1][0].worldX = 1 * gp.tileSize;
        gp.obj[1][0].worldY = 21 * gp.tileSize;


//        gp.obj[1] = new OBJ_Key(gp);
//        gp.obj[1].worldX = 23 * gp.tileSize;
//        gp.obj[1].worldY = 40 * gp.tileSize;
//
//        gp.obj[2] = new OBJ_Key(gp);
//        gp.obj[2].worldX = 38 * gp.tileSize;
//        gp.obj[2].worldY = 8 * gp.tileSize;
//
//        gp.obj[3] = new OBJ_Door(gp);
//        gp.obj[3].worldX = 10 * gp.tileSize;
//        gp.obj[3].worldY = 9 * gp.tileSize;
//
//        gp.obj[4] = new OBJ_Door(gp);
//        gp.obj[4].worldX = 8 * gp.tileSize;
//        gp.obj[4].worldY = 28 * gp.tileSize;
//
//        gp.obj[5] = new OBJ_Door(gp);
//        gp.obj[5].worldX = 12 * gp.tileSize;
//        gp.obj[5].worldY = 22 * gp.tileSize;
//
//        gp.obj[6] = new OBJ_Chest(gp);
//        gp.obj[6].worldX = 10 * gp.tileSize;
//        gp.obj[6].worldY = 7 * gp.tileSize;
//
//        gp.obj[7] = new OBJ_Chest(gp);
//        gp.obj[7].worldX = 23 * gp.tileSize;
//        gp.obj[7].worldY = 40 * gp.tileSize;
//
//        gp.obj[8] = new OBJ_Chest(gp);
//        gp.obj[8].worldX = 23 * gp.tileSize;
//        gp.obj[8].worldY = 40 * gp.tileSize;
//
//        gp.obj[9] = new OBJ_Boots(gp);
//        gp.obj[9].worldX = 37 * gp.tileSize;
//        gp.obj[9].worldY = 42 * gp.tileSize;*/


    }

    public void setNPC()
    {
        int mapNum = 0;
        gp.npc[mapNum][0] = new NPC_OldMan(gp);
        gp.npc[mapNum][0].worldX = gp.tileSize*15;
        gp.npc[mapNum][0].worldY = gp.tileSize*10;


        gp.npc[mapNum][1] = new Door(gp);
        gp.npc[mapNum][1].worldX = gp.tileSize*18;
        gp.npc[mapNum][1].worldY = gp.tileSize*2;

        gp.npc[mapNum][1] = new Door(gp);
        gp.npc[mapNum][1].worldX = gp.tileSize*18;
        gp.npc[mapNum][1].worldY = gp.tileSize*2;

        gp.npc[mapNum][2] = new Telephone(gp);
        gp.npc[mapNum][2].worldX = gp.tileSize*9;
        gp.npc[mapNum][2].worldY = gp.tileSize*7;

        mapNum = 1;
        gp.npc[mapNum][0] = new Letter_box(gp);
        gp.npc[mapNum][0].worldX = gp.tileSize*12;
        gp.npc[mapNum][0].worldY = gp.tileSize*26;

        gp.npc[mapNum][1] = new Armour(gp);
        gp.npc[mapNum][1].worldX = gp.tileSize*1;
        gp.npc[mapNum][1].worldY = gp.tileSize*21;
    }

    public void setTempoNPC()
    {
        int mapNum = 0;
        gp.temponpc[mapNum][0] = new Mystery_Man(gp);
        gp.temponpc[mapNum][0].worldX = gp.tileSize*16;
        gp.temponpc[mapNum][0].worldY = gp.tileSize*4;

    }
}
