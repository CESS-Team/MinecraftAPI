package com.powercess.minecraftapi;

import io.javalin.Javalin;
import net.fabricmc.api.ModInitializer;

public class Minecraftapi implements ModInitializer {

    @Override
    public void onInitialize() {
        // 初始化 Javalin Web 服务器
        startWebServer();
    }

    private void startWebServer() {
        // 创建 Javalin 实例并启动 Web 服务器
        Javalin app = Javalin.create().start(8080);

        // 定义 /hello 接口
        app.get("/hello", ctx -> {
            ctx.result("Hello from Minecraft!");
        });

        // 打印日志，表示 Web 服务器已启动
        System.out.println("Web server started on port 8080");
    }
}
