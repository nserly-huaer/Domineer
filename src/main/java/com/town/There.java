package com.town;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class There {
    static long starttime;

    void cheack(double u, double i, double o, double p) throws NoNullException {

        Logger logger = LogManager.getLogger(First.class);
        First f = new First();
        long starttime = System.currentTimeMillis();
        logger.info("开始时间" + starttime);
        There.starttime = starttime;
        if (u == 0)
            f.Run(u, i, o, p);
        else if (i == 0)
            f.Run2(u, i, o, p);
        else if (o == 0)
            f.Run3(u, i, o, p);
        else if (p == 0)
            f.Run4(u, i, o, p);
        else
            throw new NoNullException("No \"x\"(0) Number");
    }
}
