package ru.mirea.sdk.api;

import org.springframework.beans.factory.annotation.Value;

import java.util.Map;

public class ModuleSenderConfiguration {
    private static final Map<Modules, String> moduleMap = Map.of(
            Modules.web, "/web",
            Modules.logger, "/logger",
            Modules.outlets, "/outlets",
            Modules.showcase, "/showcase",
            Modules.storage, "/storage");
    @Value(value = "${server.baseurl}")
    private static String baseUrl = "http://localhost:8080";

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static String getModulePath(Modules module) {
        return moduleMap.get(module);
    }
}
