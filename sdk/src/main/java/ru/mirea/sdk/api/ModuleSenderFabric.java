package ru.mirea.sdk.api;

public class ModuleSenderFabric {
    public static ModuleSender getLogger() {
        return new LoggerSender(
                ModuleSenderConfiguration.getBaseUrl(),
                ModuleSenderConfiguration.getModulePath(Modules.logger)
        );
    }

    public static ModuleSender getOutlet() {
        return new OutletSender(
                ModuleSenderConfiguration.getBaseUrl(),
                ModuleSenderConfiguration.getModulePath(Modules.outlets)
        );
    }

    public static ModuleSender getShowCase() {
        return new ShowCaseSender(
                ModuleSenderConfiguration.getBaseUrl(),
                ModuleSenderConfiguration.getModulePath(Modules.showcase)
        );
    }

    public static ModuleSender getStorage() {
        return new StorageSender(
                ModuleSenderConfiguration.getBaseUrl(),
                ModuleSenderConfiguration.getModulePath(Modules.storage));
    }

    public static ModuleSender getWeb() {
        return new WebSender(
                ModuleSenderConfiguration.getBaseUrl(),
                ModuleSenderConfiguration.getModulePath(Modules.web));
    }
}
