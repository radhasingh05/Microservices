package com.radha.eurekaclient.core;

import lombok.Data;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
@Data
public class Account {
    private String accountNumber;
    private String Name;
}
