package ru.mirea.sdk.api;

class OutletSender extends AbstractModuleSender implements ModuleSender{
    public OutletSender(String outlet) {
        super(outlet);
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
