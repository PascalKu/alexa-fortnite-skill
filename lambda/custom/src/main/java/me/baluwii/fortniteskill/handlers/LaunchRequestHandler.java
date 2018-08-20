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
                .withSpeech( "Hi! Hast du Fragen zu Fortnite?" )
                .withReprompt( "I bims d1 Fortnite Alexa-Skill." )
                .withSimpleCard( "Fortnite-Skill", "Wie kann ich dir behilflich sein?" )
                .withShouldEndSession( false )
                .build();
    }
}