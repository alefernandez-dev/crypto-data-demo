package dev.alejandro.cryptodatademo.domain;

public interface CryptoManagerService {

    String encrypt(String data);
    String decrypt(String data);

}
