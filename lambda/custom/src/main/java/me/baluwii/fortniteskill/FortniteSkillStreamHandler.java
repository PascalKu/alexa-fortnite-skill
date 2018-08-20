package me.baluwii.fortniteskill;

import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;
import me.baluwii.fortniteskill.handlers.LaunchRequestHandler;
import me.baluwii.fortniteskill.handlers.buildin.ExitSkillHandler;
import me.baluwii.fortniteskill.handlers.buildin.HelpIntentHandler;
import me.baluwii.fortniteskill.handlers.buildin.SessionEndedHandler;
import me.baluwii.fortniteskill.handlers.killcounter.KillCounterRequestHandler;
import me.baluwii.fortniteskill.handlers.random.RandomFactRequestHandler;
import me.baluwii.fortniteskill.handlers.random.RecommendCityRequestHandler;

/**
 * JavaDoc this file!
 * Created: 20.08.2018
 *
 * @author Baluwii (paskutscha@gmail.com)
 */
public class FortniteSkillStreamHandler extends SkillStreamHandler {

    public FortniteSkillStreamHandler() {
        super( Skills.standard().addRequestHandlers(
                // The request start handler
                new LaunchRequestHandler(),

                // Kill-Counter
                new KillCounterRequestHandler(),

                // Random Data.
                new RecommendCityRequestHandler(),
                new RandomFactRequestHandler(),

                // The basic stuff handlers
                new HelpIntentHandler(),
                new ExitSkillHandler(),
                new SessionEndedHandler()
        ).build() );
    }
}
