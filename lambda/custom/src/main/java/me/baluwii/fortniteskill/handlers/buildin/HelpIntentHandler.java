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

    @Override
    public Optional<Response> handle( final HandlerInput input ) {
        return input.getResponseBuilder()
                .withSpeech( "Du kannst sagen, sag mir einen Landeort oder wenn ich dich nerve kannst du mir sagen, dass ich gehen soll! Ich bin virtuell, nicht so wie deine Freundin! Du kannst mich herum kommandieren und wir bleiben solange befreundet, wie du mich installiert hast!" )
                .withReprompt( "Womit kann ich dir helfen?" )
                .withShouldEndSession( false )
                .build();
    }
}