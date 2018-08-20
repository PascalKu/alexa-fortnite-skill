package me.baluwii.fortniteskill.handlers.buildin;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.SessionEndedRequest;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.requestType;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * JavaDoc this file!
 * Created: 20.08.2018
 *
 * @author Baluwii (paskutscha@gmail.com)
 */
public class SessionEndedHandler implements RequestHandler {

    @Override
    public boolean canHandle( final HandlerInput input ) {
        return input.matches( requestType( SessionEndedRequest.class ) );
    }

    @Override
    public Optional<Response> handle( final HandlerInput input ) {
        final SessionEndedRequest sessionEndedRequest = (SessionEndedRequest) input.getRequestEnvelope().getRequest();
        getLogger( SessionEndedHandler.class ).debug( "Session ended with reason: " + sessionEndedRequest.getReason().toString() );

        return Optional.empty();
    }
}