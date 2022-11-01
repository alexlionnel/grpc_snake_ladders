package org.example.snake_ladders.server;

import io.grpc.stub.StreamObserver;
import org.example.snake_ladders.Die;
import org.example.snake_ladders.GameServiceGrpc;
import org.example.snake_ladders.GameState;
import org.example.snake_ladders.Player;

public class GameService extends GameServiceGrpc.GameServiceImplBase {

    @Override
    public StreamObserver<Die> roll(StreamObserver<GameState> responseObserver) {
        Player client = Player.newBuilder()
                .setName("client")
                .setPosition(0)
                .build();
        Player server = Player.newBuilder()
                .setName("server")
                .setPosition(0)
                .build();
        return new DieStreamingRequest(client, server, responseObserver);
    }
}
