package me.baluwii.fortniteskill.handlers.killcounter;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.response.ResponseBuilder;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

/**
 * JavaDoc this file!
 * Created: 20.08.2018
 *
 * @author Baluwii (paskutscha@gmail.com)
 */
public class KillCounterRequestHandler implements RequestHandler {

    @Override
    public boolean canHandle( final HandlerInput input ) {
        return input.matches( intentName( "KillIntent" ) )
                || input.matches( intentName( "DeathIntent" ) )
                || input.matches( intentName( "GetKillInformationIntent" ) );
    }

    @Override
    public Optional<Response> handle( final HandlerInput input ) {
        final Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
        final ResponseBuilder responseBuilder = input.getResponseBuilder().withShouldEndSession( true );

        if ( input.matches( intentName( "KillIntent" ) ) ) {
            responseBuilder.withReprompt( "Soll ich dir einen zufälligen Landeort verraten oder weitere Kills zählen?" );

            final int kills;
            sessionAttributes.put( "killCounter", kills = (int) sessionAttributes.getOrDefault( "killCounter", 0 ) + 1 );

            if ( kills == 10 ) {
                responseBuilder.withSpeech( "Krass, zehn Kills sind echt eine Menge Spieler, wenn du sie dir einmal räumlich vorstellst. Du kannst mich ja gerne mal in Fortnite hinzufügen, meinen Namen findest du auf deinem Amazon Device." );
            } else {
                responseBuilder.withSpeech( "Wow, " + ( kills == 1 ? "einen Kill" : kills + " " + ( kills > 3 ? "schon" : "" ) + "Kills" ) );
            }
        } else if ( input.matches( intentName( "DeathIntent" ) ) ) {
            responseBuilder.withSpeech( "Schade, damit bist du mit " + sessionAttributes.getOrDefault( "killCounter", 0 ) + ( (int) sessionAttributes.getOrDefault( "killCounter", 0 ) == 1 ? "Kill" : "Kills" ) + " aus der Runde gegangen!" );
            sessionAttributes.remove( "killCounter" );
        } else if ( input.matches( intentName( "GetKillInformationIntent" ) ) ) {
            responseBuilder.withSpeech( "Wenn du mich nicht angelogen hast, hast du " + sessionAttributes.getOrDefault( "killCounter", 0 ) + ( (int) sessionAttributes.getOrDefault( "killCounter", 0 ) == 1 ? "Kill" : "Kills" ) );
        }

        responseBuilder.withSimpleCard( "Kill-Counter", "Kills: " + sessionAttributes.getOrDefault( "killCounter", 0 ) );
        return responseBuilder.build();
    }
}