package com.powercess.minecraftapi;

import com.powercess.minecraftapi.web.WebServer;
import net.fabricmc.api.ModInitializer;

public class Minecraftapi implements ModInitializer {

    @Override
    public void onInitialize() {
        // 启动 Web 服务器
        WebServer.start();
    }
}