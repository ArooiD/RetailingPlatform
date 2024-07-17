package ru.mirea.sdk.api;

class StorageSender extends AbstractModuleSender implements ModuleSender {
    public StorageSender(String storage) {
        super(storage);
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
