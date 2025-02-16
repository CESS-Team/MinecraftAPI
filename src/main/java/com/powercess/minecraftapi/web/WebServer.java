package com.powercess.minecraftapi.web;

import io.javalin.Javalin;
import com.powercess.minecraftapi.web.PlayerController;

public class WebServer {

    public static void start() {
        // 创建 Javalin 实例并启动 Web 服务器
        Javalin app = Javalin.create().start(8080);

        // 注册玩家相关接口
        PlayerController.registerRoutes(app);

        // 打印日志，表示 Web 服务器已启动
        System.out.println("Web server started on port 8080");
    }
}
