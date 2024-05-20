package dev.alejandro.cryptodatademo.service;

import dev.alejandro.cryptodatademo.domain.CryptoManagerService;
import org.jasypt.util.text.StrongTextEncryptor;

public class UserDataCryptoService implements CryptoManagerService {

    private final StrongTextEncryptor textEncryptor;

    public UserDataCryptoService() {
        this.textEncryptor = new StrongTextEncryptor();
        textEncryptor.setPassword(System.getenv("API_KEY"));
    }

    @Override
    public String encrypt(String data) {
        return textEncryptor.encrypt(data);
    }

    @Override
    public String decrypt(String data) {
        return textEncryptor.decrypt(data);
    }
}
