package ru.mirea.sdk.api;




class WebSender extends AbstractModuleSender implements ModuleSender {
    public WebSender(String baseUrl, String modulePath) {
        super(baseUrl, modulePath);
    }
}
