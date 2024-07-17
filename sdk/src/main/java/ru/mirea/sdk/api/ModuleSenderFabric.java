package ru.mirea.sdk.api;

public class ModuleSenderFabric {
    public static ModuleSender getLogger(){
        return new LoggerSender("logger");
    }
    public static ModuleSender getOutlet(){
        return new OutletSender("outlet");
    }
    public static ModuleSender getShowCase(){
        return new ShowCaseSender("showcase");
    }
    public static ModuleSender getStorage(){
        return new StorageSender("storage");
    }
    public static ModuleSender getWeb() {
        return new WebSender("web");
    }
}
