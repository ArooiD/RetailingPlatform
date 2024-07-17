package ru.mirea.sdk.api;

class ShowCaseSender extends AbstractModuleSender implements ModuleSender{
    public ShowCaseSender(String showcase) {
        super(showcase);
    }

    @Override
    public Message get(Endpoint endpoint) {
        return null;
    }

    @Override
    public <T> Message post(Endpoint endpoint, T body) {
        return null;
    }

    @Override
    public <T> Message put(Endpoint endpoint, T body) {
        return null;
    }

    @Override
    public Message delete(Endpoint endpoint) {
        return null;
    }
}
