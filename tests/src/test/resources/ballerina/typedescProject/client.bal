import ballerina/jballerina.java;

public isolated client class TypedescClient {

    private string serviceUrl;

    public isolated function init(string serviceUrl = "https://test.sh") returns error? {
        self.serviceUrl = serviceUrl;
    }

    // Test A: Process typedesc<string>
    remote isolated function processTypedescString(typedesc<string> expectedType) returns string {
        return "string";
    }

    // Test B: Process typedesc<Message>
    remote isolated function processTypedescRecord(typedesc<Message> expectedType) returns Message {
        return {body: "test"};
    }

    // Test C: Process typedesc<Message|MessageBatch>
    remote isolated function processTypedescUnion(typedesc<Message|MessageBatch> expectedType) returns Message|MessageBatch {
        if expectedType is typedesc<MessageBatch> {
            return {
                messageCount: 1,
                messages: [{body: "This is a batch message"}]
            };
        } else {
            return {body: "This is a single message"};
        }
    }

    // Test D: Process typedesc<anydata> — accept any JSON-serializable value
    remote isolated function processTypedescAnydata(json payload, typedesc<anydata> targetType = anydata) returns anydata|error {
        return payload.cloneWithType(targetType);
    }

    // Test E: ASB-style receivePayload — inferred typedesc with @java:Method external
    isolated remote function receivePayload(
            @display {label: "Server Wait Time"} int? serverWaitTime = 60,
            @display {label: "Expected Type"} typedesc<anydata> T = <>,
            @display {label: "Dead-Lettered Messages"} boolean deadLettered = false)
                returns @display {label: "Message Payload"} T|error = @java:Method {
        'class: "io.testorg.typedesc.MessageReceiver"
    } external;
}

