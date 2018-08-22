package me.baluwii.fortniteskill.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.requestType;

/**
 * JavaDoc this file!
 * Created: 20.08.2018
 *
 * @author Baluwii (paskutscha@gmail.com)
 */
public class LaunchRequestHandler implements RequestHandler {

    @Override
    public boolean canHandle( final HandlerInput input ) {
        return input.matches( requestType( LaunchRequest.class ) );
    }

    @Override
    public Optional<Response> handle( final HandlerInput input ) {
        return input.getResponseBuilder()
                .withSpeech( "Hi! Ich kann dir Landeorte vorschlagen, dir Geheimnisse verraten und deine Kills zählen!" )
                .withReprompt( "Soll ich dir zum Beispiel einen Landeort vorschlagen?" )
                .withSimpleCard( "Fortnite-Skill", "Wie kann ich dir behilflich sein?" )
                .withShouldEndSession( true )
                .build();
    }
}