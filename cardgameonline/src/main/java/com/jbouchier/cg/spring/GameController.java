package com.jbouchier.cg.spring;

import com.jbouchier.cg.model.Game;
import com.jbouchier.cg.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.security.Principal;


@Controller
public class GameController {

    @Autowired
    private Game game;

    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping("/message")
    @SendToUser("/queue/reply")
    public Player processMessageFromClient(@Payload String message, Principal principal) {
        System.out.println(message);
        return game.getPlayer(0);
    }

    @MessageMapping("/message/increase-hand")
    @SendToUser("/queue/reply/receive-hand")
    public Player increaseHand(@Payload int message, Principal principal) {
        System.out.println(message);
        Player player = game.getPlayer(message);
        player.addCardToHand();
        return game.getPlayer(0);
    }

    @MessageExceptionHandler
    @SendToUser("/queue/errors")
    public String handleException(Throwable exception) {
        return exception.getMessage();
    }
}