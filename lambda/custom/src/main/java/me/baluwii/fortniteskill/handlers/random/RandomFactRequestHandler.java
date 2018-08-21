package me.baluwii.fortniteskill.handlers.random;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.response.ResponseBuilder;

import java.util.*;

import static com.amazon.ask.request.Predicates.intentName;

/**
 * JavaDoc this file!
 * Created: 20.08.2018
 *
 * @author Baluwii (paskutscha@gmail.com)
 */
public class RandomFactRequestHandler implements RequestHandler {

    private final List<String> facts = new ArrayList<>(
            Arrays.asList(
                    "Wusstest du, dass Fortnite nicht als Battle Royale Modus entstand sondern als Spieler gegen Entities kurz P v E, welches man immer noch spielen kann? Dort ging es eher darum, die Welt zu erkunden anstatt blöd rum zu ballern!",
                    "Wäre dein Bildschirm rund, würdest du keine eckigen Augen bekommen!",
                    "Es gibt nichts total unnoetiges, alles kann dir weiterhelfen!"
            )
    );

    @Override
    public boolean canHandle( final HandlerInput input ) {
        return input.matches( intentName( "FortniteFaktIntent" ) );
    }

    @Override
    public Optional<Response> handle( final HandlerInput input ) {
        final ResponseBuilder responseBuilder = input.getResponseBuilder().withShouldEndSession( true );

        if ( facts.isEmpty() ) {
            // Return an error message.
            responseBuilder.withSpeech( "Entschuldige aber mir fällt gerade einfach nichts ein." );
        } else {
            // Send a random fact.
            responseBuilder.withSpeech( facts.get( new Random().nextInt( facts.size() ) ) );
        }

        return responseBuilder.build();
    }
}