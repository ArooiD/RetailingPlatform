package api;

public interface ModuleSender{
    Message get(Endpoint endpoint);
    <T> Message post(Endpoint endpoint, T body);
    <T> Message put(Endpoint endpoint, T body);
    <T> Message delete(Endpoint endpoint);

    <T> Message delete(Endpoint endpoint, T body);
}
