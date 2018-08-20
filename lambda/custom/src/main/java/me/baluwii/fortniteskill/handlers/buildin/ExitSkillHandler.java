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
public class ExitSkillHandler implements RequestHandler {

    public boolean canHandle( final HandlerInput input ) {
        return input.matches( intentName( "AMAZON.StopIntent" ).or( intentName( "AMAZON.PauseIntent" ).or( intentName( "AMAZON.CancelIntent" ) ) ) );
    }

    public Optional<Response> handle( final HandlerInput input ) {
        return input.getResponseBuilder().withSpeech( "Ciao! Meld dich, wenn du etwas brauchst!" ).build();
    }
}