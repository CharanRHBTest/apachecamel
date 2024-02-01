package com.apache.camel.logging;

import brave.handler.MutableSpan;
import brave.handler.SpanHandler;
import brave.propagation.TraceContext;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.stream.Collectors;

public class LoggingSpanHandler extends SpanHandler {
    @Override
    public boolean end(TraceContext context, MutableSpan span, Cause cause) {
        System.out.println("SPAN FINISHED: traceId=" + span.traceId()
                + " spanId=" + span.id()
                + " parentId=" + span.parentId()
                + " operation=" + span.name()
                + " tags=" + span.tags().entrySet().stream().map(Object::toString).collect(Collectors.toList())
                + " logs=[" + span.annotations().stream().map(Map.Entry::getValue).collect(Collectors.toList())
                + "]");
        return true;
    }
}
