package me.baluwii.fortniteskill.handlers.random;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.response.ResponseBuilder;

import java.text.MessageFormat;
import java.util.*;

import static com.amazon.ask.request.Predicates.intentName;

/**
 * JavaDoc this file!
 * Created: 20.08.2018
 *
 * @author Baluwii (paskutscha@gmail.com)
 */
public class RecommendCityRequestHandler implements RequestHandler {

    private final List<String> cities = new ArrayList<>(
            Arrays.asList(
                    "Tomato Town",
                    "Loot Lake",
                    "Shifty Shafts",
                    "Salty Springs",
                    "Wailing Woods"
            )
    );

    private final List<String> sentences = new ArrayList<>(
            Arrays.asList(
                    "{0} scheint ein guter Ort zu sein!",
                    "In {0} kannst du einiges reißen.",
                    "Am besten landest du in {0}!"
            )
    );

    @Override
    public boolean canHandle( final HandlerInput input ) {
        return input.matches( intentName( "RecommendCityIntent" ) );
    }

    @Override
    public Optional<Response> handle( final HandlerInput input ) {
        final ResponseBuilder responseBuilder = input.getResponseBuilder().withShouldEndSession( true );

        if ( cities.isEmpty() ) {
            responseBuilder
                    .withSimpleCard( "Ort-Empfehlung", "¯\\_(ツ)_/¯" )
                    .withSpeech( "Puhh... Mit deinen Skills kannst du überall landen!" );
        } else {
            final String sentence = sentences.get( new Random().nextInt( sentences.size() ) );
            final String targetCity = cities.get( new Random().nextInt( cities.size() ) );

            responseBuilder
                    .withSimpleCard( "Ort-Empfehlung", targetCity )
                    .withSpeech( MessageFormat.format( sentence, targetCity ) );
        }

        return responseBuilder.build();
    }
}