package me.baluwii.fortniteskill.handlers.buildin;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

/**
 * JavaDoc this file!
 * Created: 20.08.2018
 *
 * @author Baluwii (paskutscha@gmail.com)
 */
public class HelpIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle( final HandlerInput input ) {
        return input.matches( intentName( "AMAZON.HelpIntent" ) );
    }

    private final String speechAnswer = "Frag mich, wo du landen sollst mit \"Alexa frage Fortnite, wo soll ich landen\" " +
            "oder lass dir einen Fakt von mir verraten mit \"Alexa, frag Fortnite was hat fortnite für geheimnisse\".";

    @Override
    public Optional<Response> handle( final HandlerInput input ) {
        return input.getResponseBuilder()
                .withSpeech( speechAnswer )
                .withReprompt( "Womit kann ich dir helfen?" )
                .withShouldEndSession( false )
                .build();
    }
}