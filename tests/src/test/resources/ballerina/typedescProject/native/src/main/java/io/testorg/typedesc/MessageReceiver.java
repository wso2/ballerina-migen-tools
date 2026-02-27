package io.testorg.typedesc;

import io.ballerina.runtime.api.utils.StringUtils;
import io.ballerina.runtime.api.values.BObject;
import io.ballerina.runtime.api.values.BTypedesc;

/**
 * Mock Java implementation for the receivePayload external function.
 * Mirrors the ASB MessageReceiver pattern.
 */
public class MessageReceiver {

    public static Object receivePayload(BObject client,
                                        Object serverWaitTime, BTypedesc T,
                                        boolean deadLettered) {
        String typeName = T.getDescribingType().getName();
        long waitTime = serverWaitTime != null ? (long) serverWaitTime : 0;
        String result = "{\"receivedType\":\"" + typeName
                + "\",\"serverWaitTime\":" + waitTime
                + ",\"deadLettered\":" + deadLettered + "}";
        return StringUtils.fromString(result);
    }
}
