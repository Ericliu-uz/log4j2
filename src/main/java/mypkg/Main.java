package mypkg;

import org.apache.logging.log4j.*;

public class Main {

    private static final Logger logger = LogManager.getLogger();
    private static final Marker assertions_MARKER = MarkerManager.getMarker("Assertions");
    private static final Marker gibberish_MARKER = MarkerManager.getMarker("Gibberish");

    public static void main(String[] args) throws InterruptedException {

        int N = Integer.parseInt(args[0]);

        for(int i = 0; i < N; i ++) {
            ThreadContext.push(String.valueOf(i));
            logger.info("Iterations(No Marker): "+ i);
            logger.fatal(gibberish_MARKER, "Baa, baa, black sheep,");
            logger.error(assertions_MARKER, "Have you any wool?");
            logger.warn(gibberish_MARKER, "Yes, sir, yes, sir,");
            logger.info(assertions_MARKER, "Three bags full;");
            logger.debug(assertions_MARKER, "One for the master,");
            logger.trace(assertions_MARKER, "And one for the dame,");
            logger.info(assertions_MARKER, "And one for the little boy");
            logger.trace(assertions_MARKER, "Who lives down the lane.");
            ThreadContext.pop();
            Thread.sleep(1000);
        }
    }

}