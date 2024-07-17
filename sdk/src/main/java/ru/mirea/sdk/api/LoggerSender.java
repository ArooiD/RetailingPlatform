package ru.mirea.sdk.api;

class LoggerSender extends AbstractModuleSender implements ModuleSender{
    public LoggerSender(String baseUrl, String modulePath) {
        super(baseUrl, modulePath);
    }
}
