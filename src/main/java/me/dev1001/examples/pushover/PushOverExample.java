package me.dev1001.examples.pushover;

import net.pushover.client.PushOverSound;
import net.pushover.client.PushoverClient;
import net.pushover.client.PushoverException;
import net.pushover.client.PushoverMessage;
import net.pushover.client.PushoverRestClient;

/**
 * @author hongzong.li
 */
public class PushOverExample {
    public static void main(String[] args) throws PushoverException {
        PushoverClient client = new PushoverRestClient();

        client.pushMessage(PushoverMessage.builderWithApiToken("a5ysncwoq5s6bwybmdmhxpak7oxfba")
            .setUserId("uc682ryu7ghx44yw5xkzint3cjyqva")
            .setMessage("hello, world!")
            .build());

// push a message with optional fields
//        Status result = client.pushMessage(PushoverMessage.builderWithApiToken("MY_APP_API_TOKEN")
//            .setUserId("USER_ID_TOKEN")
//            .setMessage("testing!")
//            .setDevice("device")
//            .setPriority(MessagePriority.HIGH) // HIGH|NORMAL|QUIET
//            .setTitle("title")
//            .setUrl("https://github.com/sps/pushover4j")
//            .setTitleForURL("pushover4j github repo")
//            .setSound("magic")
//            .build());

//        System.out.println(String.format("status: %d, request id: %s", result.getStatus(), result.getRequestId()));

// get and print out the list of available sounds:
        for (PushOverSound sound : client.getSounds()) {
            System.out.println(String.format("name: %s, id: %s", sound.getName(), sound.getId()));
        }
    }
}
