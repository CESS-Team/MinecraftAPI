package com.powercess.minecraftapi.web;

import io.javalin.Javalin;
import io.javalin.http.Context;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;

import java.util.ArrayList;
import java.util.List;

public class PlayerController {

    private static MinecraftServer server;

    // 注册玩家相关接口
    public static void registerRoutes(Javalin app) {
        // 监听服务器启动事件，获取 MinecraftServer 实例
        ServerLifecycleEvents.SERVER_STARTED.register(minecraftServer -> {
            server = minecraftServer;
        });

        app.get("/api/list", PlayerController::getOnlinePlayers);
    }

    // 获取在线玩家列表
    private static void getOnlinePlayers(Context ctx) {
        if (server == null) {
            ctx.status(500).result("Server not initialized");
            return;
        }

        List<String> playerNames = new ArrayList<>();

        // 遍历在线玩家并获取名字
        for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
            playerNames.add(player.getEntityName());
        }

        // 返回 JSON 格式的玩家列表
        ctx.json(playerNames);
    }
}
