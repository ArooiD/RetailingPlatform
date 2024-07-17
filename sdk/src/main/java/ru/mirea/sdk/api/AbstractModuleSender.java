package ru.mirea.sdk.api;

import io.micrometer.common.util.internal.logging.InternalLogger;
import io.micrometer.common.util.internal.logging.InternalLoggerFactory;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractModuleSender {
    protected final InternalLogger logger = InternalLoggerFactory.getInstance(ModuleSender.class);
    protected final RestTemplate restTemplate = new RestTemplate();
    protected String module;

    AbstractModuleSender(String module){
        this.module = module;
    }

}
