package jp.myapp.util;

import java.util.Collection;

public class LoggableUtil {

    private LoggableUtil() {
    }

    public static void addLog(Collection<String> log, Object item, String itemName, boolean enabled) {
        if (enabled) {
            addLog(log, item, itemName);
        }
    }

    public static void addLog(Collection<String> log, Object item, String itemName) {

        if (item == null) {
            log.add(itemName + " = " + item);

        } else if (item instanceof Loggable) {
            for (String s : ((Loggable) item).getLogText()) {
                log.add(itemName + "." + s);
            }

        } else {
            log.add(itemName + " = " + item.toString());
        }
    }

    public static void addLogList(Collection<String> log, Collection<?> itemList, String itemName, boolean enabled) {
        if (enabled) {
            addLogList(log, itemList, itemName);
        }
    }

    public static void addLogList(Collection<String> log, Collection<?> itemList, String itemName) {

        if (itemList == null) {
            addLog(log, itemList, itemName);

        } else {
            int count = 0;

            for (Object o : itemList) {
                addLog(log, o, itemName + "[" + count + "]");
                count++;
            }
        }
    }
}
